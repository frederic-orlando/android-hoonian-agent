package com.example.hoonianAgent.model.content.agent;

import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Agent extends BaseSerializableObject {
    private String id;
    private String name;
    @SerializedName("profile_image")
    private String image;
    @SerializedName("phone_number")
    private String phone;
    private String email;
    @SerializedName("id_card_number")
    private String idCardNo;
    @SerializedName("id_card_photo")
    private String idCardUrl;
    @SerializedName("bank_id")
    private String bankId;
    @SerializedName("account_bank")
    private String bank;
    @SerializedName("account_number")
    private String accountNo;
    @SerializedName("birth_date")
    private String bod;
    @SerializedName("birth_place")
    private String birthPlace;
    private String address;
    private String company;
    private String position;
    @SerializedName("total_commisions")
    private int totalCommission;
    @SerializedName("total_paid")
    private int totalPaid;
    @SerializedName("total_on_hold")
    private int totalHold;
    @SerializedName("total_pending")
    private int totalPending;

    public Agent(String name, String phone, String idCardNo, String bankId, String accountNo) {
        this.name = name;
        this.phone = phone;
        this.idCardNo = idCardNo;
        this.bankId = bankId;
        this.accountNo = accountNo;
    }

    public Agent(String id, String name, String image, String phone, String email, String idCardNo, String idCardUrl, String bankId, String accountNo, String bod, String birthPlace, String address, String company, String position) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.phone = phone;
        this.email = email;
        this.idCardNo = idCardNo;
        this.idCardUrl = idCardUrl;
        this.bankId = bankId;
        this.accountNo = accountNo;
        this.bod = bod;
        this.birthPlace = birthPlace;
        this.address = address;
        this.company = company;
        this.position = position;
    }
}
