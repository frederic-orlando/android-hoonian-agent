package com.example.hoonianAgent.view.fragment.project.cluster.detail;

import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.Media;
import com.example.hoonianAgent.model.content.property.Cluster;
import com.example.hoonianAgent.model.content.property.Facility;
import com.example.hoonianAgent.model.response.project.ResponseGetClusterDetail;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.example.hoonianAgent.view.adapter.recycler.AdapterFacility;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;

import lombok.Setter;

@EBean
public class ClusterDetailImpl extends BaseImpl<ClusterDetailView> implements ClusterDetailPres, RecyclerListener {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;
    @Setter
    private Cluster cluster;

    private int currentVideoIndex = 0;

    @Override
    public void init() {
        serviceManager.getClusterDetail(cluster.getId());
    }

    @Override
    @UiThread
    public void initData() {
        viewAct.clusterName().setText(cluster.getName());
        viewAct.total().setText("Total " + cluster.getTotalUnit() + " units");
        loadImage(cluster.getImage(), viewAct.image());
        setDataFacilities(cluster.getFacilities());
        setDataCarousel(cluster.getGallery());
        if (cluster.getVr() != null) {
            loadImage(cluster.getVr().get(0).getLink(), viewAct.vr());
        }
//        setVideoThumbnail();
        loadImage(cluster.getVideos().get(currentVideoIndex).getLink(), viewAct.video());

        //Todo: Add Floor Plan
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

    // Todo: remove set video thumbnail
    @Override
    @UiThread
    public void setVideoThumbnail() {
        loadImage(cluster.getVideos().get(currentVideoIndex).getLink(), viewAct.video());
    }

    @Override
    public void playVideo() {
        intentManager.moveToVideoViewer(cluster.getVideos().get(currentVideoIndex));
    }

    @Override
    public void nextVideo() {
        if (currentVideoIndex != cluster.getVideos().size()) {
            currentVideoIndex++;
        }
        else {
            currentVideoIndex = 0;
        }
    }

    @Override
    public void prevVideo() {
        if (currentVideoIndex != 0) {
            currentVideoIndex--;
        }
        else {
            currentVideoIndex = cluster.getVideos().size();
        }
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseGetClusterDetail) {
            cluster = ((ResponseGetClusterDetail) o).getCluster();
            initData();
        }
    }

    @Override
    public void onItemClick(Object o) {

    }
}
