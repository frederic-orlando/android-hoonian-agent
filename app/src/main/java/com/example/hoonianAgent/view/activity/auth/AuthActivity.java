package com.example.hoonianAgent.view.activity.auth;

import android.widget.TextView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.view.activity.base.BaseActivity;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EFragment;

@EActivity(R.layout.activity_auth)
public class AuthActivity extends BaseActivity implements AuthView {
    @Bean
    protected AuthImpl impl;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setLayoutFragment(R.id.fragmentHolder);
        impl.setFragmentManager(getSupportFragmentManager(), getClass().getName());
        impl.init();
        impl.checkIsLogin();;
    }

    @Override
    public void onBackPressed() {
        getSupportFragmentManager().popBackStack();
    }
}
