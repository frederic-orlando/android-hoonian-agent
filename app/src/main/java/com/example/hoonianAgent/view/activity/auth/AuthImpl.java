package com.example.hoonianAgent.view.activity.auth;

import android.os.Bundle;

import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.example.hoonianAgent.view.fragment.auth.login.LoginFragment_;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.example.hoonianAgent.view.fragment.base.BaseFragmentFromMore_;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
public class AuthImpl extends BaseImpl<AuthView> implements AuthPres {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;

    @Override
    public void init() {
        moveTo(LoginFragment_.builder().build(), false);
    }

    @Override
    public void backPressed() {
        fragmentManagerUtils.backpressed();
    }

    @Override
    public void moveTo(BaseFragment fragment) {
        moveTo(fragment, true);
    }

    @Override
    public void moveTo(BaseFragment fragment, Boolean backStack) {
        moveTo(fragment, null, backStack);
    }

    @Override
    public void moveTo(BaseFragment fragment, BaseSerializableObject object, Boolean backStack) {
        if (object != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(BaseFragmentFromMore_.BASE_SERIALIZABLE_OBJECT_ARG, object);
            fragment.setArguments(bundle);
        }
        fragment.setCallback(this);
        getFragmentManagerUtils().showFragment(fragment, backStack);
    }
}
