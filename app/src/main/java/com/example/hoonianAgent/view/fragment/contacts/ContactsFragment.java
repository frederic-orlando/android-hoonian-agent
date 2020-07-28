package com.example.hoonianAgent.view.fragment.contacts;

import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.synnapps.carouselview.CarouselView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_contacts)
public class ContactsFragment extends BaseFragment implements ContactsView {
    @Bean
    protected ContactsImpl impl;
    @ViewById
    protected EditText searchTxt;
    @ViewById
    protected RecyclerView recycler;
    @ViewById
    protected ImageButton addBtn;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public void onResume() {
        super.onResume();
        impl.init();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        impl.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public EditText search() {
        return searchTxt;
    }

    @Override
    public RecyclerView recycler() { return recycler; }

    @Click(R.id.addBtn)
    protected void addContact() {
        impl.addContact();
    }
}
