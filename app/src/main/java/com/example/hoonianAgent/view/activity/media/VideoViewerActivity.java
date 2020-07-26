package com.example.hoonianAgent.view.activity.media;

import android.content.Intent;
import android.content.res.Configuration;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.Media;
import com.example.hoonianAgent.view.activity.base.BaseActivity;
import com.example.hoonianAgent.view.activity.base.BaseActivityToolBar;
import com.google.android.material.tabs.TabLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_video_player)
public class VideoViewerActivity extends BaseActivity implements VideoViewerView {
    @Bean
    protected VideoViewerImpl impl;
    @ViewById
    protected VideoView videoView;
    @Extra
    protected Media video;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setFragmentManager(getSupportFragmentManager(), getClass().getName());
        impl.setVideo(video);
        impl.init();
    }

    @Override
    public VideoView video() {
        return videoView;
    }
}