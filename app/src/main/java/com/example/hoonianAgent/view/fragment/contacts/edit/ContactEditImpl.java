package com.example.hoonianAgent.view.fragment.contacts.edit;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.hoonianAgent.model.content.contacts.Contacts;
import com.example.hoonianAgent.model.content.home.HomeItem;
import com.example.hoonianAgent.model.custom.CustomDialog;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.model.response.city.ResponseGetCityList;
import com.example.hoonianAgent.model.response.contacts.ResponseGetContactEditForm;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.CustomDialogListener;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import lombok.Setter;

@EBean
public class ContactEditImpl extends BaseImpl<ContactEditView> implements ContactEditPres, AdapterView.OnItemSelectedListener {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;

    private ArrayList<HomeItem> cities;
    private String cityId;

    @Setter
    private Contacts contact;

    @Override
    public void init() {
        utilsLayout.hide(viewAct.notesLayout());
        serviceManager.getEditContactForm(getAgent().getId(), contact.getId());
    }

    @Override
    public void initData() {
        viewAct.name().setEnabled(false);
        viewAct.idNo().setEnabled(false);

        viewAct.name().setText(contact.getName());
        viewAct.phone().setText(contact.getPhone());
        viewAct.idNo().setText(contact.getIdNo());

        cityId = contact.getCityId();
        int i = 0;
        for (HomeItem city : cities) {
            if (city.getId().equals(cityId)) {
                i++;
                continue;
            }
        }
        viewAct.city().setSelection(i);
        viewAct.position().setText(contact.getPosition());
        viewAct.relation().setText(contact.getRelation());
    }

    @Override
    public void setDataSpinner(ArrayList<HomeItem> cities) {
        if (viewAct.city() != null) {
            ArrayAdapter<HomeItem> adapter = new ArrayAdapter(activity, android.R.layout.simple_spinner_item, cities);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            viewAct.city().setAdapter(adapter);
            viewAct.city().setOnItemSelectedListener(this);

            initData();
        }
    }

    @Override
    public void save() {
        Contacts newContact = new Contacts(
                getAgent().getId(),
                utilsLayout.getBodyText(viewAct.name()),
                utilsLayout.getBodyText(viewAct.phone()),
                utilsLayout.getBodyText(viewAct.idNo()),
                utilsLayout.getBodyText(viewAct.position()),
                cityId,
                utilsLayout.getBodyText(viewAct.relation())
        );

        serviceManager.editContact(newContact);
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseGetContactEditForm) {
            ResponseGetContactEditForm response = (ResponseGetContactEditForm) o;
            contact = response.getContact();
            cities = response.getCities();
            setDataSpinner(cities);
        }
        else if (o instanceof BaseResponse) {
            new CustomDialog(activity).show("Contact updated", new CustomDialogListener() {
                @Override
                public void close(Dialog dialog) {
                    activity.onBackPressed();
                }
            }, null, false);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        cityId = cities.get(position).getId();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
