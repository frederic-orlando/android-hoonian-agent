package com.example.hoonianAgent.view.fragment.project.cluster.detail;

import com.example.hoonianAgent.model.content.Media;
import com.example.hoonianAgent.model.content.property.Facility;

import java.util.ArrayList;

public interface ClusterDetailPres {
    void init();
    void initData();
    void setDataFacilities(ArrayList<Facility> listFacility);
    void setDataCarousel(ArrayList<Media> listGallery);
    void setVideoThumbnail();
    void playVideo();
    void nextVideo();
    void prevVideo();
}
