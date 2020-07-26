package com.example.hoonianAgent.model.content.property;

import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.example.hoonianAgent.model.content.contacts.Contacts;
import com.example.hoonianAgent.presenter.utils.UtilsCurrency;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class PurchasedProject extends BaseSerializableObject {
    private String id;
    private int price;
    @SerializedName("purchase_status")
    private Status status;
    private Project project;
    @SerializedName("project_unit")
    private Unit unit;
    private Contacts client;
    private Agent agent;

    public String getCommission() {
        int commission = (int) ((float) price * project.getCommissionRate());
        return UtilsCurrency.toCurrency(commission);
    }
}
