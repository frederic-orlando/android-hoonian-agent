package com.example.hoonianAgent.presenter.manager;

import android.content.Context;
import android.os.Handler;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.content.contacts.Contacts;
import com.example.hoonianAgent.model.content.login.ModelDataLogin;
import com.example.hoonianAgent.model.request.auth.RequestChangePassword;
import com.example.hoonianAgent.model.request.auth.RequestForgetPassword;
import com.example.hoonianAgent.model.request.auth.RequestLogin;
import com.example.hoonianAgent.model.request.project.RequestProjectList;
import com.example.hoonianAgent.model.request.auth.RequestOTP;
import com.example.hoonianAgent.model.request.auth.RequestRegister;
import com.example.hoonianAgent.model.request.project.RequestFavorite;
import com.example.hoonianAgent.model.request.project.RequestFloorPlan;
import com.example.hoonianAgent.model.request.project.RequestGetUnitTypeDetail;
import com.example.hoonianAgent.model.request.project.RequestRefer;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.model.response.login.ResponseLogin;
import com.example.hoonianAgent.presenter.connection.auth.ConChangePassword;
import com.example.hoonianAgent.presenter.connection.auth.ConForgetPassword;
import com.example.hoonianAgent.presenter.connection.auth.ConLogin;
import com.example.hoonianAgent.presenter.connection.auth.ConRegister;
import com.example.hoonianAgent.presenter.connection.auth.ConRequestOTP;
import com.example.hoonianAgent.presenter.connection.bank.ConGetBankList;
import com.example.hoonianAgent.presenter.connection.city.ConGetCityList;
import com.example.hoonianAgent.presenter.connection.contacts.ConAddContact;
import com.example.hoonianAgent.presenter.connection.contacts.ConEditContact;
import com.example.hoonianAgent.presenter.connection.contacts.ConGetContactDetail;
import com.example.hoonianAgent.presenter.connection.contacts.ConGetContactList;
import com.example.hoonianAgent.presenter.connection.contacts.ConGetEditContactForm;
import com.example.hoonianAgent.presenter.connection.home.ConGetHome;
import com.example.hoonianAgent.presenter.connection.news.ConGetNewsDetail;
import com.example.hoonianAgent.presenter.connection.profile.ConEditProfile;
import com.example.hoonianAgent.presenter.connection.profile.ConGetProfile;
import com.example.hoonianAgent.presenter.connection.projects.ConFavorite;
import com.example.hoonianAgent.presenter.connection.projects.ConGetClusterDetail;
import com.example.hoonianAgent.presenter.connection.projects.ConGetClusterList;
import com.example.hoonianAgent.presenter.connection.projects.ConGetFloorPlan;
import com.example.hoonianAgent.presenter.connection.projects.ConGetProjectDetail;
import com.example.hoonianAgent.presenter.connection.projects.ConGetProjectList;
import com.example.hoonianAgent.presenter.connection.projects.ConGetPurchaseDetail;
import com.example.hoonianAgent.presenter.connection.projects.ConGetReferredForm;
import com.example.hoonianAgent.presenter.connection.projects.ConGetReferredList;
import com.example.hoonianAgent.presenter.connection.projects.ConGetUnitTable;
import com.example.hoonianAgent.presenter.connection.projects.ConGetUnitTypeDetail;
import com.example.hoonianAgent.presenter.connection.projects.ConRefer;
import com.example.hoonianAgent.presenter.connection.projects.ConUnfavorite;
import com.example.hoonianAgent.presenter.connection.purchase.ConGetPurchasedList;
import com.example.hoonianAgent.presenter.utils.UtilsCon;
import com.example.hoonianAgent.presenter.utils.UtilsUser;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.res.StringRes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import connection.rxconnection.connection.CallBackForLog;
import connection.rxconnection.connection.ConnectionListener;
import connection.rxconnection.connection.ConnectionManager;
import connection.rxconnection.connection.HttpRequest;
import connection.rxconnection.model.ModelLog;
import connection.rxconnection.session.SessionLogin;

@EBean
public class ServiceManager extends ConnectionManager implements ConnectionListener, CallBackForLog {
    @RootContext
    protected Context context;

    @AfterInject
    protected void init() { setContext(context); }

    private ConnectionListener listener;
    private boolean refreshToken;
    @Bean
    protected DialogManager dialogmanager;
    @Bean
    protected UtilsCon utilsCon;
    private boolean showError = true;
    private List<HttpRequest> listRequestHold = new ArrayList<>();
    @Bean
    protected UtilsUser utilsUser;

    @StringRes(R.string.waiting_download)
    protected String waitingDownload;
    @StringRes(R.string.waiting)
    protected String waiting;
    @StringRes(R.string.waiting_login)
    protected String waitingLogin;
    @StringRes(R.string.no_internet)
    protected String noInternet;
    @StringRes(R.string.internal_server_error)
    protected String internalServerError;

    private ModelDataLogin modelDataLogin;

    @AfterInject
    protected void inject() {
        //modelDataLogin = new SessionUser(context).getData();
    }

    @Override
    public ConnectionManager setContext(Context context) {
        return super.setContext(context);
    }

    public ServiceManager setShowError(boolean showError) {
        this.showError = showError;
        return this;
    }

    @Override
    public ConnectionManager setConnectionListener(ConnectionListener connectionListener) {
        listener = connectionListener;
        return super.setConnectionListener(this);
    }

    private void initSubscribe(HttpRequest httpRequest, String message, boolean checkConnection) {
        initCon(httpRequest);
        checkConnectionSubscribe(httpRequest, message, checkConnection);
    }

    private void checkConnectionSubscribe(HttpRequest httpRequest, String message,
                                          boolean checkConnection) {
        try {
            if (checkConnection)
                if (utilsCon.isInternetAvailable(getContext())) {
                    subscribe(httpRequest, message);
                } else {
                    showDialog(noInternet);
                    listener.onError(null, httpRequest);
                }
            else
                subscribe(httpRequest, message);
        } catch (Exception e) {
            e.printStackTrace();
            listener.onError(e.getMessage(), httpRequest);
        }
    }

    private void checkConnectionSubscribe(HttpRequest httpRequest, boolean checkConnection) {
        try {
            if (checkConnection)
                if (utilsCon.isInternetAvailable(getContext())) {
                    subscribe(httpRequest);
                } else {
                    showDialog(noInternet);
                    listener.onError(null, httpRequest);
                }
            else
                subscribe(httpRequest);
        } catch (Exception e) {
            e.printStackTrace();
            listener.onError(e.getMessage(), httpRequest);
        }
    }

    private void initCon(HttpRequest httpRequest) {
        httpRequest.setCustomHeader(header());
        httpRequest.setLogInfoRequestResponse(true);
        httpRequest.setCallBackForLog(this);
    }

    private void initSubscribe(HttpRequest httpRequest, boolean checkConnection) {
        initCon(httpRequest);
        checkConnectionSubscribe(httpRequest, checkConnection);
    }

    @Override
    public void onSuccessWithData(Object o) {
        if (o instanceof BaseResponse) {
            String status = ((BaseResponse) o).getStatus();
            if (status.equals("Success") | status.equals("Created")) {
                if (o instanceof ResponseLogin) {
                    utilsUser.setData(((ResponseLogin) o).getData());
                }
                listener.onSuccessWithData(o);
                return;
            }
            else if (status.equals("Failed")) {
                showDialog(((BaseResponse) o).getMessage());
            }
        }
    }


    @Override
    public void onSuccessNull() {
        listener.onSuccessNull();
    }

    @Override
    public void onMessageSuccess(String s) {
        listener.onMessageSuccess(s);
        showDialog(s);
    }

    public void showDialog(final String s) {
        if (!s.toLowerCase().contains("attempt to invoke virtual method"))
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    if (dialogmanager == null) {
                        dialogmanager = new DialogManager();
                    }
                    dialogmanager.errorDialog(s);
                }
            });
    }

    @UiThread
    @Override
    public void onError(final Object o, HttpRequest httpRequest) {
        if (showError) {
            String message = getErrorMessage(o);
            if (message != null)
                showDialog(message.contains("timed out") ? internalServerError : message);

        }

        listener.onError(o, httpRequest);
    }

    public String getErrorMessage(Object o) {
        String message = (String) o;
        return message;
    }

    @Override
    public void unAuthorized(HttpRequest httpRequest, String errorMessage) {
        listener.unAuthorized(httpRequest, errorMessage);
    }

    private Map<String, String> header() {
        Map<String, String> header = new HashMap<String, String>();
        String token = new SessionLogin(getContext()).getToken();
        if (token != null)
            header.put("Authorization", new SessionLogin(getContext()).getToken());
        header.put("Accept", "application/json");
        return header;
    }

    @Override
    public void log(ModelLog modelLog) {

    }

    public void login(RequestLogin request) {
        initSubscribe(new ConLogin(request, getContext()),
                waitingLogin, true);
    }
    public void register(RequestRegister request) {
        initSubscribe(new ConRegister(request, getContext()),
                waitingLogin, true);
    }
    public void requestOTP(RequestOTP request) {
        initSubscribe(new ConRequestOTP(request, getContext()),
                waitingLogin, true);
    }
    public void verifyOTP(RequestOTP request) {
        initSubscribe(new ConRequestOTP(request, getContext()),
                waitingLogin, true);
    }
    public void forgetPassword(RequestForgetPassword request) {
        initSubscribe(new ConForgetPassword(request, getContext()),
                waitingLogin, true);
    }
    public void getHome(String agentId) {
        initSubscribe(new ConGetHome(agentId, getContext()),
                waitingLogin, true);
    }
    public void getNewsDetail(String newsId) {
        initSubscribe(new ConGetNewsDetail(newsId, getContext()),
                waitingLogin, true);
    }
    public void getContactList(String agentId) {
        initSubscribe(new ConGetContactList(agentId, getContext()),
                waitingLogin, true);
    }
    public void getCityList() {
        initSubscribe(new ConGetCityList(getContext()),
                waitingLogin, true);
    }
    public void getProjectList(RequestProjectList request) {
        initSubscribe(new ConGetProjectList(request, getContext()),
                waitingLogin, true);
    }
    public void getProfile(String agentId) {
        initSubscribe(new ConGetProfile(agentId, getContext()),
                waitingLogin, true);
    }
    public void changePassword(RequestChangePassword request) {
        initSubscribe(new ConChangePassword(request, getContext()),
                waitingLogin, true);
    }
    public void getPurchaseList(String agentId) {
        initSubscribe(new ConGetPurchasedList(agentId, getContext()),
                waitingLogin, true);
    }
    public void getPurchaseDetail(String purchaseId) {
        initSubscribe(new ConGetPurchaseDetail(purchaseId, getContext()),
                waitingLogin, true);
    }
    public void getProjectDetail(String projectId) {
        initSubscribe(new ConGetProjectDetail(projectId, getContext()),
                waitingLogin, true);
    }
    public void getClusterList(String projectId) {
        initSubscribe(new ConGetClusterList(projectId, getContext()),
                waitingLogin, true);
    }
    public void getReferredList(String agentId, String projectId) {
        initSubscribe(new ConGetReferredList(agentId, projectId, getContext()),
                waitingLogin, true);
    }
    public void getUnitTypeDetail(RequestGetUnitTypeDetail request) {
        initSubscribe(new ConGetUnitTypeDetail(request, getContext()),
                waitingLogin, true);
    }
    public void favoriteProject(RequestFavorite request) {
        initSubscribe(new ConFavorite(request, getContext()),
                waitingLogin, true);
    }
    public void unfavoriteProject(RequestFavorite request) {
        initSubscribe(new ConUnfavorite(request, getContext()),
                waitingLogin, true);
    }
    public void getClusterDetail(String clusterId) {
        initSubscribe(new ConGetClusterDetail(clusterId, getContext()),
                waitingLogin, true);
    }
    public void getReferredForm(String agentId, String projectId) {
        initSubscribe(new ConGetReferredForm(agentId, projectId, getContext()),
                waitingLogin, true);
    }
    public void referProject(RequestRefer request) {
        initSubscribe(new ConRefer(request, getContext()),
                waitingLogin, true);
    }
    public void getContactDetail(String contactId, String agentId) {
        initSubscribe(new ConGetContactDetail(contactId, agentId, getContext()),
                waitingLogin, true);
    }
    public void addContact(Contacts request) {
        initSubscribe(new ConAddContact(request, getContext()),
                waitingLogin, true);
    }
    public void getEditContactForm(String agentId, String contactId) {
        initSubscribe(new ConGetEditContactForm(agentId, contactId, getContext()),
                waitingLogin, true);
    }
    public void editContact(Contacts request) {
        initSubscribe(new ConEditContact(request, getContext()),
                waitingLogin, true);
    }
    public void editProfile(Agent request) {
        initSubscribe(new ConEditProfile(request, getContext()),
                waitingLogin, true);
    }
    public void getBankList() {
        initSubscribe(new ConGetBankList(getContext()),
                waitingLogin, true);
    }
    public void getFloorPlan(RequestFloorPlan request) {
        initSubscribe(new ConGetFloorPlan(request, getContext()),
                waitingLogin, true);
    }
    public void getUnitTable(RequestFloorPlan request) {
        initSubscribe(new ConGetUnitTable(request, getContext()),
                waitingLogin, true);
    }
}
