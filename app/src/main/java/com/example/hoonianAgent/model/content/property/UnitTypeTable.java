package com.example.hoonianAgent.model.content.property;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class UnitTypeTable {
    @SerializedName("unit_type_name")
    private String unitTypeName;
    @SerializedName("total_unit")
    private int totalUnit;
    @SerializedName("available_unit")
    private int availableUnit;
    @SerializedName("sold_unit")
    private int soldUnit;
    @SerializedName("start_price")
    private int startPrice;
}
