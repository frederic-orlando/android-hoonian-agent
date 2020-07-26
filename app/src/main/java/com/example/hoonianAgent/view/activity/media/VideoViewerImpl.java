package com.example.hoonianAgent.view.activity.media;

import android.content.Intent;
import android.widget.MediaController;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.Media;
import com.example.hoonianAgent.model.content.acl.ModelMenu;
import com.example.hoonianAgent.model.content.home.ModelDataHome;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.session.SessionMenu;
import com.example.hoonianAgent.view.adapter.pager.AdapterPagerTabMenu;
import com.example.hoonianAgent.view.fragment.profile.ProfileFragment;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.res.StringRes;

import java.util.ArrayList;

import lombok.Setter;

@EBean
public class VideoViewerImpl extends BaseImpl<VideoViewerView> implements VideoViewerPres {
    @Setter
    private Media video;
    @Override
    public void init() {
        viewAct.video().setVideoPath(video.getLink());

        MediaController mediaController = new MediaController(activity);
        viewAct.video().setMediaController(mediaController);
        mediaController.setAnchorView(viewAct.video());

        viewAct.video().start();
    }
}
