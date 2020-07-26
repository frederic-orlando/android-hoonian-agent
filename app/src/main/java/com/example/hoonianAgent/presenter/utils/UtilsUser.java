package com.example.hoonianAgent.presenter.utils;

import android.app.Activity;

import com.example.hoonianAgent.BuildConfig;
import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.acl.ModelMenu;
import com.example.hoonianAgent.model.content.acl.ModelMore;
import com.example.hoonianAgent.model.content.login.Menu;
import com.example.hoonianAgent.model.content.login.ModelDataLogin;
import com.example.hoonianAgent.model.content.login.UserAccess;
import com.example.hoonianAgent.presenter.session.SessionMenu;
import com.example.hoonianAgent.presenter.session.SessionUser;
import com.example.hoonianAgent.presenter.session.SessionVersion;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;

import connection.rxconnection.session.SessionLogin;

@EBean
public class UtilsUser {
    @RootContext
    protected Activity activity;

    @Bean
    protected UtilsMenu utilsMenu;

    public void setData(ModelDataLogin dataUser) {
        new SessionUser(activity).setData(dataUser);
        new SessionLogin(activity).setToken("Bearer " + dataUser.getToken());

        setMenu(dataUser);
    }

    @Background(delay = 100)
    protected void setMenu(ArrayList<Menu> navBars, ArrayList<UserAccess> userAccess) {
        if (utilsMenu.getCallback() >= utilsMenu.getMaxCallback()) {
            createMenu(navBars, userAccess);
        }
        else setMenu(navBars, userAccess);
    }

    @Background(delay = 100)
    protected void setMenu(ModelDataLogin dataUser) {
        if (utilsMenu.getCallback() >= utilsMenu.getMaxCallback()) {
            createMenu(dataUser.getMenuNavBars(), dataUser.getUserAccess());
        }
        else setMenu(dataUser);
    }

    @Background(delay = 100)
    protected void generate(ArrayList<Menu> listNavbar, ArrayList<UserAccess> listAccess) {
        if (utilsMenu.getCallback() >= utilsMenu.getMaxCallback()) {
            createMenu(listNavbar, listAccess);
        }
        else generate(listNavbar, listAccess);
    }

    @Background(delay = 500)
    protected void createMenu(ArrayList<Menu> listNavBar, ArrayList<UserAccess> listAccess) {
        ArrayList<ModelMenu> listMenu = new ArrayList<>();
        ArrayList<ModelMore> listMore = new ArrayList<>();

        for (Menu menu : listNavBar) {
            ModelMenu modelMenu = utilsMenu.getMenu(menu.getId(),
                    menu.getName());
            listMenu.add(modelMenu);
        }

        if (listAccess.size() != 0) {
            listMenu.add(utilsMenu.getMenu(0, "More"));
        }

        // if listmenu has not only more menu, set first one as home
        if (listMenu.size() > 1) {
            listMenu.get(0).setTitle("Home");
            listMenu.get(0).setIconNav(R.drawable.ic_baseline_home_24);
        }

        for (UserAccess userAccess : listAccess) {
            ModelMore modelMore = new ModelMore();
            modelMore.setTitle(userAccess.getName());
            ArrayList<ModelMenu> listMenuMore = new ArrayList<>();
            for (Menu item : userAccess.getItems()){
                ModelMenu modelMenu = utilsMenu.getMenu(item.getId(), item.getName());
                listMenuMore.add(modelMenu);
            }
            modelMore.setChild(listMenuMore);
            listMore.add(modelMore);
        }

        SessionMenu sessionMenu = new SessionMenu(activity);
        sessionMenu.setDataNavBar(listMenu);
        sessionMenu.setDataMore(listMore);
        new SessionVersion(activity).setVersion(BuildConfig.VERSION_CODE);
    }
}
