package com.example.hoonianAgent.model.response.project;

import com.example.hoonianAgent.model.content.property.Category;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.model.response.BaseResponsePagination;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ModelDataProjectList extends BaseResponsePagination {
    @SerializedName("selected_category_id")
    private String categoryId;
    @SerializedName("selected_city_id")
    private String cityId;
    private ArrayList<Project> projects;
    @SerializedName("project_categories")
    private ArrayList<Category> categories;
}
