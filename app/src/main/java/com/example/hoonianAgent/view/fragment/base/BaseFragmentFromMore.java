package com.example.hoonianAgent.view.fragment.base;

import com.example.hoonianAgent.model.content.base.BaseSerializableObject;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;

@EFragment
public class BaseFragmentFromMore<T> extends BaseFragment<T> {
    @FragmentArg
    protected BaseSerializableObject baseSerializableObject;
}
