package com.example.hoonianAgent.model.content.news;

import com.example.hoonianAgent.model.content.BaseHomeItem;
import com.example.hoonianAgent.model.content.CustomContent;

import java.util.ArrayList;

import lombok.Data;

@Data
public class News extends BaseHomeItem {
    private String title;
    private ArrayList<CustomContent> content;
}
