package com.example.hoonianAgent.view.fragment.project.detail;

import com.example.hoonianAgent.model.content.Media;
import com.example.hoonianAgent.model.content.property.Facility;
import com.example.hoonianAgent.model.content.property.Project;

import java.util.ArrayList;

public interface ProjectDetailPres {
    void init();
    void initData();
    void initMap();
    void openMap();
    void setDataWarehouseInfo();
    void setDataFacilities(ArrayList<Facility> listFacility);
    void setDataCarousel(ArrayList<Media> listGallery);
    void setVideoThumbnail();
    void favorite();
    void share();
    void playVideo();
    void nextVideo();
    void prevVideo();
}
