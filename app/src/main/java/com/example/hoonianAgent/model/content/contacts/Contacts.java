package com.example.hoonianAgent.model.content.contacts;

import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.example.hoonianAgent.model.content.property.Project;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Contacts extends BaseSerializableObject {
    private String id;
    @SerializedName("agent_id")
    private String agentId;
    private String name;
    @SerializedName("phone_number")
    private String phone;
    @SerializedName("id_card_number")
    private String idNo;
    @SerializedName("occupation")
    private String position;
    @SerializedName("city_id")
    private String cityId;
    private String relation;
    private int referred;
    private int purchase;

    @SerializedName("referred_project")
    private ArrayList<Project> referredProjects;
    @SerializedName("purchased_project")
    private ArrayList<Project> purchasedProjects;

    public Contacts(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Contacts(String agentId, String name, String phone, String idNo, String position, String cityId, String relation) {
        this.agentId = agentId;
        this.name = name;
        this.phone = phone;
        this.idNo = idNo;
        this.position = position;
        this.cityId = cityId;
        this.relation = relation;
    }
}