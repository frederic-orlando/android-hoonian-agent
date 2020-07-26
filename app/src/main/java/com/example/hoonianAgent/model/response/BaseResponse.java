package com.example.hoonianAgent.model.response;

import com.google.gson.annotations.SerializedName;

import lombok.Data;


@Data
public class BaseResponse<T> extends connection.rxconnection.model.BaseResponse<T> {
    @SerializedName("status_desc")
    private String status;
    private String message;
}
