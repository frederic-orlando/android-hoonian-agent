package com.example.hoonianAgent.presenter.manager;

import android.app.Activity;
import android.content.Intent;

import com.example.hoonianAgent.model.content.Media;
import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.example.hoonianAgent.view.activity.auth.AuthActivity_;
import com.example.hoonianAgent.view.activity.main.MainActivity_;
import com.example.hoonianAgent.view.activity.media.VideoViewerActivity_;
import com.example.hoonianAgent.view.activity.more.FromMoreActivity_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class IntentManager {
    @RootContext
    protected Activity activity;

    public void moveToLogin() {
        AuthActivity_.intent(activity).flags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)
                .start();
        activity.finish();
    }

    public void moveToMain() {
        MainActivity_.intent(activity).flags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)
                .start();
        activity.finish();
    }

    //Todo: Implement moveToMain from Template
//    public void moveToMain(boolean isFromMore) {
//        MainActivity_.intent(activity).isFromMore(isFromMore).flags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK).start();
//        activity.finish();
//    }

    public void moveToNext(String title, int idFragment) {
        FromMoreActivity_.intent(activity).title(title).fragmentToAttach(idFragment)
                .flags(Intent.FLAG_ACTIVITY_CLEAR_TASK).start();
    }

    public void moveToNext(String title, int idFragment, BaseSerializableObject data) {
        FromMoreActivity_.intent(activity).title(title).fragmentToAttach(idFragment).data(data)
                .flags(Intent.FLAG_ACTIVITY_CLEAR_TASK).start();
    }
    public void moveToVideoViewer(Media video) {
        VideoViewerActivity_.intent(activity).video(video).start();
    }
}
