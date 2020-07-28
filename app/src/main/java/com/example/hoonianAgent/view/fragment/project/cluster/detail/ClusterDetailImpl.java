package com.example.hoonianAgent.view.fragment.project.cluster.detail;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.Media;
import com.example.hoonianAgent.model.content.customShape.CustomCanvasView;
import com.example.hoonianAgent.model.content.property.Block;
import com.example.hoonianAgent.model.content.property.Cluster;
import com.example.hoonianAgent.model.content.property.Facility;
import com.example.hoonianAgent.model.content.property.Unit;
import com.example.hoonianAgent.model.content.property.UnitTypeTable;
import com.example.hoonianAgent.model.request.project.RequestFloorPlan;
import com.example.hoonianAgent.model.response.project.ModelDataGetFloorPlan;
import com.example.hoonianAgent.model.response.project.ResponseGetClusterDetail;
import com.example.hoonianAgent.model.response.project.ResponseGetFloorPlan;
import com.example.hoonianAgent.model.response.project.ResponseGetUnitTable;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.utils.UtilsCurrency;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.example.hoonianAgent.view.adapter.recycler.AdapterFacility;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;

import lombok.Setter;

@EBean
public class ClusterDetailImpl extends BaseImpl<ClusterDetailView> implements ClusterDetailPres, RecyclerListener {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;
    @Setter
    private Cluster cluster;

    private int currentVideoIndex = 0;

    private int currentFloor = 1;
    private int totalFloor = 1;

    @Override
    public void init() {
        viewAct.prevFloorBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prevFloor();
            }
        });

        viewAct.nextFloorBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextFloor();
            }
        });

        serviceManager.getClusterDetail(cluster.getId());
    }

    @Override
    @UiThread
    public void initData() {
        viewAct.clusterName().setText(cluster.getName());
        viewAct.total().setText("Total " + cluster.getTotalUnit() + " units");
        loadImage(cluster.getImage(), viewAct.image());
        setDataFacilities(cluster.getFacilities());
        setDataCarousel(cluster.getGallery());
        if (cluster.getVr().size() == 0) {
            utilsLayout.hide(viewAct.vrLayout());
        }
        else {
            loadImage(cluster.getVr().get(0).getLink(), viewAct.vr());
        }

        if (cluster.getGallery().size() == 0) {
            utilsLayout.hide(viewAct.galleryLayout());
        }
        else {
            setDataCarousel(cluster.getGallery());
        }

        if (cluster.getVideos().size() == 0) {
            utilsLayout.hide(viewAct.videoLayout());
        }
        else {
            setVideoThumbnail();
        }

        getDataFloorPlan();
    }

    @Override
    @UiThread
    public void setDataFacilities(ArrayList<Facility> listFacility) {
        if (viewAct.facilities() != null) {
            AdapterFacility adapter = new AdapterFacility(listFacility, this);
            viewAct.facilities().setAdapter(adapter);
            viewAct.facilities().setLayoutManager(new LinearLayoutManager(activity));
        }
    }

    @Override
    @UiThread
    public void setDataCarousel(ArrayList<Media> listGallery) {
        if (viewAct.gallery() != null) {
            viewAct.gallery().setImageListener(new ImageListener() {
                @Override
                public void setImageForPosition(int position, ImageView imageView) {
                    loadImage(listGallery.get(position).getLink(), imageView);
                }
            });

            viewAct.gallery().setPageCount(listGallery.size());
            viewAct.gallery().setImageClickListener(new ImageClickListener() {
                @Override
                public void onClick(int position) {
                }
            });
        }
    }

    @Override
    @UiThread
    public void setVideoThumbnail() {
        loadImage(cluster.getVideos().get(currentVideoIndex).getLink(), viewAct.video());
    }

    @Override
    public void setDataUnitCount(ArrayList<UnitTypeTable> unitTypeTables) {
        String[] data = new String[]{"Type", "Total", "Available", "Sold"};
        String[] row = {};
        TableLayout table = viewAct.unitCountTable();
        table.removeAllViews();
        table.setStretchAllColumns(true);
        for (int i = 0; i < unitTypeTables.size() + 1; i++) {
            TableRow tr = new TableRow(activity);
            if (i == 0) {
                tr.setBackgroundColor(ContextCompat.getColor(activity, R.color.cyan));
            }
            else {
                UnitTypeTable uTable = unitTypeTables.get(i-1);
                row = new String[]{uTable.getUnitTypeName(),
                        ""+uTable.getTotalUnit(),
                        ""+uTable.getSoldUnit(),
                        UtilsCurrency.toCurrency(uTable.getStartPrice())};
            }

            for (int j = 0; j < data.length; j++) {
                TextView c = new TextView(activity);
                if (i == 0) {
                    c.setTextColor(ContextCompat.getColor(activity, R.color.white));
                    c.setText(data[j]);
                }
                else {
                    c.setText(row[j]);
                }
                c.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                int padding = (int) activity.getResources().getDimension(R.dimen.padding_xmsmall);
                c.setPadding(0, padding, 0, padding);
                tr.addView(c);
            }
            table.addView(tr);
        }
    }

    @Override
    public void getDataFloorPlan() {
        RequestFloorPlan request = new RequestFloorPlan(
                cluster.getProjectId(),
                cluster.getId(),
                "",
                currentFloor
        );
        serviceManager.getFloorPlan(request);
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
    public void nextFloor() {
        if (currentFloor != totalFloor) {
            currentFloor++;
            getDataFloorPlan();
        }
        else {
            Toast.makeText(activity, "Last Floor", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void prevFloor() {
        if (currentFloor != 1) {
            currentFloor--;
            getDataFloorPlan();
        }
        else {
            Toast.makeText(activity, "First Floor", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void playVideo() {
        intentManager.moveToVideoViewer(cluster.getVideos().get(currentVideoIndex));
    }

    @Override
    public void nextVideo() {
        if (currentVideoIndex != cluster.getVideos().size()) {
            currentVideoIndex++;
        }
        else {
            currentVideoIndex = 0;
        }
        setVideoThumbnail();
    }

    @Override
    public void prevVideo() {
        if (currentVideoIndex != 0) {
            currentVideoIndex--;
        }
        else {
            currentVideoIndex = cluster.getVideos().size();
        }
        setVideoThumbnail();
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseGetClusterDetail) {
            cluster = ((ResponseGetClusterDetail) o).getCluster();
            initData();
        }
        else if (o instanceof ResponseGetFloorPlan) {
            ModelDataGetFloorPlan data = ((ResponseGetFloorPlan) o).getData();
            totalFloor = data.getTotalPage();

            Block block = data.getBlock();
            setDataFloorPlan(data.getUnits(), block.getFloorImage());

            viewAct.floorLbl().setText("Floor" + block.getName());

            RequestFloorPlan request = new RequestFloorPlan
                    (cluster.getId(), "", block.getId());
            serviceManager.getUnitTable(request);
        }
        else if (o instanceof ResponseGetUnitTable) {
            ArrayList<UnitTypeTable> unitTypeTables = ((ResponseGetUnitTable) o).getUnitTypeTable();

            setDataUnitCount(unitTypeTables);
        }
    }

    @Override
    public void onItemClick(Object o) {

    }
}
