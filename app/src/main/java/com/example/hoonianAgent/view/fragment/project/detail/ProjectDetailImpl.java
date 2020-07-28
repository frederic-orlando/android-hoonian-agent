package com.example.hoonianAgent.view.fragment.project.detail;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.Media;
import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.content.property.Facility;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.model.request.project.RequestFavorite;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.model.response.project.ResponseGetProjectDetail;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.session.SessionUser;
import com.example.hoonianAgent.presenter.utils.UtilsCurrency;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.example.hoonianAgent.view.adapter.recycler.AdapterFacility;
import com.example.hoonianAgent.view.fragment.project.ProjectImpl;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;

import lombok.Setter;

@EBean
public class ProjectDetailImpl extends BaseImpl<ProjectDetailView> implements ProjectDetailPres, RecyclerListener, OnMapReadyCallback {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;
    @Setter
    private ProjectImpl callback;
    @Setter
    protected Project project;

    private int currentVideoIndex;

    private GoogleMap map;

    @Override
    public void init() {
        serviceManager.getProjectDetail(project.getId());
    }

    @Override
    public void initData() {
        currentVideoIndex = 0;
        loadImage(project.getImage(), viewAct.image());
        initMap();
        viewAct.location().setText(project.getCity().getName());
        viewAct.available().setText("Available : " + project.getAvailableUnit() + " units");
        viewAct.startPrice().setText(UtilsCurrency.toString(project.getStartFrom()));
        viewAct.address().setText(project.getAddress());
        viewAct.desc().setText(project.getDesc());
        setDataWarehouseInfo();
        setDataFacilities(project.getFacilities());

        if (project.getGallery().size() == 0) {
            utilsLayout.hide(viewAct.galleryLayout());
        }
        else {
            setDataCarousel(project.getGallery());
        }

        if (project.getVideos().size() == 0) {
            utilsLayout.hide(viewAct.videoLayout());
        }
        else {
            setVideoThumbnail();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setAllGesturesEnabled(false);
        map.getUiSettings().setMapToolbarEnabled(false);
        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                openMap();
            }
        });
    }

    @Override
    public void initMap() {
        LatLng latLng = new LatLng(-6.293267, 106.823501);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f));

        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng);
        map.addMarker(markerOptions);
    }

    @Override
    public void openMap() {
        Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivity(mapIntent);
        }
    }

    @Override
    public void setDataWarehouseInfo() {
        if (project.getOperationHour() != null) {
            callback.removeUnitPriceTab();
            viewAct.startPrice().setText(utilsLayout.getBodyText(viewAct.startPrice()) + "/m2");
            viewAct.operationHour().setText(project.getOperationHour());
            viewAct.warehouseSize().setText(project.getSize() + " m2");
            viewAct.pricePerMeter().setText(UtilsCurrency.toCurrency(project.getPricePerMeter()));
            viewAct.type().setText(project.getType());
            viewAct.minimumRent().setText(project.getMinimumRent() + " m2");
        }
        else {
            utilsLayout.hide(viewAct.warehouseInfo());
        }
    }

    @Override
    @UiThread
    public void setDataFacilities(ArrayList<Facility> listFacility) {
        if (viewAct.facilities() != null) {
            AdapterFacility adapter = new AdapterFacility(listFacility, this);
            viewAct.facilities().setAdapter(adapter);
            viewAct.facilities().setLayoutManager(new LinearLayoutManager(activity));
        }
    }

    @Override
    @UiThread
    public void setDataCarousel(ArrayList<Media> listGallery) {
        if (viewAct.gallery() != null) {
            viewAct.gallery().setImageListener(new ImageListener() {
                @Override
                public void setImageForPosition(int position, ImageView imageView) {
                    loadImage(listGallery.get(position).getLink(), imageView);
                }
            });

            viewAct.gallery().setPageCount(listGallery.size());
            viewAct.gallery().setImageClickListener(new ImageClickListener() {
                @Override
                public void onClick(int position) {
                }
            });
        }
    }

    @Override
    public void setVideoThumbnail() {
        loadImage(project.getVideos().get(currentVideoIndex).getLink(), viewAct.video());
    }

    @Override
    public void favorite() {
        Agent agent = new SessionUser(activity).getData();
        RequestFavorite request = new RequestFavorite(project.getId(), agent.getId());
        if (project.getIsFavorite()) {
            serviceManager.unfavoriteProject(request);
        }
        else {
            serviceManager.favoriteProject(request);
        }
    }

    @Override
    public void share() {
    //Todo: Add share dialog
        Toast.makeText(activity, "Share", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void playVideo() {
        intentManager.moveToVideoViewer(project.getVideos().get(currentVideoIndex));
    }

    @Override
    public void nextVideo() {
        if (currentVideoIndex != project.getVideos().size() - 1) {
            currentVideoIndex++;
        }
        else {
            currentVideoIndex = 0;
        }
        setVideoThumbnail();
    }

    @Override
    public void prevVideo() {
        if (currentVideoIndex != 0) {
            currentVideoIndex--;
        }
        else {
            currentVideoIndex = project.getVideos().size() - 1;
        }
        setVideoThumbnail();
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseGetProjectDetail) {
            project = ((ResponseGetProjectDetail) o).getProject();
            initData();
        }
        else if (o instanceof BaseResponse) {
            project.setIsFavorite(!project.getIsFavorite());

            int colorId;
            if (project.getIsFavorite()) {
                colorId = R.color.yellow;
            }
            else {
                colorId = R.color.white;
            }

            utilsLayout.changeTint(viewAct.favoriteBtn(), colorId);
        }
    }

    @Override
    public void onItemClick(Object o) {

    }
}
