package com.example.hoonianAgent.view.fragment.auth.forgetPassword;

import android.widget.EditText;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.view.activity.auth.AuthImpl;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_forget_password)
public class ForgetPasswordFragment extends BaseFragment<AuthImpl> implements ForgetPasswordView {
    @Bean
    protected ForgetPasswordImpl impl;
    @ViewById
    protected EditText newTxt;
    @ViewById
    protected EditText confirmTxt;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setCallback(callback);
    }

    @Override
    public EditText newTxt() {
        return newTxt;
    }

    @Override
    public EditText confirmTxt() {
        return confirmTxt;
    }

    @Click(R.id.submitBtn)
    protected void changePassword() { impl.changePassword(); }
}