package com.example.hoonianAgent.view.fragment.auth.forgetPassword;

import android.widget.Toast;

import com.example.hoonianAgent.model.request.auth.RequestForgetPassword;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.view.activity.auth.AuthImpl;

import org.androidannotations.annotations.EBean;

import lombok.Setter;

@EBean
public class ForgetPasswordImpl extends BaseImpl<ForgetPasswordView> implements ForgetPasswordPres {
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
    public void changePassword() {
        RequestForgetPassword request = new RequestForgetPassword(
                utilsLayout.getBodyText(viewAct.newTxt()),
                utilsLayout.getBodyText(viewAct.confirmTxt())
        );
        serviceManager.forgetPassword(request);
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof BaseResponse) {
            Toast.makeText(activity, "Change Password Success", Toast.LENGTH_SHORT).show();
            intentManager.moveToLogin();
        }
    }
}
