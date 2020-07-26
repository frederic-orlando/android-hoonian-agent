package com.example.hoonianAgent.view.fragment.profile.edit;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public interface ProfileEditView {
    ImageView profile();
    EditText name();
    EditText phone();
    EditText idNo();
    Spinner bank();
    EditText accountNo();
    EditText email();
    EditText address();
    EditText company();
    EditText position();
    EditText bod();
    EditText birthPlace();
    ImageView idCard();
}
