package com.example.hoonianAgent.view.fragment.purchase;

import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.content.property.PurchasedProject;
import com.example.hoonianAgent.model.custom.CustomDialog;
import com.example.hoonianAgent.model.response.purchase.ResponseGetPurchaseList;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.PurchaseRecyclerListener;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.session.SessionUser;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.example.hoonianAgent.view.adapter.recycler.AdapterPurchase;
import com.example.hoonianAgent.view.adapter.recycler.itemDecoration.ItemDecorationVertical;
import com.example.hoonianAgent.view.fragment.purchase.detail.PurchaseDetailFragment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;

@EBean
public class PurchaseImpl extends BaseImpl<PurchaseView> implements PurchasePres, RecyclerListener, PurchaseRecyclerListener {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;

    @Override
    public void init() {
        Agent agent = new SessionUser(activity).getData();
        serviceManager.getPurchaseList(agent.getId());
    }

    @Override
    @UiThread
    public void setDataPurchase(ArrayList<PurchasedProject> listPurchase) {
        if (viewAct.recycler() != null) {
            viewAct.recycler().addItemDecoration(new ItemDecorationVertical(activity, R.dimen.padding_smlarge));
            AdapterPurchase adapter = new AdapterPurchase(listPurchase, this);
            viewAct.recycler().setAdapter(adapter);
            viewAct.recycler().setLayoutManager(new LinearLayoutManager(activity));
        }
    }

    @Override
    public void showNotice() {
        new CustomDialog(activity).show("Commission will be released after payment term initiated");
    }

    @Override
    public void onItemClick(Object o) {

    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseGetPurchaseList) {
            ArrayList<PurchasedProject> listPurchased = ((ResponseGetPurchaseList) o).getPurchased();
            setDataPurchase(listPurchased);
        }
    }

    @Override
    public void openDetail(PurchasedProject purchased) {
        intentManager.moveToNext(purchased.getProject().getName(), PurchaseDetailFragment.FRAGMENT_ID, purchased);
    }
}
