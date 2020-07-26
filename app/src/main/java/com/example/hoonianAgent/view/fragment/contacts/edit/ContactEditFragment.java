package com.example.hoonianAgent.view.fragment.contacts.edit;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.contacts.Contacts;
import com.example.hoonianAgent.view.fragment.base.BaseFragmentFromMore;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_add_contact)
public class ContactEditFragment extends BaseFragmentFromMore implements ContactEditView {
    public static final int FRAGMENT_ID = 22;
    @Bean
    protected ContactEditImpl impl;
    @ViewById
    protected EditText nameTxt;
    @ViewById
    protected EditText phoneTxt;
    @ViewById
    protected EditText idNoTxt;
    @ViewById
    protected EditText positionTxt;
    @ViewById
    protected Spinner citySpinner;
    @ViewById
    protected EditText relationTxt;
    @ViewById
    protected LinearLayout notesLayout;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setContact((Contacts) baseSerializableObject);
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public EditText name() {
        return nameTxt;
    }

    @Override
    public EditText phone() {
        return phoneTxt;
    }

    @Override
    public EditText idNo() {
        return idNoTxt;
    }

    @Override
    public EditText position() {
        return positionTxt;
    }

    @Override
    public Spinner city() {
        return citySpinner;
    }

    @Override
    public EditText relation() {
        return relationTxt;
    }

    @Override
    public LinearLayout notesLayout() {
        return notesLayout;
    }

    @Click(R.id.saveBtn)
    protected void save() {impl.save();}
}
