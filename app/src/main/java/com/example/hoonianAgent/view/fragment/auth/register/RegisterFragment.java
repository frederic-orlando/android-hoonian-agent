package com.example.hoonianAgent.view.fragment.auth.register;

import android.widget.EditText;
import android.widget.Spinner;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.view.activity.auth.AuthImpl;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_register)
public class RegisterFragment extends BaseFragment<AuthImpl> implements RegisterView {
    @Bean
    protected RegisterImpl impl;
    @ViewById
    protected EditText nameTxt;
    @ViewById
    protected EditText phoneTxt;
    @ViewById
    protected EditText passwordTxt;
    @ViewById
    protected EditText idNo;
    @ViewById
    protected Spinner bankSpinner;
    @ViewById
    protected EditText bankNoTxt;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setCallback(callback);
        impl.init();
    }

    @Override
    public EditText name() { return nameTxt; }

    @Override
    public EditText phone() { return phoneTxt; }

    @Override
    public EditText password() { return passwordTxt; }

    @Override
    public EditText idNumber() { return idNo; }

    @Override
    public Spinner bank() { return bankSpinner; }

    @Override
    public EditText bankNo() { return bankNoTxt; }

    @Click(R.id.registerBtn)
    protected void register() { impl.register(); }
}