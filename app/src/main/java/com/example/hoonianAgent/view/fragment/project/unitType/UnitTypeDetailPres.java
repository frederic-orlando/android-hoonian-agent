package com.example.hoonianAgent.view.fragment.project.unitType;

import com.example.hoonianAgent.model.content.Media;
import com.example.hoonianAgent.model.content.property.Facility;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.model.content.property.UnitType;

import java.util.ArrayList;

public interface UnitTypeDetailPres {
    void init();
    void initData(UnitType unitType);
    void setDataCarousel(ArrayList<Media> listGallery);
    void setVideoThumbnail();
    void playVideo();
    void nextVideo();
    void prevVideo();
}
