package com.example.hoonianAgent.model.response.contacts;

import com.example.hoonianAgent.model.content.contacts.Contacts;
import com.example.hoonianAgent.model.content.home.HomeItem;
import com.example.hoonianAgent.model.response.BaseResponse;

import java.util.ArrayList;

public class ResponseGetContactEditForm extends BaseResponse<ResponseGetContactEditForm.ModelData> {
    public class ModelData {
        private Contacts contact;
        private ArrayList<HomeItem> cities;
    }

    public Contacts getContact() {
        return getData().contact;
    }

    public ArrayList<HomeItem> getCities() {
        return getData().cities;
    }
}
