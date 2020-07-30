package com.example.hoonianAgent.view.adapter.pager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import com.example.hoonianAgent.model.content.acl.ModelTab;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by AndreHF on 10/28/2016.
 */

public class AdapterPagerTab extends FragmentStatePagerAdapter {
    private ArrayList<ModelTab> modelTabs;

    public AdapterPagerTab(FragmentManager fm, ArrayList<ModelTab> modelTabs) {
        super(fm);
        this.modelTabs = modelTabs;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
        return modelTabs.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return modelTabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return modelTabs.get(position).getTitle();
    }

    public ModelTab getModelTab(int position){
        return modelTabs.get(position);
    }

}
