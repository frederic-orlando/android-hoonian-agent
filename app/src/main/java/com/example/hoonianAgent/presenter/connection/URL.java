package com.example.hoonianAgent.presenter.connection;

import com.example.hoonianAgent.BuildConfig;
import com.example.hoonianAgent.model.request.RequestProjectList;
import com.example.hoonianAgent.model.request.project.RequestBlockFloorPlan;

public class URL {
    private static final String BASE_URL = BuildConfig.API_BASE_URL;
    public static final String BASE_URL_AGENT = BASE_URL + "/agent";
    public static final String BASE_URL_NEWS = BASE_URL + "/news";
    public static final String BASE_URL_CITY = BASE_URL + "/city";
    public static final String BASE_URL_PROJECT = BASE_URL + "/project";
    public static final String BASE_URL_CONTACT = BASE_URL_AGENT + "/contact";

    public static final String LOGIN = BASE_URL_AGENT + "/login";
    public static final String REGISTER = BASE_URL_AGENT + "/register";
    public static final String PASSWORD = BASE_URL_AGENT + "/password";
    public static final String FORGET_PASSWORD = PASSWORD + "/forgot";
    public static final String FAVORITE = BASE_URL_AGENT + "/favorite";
    public static final String REFER = BASE_URL_AGENT + "/referred";
    public static final String UPDATE_PROFILE = BASE_URL_AGENT + "/profile/update";
    public static final String CONTACT_DETAIL = BASE_URL_CONTACT + "/detail";

    public static final String getHome(String id) {
        return BASE_URL_AGENT + "/home?id=" + id;
    }
    public static final String getNewsDetail(String id) {
        return BASE_URL_NEWS + "/detail?id=" + id;
    }
    public static final String getContactList(String id) {
        return BASE_URL_CONTACT + "?agent_id=" + id;
    }
    public static final String getCityList() {
        return BASE_URL_CITY;
    }
    public static final String getProjectList(RequestProjectList request) {
        return BASE_URL_PROJECT + "?limit_per_page=" + request.getLimitPerPage()
                + "&page=" + request.getPage()
                + "&selected_city_id=" + request.getCityId()
                + "&selected_category_id=" + request.getCategoryId();
    }
    public static final String getProfile(String id) {
        return BASE_URL_AGENT + "/profile?id=" + id;

    }
    public static final String getPurchaseList(String id) {
        return BASE_URL_AGENT + "/purchase?agent_id=" + id;
    }
    public static final String getPurchaseDetail(String id) {
        return BASE_URL_AGENT + "/purchase/detail?purchase_id=" + id;
    }
    public static final String getProjectDetail(String id) {
        return BASE_URL_PROJECT + "/detail?id=" + id;
    }
    public static final String getClusterList(String id) {
        return BASE_URL_PROJECT + "/detail/cluster?project_id=" + id;

    }
    public static final String getClusterDetail(String id) {
        return BASE_URL_PROJECT + "/detail/cluster/detail?id=" + id;

    }
    public static final String getReferredList(String agentId, String projectId) {
        return BASE_URL_AGENT + "/referred?agent_id=" + agentId + "&project_id=" + projectId;
    }
    public static final String getUnitTypeDetail(String unitTypeId) {
        return BASE_URL_PROJECT + "/detail/unit-type/detail?unit_type_id=" + unitTypeId;
    }
    public static final String getReferredForm(String agentId, String projectId) {
        return BASE_URL_AGENT + "/referred/create?agent_id=" + agentId
                + "&project_id=" + projectId;
    }
    public static final String getContactDetail(String contactId) {
        return CONTACT_DETAIL + "?contact_id=" + contactId;
    }
    public static final String getContactForm(String agentId, String contactId) {
        return CONTACT_DETAIL + "/edit?agent_id=" + agentId
                + "&contact_id=" + contactId;
    }
    public static final String getFloorPlan(RequestBlockFloorPlan request) {
        return CONTACT_DETAIL + "/detail/cluster/floorplan?project_id=" + request.getProjectId()
                + "&cluster_id=" + request.getClusterId()
                + "&page=" + request.getPage() + "&limit_per_page=" + request.getLimitPerPage()
                + "&unit_type_id=" + request.getUnitTypeId();
    }
    public static final String getBankList() {
        return BASE_URL + "/bank";
    }
}