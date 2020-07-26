package com.example.hoonianAgent.model.response.city;

import com.example.hoonianAgent.model.content.City;
import com.example.hoonianAgent.model.content.home.HomeItem;
import com.example.hoonianAgent.model.response.BaseResponse;

import java.util.ArrayList;

public class ResponseGetCityList extends BaseResponse<ResponseGetCityList.ModelData> {
    public class ModelData {
        private ArrayList<City> cities;
    }

    public ArrayList<City> getCities() {
        return getData().cities;
    }
}
