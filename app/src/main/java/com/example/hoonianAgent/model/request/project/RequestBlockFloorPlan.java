package com.example.hoonianAgent.model.request.project;

import com.example.hoonianAgent.model.request.base.BaseRequestPagination;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class RequestBlockFloorPlan extends BaseRequestPagination {
    @SerializedName("project_id")
    private String projectId;
    @SerializedName("cluster_id")
    private String clusterId;
    @SerializedName("unit_type_id")
    private String unitTypeId;

    public RequestBlockFloorPlan(String projectId, String clusterId, String unitTypeId, int limitPerPage, int page) {
        super(limitPerPage, page);
        this.projectId = projectId;
        this.clusterId = clusterId;
        this.unitTypeId = unitTypeId;
    }
}
