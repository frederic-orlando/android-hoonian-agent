package com.example.hoonianAgent.view.fragment.home;

import com.example.hoonianAgent.model.content.City;
import com.example.hoonianAgent.model.content.home.HomeItem;
import com.example.hoonianAgent.model.content.news.News;
import com.example.hoonianAgent.model.content.property.Category;

import java.util.ArrayList;

public interface HomePres {
    void init();
    void initData();
    void setDataCarousel(ArrayList<News> listNews);
    void seeMoreLocation();
    void setDataLocation(ArrayList<City> listCities);
    void setDataProperty(ArrayList<Category> listNews);
}
