package com.example.hoonianAgent.view.fragment.contacts.add;

import com.example.hoonianAgent.model.content.City;
import com.example.hoonianAgent.model.content.home.HomeItem;

import java.util.ArrayList;

public interface ContactAddPres {
    void init();
    void setDataSpinner(ArrayList<City> listCities);
    void save();
}
