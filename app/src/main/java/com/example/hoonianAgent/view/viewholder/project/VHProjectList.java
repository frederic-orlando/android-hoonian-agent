package com.example.hoonianAgent.view.viewholder.project;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.FavoriteListener;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.utils.UtilsCurrency;
import com.example.hoonianAgent.presenter.utils.UtilsLayout;
import com.example.hoonianAgent.view.viewholder.base.BaseViewHolder;

public class VHProjectList extends BaseViewHolder<Project> {
    private ImageView image;
    private ImageButton favoriteBtn;
    private TextView nameLbl;
    private TextView locationLbl;
    private TextView availableLbl;
    private TextView startPriceLbl;

    public VHProjectList(View itemView, RecyclerListener recyclerListener) {
        super(itemView, recyclerListener);
        image = findView(R.id.image);
        favoriteBtn = findView(R.id.favoriteBtn);
        nameLbl = findView(R.id.nameLbl);
        locationLbl = findView(R.id.locationLbl);
        availableLbl = findView(R.id.availableLbl);
        startPriceLbl = findView(R.id.startPriceLbl);
    }

    @Override
    public void setData(Project data) {
        super.setData(data);
        Activity activity = ((BaseImpl) getRecyclerListener()).getActivity();
        loadImage(data.getImage(), image);
        nameLbl.setText(data.getName());
        locationLbl.setText(data.getCity());
        availableLbl.setText("Available: " + data.getAvailableUnit() + " units");

        startPriceLbl.setText(UtilsCurrency.toString(data.getStartFrom()));

        if (data.getIsFavorite()) {
            UtilsLayout.changeTint(activity, favoriteBtn, R.color.yellow);
        }
        else {
            UtilsLayout.changeTint(activity, favoriteBtn, R.color.white);
        }

        favoriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FavoriteListener) getRecyclerListener()).favorite(data);
            }
        });
    }
}
