package com.example.hoonianAgent.view.fragment.project.city;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.hoonianAgent.model.content.City;
import com.example.hoonianAgent.model.content.property.Category;
import com.example.hoonianAgent.model.request.project.RequestProjectList;
import com.example.hoonianAgent.model.response.project.ModelDataProjectList;
import com.example.hoonianAgent.model.response.project.ResponseGetProjectList;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.example.hoonianAgent.view.fragment.base.BaseFragmentFromMore_;
import com.example.hoonianAgent.view.fragment.project.list.ProjectListFragment_;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import lombok.Setter;

@EBean
public class CityProjectImpl extends BaseImpl<CityProjectView> implements CityProjectPres,  View.OnClickListener {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;
    @Setter
    private City city;

    ArrayList<Category> categories;
    ArrayList<ImageButton> categoryButtons = new ArrayList<>();

    @Override
    public void init() {
        categoryButtons.add(viewAct.apartment());
        categoryButtons.add(viewAct.landed());
        categoryButtons.add(viewAct.warehouse());
        viewAct.apartment().setOnClickListener(this);
        viewAct.landed().setOnClickListener(this);
        viewAct.warehouse().setOnClickListener(this);

        serviceManager.getProjectList(new RequestProjectList(5, 1, city.getId(), ""));
    }

    @Override
    public void reloadList(ModelDataProjectList data) {
        BaseFragment fragment = ProjectListFragment_.builder().build();

        Bundle bundle = new Bundle();
        bundle.putSerializable(BaseFragmentFromMore_.BASE_SERIALIZABLE_OBJECT_ARG, data);
        fragment.setArguments(bundle);

        getFragmentManagerUtils().showFragmentUsingCallBackNoBackStack(fragment);
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseGetProjectList) {
            ModelDataProjectList data = ((ResponseGetProjectList) o).getData();
            if (categories == null) {
                categories = data.getCategories();
            }
            reloadList(data);
        }
    }

    @Override
    public void onClick(View v) {
        int index = categoryButtons.indexOf(v);
        String categoryId = categories.get(index).getId();
        serviceManager.getProjectList(new RequestProjectList(5, 1, city.getId(), categoryId));
    }
}
