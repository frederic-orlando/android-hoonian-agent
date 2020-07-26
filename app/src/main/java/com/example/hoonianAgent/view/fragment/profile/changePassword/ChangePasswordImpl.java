package com.example.hoonianAgent.view.fragment.profile.changePassword;

import android.app.Dialog;
import android.widget.Toast;

import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.custom.CustomDialog;
import com.example.hoonianAgent.model.request.auth.RequestChangePassword;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.CustomDialogListener;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.session.SessionUser;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
public class ChangePasswordImpl extends BaseImpl<ChangePasswordView> implements ChangePasswordPres {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;

    private Agent agent;
    @Override
    public void init() {
        agent = new SessionUser(activity).getData();
    }

    @Override
    public void changePassword() {
        RequestChangePassword request = new RequestChangePassword(
                utilsLayout.getBodyText(viewAct.oldTxt()),
                utilsLayout.getBodyText(viewAct.newTxt()),
                utilsLayout.getBodyText(viewAct.confirmTxt()),
                agent.getId()
        );

        serviceManager.changePassword(request);
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof BaseResponse) {
            //Todo: Show Custom Dialog
            new CustomDialog(activity).show("Change Password Success", new CustomDialogListener() {
                @Override
                public void close(Dialog dialog) {
                    activity.onBackPressed();
                }
            }, null, false);
        }
    }
}
