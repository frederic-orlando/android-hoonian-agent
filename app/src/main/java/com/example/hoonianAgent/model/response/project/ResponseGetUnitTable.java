package com.example.hoonianAgent.model.response.project;

import com.example.hoonianAgent.model.content.property.UnitTypeTable;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseGetUnitTable extends BaseResponse<ResponseGetUnitTable.ModelData> {
    public class ModelData {
        @SerializedName("unit_type_table")
        private ArrayList<UnitTypeTable> unitTypeTable;
    }

    public ArrayList<UnitTypeTable> getUnitTypeTable() {
        return getData().unitTypeTable;
    }
}