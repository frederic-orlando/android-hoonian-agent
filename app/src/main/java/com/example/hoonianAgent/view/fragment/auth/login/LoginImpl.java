package com.example.hoonianAgent.view.fragment.auth.login;

import com.example.hoonianAgent.model.request.auth.RequestLogin;
import com.example.hoonianAgent.model.response.login.ResponseLogin;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.view.activity.auth.AuthImpl;
import com.example.hoonianAgent.view.fragment.auth.forgetPassword.requestOTP.RequestOTPFragment_;
import com.example.hoonianAgent.view.fragment.auth.register.RegisterFragment_;

import org.androidannotations.annotations.EBean;

import connection.rxconnection.connection.HttpRequest;
import lombok.Setter;

@EBean
public class LoginImpl extends BaseImpl<LoginView> implements LoginPres {
    @Setter
    private AuthImpl callback;
    @Override
    public void onValidationSucceeded() {
        super.onValidationSucceeded();
        login();
    }

    @Override
    public void init() {
        initValidator(viewAct);
    }

    @Override
    public void login() {
        RequestLogin requestLogin = new RequestLogin();
        requestLogin.setPassword(utilsLayout.getBodyText(viewAct.password()));
        if (utilsLayout.checkLength(viewAct.phone())) {
            String username = utilsLayout.getBodyText(viewAct.phone());
            requestLogin.setPhone(username);
        }
        serviceManager.login(requestLogin);
    }

    @Override
    public void forgotPass() {
        callback.moveTo(RequestOTPFragment_.builder().build());
    }

    @Override
    public void register() {
        callback.moveTo(RegisterFragment_.builder().build());
    }

    @Override
    public void unAuthorized(HttpRequest httpRequest, String message) {
        dialogManager.errorDialog(message);
    }

    @Override
    public void onSuccessWithData(Object o) {
        if (o instanceof ResponseLogin) {
            checkIsLogin();
        }
    }
}
