package com.example.hoonianAgent.view.fragment.purchase.detail;

import com.example.hoonianAgent.model.content.Media;
import com.example.hoonianAgent.model.content.customShape.Point;
import com.example.hoonianAgent.model.content.property.PurchasedProject;
import com.example.hoonianAgent.model.content.property.Unit;

import java.util.ArrayList;

public interface PurchaseDetailPres {
    void init();
    void initData(PurchasedProject purchased);
    void initFloorPlan(Unit unit, String url);
    void setDataCarousel(ArrayList<Media> listGallery);
}
