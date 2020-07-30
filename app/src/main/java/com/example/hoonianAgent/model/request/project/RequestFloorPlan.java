package com.example.hoonianAgent.model.request.project;

import com.example.hoonianAgent.model.request.base.BaseRequestPagination;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class RequestFloorPlan extends BaseRequestPagination {
    @SerializedName("project_id")
    private String projectId;
    @SerializedName("cluster_id")
    private String clusterId;
    @SerializedName("unit_type_id")
    private String unitTypeId;
    @SerializedName("block_id")
    private String blockId;

    public RequestFloorPlan(String clusterId, String unitTypeId, String blockId) {
        super();
        this.clusterId = clusterId;
        this.unitTypeId = unitTypeId;
        this.blockId = blockId;
    }

    public RequestFloorPlan(String projectId, String clusterId, String unitTypeId, int page) {
        super(page);
        this.projectId = projectId;
        this.clusterId = clusterId;
        this.unitTypeId = unitTypeId;
    }
}