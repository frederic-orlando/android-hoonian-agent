package com.example.hoonianAgent.view.fragment.auth.forgetPassword.verifyOTP;

import com.example.hoonianAgent.model.request.auth.RequestOTP;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.view.activity.auth.AuthImpl;
import com.example.hoonianAgent.view.fragment.auth.forgetPassword.ForgetPasswordFragment_;

import org.androidannotations.annotations.EBean;

import lombok.Setter;

@EBean
public class VerifyOTPImpl extends BaseImpl<VerifyOTPView> implements VerifyOTPPres {
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
    public void verifyOTP() {
        callback.moveTo(ForgetPasswordFragment_.builder().build());
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof BaseResponse) {

        }
    }
}
