package com.example.hoonianAgent.view.fragment.auth.login;

import android.widget.EditText;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.view.activity.auth.AuthImpl;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_login)
public class LoginFragment extends BaseFragment<AuthImpl> implements LoginView{
    @NotEmpty
    @ViewById
    protected EditText phoneTxt;
    @NotEmpty
    @ViewById
    protected EditText passwordTxt;

    @Bean
    protected LoginImpl impl;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setCallback(callback);
        impl.init();
    }

    @Override
    public EditText phone() { return phoneTxt; }

    @Override
    public EditText password() { return passwordTxt; }

    @Click(R.id.loginBtn)
    protected void login() {
        impl.getValidator().validate();
    }

    @Click(R.id.forgotPassBtn)
    protected void forgotPass() {
        impl.forgotPass();
    }

    @Click(R.id.registerBtn)
    protected void register() {
        impl.register();
    }

    // CRASH
    //Todo: Implement showPassword
//    @Touch(R.id.password_textView)
//    protected boolean showPassword(View v, MotionEvent event) {
//        if (event.getAction() == MotionEvent.ACTION_UP && v instanceof EditText) {
//            if (event.getRawX() >= (v.getRight() - ((EditText) v).getCompoundDrawables()[2]
//                    .getBounds().width())) {
//                login.showHidePass((TextView) v);
//                return true;
//            }
//        }
//        return false;
//    }
}