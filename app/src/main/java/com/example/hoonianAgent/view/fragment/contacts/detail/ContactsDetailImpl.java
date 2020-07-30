package com.example.hoonianAgent.view.fragment.contacts.detail;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.content.contacts.Contacts;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.model.content.property.ReferredProject;
import com.example.hoonianAgent.model.response.contacts.ResponseGetContactDetail;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.example.hoonianAgent.view.adapter.recycler.AdapterContactProject;
import com.example.hoonianAgent.view.fragment.contacts.edit.ContactEditFragment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;

import lombok.Setter;

@EBean
public class ContactsDetailImpl extends BaseImpl<ContactsDetailView> implements ContactsDetailPres, RecyclerListener {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;

    @Setter
    private Contacts contact;

    @Override
    public void init() {
        serviceManager.getContactDetail(contact.getId(), getAgent().getId());
    }

    @Override
    @UiThread
    public void initData() {
        viewAct.name().setText(contact.getName());
        viewAct.phone().setText(contact.getPhone());
        viewAct.idNo().setText(contact.getIdNo());
        viewAct.position().setText(contact.getPosition());
        viewAct.relation().setText(contact.getRelation());
        setDataReferred(contact.getReferredProjects());
        setDataPurchased(contact.getPurchasedProjects());
    }

    @Override
    public void editProfile() {
        intentManager.moveToNext("Edit Contact", ContactEditFragment.FRAGMENT_ID, contact);
    }

    @Override
    @UiThread
    public void setDataReferred(ArrayList<ReferredProject> listReferred) {
        RecyclerView recycler = viewAct.referred();
        if (recycler != null) {
            recycler.setAdapter(new AdapterContactProject(listReferred, this));
            recycler.setLayoutManager(new LinearLayoutManager(activity));
        }
    }

    @Override
    @UiThread
    public void setDataPurchased(ArrayList<ReferredProject> listPurchased) {
        RecyclerView recycler = viewAct.purchased();
        if (recycler != null) {
            recycler.setAdapter(new AdapterContactProject(listPurchased, this));
            recycler.setLayoutManager(new LinearLayoutManager(activity));
        }
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseGetContactDetail) {
            contact = ((ResponseGetContactDetail) o).getContact();
            initData();
        }
    }

    @Override
    public void onItemClick(Object o) {

    }
}
