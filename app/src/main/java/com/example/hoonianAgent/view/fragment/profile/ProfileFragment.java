package com.example.hoonianAgent.view.fragment.profile;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_profile)
public class ProfileFragment extends BaseFragment implements ProfileView {
    public static final int FRAGMENT_ID = 12;
    @Bean
    protected ProfileImpl impl;
    @ViewById
    protected ImageView profileImage;
    @ViewById
    protected TextView commissionLbl;
    @ViewById
    protected TextView paidLbl;
    @ViewById
    protected TextView holdLbl;
    @ViewById
    protected TextView pendingLbl;
    @ViewById
    protected TextView nameLbl;
    @ViewById
    protected TextView phoneLbl;
    @ViewById
    protected TextView idNoLbl;
    @ViewById
    protected TextView bankLbl;
    @ViewById
    protected TextView accountNoLbl;
    @ViewById
    protected TextView emailLbl;
    @ViewById
    protected TextView addressLbl;
    @ViewById
    protected TextView companyLbl;
    @ViewById
    protected TextView positionLbl;
    @ViewById
    protected TextView bodLbl;
    @ViewById
    protected TextView birthPlaceLbl;
    @ViewById
    protected ImageView idCardImage;


    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public ImageView profile() {
        return profileImage;
    }

    @Override
    public TextView commission() {
        return commissionLbl;
    }

    @Override
    public TextView paid() {
        return paidLbl;
    }

    @Override
    public TextView hold() {
        return holdLbl;
    }

    @Override
    public TextView pending() {
        return pendingLbl;
    }

    @Override
    public TextView name() {
        return nameLbl;
    }

    @Override
    public TextView phone() {
        return phoneLbl;
    }

    @Override
    public TextView idNo() {
        return idNoLbl;
    }

    @Override
    public TextView bank() {
        return bankLbl;
    }

    @Override
    public TextView accountNo() {
        return accountNoLbl;
    }

    @Override
    public TextView email() {
        return emailLbl;
    }

    @Override
    public TextView address() {
        return addressLbl;
    }

    @Override
    public TextView company() {
        return companyLbl;
    }

    @Override
    public TextView position() {
        return positionLbl;
    }

    @Override
    public TextView bod() {
        return bodLbl;
    }

    @Override
    public TextView birthPlace() {
        return birthPlaceLbl;
    }

    @Override
    public ImageView idCard() {
        return idCardImage;
    }

    @Click(R.id.editBtn)
    protected void edit() {impl.edit();}

    @Click(R.id.changePasswordBtn)
    protected void changePassword() {impl.changePassword();}

    @Click(R.id.logOutBtn)
    protected void logOut() {impl.logOutUser();}
}
