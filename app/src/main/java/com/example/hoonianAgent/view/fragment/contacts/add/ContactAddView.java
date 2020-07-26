package com.example.hoonianAgent.view.fragment.contacts.add;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public interface ContactAddView {
    EditText name();
    EditText phone();
    EditText idNo();
    EditText position();
    Spinner city();
    EditText relation();
    LinearLayout notesLayout();
}
