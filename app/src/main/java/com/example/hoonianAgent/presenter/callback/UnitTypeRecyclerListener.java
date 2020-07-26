package com.example.hoonianAgent.presenter.callback;

import com.example.hoonianAgent.model.content.File;

public interface UnitTypeRecyclerListener {
    void openFloorPlan(String clusterId, String unitTypeId);
    void openPriceList(File priceList);
}
