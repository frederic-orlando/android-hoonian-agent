package com.example.hoonianAgent.model.response.contacts;

import com.example.hoonianAgent.model.content.contacts.Contacts;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.model.response.BaseResponsePagination;

import java.util.ArrayList;

public class ResponseGetContactList extends BaseResponse<ResponseGetContactList.ModelData> {
    public class ModelData extends BaseResponsePagination {
        private ArrayList<Contacts> contacts;
    }

    public ArrayList<Contacts> getContacts() {
        return getData().contacts;
    }
}

