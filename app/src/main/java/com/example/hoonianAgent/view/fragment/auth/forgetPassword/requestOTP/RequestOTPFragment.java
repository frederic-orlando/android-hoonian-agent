package com.example.hoonianAgent.view.fragment.auth.forgetPassword.requestOTP;

import android.widget.EditText;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.view.activity.auth.AuthImpl;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_request_otp)
public class RequestOTPFragment extends BaseFragment<AuthImpl> implements RequestOTPView {
    @Bean
    protected RequestOTPImpl impl;
    @ViewById
    protected EditText emailTxt;
    @ViewById
    protected EditText phoneTxt;
    @ViewById
    protected EditText passwordTxt;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setCallback(callback);
    }

    @Override
    public EditText email() {
        return emailTxt;
    }

    @Override
    public EditText phone() { return phoneTxt; }

    @Click(R.id.submitBtn)
    protected void requestOTP() { impl.requestOTP(); }
}