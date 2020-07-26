package com.example.hoonianAgent.presenter.utils;

import android.app.Activity;

import com.example.hoonianAgent.view.fragment.ar.ARFragment_;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.example.hoonianAgent.view.fragment.city.CityListFragment_;
import com.example.hoonianAgent.view.fragment.contacts.ContactsFragment_;
import com.example.hoonianAgent.view.fragment.contacts.add.ContactAddFragment_;
import com.example.hoonianAgent.view.fragment.contacts.detail.ContactsDetailFragment_;
import com.example.hoonianAgent.view.fragment.contacts.edit.ContactEditFragment_;
import com.example.hoonianAgent.view.fragment.home.HomeFragment_;
import com.example.hoonianAgent.view.fragment.more.MoreFragment_;
import com.example.hoonianAgent.view.fragment.news.NewsDetailFragment_;
import com.example.hoonianAgent.view.fragment.profile.ProfileFragment_;
import com.example.hoonianAgent.view.fragment.profile.changePassword.ChangePasswordFragment_;
import com.example.hoonianAgent.view.fragment.profile.edit.ProfileEditFragment_;
import com.example.hoonianAgent.view.fragment.project.ProjectFragment_;
import com.example.hoonianAgent.view.fragment.project.category.CategoryProjectFragment_;
import com.example.hoonianAgent.view.fragment.project.city.CityProjectFragment_;
import com.example.hoonianAgent.view.fragment.project.cluster.detail.ClusterDetailFragment_;
import com.example.hoonianAgent.view.fragment.project.referred.form.ReferredFormFragment_;
import com.example.hoonianAgent.view.fragment.project.unitType.UnitTypeDetailFragment_;
import com.example.hoonianAgent.view.fragment.purchase.PurchaseFragment_;
import com.example.hoonianAgent.view.fragment.purchase.detail.PurchaseDetailFragment_;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;

@EBean
public class UtilsMenuFragment {
    @RootContext
    protected Activity activity;
    private ArrayList<BaseFragment> listFragment = new ArrayList();

    @AfterInject
    protected void generateList() {
        listFragment.add(MoreFragment_.builder().build());
        listFragment.add(HomeFragment_.builder().build());
        listFragment.add(PurchaseFragment_.builder().build());
        listFragment.add(ContactsFragment_.builder().build());
        listFragment.add(ARFragment_.builder().build());
        listFragment.add(new BaseFragment());
        listFragment.add(new BaseFragment());
        listFragment.add(new BaseFragment());
        listFragment.add(new BaseFragment());
        listFragment.add(NewsDetailFragment_.builder().build());
        listFragment.add(CityListFragment_.builder().build());

        listFragment.add(CityProjectFragment_.builder().build()); // 11
        listFragment.add(ProfileFragment_.builder().build());
        listFragment.add(CategoryProjectFragment_.builder().build());
        listFragment.add(PurchaseDetailFragment_.builder().build());
        listFragment.add(ProjectFragment_.builder().build());
        listFragment.add(ChangePasswordFragment_.builder().build());
        listFragment.add(UnitTypeDetailFragment_.builder().build());
        listFragment.add(ClusterDetailFragment_.builder().build()); // 18
        listFragment.add(ReferredFormFragment_.builder().build()); // 19
        listFragment.add(ContactsDetailFragment_.builder().build()); // 20
        listFragment.add(ContactAddFragment_.builder().build()); // 21
        listFragment.add(ContactEditFragment_.builder().build()); // 22
        listFragment.add(ProfileEditFragment_.builder().build()); // 22
    }

    public BaseFragment getFragment(int position) {
        BaseFragment bf;
        int index = position;
        if (index >= listFragment.size()) {
            bf = new BaseFragment();
        } else {
            bf = listFragment.get(index);
        }
        return bf;
    }
}
