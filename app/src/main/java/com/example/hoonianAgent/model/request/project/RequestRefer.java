package com.example.hoonianAgent.model.request.project;

import com.example.hoonianAgent.model.content.referred.Referred;
import com.google.gson.annotations.SerializedName;

public class RequestRefer {
    @SerializedName("agent_id")
    private String agentId;
    @SerializedName("contact_id")
    private String contactId;
    @SerializedName("project_id")
    private String projectId;
    private String note;

    public RequestRefer(Referred referred) {
        this.agentId = referred.getAgent().getId();
        this.contactId = referred.getContact().getId();
        this.projectId = referred.getProject().getId();
        this.note = referred.getNote();
    }
}
