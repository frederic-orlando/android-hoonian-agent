package com.example.hoonianAgent.view.fragment.base;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import lombok.Setter;

public class BaseFragment<T> extends Fragment {
    @Setter
    protected T callback;
    private FragmentTransaction fragmentTransaction;

    public void backpressed() {
        getActivity().finish();
    }
}
