package com.example.hoonianAgent.model.content.referred;

import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.content.contacts.Contacts;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.model.content.property.Status;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Referred {
    private Contacts contacts;
    private Agent agent;
    private Project project;
    @SerializedName("referred_status")
    private Status status;
    private String note;

    private Boolean isSelected;

    public Referred(Contacts contacts, Agent agent, Project project) {
        this.contacts = contacts;
        this.agent = agent;
        this.project = project;
        this.isSelected = false;
    }
}
