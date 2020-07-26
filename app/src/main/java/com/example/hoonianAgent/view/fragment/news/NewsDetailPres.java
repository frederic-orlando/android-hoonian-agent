package com.example.hoonianAgent.view.fragment.news;

import com.example.hoonianAgent.model.content.CustomContent;

import java.util.ArrayList;

public interface NewsDetailPres {
    void init();
    void initData();
    void setDataContent(ArrayList<CustomContent> contents);
}
