package com.example.hoonianAgent.view.fragment.profile.changePassword;

import android.widget.TextView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_change_password)
public class ChangePasswordFragment extends BaseFragment implements ChangePasswordView {
    public static final int FRAGMENT_ID = 16;

    @Bean
    protected ChangePasswordImpl impl;
    @ViewById
    protected TextView oldTxt;
    @ViewById
    protected TextView newTxt;
    @ViewById
    protected TextView confirmTxt;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public TextView oldTxt() {
        return oldTxt;
    }

    @Override
    public TextView newTxt() {
        return newTxt;
    }

    @Override
    public TextView confirmTxt() {
        return confirmTxt;
    }

    @Click(R.id.changePasswordBtn)
    protected void changePassword() {impl.changePassword();}
}
