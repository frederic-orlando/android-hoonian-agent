package com.example.hoonianAgent.presenter.utils;

import android.app.Activity;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.acl.ModelMenu;
import com.google.gson.Gson;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@EBean
public class UtilsMenu implements Observer {
    public static ArrayList<ModelMenu> listMenu;

    @Setter
    @Getter
    private static int callback;

    @Getter
    private static int maxCallback = 1;

    @RootContext
    protected Activity activity;

    @Background
    @AfterInject
    protected void generateMenu() {
        if (listMenu == null) {
            listMenu = new ArrayList();
            callback = 0;
            createMenu1();
        }
    }

    @Background
    protected void createMenu1() {
        Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                listMenu.add(makeMenu("more",0, R.drawable.ic_baseline_more_horiz_24));
                listMenu.add(makeMenu("35833063-33cb-4fdc-9234-44facd31227c",1, R.drawable.ic_baseline_home_24));
                listMenu.add(makeMenu("a62d1b49-1523-448c-9668-ea45c975c6c4",2, R.drawable.ic_baseline_book_24));
                listMenu.add(makeMenu("cedfbfdf-6c6e-4c53-9bf0-e376ef8bec79",3, R.drawable.ic_baseline_account_circle_24));
                listMenu.add(makeMenu("0aea09d1-f3cf-47f6-87fd-3b20a97d85ba",4, R.drawable.ic_baseline_filter_center_focus_24));

                subscriber.onNext(null);
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.newThread())
                .subscribe(this);
    }

    private ModelMenu makeMenu(String id, int fragmentPos, int iconNavbar) {
        ModelMenu modelMenu = new ModelMenu();
        modelMenu.setId(id);
        modelMenu.setPositionFragment(fragmentPos);
        modelMenu.setIconMore(iconNavbar);
        modelMenu.setIconNav(iconNavbar);
        return modelMenu;
    }

    public ModelMenu getMenu(String id, String title) {
        ModelMenu modelMenu = getMenuUseId(id);
        if (modelMenu == null) {
            modelMenu = makeMenu("abcdef", 100, R.drawable.ic_icon_close_eye);
        }
        modelMenu.setTitle(title);
        return new Gson().fromJson(new Gson().toJson(modelMenu != null ? modelMenu : new
                ModelMenu()), ModelMenu.class);
    }

    public ModelMenu getMenuUseId(String id) {
        if (listMenu != null) {
            for (ModelMenu modelMenu : listMenu) {
                try {
                    if (modelMenu.getId().equals(id)) {
                        return modelMenu;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(Object o) { callback++; }
}
