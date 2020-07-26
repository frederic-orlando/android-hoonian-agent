package com.example.hoonianAgent.view.activity.more;

import android.content.Intent;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.example.hoonianAgent.view.activity.base.BaseActivityToolBar;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;

@EActivity(R.layout.activity_from_more)
public class FromMoreActivity extends BaseActivityToolBar implements FromMoreView {
    @Bean
    protected FromMoreImpl impl;
    @Extra
    protected int fragmentToAttach;
    @Extra
    protected String title;
    @Extra
    protected BaseSerializableObject data;

    @Override
    protected void init() {
        Drawable normalDrawable = getResources().getDrawable(R.drawable.ic_baseline_chevron_left_24);
        Drawable wrapDrawable = DrawableCompat.wrap(normalDrawable);
        DrawableCompat.setTint(wrapDrawable, getResources().getColor(R.color.white));

        toolbar.setNavigationIcon(wrapDrawable);
        impl.setViewAct(this);
        impl.setTitle(title);
        impl.setObject(data);
        impl.setLayoutFragment(R.id.frame_next);
        impl.setFragmentId(fragmentToAttach);
        impl.setFragmentManager(getSupportFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        impl.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        impl.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onBackPressed() {
        impl.getFragmentManagerUtils().backpressed();
    }

    @Override
    protected String titleApp() {
        return title;
    }


    @Override
    protected void onResume() {
        super.onResume();
        impl.init();
    }
}
