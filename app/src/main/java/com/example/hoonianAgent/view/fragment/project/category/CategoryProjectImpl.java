package com.example.hoonianAgent.view.fragment.project.category;

import android.os.Bundle;

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

import lombok.Setter;

@EBean
public class CategoryProjectImpl extends BaseImpl<CategoryProjectView> implements CategoryProjectPres {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;
    @Setter
    private Category category;

    @Override
    public void init() {
        serviceManager.getProjectList(new RequestProjectList(5, 1, "", category.getId()));
    }

    @Override
    public void search() {

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
            reloadList(data);
        }
    }
}
