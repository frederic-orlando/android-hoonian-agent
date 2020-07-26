package com.example.hoonianAgent.view.fragment.profile.edit;

import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.example.hoonianAgent.view.fragment.base.BaseFragmentFromMore;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_edit_profile)
public class ProfileEditFragment extends BaseFragmentFromMore implements ProfileEditView {
    public static final int FRAGMENT_ID = 23;
    @Bean
    protected ProfileEditImpl impl;
    @ViewById
    protected ImageView profileImage;
    @ViewById
    protected EditText nameTxt;
    @ViewById
    protected EditText phoneTxt;
    @ViewById
    protected EditText idNoTxt;
    @ViewById
    protected Spinner bankSpinner;
    @ViewById
    protected EditText bankNoTxt;
    @ViewById
    protected EditText emailTxt;
    @ViewById
    protected EditText addressTxt;
    @ViewById
    protected EditText companyTxt;
    @ViewById
    protected EditText positionTxt;
    @ViewById
    protected EditText bodTxt;
    @ViewById
    protected EditText birthPlaceTxt;
    @ViewById
    protected ImageView idCardImage;


    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setAgent((Agent) baseSerializableObject);
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public ImageView profile() {
        return profileImage;
    }

    @Override
    public EditText name() {
        return nameTxt;
    }

    @Override
    public EditText phone() {
        return phoneTxt;
    }

    @Override
    public EditText idNo() {
        return idNoTxt;
    }

    @Override
    public Spinner bank() {
        return bankSpinner;
    }

    @Override
    public EditText accountNo() {
        return bankNoTxt;
    }

    @Override
    public EditText email() {
        return emailTxt;
    }

    @Override
    public EditText address() {
        return addressTxt;
    }

    @Override
    public EditText company() {
        return companyTxt;
    }

    @Override
    public EditText position() {
        return positionTxt;
    }

    @Override
    public EditText bod() {
        return bodTxt;
    }

    @Override
    public EditText birthPlace() {
        return birthPlaceTxt;
    }

    @Override
    public ImageView idCard() {
        return idCardImage;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        impl.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        impl.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Click(R.id.saveBtn)
    protected void save() {impl.save();}

    @Click(R.id.profileImage)
    protected void uploadProfile() {impl.uploadProfile();}

    @Click(R.id.idCardImage)
    protected void uploadIdCard() {impl.uploadIdCard();}
}
