package com.example.hoonianAgent.model.request.project;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class RequestGetUnitTypeDetail {
    @SerializedName("unit_type_id")
    private String id;
    @SerializedName("cluster_id")
    private String clusterId;
    @SerializedName("project_id")
    private String projectId;

    public RequestGetUnitTypeDetail(String id, String clusterId, String projectId) {
        this.id = id;
        this.clusterId = clusterId;
        this.projectId = projectId;
    }
}
