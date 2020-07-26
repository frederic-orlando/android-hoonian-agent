package com.example.hoonianAgent.view.activity.auth;

import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;

public interface AuthPres {
    void init();
    void moveTo(BaseFragment fragment);
    void moveTo(BaseFragment fragment, Boolean backStack);
    void moveTo(BaseFragment fragment, BaseSerializableObject object, Boolean backStack);
}
