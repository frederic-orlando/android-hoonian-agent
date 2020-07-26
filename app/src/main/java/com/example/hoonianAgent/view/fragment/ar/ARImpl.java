package com.example.hoonianAgent.view.fragment.ar;

import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import lombok.Setter;

@EBean
public class ARImpl extends BaseImpl<ARView> implements ARPres, RecyclerListener {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;

    @Setter
    private int fragmentId;

    @Override
    public void init() {

    }

    @Override
    public void onItemClick(Object o) {

    }
}
