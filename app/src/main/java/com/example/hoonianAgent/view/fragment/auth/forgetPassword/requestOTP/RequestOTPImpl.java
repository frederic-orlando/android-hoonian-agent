package com.example.hoonianAgent.view.fragment.auth.forgetPassword.requestOTP;

import com.example.hoonianAgent.model.request.auth.RequestOTP;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.view.activity.auth.AuthImpl;
import com.example.hoonianAgent.view.fragment.auth.forgetPassword.verifyOTP.VerifyOTPFragment_;

import org.androidannotations.annotations.EBean;

import lombok.Setter;

@EBean
public class RequestOTPImpl extends BaseImpl<RequestOTPView> implements RequestOTPPres {
    @Setter
    private AuthImpl callback;
    @Override
    public void onValidationSucceeded() {
        super.onValidationSucceeded();

    }

    @Override
    public void init() {
        initValidator(viewAct);
    }

    @Override
    public void requestOTP() {
        RequestOTP request = new RequestOTP(
                utilsLayout.getBodyText(viewAct.email()),
                utilsLayout.getBodyText(viewAct.phone())
        );
        serviceManager.requestOTP(request);
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof BaseResponse) {
            callback.moveTo(VerifyOTPFragment_.builder().build());
        }
    }
}
