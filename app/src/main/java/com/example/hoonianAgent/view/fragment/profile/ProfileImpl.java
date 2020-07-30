package com.example.hoonianAgent.view.fragment.profile;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.response.profile.ResponseGetProfile;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.session.SessionUser;
import com.example.hoonianAgent.presenter.utils.UtilsCurrency;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.example.hoonianAgent.view.fragment.profile.changePassword.ChangePasswordFragment;
import com.example.hoonianAgent.view.fragment.profile.edit.ProfileEditFragment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

@EBean
public class ProfileImpl extends BaseImpl<ProfileView> implements ProfilePres {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;

    private Agent agent;

    @Override
    public void init() {
        Agent agent = new SessionUser(activity).getData();
        serviceManager.getProfile(agent.getId());
    }

    @Override
    @UiThread
    public void initData() {
        loadImage(agent.getImage(), viewAct.profile());
        viewAct.commission().setText(UtilsCurrency.toCurrency(agent.getTotalCommission()));
        viewAct.paid().setText(UtilsCurrency.toCurrency(agent.getTotalPaid()));
        viewAct.hold().setText(UtilsCurrency.toCurrency(agent.getTotalHold()));
        viewAct.pending().setText(UtilsCurrency.toCurrency(agent.getTotalPending()));
        viewAct.name().setText(agent.getName());
        viewAct.phone().setText(agent.getPhone());
        viewAct.idNo().setText(agent.getIdCardNo());
        viewAct.bank().setText(agent.getBank());
        viewAct.accountNo().setText(agent.getAccountNo());
        viewAct.email().setText(agent.getEmail());
        viewAct.address().setText(agent.getAddress());
        viewAct.company().setText(agent.getCompany());
        viewAct.position().setText(agent.getPosition());
        viewAct.bod().setText(agent.getBod());
        viewAct.birthPlace().setText(agent.getBirthPlace());
        loadImage(agent.getIdCardUrl(), viewAct.idCard());
    }

    @Override
    public void edit() {
        intentManager.moveToNext("Edit Profile", ProfileEditFragment.FRAGMENT_ID, agent);
    }

    @Override
    public void changePassword() {
        intentManager.moveToNext("Change Password", ChangePasswordFragment.FRAGMENT_ID);
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseGetProfile) {
            agent = ((ResponseGetProfile) o).getAgent();
            initData();
        }
    }
}
