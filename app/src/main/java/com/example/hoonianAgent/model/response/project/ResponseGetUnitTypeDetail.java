package com.example.hoonianAgent.model.response.project;

import com.example.hoonianAgent.model.content.property.UnitType;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.google.gson.annotations.SerializedName;


public class ResponseGetUnitTypeDetail extends BaseResponse<ResponseGetUnitTypeDetail.ModelData> {
    public class ModelData {
        @SerializedName("project_unit_type")
        private UnitType unitType;
    }

    public UnitType getUnitTpe() {
        return getData().unitType;
    }
}
