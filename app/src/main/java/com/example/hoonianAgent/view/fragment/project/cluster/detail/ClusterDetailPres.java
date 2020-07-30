package com.example.hoonianAgent.view.fragment.project.cluster.detail;

import com.example.hoonianAgent.model.content.Media;
import com.example.hoonianAgent.model.content.property.Facility;
import com.example.hoonianAgent.model.content.property.Unit;
import com.example.hoonianAgent.model.content.property.UnitTypeTable;
import com.example.hoonianAgent.model.response.project.ModelDataGetFloorPlan;

import java.util.ArrayList;

public interface ClusterDetailPres {
    void init();
    void initData();
    void setDataFacilities(ArrayList<Facility> listFacility);
    void setDataCarousel(ArrayList<Media> listGallery);
    void setVideoThumbnail();
    void setDataUnitCount(ArrayList<UnitTypeTable> unitTypeTables);
    void getDataFloorPlan();
    void setDataFloorPlan(ArrayList<Unit> units, String url);
    void nextFloor();
    void prevFloor();
    void playVideo();
    void nextVideo();
    void prevVideo();
}
