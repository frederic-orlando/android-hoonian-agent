package com.example.hoonianAgent.model.response.purchase;

import com.example.hoonianAgent.model.content.property.PurchasedProject;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

public class ResponseGetPurchaseDetail extends BaseResponse<ResponseGetPurchaseDetail.ModelData> {
    public class ModelData {
        @SerializedName("project_purchase")
        private PurchasedProject purchased;
    }

    public PurchasedProject getPurchased() {
        return getData().purchased;
    }
}
