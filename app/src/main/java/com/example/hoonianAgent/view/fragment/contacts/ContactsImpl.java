package com.example.hoonianAgent.view.fragment.contacts;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.content.contacts.Contacts;
import com.example.hoonianAgent.model.response.contacts.ResponseGetContactList;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.session.SessionUser;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.example.hoonianAgent.view.adapter.recycler.AdapterCategoryHome;
import com.example.hoonianAgent.view.adapter.recycler.AdapterContactList;
import com.example.hoonianAgent.view.fragment.contacts.add.ContactAddFragment;
import com.example.hoonianAgent.view.fragment.contacts.detail.ContactsDetailFragment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;

import lombok.Setter;

@EBean
public class ContactsImpl extends BaseImpl<ContactsView> implements ContactsPres, RecyclerListener {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;
    private static final int PICK_CONTACT = 1;

    @Override
    public void init() {
        Agent agent = new SessionUser(activity).getData();
        serviceManager.getContactList(agent.getId());
    }

    @Override
    @UiThread
    public void setDataContacts(ArrayList<Contacts> listContact) {
        if (viewAct.recycler() != null) {
            AdapterContactList adapter = new AdapterContactList(listContact, this);
            viewAct.recycler().setAdapter(adapter);
            viewAct.recycler().setLayoutManager(new LinearLayoutManager(activity));
        }
    }

    @Override
    public void addContact() {
        if (permissionMarshmallow.checkPermissionForReadContacts()) {
            Intent intent= new Intent(Intent.ACTION_PICK,  ContactsContract.Contacts.CONTENT_URI);

            activity.startActivityForResult(intent, PICK_CONTACT);
        }
        else {
            permissionMarshmallow.requestPermissionGetContacts();
        }
    }

    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        switch (reqCode) {
            case (PICK_CONTACT) :
                if (resultCode == Activity.RESULT_OK) {
                    Contacts newContact = null;
                    String phoneNumber = null;
                    ContentResolver cr = activity.getContentResolver();
                    Cursor cursor = cr.query(data.getData(), null, null, null, null);
                    if (cursor.moveToFirst()) {
                        String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                        String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                        Cursor phones = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);
                        while (phones.moveToNext()) {
                            String number = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                            phoneNumber = number;
                        }
                        newContact = new Contacts(name, phoneNumber);
                        phones.close();
                    }
                    cursor.close();
                    intentManager.moveToNext("Add Contact", ContactAddFragment.FRAGMENT_ID, newContact);
                }
                break;
        }
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseGetContactList) {
            setDataContacts(((ResponseGetContactList) o).getContacts());
        }
    }

    @Override
    public void onItemClick(Object o) {
        if (o instanceof Contacts) {
            intentManager.moveToNext("Contact Detail", ContactsDetailFragment.FRAGMENT_ID, (Contacts) o);
        }
    }
}
