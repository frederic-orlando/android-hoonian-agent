package com.example.hoonianAgent.view.fragment.auth.register;

import android.widget.EditText;
import android.widget.Spinner;

public interface RegisterView {
    EditText name();
    EditText phone();
    EditText password();
    EditText idNumber();
    Spinner bank();
    EditText bankNo();
}
