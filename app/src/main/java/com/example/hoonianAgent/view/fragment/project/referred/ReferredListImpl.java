package com.example.hoonianAgent.view.fragment.project.referred;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.model.content.referred.Referred;
import com.example.hoonianAgent.model.response.project.ResponseGetReferredList;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.callback.ReferredRecyclerListener;
import com.example.hoonianAgent.presenter.session.SessionUser;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.example.hoonianAgent.view.adapter.recycler.AdapterReferred;
import com.example.hoonianAgent.view.fragment.project.referred.form.ReferredFormFragment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import lombok.Setter;

@EBean
public class ReferredListImpl extends BaseImpl<ReferredListView> implements ReferredListPres, RecyclerListener, ReferredRecyclerListener {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;

    @Setter
    private Project project;

    @Override
    public void init() {
        //getData(null);
    }

    @Override
    public void search() {
        getData(utilsLayout.getBodyText(viewAct.search()));
    }

    @Override
    public void setDataReferred(ArrayList<Referred> referred) {
        RecyclerView recycler = viewAct.recycler();
        if (recycler != null) {
            recycler.setAdapter(new AdapterReferred(referred, this));
            recycler.setLayoutManager(new LinearLayoutManager(activity));
        }
    }

    @Override
    public void refer() {
        intentManager.moveToNext(project.getName(), ReferredFormFragment.FRAGMENT_ID, project);
    }

    @Override
    public void getData(String keyWord) {
        Agent agent = new SessionUser(activity).getData();
        serviceManager.getReferredList(agent.getId(), project.getId());
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseGetReferredList) {
            setDataReferred(((ResponseGetReferredList) o).getListReferred());
        }
    }

    @Override
    public void onItemClick(Object o) {

    }

    @Override
    public void call(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        activity.startActivity(intent);
    }
}
