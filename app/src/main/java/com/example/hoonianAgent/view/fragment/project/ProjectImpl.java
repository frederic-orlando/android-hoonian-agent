package com.example.hoonianAgent.view.fragment.project;

import androidx.viewpager.widget.ViewPager;

import com.example.hoonianAgent.model.content.acl.ModelTab;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.example.hoonianAgent.view.adapter.pager.AdapterPagerTab;
import com.example.hoonianAgent.view.fragment.project.cluster.list.ClusterListFragment_;
import com.example.hoonianAgent.view.fragment.project.detail.ProjectDetailFragment_;
import com.example.hoonianAgent.view.fragment.project.referred.ReferredListFragment_;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@EBean
public class ProjectImpl extends BaseImpl<ProjectView> implements ProjectPres, ViewPager.OnPageChangeListener {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;
    @Setter
    @Getter
    private Project project;

    private ArrayList<ModelTab> modelTabs = new ArrayList<>();

    @Override
    public void init() {
        modelTabs.add(makeTab(ProjectDetailFragment_.builder().build(), "detail"));
        modelTabs.add(makeTab(ClusterListFragment_.builder().build(), "unit & price"));
        modelTabs.add(makeTab(ReferredListFragment_.builder().build(), "referred"));

        initTab(modelTabs);
    }

    @Override
    public void initTab(ArrayList<ModelTab> dataTabs) {
        viewAct.pager().setAdapter(new AdapterPagerTab(getFragmentManagerUtils().getFragmentManager(),
                dataTabs));
        viewAct.tab().setupWithViewPager(viewAct.pager());
        try {
            viewAct.pager().setOffscreenPageLimit(dataTabs.size());
        } catch (IllegalStateException ignored) {

        }
        viewAct.pager().addOnPageChangeListener(this);
    }

    @Override
    public void removeUnitPriceTab() {
        if (modelTabs.size() == 3) {
//            ((AdapterPagerTab) viewAct.pager().getAdapter()).removeFragmentAt(1);
            modelTabs.remove(1);
            viewAct.pager().getAdapter().notifyDataSetChanged();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
