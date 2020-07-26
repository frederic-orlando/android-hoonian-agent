package com.example.hoonianAgent.model.response.profile;

import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.response.BaseResponse;

public class ResponseGetProfile extends BaseResponse<ResponseGetProfile.ModelData> {
    public class ModelData {
        private Agent agent;
    }

    public Agent getAgent() {
        return getData().agent;
    }
}
