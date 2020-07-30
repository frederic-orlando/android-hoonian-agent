package com.example.hoonianAgent.view.adapter.recycler;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.model.content.property.ReferredProject;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.viewholder.contacts.VHContactProject;

import java.util.ArrayList;

public class AdapterContactProject extends BaseAdapter<ReferredProject>{
    public AdapterContactProject(ArrayList<ReferredProject> listItem, RecyclerListener recyclerListener) {
        super(listItem, recyclerListener);
    }

    @Override
    protected RecyclerView.ViewHolder createHolder(ViewGroup parent, int viewType) {
        return new VHContactProject(createView(parent, R.layout.row_contact_project), recyclerListener);
    }
}
