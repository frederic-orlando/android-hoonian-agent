package com.example.hoonianAgent.view.fragment.auth.forgetPassword.verifyOTP;

import android.widget.EditText;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.view.activity.auth.AuthImpl;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_verify_otp)
public class VerifyOTPFragment extends BaseFragment<AuthImpl> implements VerifyOTPView {
    @Bean
    protected VerifyOTPImpl impl;
    @ViewById
    protected EditText otpTxt;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setCallback(callback);
    }

    @Click(R.id.submitBtn)
    protected void verify() { impl.verifyOTP(); }

    @Override
    public EditText otp() {
        return otpTxt;
    }
}