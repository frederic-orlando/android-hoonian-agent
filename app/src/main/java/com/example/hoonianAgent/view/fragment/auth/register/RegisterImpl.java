package com.example.hoonianAgent.view.fragment.auth.register;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.hoonianAgent.model.content.City;
import com.example.hoonianAgent.model.content.bank.Bank;
import com.example.hoonianAgent.model.custom.CustomDialog;
import com.example.hoonianAgent.model.request.auth.RequestRegister;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.model.response.bank.ResponseGetBankList;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.CustomDialogListener;
import com.example.hoonianAgent.view.activity.auth.AuthImpl;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import connection.rxconnection.connection.HttpRequest;
import lombok.Setter;

@EBean
public class RegisterImpl extends BaseImpl<RegisterView> implements RegisterPres, AdapterView.OnItemSelectedListener {
    @Setter
    private AuthImpl callback;

    private ArrayList<Bank> banks;
    private String bankId;

    @Override
    public void onValidationSucceeded() {
        super.onValidationSucceeded();

    }

    @Override
    public void init() {
        serviceManager.getBankList();
    }

    @Override
    public void initDataBank(ArrayList<Bank> listBank) {
        if (viewAct.bank() != null) {
            ArrayAdapter<City> adapter = new ArrayAdapter(activity, android.R.layout.simple_spinner_item, listBank);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            viewAct.bank().setAdapter(adapter);
            viewAct.bank().setOnItemSelectedListener(this);
        }
    }

    @Override
    public void register() {
        RequestRegister request = new RequestRegister(
                utilsLayout.getBodyText(viewAct.name()),
                utilsLayout.getBodyText(viewAct.password()),
                utilsLayout.getBodyText(viewAct.phone()),
                utilsLayout.getBodyText(viewAct.idNumber()),
                bankId,
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
        if (o instanceof ResponseGetBankList) {
            banks = ((ResponseGetBankList) o).getBanks();
            initDataBank(banks);
        }
        else if (o instanceof BaseResponse) {
            new CustomDialog(activity).show("Register Success", new CustomDialogListener() {
                @Override
                public void close(Dialog dialog) {
                    activity.onBackPressed();
                }
            }, null, false);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        bankId = banks.get(position).getId();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
