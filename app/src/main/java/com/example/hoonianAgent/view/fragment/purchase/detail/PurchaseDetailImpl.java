package com.example.hoonianAgent.view.fragment.purchase.detail;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.Media;
import com.example.hoonianAgent.model.content.customShape.CustomCanvasView;
import com.example.hoonianAgent.model.content.customShape.Point;
import com.example.hoonianAgent.model.content.property.PurchasedProject;
import com.example.hoonianAgent.model.content.property.Unit;
import com.example.hoonianAgent.model.content.property.UnitType;
import com.example.hoonianAgent.model.response.purchase.ResponseGetPurchaseDetail;
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
public class PurchaseDetailImpl extends BaseImpl<PurchaseDetailView> implements PurchaseDetailPres {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;
    @Setter
    private PurchasedProject purchased;

    @Override
    public void init() {
        serviceManager.getPurchaseDetail(purchased.getId());
    }

    @Override
    @UiThread
    public void initData(PurchasedProject purchased) {
        Unit unit = purchased.getUnit();
        UnitType type = unit.getType();
        setDataCarousel(type.getGallery());
        viewAct.type().setText(type.getName() + " Unit");
        viewAct.sizeLbl().setText(type.getSize() + " meter");
        viewAct.priceLbl().setText(UtilsCurrency.toCurrency(purchased.getPrice()));
        viewAct.unitNameLbl().setText(unit.getName());

        initFloorPlan(unit, unit.getBlock().getFloorImage());
        loadImage(type.getAr().get(0).getLink(), viewAct.ar());
        loadImage(type.getVr().get(0).getLink(), viewAct.vr());

    }

    @Override
    @UiThread
    public void initFloorPlan(Unit unit, String url) {
        String coord1 = "440.260|440.510|650.510|650.340|600.340|600.260";
        String coord2 = "30.30|30.300|300.300|300.30";

        // Todo: unit dummy
        ArrayList<Unit> units = new ArrayList<>();
        units.add(new Unit(coord1, "#FF0000"));
        units.add(new Unit(coord2, "#00ff11"));
        CustomCanvasView canvasView = new CustomCanvasView(activity, units);
        canvasView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        loadImage(url, viewAct.floor());
        viewAct.floorLayout().addView(canvasView);
    }

    @Override
    @UiThread
    public void setDataCarousel(ArrayList<Media> listGallery) {
        if (viewAct.carousel() != null) {
            viewAct.carousel().setImageListener(new ImageListener() {
                @Override
                public void setImageForPosition(int position, ImageView imageView) {
                    loadImage(listGallery.get(position).getLink(), imageView);
                }
            });

            viewAct.carousel().setPageCount(listGallery.size());
            viewAct.carousel().setImageClickListener(new ImageClickListener() {
                @Override
                public void onClick(int position) {
                }
            });
        }
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseGetPurchaseDetail) {
            PurchasedProject purchased = ((ResponseGetPurchaseDetail) o).getPurchased();
            initData(purchased);
        }
    }
}
