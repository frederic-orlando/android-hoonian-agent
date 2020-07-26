package com.example.hoonianAgent.model.response.purchase;

import com.example.hoonianAgent.model.content.property.PurchasedProject;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseGetPurchaseList extends BaseResponse<ResponseGetPurchaseList.ModelData> {
    public class ModelData {
        @SerializedName("project_purchase")
        private ArrayList<PurchasedProject> purchased;
    }

    public ArrayList<PurchasedProject> getPurchased() {
        return getData().purchased;
    }
}
