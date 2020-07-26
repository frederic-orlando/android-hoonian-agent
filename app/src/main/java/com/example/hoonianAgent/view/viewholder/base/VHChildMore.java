package com.example.hoonianAgent.view.viewholder.base;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.acl.ModelMenu;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;

public class VHChildMore extends BaseViewHolder<ModelMenu> {
    private ImageView icon;
    private TextView name;

    public VHChildMore(View itemView, RecyclerListener recyclerListener) {
        super(itemView, recyclerListener);
        icon = findView(R.id.icon);
        name = findView(R.id.name);
    }

    @Override
    public void setData(ModelMenu data) {
        super.setData(data);
        icon.setImageResource(data.getIconMore());
        name.setText(data.getTitle().replace(" ", "\n"));
    }
}
