package com.example.hoonianAgent.view.adapter.recycler;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.viewholder.project.VHProjectList;

import java.util.ArrayList;

public class AdapterProjectList extends BaseAdapter<Project>{
    public AdapterProjectList(ArrayList<Project> listItem, RecyclerListener recyclerListener) {
        super(listItem, recyclerListener);
    }

    @Override
    protected RecyclerView.ViewHolder createHolder(ViewGroup parent, int viewType) {
        return new VHProjectList(createView(parent, R.layout.row_project), recyclerListener);
    }
}
