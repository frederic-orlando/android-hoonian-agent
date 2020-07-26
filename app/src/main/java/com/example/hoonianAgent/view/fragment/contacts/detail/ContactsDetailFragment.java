package com.example.hoonianAgent.view.fragment.contacts.detail;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.contacts.Contacts;
import com.example.hoonianAgent.model.content.home.HomeItem;
import com.example.hoonianAgent.view.fragment.base.BaseFragmentFromMore;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_contact_detail)
public class ContactsDetailFragment extends BaseFragmentFromMore implements ContactsDetailView {
    public static final int FRAGMENT_ID = 20;
    @Bean
    protected ContactsDetailImpl impl;
    @ViewById
    protected TextView nameLbl;
    @ViewById
    protected TextView phoneNoLbl;
    @ViewById
    protected TextView idNoLbl;
    @ViewById
    protected TextView positionLbl;
    @ViewById
    protected TextView relationLbl;
    @ViewById
    protected RecyclerView referredRecycler;
    @ViewById
    protected RecyclerView purchaseRecycler;
    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setContact((Contacts) baseSerializableObject);
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public TextView name() {
        return nameLbl;
    }

    @Override
    public TextView phone() {
        return phoneNoLbl;
    }

    @Override
    public TextView idNo() {
        return idNoLbl;
    }

    @Override
    public TextView position() {
        return positionLbl;
    }

    @Override
    public TextView relation() {
        return relationLbl;
    }

    @Override
    public RecyclerView referred() {
        return referredRecycler;
    }

    @Override
    public RecyclerView purchased() {
        return purchaseRecycler;
    }

    @Click(R.id.editBtn)
    protected void editProfile() {impl.editProfile();}
}
