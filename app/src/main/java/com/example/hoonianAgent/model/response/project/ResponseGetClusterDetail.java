package com.example.hoonianAgent.model.response.project;

import com.example.hoonianAgent.model.content.property.Cluster;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

public class ResponseGetClusterDetail extends BaseResponse<ResponseGetClusterDetail.ModelData> {
    public class ModelData {
        @SerializedName("project_cluster")
        private Cluster cluster;
    }

    public Cluster getCluster() {
        return getData().cluster;
    }
}
