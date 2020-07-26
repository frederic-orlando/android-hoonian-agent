package com.example.hoonianAgent.model.content.login;

import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.content.home.ModelDataHome;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import lombok.Data;

@Data
public class ModelDataLogin extends BaseResponse {
    @SerializedName("access_token")
    private String token;
    private Agent agent;
    @SerializedName("home")
    private ModelDataHome dataHome;
    @SerializedName("menu_navbar")
    private ArrayList<Menu> menuNavBars;
    @SerializedName("access_list")
    private ArrayList<UserAccess> userAccess;
}
