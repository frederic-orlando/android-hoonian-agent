package com.example.hoonianAgent.view.adapter.recycler;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.contacts.Contacts;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.viewholder.contacts.VHContact;

import java.util.ArrayList;

public class AdapterContactList extends BaseAdapter<Contacts>{
    public AdapterContactList(ArrayList<Contacts> listItem, RecyclerListener recyclerListener) {
        super(listItem, recyclerListener);
    }

    @Override
    protected RecyclerView.ViewHolder createHolder(ViewGroup parent, int viewType) {
        return new VHContact(createView(parent, R.layout.row_contacts), recyclerListener);
    }
}
