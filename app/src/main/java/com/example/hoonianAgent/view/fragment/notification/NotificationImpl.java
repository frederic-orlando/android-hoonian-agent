package com.example.hoonianAgent.view.fragment.notification;

import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
public class NotificationImpl extends BaseImpl<NotificationView> implements NotificationPres, RecyclerListener {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;

    @Override
    public void init() {

    }

    @Override
    public void onItemClick(Object o) {

    }
}
