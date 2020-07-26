package com.example.hoonianAgent.model.response.project;

import com.example.hoonianAgent.model.content.property.Cluster;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseGetClusterList extends BaseResponse<ResponseGetClusterList.ModelData> {
    public class ModelData {
        @SerializedName("project_clusters")
        private ArrayList<Cluster> cluster;
    }

    public ArrayList<Cluster> getCluster() {
        return getData().cluster;
    }
}
