package com.example.hoonianAgent.model.request.project;

import com.google.gson.annotations.SerializedName;

public class RequestFavorite {
    @SerializedName("project_id")
    private String projectId;
    @SerializedName("agent_id")
    private String agentId;

    public RequestFavorite(String projectId, String agentId) {
        this.projectId = projectId;
        this.agentId = agentId;
    }
}
