package com.example.hoonianAgent.view.viewholder.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.viewholder.base.BaseViewHolder;

public class VHHomeProject extends BaseViewHolder<Project> {
    private ImageView image;
    private TextView primaryLbl;
    private TextView secondaryLbl;

    public VHHomeProject(View itemView, RecyclerListener recyclerListener) {
        super(itemView, recyclerListener);
        image = findView(R.id.image);
        primaryLbl = findView(R.id.primaryLbl);
        secondaryLbl = findView(R.id.secondaryLbl);
    }

    @Override
    public void setData(Project data) {
        super.setData(data);

        loadImage(data.getImage(), image);

        primaryLbl.setText(data.getName());
        secondaryLbl.setText(data.getCity().getName());
    }
}
