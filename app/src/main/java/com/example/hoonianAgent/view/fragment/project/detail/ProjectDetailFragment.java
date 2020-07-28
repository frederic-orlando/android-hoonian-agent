package com.example.hoonianAgent.view.fragment.project.detail;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.example.hoonianAgent.view.fragment.base.BaseFragmentFromMore;
import com.example.hoonianAgent.view.fragment.project.ProjectImpl;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.synnapps.carouselview.CarouselView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_project_detail)
public class ProjectDetailFragment extends BaseFragmentFromMore<ProjectImpl> implements ProjectDetailView {
    @Bean
    protected ProjectDetailImpl impl;
    @ViewById
    protected ImageView image;
    @ViewById
    protected ImageButton favoriteBtn;
    @ViewById
    protected TextView locationLbl;
    @ViewById
    protected TextView availableLbl;
    @ViewById
    protected TextView startPriceLbl;
    @ViewById
    protected TextView addressLbl;
    @ViewById
    protected TextView descLbl;
    @ViewById
    protected RecyclerView facilityRecycler;
    @ViewById
    protected LinearLayout galleryLayout;
    @ViewById
    protected CarouselView carousel;
    @ViewById
    protected LinearLayout videoLayout;
    @ViewById
    protected ImageView videoThumbnail;

    @ViewById
    protected TableLayout warehouseInfo;
    @ViewById
    protected TextView operationHourLbl;
    @ViewById
    protected TextView sizeLbl;
    @ViewById
    protected TextView priceMeterLbl;
    @ViewById
    protected TextView typeLbl;
    @ViewById
    protected TextView minimumRent;

    @AfterViews
    protected void init() {
        SupportMapFragment map = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        map.getMapAsync(impl);

        impl.setViewAct(this);
        impl.setCallback(callback);
        impl.setProject(callback.getProject());
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public ImageView image() {
        return image;
    }

    @Override
    public ImageButton favoriteBtn() {
        return favoriteBtn;
    }

    @Override
    public TextView location() {
        return locationLbl;
    }

    @Override
    public TextView available() {
        return availableLbl;
    }

    @Override
    public TextView startPrice() {
        return startPriceLbl;
    }

    @Override
    public TextView address() {
        return addressLbl;
    }

    @Override
    public TextView desc() {
        return descLbl;
    }

    @Override
    public RecyclerView facilities() {
        return facilityRecycler;
    }

    @Override
    public LinearLayout galleryLayout() {
        return galleryLayout;
    }

    @Override
    public CarouselView gallery() {
        return carousel;
    }

    @Override
    public LinearLayout videoLayout() {
        return videoLayout;
    }

    @Override
    public ImageView video() {
        return videoThumbnail;
    }

    @Override
    public TableLayout warehouseInfo() {
        return warehouseInfo;
    }

    @Override
    public TextView operationHour() {
        return operationHourLbl;
    }

    @Override
    public TextView warehouseSize() {
        return sizeLbl;
    }

    @Override
    public TextView pricePerMeter() {
        return priceMeterLbl;
    }

    @Override
    public TextView type() {
        return typeLbl;
    }

    @Override
    public TextView minimumRent() {
        return minimumRent;
    }

    @Click(R.id.favoriteBtn)
    protected void favorite() {impl.favorite();}

    @Click(R.id.shareBtn)
    protected void share() {impl.share();}

    @Click(R.id.playBtn)
    protected void playVideo() {impl.playVideo();}

    @Click(R.id.prevBtn)
    protected void prevVideo() {impl.prevVideo();}

    @Click(R.id.nextBtn)
    protected void nextVideo() {impl.nextVideo();}

    @Click(R.id.map)
    protected void openMap() {impl.openMap();}
}
