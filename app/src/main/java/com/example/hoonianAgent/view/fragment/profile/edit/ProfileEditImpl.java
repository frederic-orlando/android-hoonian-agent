package com.example.hoonianAgent.view.fragment.profile.edit;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.content.bank.Bank;
import com.example.hoonianAgent.model.content.home.HomeItem;
import com.example.hoonianAgent.model.custom.CustomDialog;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.model.response.bank.ResponseGetBankList;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.CustomDialogListener;
import com.example.hoonianAgent.presenter.utils.UtilsFile;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import lombok.Setter;

import static android.app.Activity.RESULT_OK;

@EBean
public class ProfileEditImpl extends BaseImpl<ProfileEditView> implements ProfileEditPres, AdapterView.OnItemSelectedListener {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;

    @Setter
    private Agent agent;

    private ArrayList<Bank> banks;
    private String bankId;

    private static final int SELECT_PROFILE = 1;
    private static final int SELECT_ID_CARD = 2;

    private int pendingRequestCode;

    @Override
    public void init() {
        serviceManager.getBankList();
    }

    @Override
    public void initData() {
        String rp = "Rp ";
        loadImage(agent.getImage(), viewAct.profile());
        viewAct.name().setText(agent.getName());
        viewAct.phone().setText(agent.getPhone());
        viewAct.idNo().setText(agent.getIdCardNo());

        bankId = agent.getBankId();

        if (bankId != null) {
            int i = 0;
            for (Bank bank : banks) {
                if (bank.getId().equals(bankId)) {
                    i++;
                    continue;
                }
            }
            viewAct.bank().setSelection(i);
        }

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
    public void setDataBank(ArrayList<Bank> banks) {
        if (viewAct.bank() != null) {
            ArrayAdapter<HomeItem> adapter = new ArrayAdapter(activity, android.R.layout.simple_spinner_item, banks);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            viewAct.bank().setAdapter(adapter);
            viewAct.bank().setOnItemSelectedListener(this);

            initData();
        }
    }

    @Override
    public void uploadProfile() {
        pickImage(SELECT_PROFILE);
    }

    @Override
    public void uploadIdCard() {
        pickImage(SELECT_ID_CARD);
    }

    @Override
    public void pickImage(int requestCode) {
        if (permissionMarshmallow.checkPermissionForRead()) {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            activity.startActivityForResult(intent, requestCode);
        }
        else {
            pendingRequestCode = requestCode;
            permissionMarshmallow.requestPermissionForStorage();
        }

    }

    @Override
    public void save() {
        Agent newAgent = new Agent(
                getAgent().getId(),
                agent.getName(),
                agent.getImage(),
                utilsLayout.getBodyText(viewAct.phone()),
                utilsLayout.getBodyText(viewAct.email()),
                agent.getIdCardNo(),
                agent.getIdCardUrl(),
                bankId,
                utilsLayout.getBodyText(viewAct.accountNo()),
                agent.getBod(),
                agent.getBirthPlace(),
                utilsLayout.getBodyText(viewAct.address()),
                utilsLayout.getBodyText(viewAct.company()),
                utilsLayout.getBodyText(viewAct.position())
        );

        serviceManager.editProfile(newAgent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && data.getData() != null) {
            Uri uri = data.getData();

            Bitmap b = BitmapFactory.decodeFile(UtilsFile.getRealPathFromURI(activity, uri));

            switch (requestCode) {
                case SELECT_PROFILE:
                    viewAct.profile().setImageBitmap(b);
                    break;
                case SELECT_ID_CARD:
                    viewAct.idCard().setImageBitmap(b);
                    break;
            }
            String base64 = UtilsFile.toBase64(activity, uri);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
       if (requestCode == permissionMarshmallow.READ_EXTERNAL_STORAGE) {
           if(grantResults.length > 0) {
               for (int grantResult: grantResults) {
                   if (grantResult != PackageManager.PERMISSION_GRANTED) {
                       return;
                   }
               }
               pickImage(pendingRequestCode);
           }
        }
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseGetBankList) {
            banks = ((ResponseGetBankList) o).getBanks();
            setDataBank(banks);
        }
        else if (o instanceof BaseResponse) {
            new CustomDialog(activity).show("Profile updated", new CustomDialogListener() {
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
