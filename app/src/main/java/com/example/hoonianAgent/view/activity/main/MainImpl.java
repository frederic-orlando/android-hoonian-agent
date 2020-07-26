package com.example.hoonianAgent.view.activity.main;

import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.hoonianAgent.R;
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
public class MainImpl extends BaseImpl<MainView> implements MainPres, ViewPager.OnPageChangeListener {
    @StringRes(R.string.app_name)
    protected String appName;

    @Setter
    private boolean isFromMore;
    @Setter
    private ModelDataHome dataHome;
    @Override
    public void init() {
        getMenu();
    }

    @Override
    public void profile() {
        intentManager.moveToNext("Profile", ProfileFragment.FRAGMENT_ID);
    }

    @Override
    public void notification() {

    }

    @Background(delay = 100)
    protected void getMenu() {
        SessionMenu sessionMenu = new SessionMenu(activity);
        if (sessionMenu.getDataNavbar().size() > 0) {

            activity.runOnUiThread(() -> setData(sessionMenu.getDataNavbar()));
        } else {
            getMenu();
        }
    }

    protected void setData(ArrayList<ModelMenu> dataNavbar) {
        viewAct.pager().setAdapter(new AdapterPagerTabMenu(getFragmentManagerUtils().getFragmentManager(),
                dataNavbar, activity, this));
        viewAct.menu().setupWithViewPager(viewAct.pager());
        try {
            viewAct.pager().setOffscreenPageLimit(dataNavbar.size());
        } catch (IllegalStateException ignored) {

        }
        setIcon(dataNavbar);

        viewAct.pager().addOnPageChangeListener(this);
        if (isFromMore) {
            viewAct.pager().setCurrentItem(4, true);
        }
    }

    @Override
    public void showHideBack(boolean show) {
        viewAct.showHideBackPressed(show);
    }

    private void setIcon(ArrayList<ModelMenu> dataNavbar) {
        for (int pos = 0; pos < viewAct.menu().getTabCount(); pos++) {
            viewAct.menu().getTabAt(pos).setIcon(dataNavbar.get(pos).
                    getIconNav());
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        AdapterPagerTabMenu adapter = (AdapterPagerTabMenu) viewAct.pager().getAdapter();
        int index = viewAct.pager().getCurrentItem();
        Fragment fragment = adapter.getItem(index);

        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        AdapterPagerTabMenu adapter = (AdapterPagerTabMenu) viewAct.pager().getAdapter();
        ((MainActivity) activity).setTitleToolbar(adapter.getPageTitle(position));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
