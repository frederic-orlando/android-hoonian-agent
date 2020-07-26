package com.example.hoonianAgent.model.response.contacts;

import com.example.hoonianAgent.model.content.contacts.Contacts;
import com.example.hoonianAgent.model.response.BaseResponse;

public class ResponseGetContactDetail extends BaseResponse<ResponseGetContactDetail.ModelData> {
    public class ModelData {
        private Contacts contact;
    }

    public Contacts getContact() {
        return getData().contact;
    }
}
