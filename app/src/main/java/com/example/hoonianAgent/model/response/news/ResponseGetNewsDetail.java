package com.example.hoonianAgent.model.response.news;

import com.example.hoonianAgent.model.content.news.News;
import com.example.hoonianAgent.model.response.BaseResponse;

public class ResponseGetNewsDetail extends BaseResponse<ResponseGetNewsDetail.ModelData> {
    public class ModelData {
        private News news;
    }

    public News getNews() {
        return getData().news;
    }
}
