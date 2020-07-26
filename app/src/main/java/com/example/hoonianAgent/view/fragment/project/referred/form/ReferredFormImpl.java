package com.example.hoonianAgent.view.fragment.project.referred.form;

import android.app.Dialog;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.content.contacts.Contacts;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.model.content.referred.Referred;
import com.example.hoonianAgent.model.custom.CustomDialog;
import com.example.hoonianAgent.model.custom.DialogNotes;
import com.example.hoonianAgent.model.request.project.RequestRefer;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.model.response.contacts.ResponseGetContactList;
import com.example.hoonianAgent.model.response.project.ResponseGetReferredList;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.CustomDialogListener;
import com.example.hoonianAgent.presenter.callback.DialogNotesListener;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.callback.ReferredFormCallback;
import com.example.hoonianAgent.presenter.callback.ReferredRecyclerListener;
import com.example.hoonianAgent.presenter.session.SessionUser;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.example.hoonianAgent.view.adapter.recycler.AdapterReferred;
import com.example.hoonianAgent.view.adapter.recycler.AdapterReferredForm;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import lombok.Setter;

@EBean
public class ReferredFormImpl extends BaseImpl<ReferredFormView> implements ReferredFormPres, RecyclerListener, ReferredFormCallback {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;

    @Setter
    private Project project;

    private ArrayList<Referred> listReferred = new ArrayList<>();
    private int maxCallback = 0;
    private int callback = 0;
    
    @Override
    public void init() {
        serviceManager.getReferredForm(getAgent().getId(), project.getId());
    }

    @Override
    public void setDataReferred(ArrayList<Referred> referred) {
        RecyclerView recycler = viewAct.recycler();
        if (recycler != null) {
            recycler.setAdapter(new AdapterReferredForm(referred, this));
            recycler.setLayoutManager(new LinearLayoutManager(activity));
        }
    }

    @Override
    public void send() {
        callback = 0;
        maxCallback = 0;

        for (Referred referred : listReferred) {
            if (referred.getIsSelected()) {
                RequestRefer request = new RequestRefer(referred);
                serviceManager.referProject(request);
                maxCallback++;
            }
        }
    }

    @Override
    public void addFromContact() {

    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseGetContactList) {
            ArrayList<Contacts> contacts = ((ResponseGetContactList) o).getContacts();
            for (Contacts contact: contacts) {
                listReferred.add(new Referred(contact, getAgent(), project));
            }
            setDataReferred(listReferred);
        }
        else if (o instanceof BaseResponse) {
            callback++;
            if (callback == maxCallback) {
                new CustomDialog(activity).show("Refer Project Success", new CustomDialogListener() {
                    @Override
                    public void close(Dialog dialog) {
                        activity.onBackPressed();
                    }
                }, null, false);
            }
        }
    }

    @Override
    public void onItemClick(Object o) {
        if (o instanceof Referred) {
            Referred referred = (Referred) o;
            referred.setIsSelected(!referred.getIsSelected());
            refresh();
        }
    }

    @Override
    public void refresh() {
        viewAct.recycler().getAdapter().notifyDataSetChanged();
    }

    @Override
    public void addNotes(int position) {
        Referred referred = listReferred.get(position);

        new DialogNotes(activity).show(referred.getNote(), new DialogNotesListener() {
            @Override
            public void save(String note) {
                referred.setNote(note);
            }
        });
    }
}
