package com.example.hoonianAgent.model.response.project;

import com.example.hoonianAgent.model.content.referred.Referred;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseGetReferredList extends BaseResponse<ResponseGetReferredList.ModelData> {
    public class ModelData {
        @SerializedName("referred_project")
        private ArrayList<Referred> listReferred;
    }

    public ArrayList<Referred> getListReferred() {
        return getData().listReferred;
    }
}
