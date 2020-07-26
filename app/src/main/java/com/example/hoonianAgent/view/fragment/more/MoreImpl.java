package com.example.hoonianAgent.view.fragment.more;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hoonianAgent.model.content.acl.ModelMenu;
import com.example.hoonianAgent.model.content.acl.ModelMore;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.session.SessionMenu;
import com.example.hoonianAgent.view.adapter.recycler.AdapterMore;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;

@EBean
public class MoreImpl extends BaseImpl<MoreView> implements MorePres, RecyclerListener {
    @Override
    public void init() {
        setData(new SessionMenu(activity).getDataMore());
    }

    @UiThread
    protected void setData(ArrayList<ModelMore> dataMore) {
        if (viewAct.more() != null) {
            AdapterMore adapter = new AdapterMore(dataMore, this);
            viewAct.more().setAdapter(adapter);
            viewAct.more().setLayoutManager(new LinearLayoutManager(activity));
        }
    }

    @Override
    public void onItemClick(Object o) {
        if (o instanceof ModelMenu) {
            ModelMenu modelMenu = (ModelMenu) o;
            if (modelMenu.getId() == 10) {
                logOutUser();
            }
            else {
                intentManager.moveToNext(modelMenu.getTitle(), ((int) modelMenu.getPositionFragment()));
            }
        }
    }


}