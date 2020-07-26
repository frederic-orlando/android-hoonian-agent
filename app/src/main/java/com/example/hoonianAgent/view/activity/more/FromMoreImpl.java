package com.example.hoonianAgent.view.activity.more;

import android.os.Bundle;

import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.example.hoonianAgent.view.fragment.base.BaseFragmentFromMore_;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import lombok.Setter;

@EBean
public class FromMoreImpl extends BaseImpl<FromMoreView> implements FromMorePres {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;

    @Setter
    private int fragmentId;

    @Setter
    private String title;
    @Setter
    private BaseSerializableObject object;

    @Override
    public void init() {
        BaseFragment fragment = utilsMenuFragment.getFragment(fragmentId);

        if (object != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(BaseFragmentFromMore_.BASE_SERIALIZABLE_OBJECT_ARG, object);
            fragment.setArguments(bundle);
        }

        getFragmentManagerUtils().showFragmentUsingCallBackNoBackStack(fragment);
    }

    @Override
    public String titleActivity() { return title; }
}
