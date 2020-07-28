package com.example.hoonianAgent.view.viewholder.project;

import android.app.Activity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.referred.Referred;
import com.example.hoonianAgent.model.custom.DialogNotes;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.DialogNotesListener;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.callback.ReferredFormCallback;
import com.example.hoonianAgent.view.viewholder.base.BaseViewHolder;
import com.example.hoonianAgent.view.viewholder.base.BaseViewHolderPos;

public class VHReferredForm extends BaseViewHolderPos<Referred> {
    private CheckBox checkBox;
    private ImageButton noteBtn;

    public VHReferredForm(View itemView, RecyclerListener recyclerListener) {
        super(itemView, recyclerListener);
        checkBox = findView(R.id.checkBox);
        noteBtn = findView(R.id.noteBtn);
    }

    @Override
    public void setData(Referred data, int position) {
        super.setData(data);
        ReferredFormCallback listener = (ReferredFormCallback) getRecyclerListener();
        Activity activity = ((BaseImpl) getRecyclerListener()).getActivity();
        checkBox.setText(data.getContact().getName());
        checkBox.setChecked(data.getIsSelected());

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                data.setIsSelected(isChecked);
                listener.refresh();
            }
        });

        noteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.addNotes(position);
            }
        });
    }
}
