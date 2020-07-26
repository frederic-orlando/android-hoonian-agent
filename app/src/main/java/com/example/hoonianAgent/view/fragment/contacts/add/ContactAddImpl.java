package com.example.hoonianAgent.view.fragment.contacts.add;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.hoonianAgent.model.content.City;
import com.example.hoonianAgent.model.content.contacts.Contacts;
import com.example.hoonianAgent.model.content.home.HomeItem;
import com.example.hoonianAgent.model.custom.CustomDialog;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.model.response.city.ResponseGetCityList;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.CustomDialogListener;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import lombok.Setter;

@EBean
public class ContactAddImpl extends BaseImpl<ContactAddView> implements ContactAddPres, AdapterView.OnItemSelectedListener {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;

    private ArrayList<City> cities;
    private String cityId;

    @Setter
    private Contacts contact;

    @Override
    public void init() {
        if (contact != null) {
            viewAct.name().setText(contact.getName());
            viewAct.phone().setText(contact.getPhone());
        }
        utilsLayout.hide(viewAct.notesLayout());
        serviceManager.getCityList();
    }

    @Override
    public void setDataSpinner(ArrayList<City> listCities) {
        if (viewAct.city() != null) {
            ArrayAdapter<City> adapter = new ArrayAdapter(activity, android.R.layout.simple_spinner_item, cities);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            viewAct.city().setAdapter(adapter);
            viewAct.city().setOnItemSelectedListener(this);
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

        serviceManager.addContact(newContact);
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseGetCityList) {
            cities = ((ResponseGetCityList) o).getCities();
            setDataSpinner(cities);
        }
        else if (o instanceof BaseResponse) {
            new CustomDialog(activity).show("Contact created", new CustomDialogListener() {
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
