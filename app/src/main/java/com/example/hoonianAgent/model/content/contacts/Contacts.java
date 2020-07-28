package com.example.hoonianAgent.model.content.contacts;

import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.model.content.property.ReferredProject;
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
    @SerializedName("total_referred")
    private int referred;
    @SerializedName("total_purchase")
    private int purchase;

    @SerializedName("agent_contact_referreds")
    private ArrayList<ReferredProject> referredProjects;
    @SerializedName("agent_purchased_project")
    private ArrayList<ReferredProject> purchasedProjects;

    public Contacts(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Contacts(String id, String agentId, String name, String phone, String idNo, String position, String cityId, String relation) {
        this.id = id;
        this.agentId = agentId;
        this.name = name;
        this.phone = phone;
        this.idNo = idNo;
        this.position = position;
        this.cityId = cityId;
        this.relation = relation;
    }
}