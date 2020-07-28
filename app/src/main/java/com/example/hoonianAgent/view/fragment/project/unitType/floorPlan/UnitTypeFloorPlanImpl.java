package com.example.hoonianAgent.view.fragment.project.unitType.floorPlan;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.Media;
import com.example.hoonianAgent.model.content.customShape.CustomCanvasView;
import com.example.hoonianAgent.model.content.property.Block;
import com.example.hoonianAgent.model.content.property.Unit;
import com.example.hoonianAgent.model.content.property.UnitType;
import com.example.hoonianAgent.model.request.project.RequestFloorPlan;
import com.example.hoonianAgent.model.request.project.RequestGetUnitTypeDetail;
import com.example.hoonianAgent.model.response.project.ModelDataGetFloorPlan;
import com.example.hoonianAgent.model.response.project.ResponseGetFloorPlan;
import com.example.hoonianAgent.model.response.project.ResponseGetUnitTypeDetail;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.utils.UtilsCurrency;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;

import lombok.Setter;

@EBean
public class UnitTypeFloorPlanImpl extends BaseImpl<UnitTypeFloorPlanView> implements UnitTypeFloorPlanPres {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;
    @Setter
    protected UnitType unitType;

    private int currentFloor = 1;
    private int totalFloor = 1;

    @Override
    public void init() {
        getData();
    }

    @Override
    public void initData(ModelDataGetFloorPlan modelData) {
        Block block = modelData.getBlock();
        viewAct.floorLbl().setText("Floor " + block.getName());

        String[][] data = new String[][]{{"Total", "Available", "Sold"},
                {""+block.getTotalUnit(), ""+block.getAvailableUnit(), ""+block.getSoldUnit()}};

        TableLayout table = viewAct.unitCountTable();
        table.removeAllViews();
        table.setStretchAllColumns(true);
        for (int i = 0; i < data.length; i++) {
            TableRow tr = new TableRow(activity);
            if (i == 0) {
                tr.setBackgroundColor(ContextCompat.getColor(activity, R.color.cyan));
            }

            for (int j = 0; j < data[i].length; j++) {
                TextView c = new TextView(activity);
                if (i == 0) {
                    c.setTextColor(ContextCompat.getColor(activity, R.color.white));
                }
                c.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                int padding = (int) activity.getResources().getDimension(R.dimen.padding_xmsmall);
                c.setPadding(0, padding, 0, padding);
                c.setText(data[i][j]);
                tr.addView(c);
            }
            table.addView(tr);
        }

        setDataFloorPlan(modelData.getUnits(), block.getFloorImage());
    }

    @Override
    public void setDataFloorPlan(ArrayList<Unit> units, String url) {
        CustomCanvasView canvasView = new CustomCanvasView(activity, units);
        canvasView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        loadImage(url, viewAct.floor());
        viewAct.floorLayout().removeAllViews();
        viewAct.floorLayout().addView(canvasView);
    }

    @Override
    public void getData() {
        RequestFloorPlan request = new RequestFloorPlan(
                unitType.getProjectId(),
                unitType.getClusterId(),
                unitType.getId(),
                currentFloor
        );
        serviceManager.getFloorPlan(request);
    }

    @Override
    public void nextFloor() {
        if (currentFloor != totalFloor) {
            currentFloor ++;
            getData();
        }
        else {
            Toast.makeText(activity, "Last Floor", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void prevFloor() {
        if (currentFloor != 1) {
            currentFloor --;
            getData();
        }
        else {
            Toast.makeText(activity, "First Floor", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseGetFloorPlan) {
            ResponseGetFloorPlan response = (ResponseGetFloorPlan) o;
            totalFloor = response.getData().getTotalPage();
            initData(response.getData());
        }
    }
}
