package com.example.hoonianAgent.view.viewholder.project;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.UnitType;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.callback.UnitTypeRecyclerListener;
import com.example.hoonianAgent.presenter.utils.UtilsCurrency;
import com.example.hoonianAgent.view.viewholder.base.BaseViewHolder;

public class VHUnitType extends BaseViewHolder<UnitType> {
    private UnitTypeRecyclerListener unitListener;
    private TextView typeNameLbl;
    private ImageView image;
    private TextView availableLbl;
    private TextView priceLbl;
    private TextView floorPlanBtn;
    private TextView priceListBtn;

    public VHUnitType(View itemView, RecyclerListener recyclerListener, UnitTypeRecyclerListener unitListener) {
        super(itemView, recyclerListener);
        this.unitListener = unitListener;
        typeNameLbl = findView(R.id.typeNameLbl);
        image = findView(R.id.image);
        availableLbl = findView(R.id.availableLbl);
        priceLbl = findView(R.id.priceLbl);
        floorPlanBtn = findView(R.id.floorPlanBtn);
        priceListBtn = findView(R.id.priceListBtn);
    }

    @Override
    public void setData(UnitType data) {
        super.setData(data);
        typeNameLbl.setText(data.getName());
        loadImage(data.getImage(), image);
        availableLbl.setText("Available : " + data.getAvailableUnit());
        priceLbl.setText("Price : " + UtilsCurrency.toCurrency(data.getStartPrice()));
        floorPlanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unitListener.openFloorPlan(data);
            }
        });
        priceListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unitListener.openPriceList(data.getPriceList());
            }
        });
    }
}
