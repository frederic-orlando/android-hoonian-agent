package com.example.hoonianAgent.model.response;

import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class BaseResponsePagination extends BaseSerializableObject {
    @SerializedName("total_data")
    private int totalData;
    @SerializedName("total_data_displayed")
    private int totalDataDisplayed;
    @SerializedName("limit_per_page")
    private int limitPerPage;
    @SerializedName("current_page")
    private int currentPage;
    @SerializedName("total_page")
    private int totalPage;
}
