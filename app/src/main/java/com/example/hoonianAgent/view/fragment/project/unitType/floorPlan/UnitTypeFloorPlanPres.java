package com.example.hoonianAgent.view.fragment.project.unitType.floorPlan;

import com.example.hoonianAgent.model.content.Media;
import com.example.hoonianAgent.model.content.property.Unit;
import com.example.hoonianAgent.model.content.property.UnitType;
import com.example.hoonianAgent.model.response.project.ModelDataGetFloorPlan;

import java.util.ArrayList;

public interface UnitTypeFloorPlanPres {
    void init();
    void initData(ModelDataGetFloorPlan modelData);
    void setDataFloorPlan(ArrayList<Unit> units, String url);
    void getData();
    void nextFloor();
    void prevFloor();
}
