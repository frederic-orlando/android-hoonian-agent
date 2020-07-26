package com.example.hoonianAgent.presenter.base.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.acl.ModelTab;
import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.presenter.callback.CallBackDialog;
import com.example.hoonianAgent.presenter.callback.ImageLoader;
import com.example.hoonianAgent.presenter.manager.DialogManager;
import com.example.hoonianAgent.presenter.manager.IntentManager;
import com.example.hoonianAgent.presenter.manager.ServiceManager;
import com.example.hoonianAgent.presenter.session.SessionMenu;
import com.example.hoonianAgent.presenter.session.SessionUser;
import com.example.hoonianAgent.presenter.utils.FragmentManagerUtils;
import com.example.hoonianAgent.presenter.utils.PermissionMarshmallow;
import com.example.hoonianAgent.presenter.utils.UtilsLayout;
import com.example.hoonianAgent.presenter.utils.UtilsThumbnail;
import com.example.hoonianAgent.view.activity.auth.AuthActivity_;
import com.example.hoonianAgent.view.activity.base.BaseActivity;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import connection.rxconnection.connection.ConnectionListener;
import connection.rxconnection.connection.HttpRequest;
import connection.rxconnection.session.SessionLogin;
import lombok.Getter;
import lombok.Setter;

@EBean
public class BaseImpl<T> implements ConnectionListener, CallBackDialog, Validator.ValidationListener, ImageLoader {
    @RootContext
    @Getter
    protected Activity activity;
    @Bean
    protected IntentManager intentManager;
    @Setter
    protected T viewAct;
    @Getter
    protected Validator validator;
    @Bean
    protected UtilsLayout utilsLayout;
    @Bean
    protected ServiceManager serviceManager;
    @Getter
    @Bean
    protected FragmentManagerUtils fragmentManagerUtils;
    @Bean
    protected DialogManager dialogManager;

    @Bean
    protected PermissionMarshmallow permissionMarshmallow;

    @AfterInject
    protected void inject() {
        serviceManager.setConnectionListener(this);
        try {
            validator = new Validator(activity);
            validator.setValidationListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> void initValidator(T target) {
        validator = new Validator(target);
        validator.setValidationListener(this);
    }

    public void showHidePass(TextView textView) {
        utilsLayout.showHidePass(textView);
    }

    public void setFragmentManager(FragmentManager fragmentManager, String className) {
        fragmentManagerUtils.setFragmentManager(fragmentManager);
        fragmentManagerUtils.setCallback(this);
        fragmentManagerUtils.setClassName(className);
        dialogManager.setFragmentManager(fragmentManager);
    }

    public void setLayoutFragment(int layoutFragment) {
        fragmentManagerUtils.setLayoutFragment(layoutFragment);
    }

    private BaseActivity getBaseActivity() {
        return (BaseActivity) activity;
    }


    @Override
    public void onSuccessWithData(Object o) {
    }

    @Override
    public void onSuccessNull() {
    }

    @Override
    public void onMessageSuccess(String s) {
        dialogManager.errorNonAuth(this, s);
    }

    @UiThread
    @Override
    public void onError(Object o, HttpRequest httpRequest) {

    }

    @UiThread
    @Override
    public void unAuthorized(HttpRequest httpRequest, String message) {
        logOutUser();
    }

    public void checkIsLogin() {
        if (getToken() == null) {
            if (!activity.getClass().getName().equals(AuthActivity_.class.getName())) {
                intentManager.moveToLogin();
            }
        }
        else {
            //intentManager.moveToMain(false);
            intentManager.moveToMain();
        }
    }

    public boolean isAlreadyLogin() {
        return getToken() != null;
    }


    private String getToken() {
        return new SessionLogin(activity).getToken();
    }

    protected ModelTab makeTab(BaseFragment fragment, String title) {
        fragment.setCallback(this);
        return new ModelTab().setFragment(fragment).setTitle(title);
    }

    protected ModelTab makeTab(BaseFragment fragment, String title, int imageId) {
        fragment.setCallback(this);
        return new ModelTab().setFragment(fragment).setImageId(imageId).setTitle(title);
    }

    protected ModelTab makeTab(BaseFragment fragment, String title, int imageId, Object callback) {
        fragment.setCallback(callback);
        return new ModelTab().setFragment(fragment).setImageId(imageId).setTitle(title);
    }

    public void onOptionsItemSelected(MenuItem menuItem) {

    }

    protected ArrayList arrayToArrayList(Object[] array) {
        if (array != null && array.length > 0) {
            return new ArrayList(Arrays.asList(array));
        } else {
            return new ArrayList();
        }
    }


    @Override
    public void ok() {
        activity.finish();
    }

    //Todo: Add setSpinner
//    protected <T extends BaseSpinner> void setSpinner(Spinner spinner, T[] data) {
//        AdapterGenericGetName adapter = new AdapterGenericGetName<>(activity, data);
//        adapter.setDropDownViewResource(R.layout.spinner_list_item_dropdown);
//        spinner.setAdapter(adapter);
//    }


    @Override
    public void onValidationSucceeded() {

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(activity);
            utilsLayout.setError(view, message);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (fragmentManagerUtils.getLayoutFragment() != -1) {
            BaseFragment baseFragment = (BaseFragment) fragmentManagerUtils.getFragmentManager().
                    findFragmentById(fragmentManagerUtils.getLayoutFragment());
            if (baseFragment != null)
                baseFragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (fragmentManagerUtils.getLayoutFragment() != -1) {
            BaseFragment baseFragment = (BaseFragment) fragmentManagerUtils.getFragmentManager().
                    findFragmentById(fragmentManagerUtils.getLayoutFragment());
            if (baseFragment != null)
                baseFragment.onActivityResult(requestCode, resultCode, data);
        }
    }


    public void backPressed() {

    }

    public Agent getAgent() {
        return new SessionUser(activity).getData();
    }

    public void logOutUser() {
        new SessionLogin(activity).clearToken();
        new SessionUser(activity).clearData();
        new SessionMenu(activity).clearData();
        checkIsLogin();
    }


    protected ArrayList<Object> transformToListObject(ArrayList arrayList) {
        return arrayList;
    }

    public void resume() {
        if (getFragmentManagerUtils().getExistFragment() != null) {
            getFragmentManagerUtils().getExistFragment().onResume();
        }
    }

    @Override
    public void loadImage(String url, ImageView view) {
        int placeholder = R.drawable.ic_launcher_background;
        Glide.with(activity).load(url)
                .placeholder(placeholder)
                .into(view);
    }

    //Todo: Add Get Real Path Image
    public String getRealPathImageGallery(Intent data, boolean video) {
        String filePath = null;
//        if (Build.VERSION.SDK_INT < 11) {
//            filePath = RealPathUtil.getRealPathFromURIbelowAPI11(activity, data.getData(), video);
//        } // SDK >= 11 && SDK < 19
//        else if (Build.VERSION.SDK_INT < 19) {
//            filePath = RealPathUtil.getRealPathFromURIaPI11to18(activity, data.getData(), video);
//        } // SDK > 19 (Android 4.4)
//        else {
//            filePath = RealPathUtil.getRealPathFromURIaPI19(activity, data.getData(), video);
//        }
        return filePath;
    }
}
