package com.example.hoonianAgent.model.response.project;

import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.model.response.BaseResponse;

public class ResponseGetProjectDetail extends BaseResponse<ResponseGetProjectDetail.ModelData> {
    public class ModelData {
        private Project project;
    }

    public Project getProject() {
        return getData().project;
    }
}
