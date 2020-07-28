package com.example.hoonianAgent.presenter.callback;

import com.example.hoonianAgent.model.content.File;
import com.example.hoonianAgent.model.content.property.UnitType;

public interface UnitTypeRecyclerListener {
    void openFloorPlan(UnitType unitType);
    void openPriceList(File priceList);
}
