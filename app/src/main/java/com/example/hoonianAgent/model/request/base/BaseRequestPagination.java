package com.example.hoonianAgent.model.request.base;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class BaseRequestPagination {
    @SerializedName("limit_per_page")
    private int limitPerPage;
    private int page;

    public BaseRequestPagination(int limitPerPage, int page) {
        this.limitPerPage = limitPerPage;
        this.page = page;
    }
}
