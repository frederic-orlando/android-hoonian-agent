package com.example.hoonianAgent.model.request;

import com.example.hoonianAgent.model.request.base.BaseRequestPagination;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class RequestProjectList extends BaseRequestPagination {
    @SerializedName("selected_city_id")
    private String cityId;
    @SerializedName("selected_category_id")
    private String categoryId;

    public RequestProjectList(int limitPerPage, int page, String cityId, String categoryId) {
        super(limitPerPage, page);
        this.cityId = cityId;
        this.categoryId = categoryId;
    }
}
