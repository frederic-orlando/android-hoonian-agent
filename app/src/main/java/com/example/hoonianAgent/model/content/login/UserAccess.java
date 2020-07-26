package com.example.hoonianAgent.model.content.login;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import lombok.Data;

@Data
public class UserAccess {
    @SerializedName("group")
    private String name;
    @SerializedName("menus")
    private ArrayList<Menu> items;
}
