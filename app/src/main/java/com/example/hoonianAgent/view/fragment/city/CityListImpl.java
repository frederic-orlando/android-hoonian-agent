package com.example.hoonianAgent.view.fragment.city;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.City;
import com.example.hoonianAgent.model.content.home.HomeItem;
import com.example.hoonianAgent.model.response.city.ResponseGetCityList;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.example.hoonianAgent.view.adapter.recycler.AdapterCategoryHome;
import com.example.hoonianAgent.view.adapter.recycler.AdapterCityList;
import com.example.hoonianAgent.view.adapter.recycler.itemDecoration.ItemDecorationGrid;
import com.example.hoonianAgent.view.fragment.project.city.CityProjectFragment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;

import lombok.Setter;

@EBean
public class CityListImpl extends BaseImpl<CityListView> implements CityListPres, RecyclerListener {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;

    @Override
    public void init() {
        serviceManager.getCityList();
    }

    @Override
    @UiThread
    public void setDataCities(ArrayList<City> listCities) {
        if (viewAct.recycler() != null) {
            int column = 2;
            viewAct.recycler().addItemDecoration(new ItemDecorationGrid(activity, R.dimen.padding_smlarge, column));
            AdapterCityList adapter = new AdapterCityList(listCities, this);
            viewAct.recycler().setAdapter(adapter);
            viewAct.recycler().setLayoutManager(new GridLayoutManager(activity, column));
        }
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseGetCityList) {
            ArrayList<City> cities = ((ResponseGetCityList) o).getCities();
            setDataCities(cities);
        }
    }

    @Override
    public void onItemClick(Object o) {
        if (o instanceof City) {
            City city = (City) o;
            intentManager.moveToNext(city.getName(), CityProjectFragment.FRAGMENT_ID, city);
        }
    }
}
