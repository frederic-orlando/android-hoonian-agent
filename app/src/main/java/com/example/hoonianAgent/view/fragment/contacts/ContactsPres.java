package com.example.hoonianAgent.view.fragment.contacts;

import com.example.hoonianAgent.model.content.contacts.Contacts;
import com.example.hoonianAgent.model.content.home.HomeItem;

import java.util.ArrayList;

public interface ContactsPres {
    void init();
    void setDataContacts(ArrayList<Contacts> listContact);
    void addContact();
}
