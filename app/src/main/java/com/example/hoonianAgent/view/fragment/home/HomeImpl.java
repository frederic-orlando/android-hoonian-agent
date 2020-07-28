package com.example.hoonianAgent.view.fragment.home;

import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.City;
import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.content.home.ModelDataHome;
import com.example.hoonianAgent.model.content.news.News;
import com.example.hoonianAgent.model.content.property.Category;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.model.response.home.ResponseHome;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.HomeCategoryListener;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.session.SessionUser;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.example.hoonianAgent.view.adapter.recycler.AdapterCategoryHome;
import com.example.hoonianAgent.view.adapter.recycler.AdapterLocation;
import com.example.hoonianAgent.view.adapter.recycler.itemDecoration.ItemDecorationHorizontal;
import com.example.hoonianAgent.view.fragment.city.CityListFragment;
import com.example.hoonianAgent.view.fragment.news.NewsDetailFragment;
import com.example.hoonianAgent.view.fragment.project.ProjectFragment_;
import com.example.hoonianAgent.view.fragment.project.category.CategoryProjectFragment;
import com.example.hoonianAgent.view.fragment.project.city.CityProjectFragment;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;

@EBean
public class HomeImpl extends BaseImpl<HomeView> implements HomePres, RecyclerListener, HomeCategoryListener {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;

    Agent currentUser;
    ModelDataHome data;

    @Override
    public void init() {
        viewAct.swipe().setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                serviceManager.getHome(currentUser.getId());
            }
        });

        currentUser = new SessionUser(activity).getData();
        serviceManager.getHome(currentUser.getId());
    }

    @Override
    public void initData() {
        viewAct.name().setText(currentUser.getName());

        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category("Apartments", data.getApartment()));
        categories.add(new Category("Landed Property", data.getLandedProperty()));
        categories.add(new Category("Warehouse", data.getWarehouse()));

        setDataCarousel(data.getNews());
        setDataLocation(data.getCities());
        setDataProperty(categories);
        viewAct.swipe().setRefreshing(false);
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseHome) {
            data = ((ResponseHome) o).getData();
            initData();
        }
    }

    @Override
    @UiThread
    public void setDataCarousel(ArrayList<News> newsItem) {
        if (viewAct.carousel() != null) {
            viewAct.carousel().setImageListener(new ImageListener() {
                @Override
                public void setImageForPosition(int position, ImageView imageView) {
                    loadImage(newsItem.get(position).getImage(), imageView);
                }
            });

            viewAct.carousel().setPageCount(newsItem.size());
            viewAct.carousel().setImageClickListener(new ImageClickListener() {
                @Override
                public void onClick(int position) {
                    intentManager.moveToNext("News", NewsDetailFragment.FRAGMENT_ID, newsItem.get(position));
                }
            });
        }
    }

    @Override
    public void seeMoreLocation() {
        intentManager.moveToNext("Locations", CityListFragment.FRAGMENT_ID);
    }

    @Override
    public void setDataLocation(ArrayList<City> listCities) {
        if (viewAct.locations() != null) {
            AdapterLocation adapter = new AdapterLocation(listCities, this);

            if (viewAct.locations().getItemDecorationCount() == 0) {
                viewAct.locations().addItemDecoration(new ItemDecorationHorizontal(activity, R.dimen.padding_default, R.dimen.padding_xmsmall));
            }
            viewAct.locations().setAdapter(adapter);
            LinearLayoutManager manager = new LinearLayoutManager(activity);
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            viewAct.locations().setLayoutManager(manager);
        }
    }

    @Override
    @UiThread
    public void setDataProperty(ArrayList<Category> categories) {
        if (viewAct.properties() != null) {
            AdapterCategoryHome adapter = new AdapterCategoryHome(categories, this);
            viewAct.properties().setAdapter(adapter);
            viewAct.properties().setLayoutManager(new LinearLayoutManager(activity));
        }
    }

    @Override
    public void onItemClick(Object o) {
        if (o instanceof City) {
            City city = (City) o;
            intentManager.moveToNext(city.getName(), CityProjectFragment.FRAGMENT_ID, city);
        }
        else if (o instanceof Project) {
            Project project = (Project) o;
            intentManager.moveToNext(project.getName(), ProjectFragment_.FRAGMENT_ID, project);
        }
    }

    @Override
    public void onMoreClick(Category category) {
        intentManager.moveToNext(category.getName(), CategoryProjectFragment.FRAGMENT_ID, category);
    }
}
