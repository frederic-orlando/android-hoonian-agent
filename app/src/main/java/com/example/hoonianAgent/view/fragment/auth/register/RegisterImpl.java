package com.example.hoonianAgent.view.fragment.auth.register;

import android.app.Dialog;
import android.widget.Toast;

import com.example.hoonianAgent.model.custom.CustomDialog;
import com.example.hoonianAgent.model.request.auth.RequestRegister;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.CustomDialogListener;
import com.example.hoonianAgent.view.activity.auth.AuthImpl;

import org.androidannotations.annotations.EBean;

import connection.rxconnection.connection.HttpRequest;
import lombok.Setter;

@EBean
public class RegisterImpl extends BaseImpl<RegisterView> implements RegisterPres {
    @Setter
    private AuthImpl callback;
    @Override
    public void onValidationSucceeded() {
        super.onValidationSucceeded();

    }

    @Override
    public void register() {
        RequestRegister request = new RequestRegister(
                utilsLayout.getBodyText(viewAct.name()),
                utilsLayout.getBodyText(viewAct.password()),
                utilsLayout.getBodyText(viewAct.phone()),
                utilsLayout.getBodyText(viewAct.idNumber()),
                null,
                utilsLayout.getBodyText(viewAct.bankNo())
        );

        serviceManager.register(request);
    }

    @Override
    public void unAuthorized(HttpRequest httpRequest, String message) {
        dialogManager.errorDialog(message);
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof BaseResponse) {
            new CustomDialog(activity).show("Register Success", new CustomDialogListener() {
                @Override
                public void close(Dialog dialog) {
                    activity.onBackPressed();
                }
            }, null, false);
        }
    }
}
