package com.example.hoonianAgent.model.custom;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.presenter.callback.CustomDialogListener;

public class CustomDialog {
    Activity activity;
    AlertDialog.Builder builder;
    LayoutInflater inflater;
    View dialogView;
    AlertDialog dialog;

    public CustomDialog(Activity activity) {
        this.activity = activity;
        init();
    }

    public void init() {
        builder = new AlertDialog.Builder(activity);
        dialog = builder.create();
        inflater = activity.getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_custom_text, null);
        dialog.setView(dialogView);
    }

    public void show(String text) {
        show(text, new CustomDialogListener() {
            @Override
            public void close(Dialog dialog) {

            }
        });
    }

    public void show(String text, CustomDialogListener closeListener) {
        show(text, new CustomDialogListener() {
            @Override
            public void close(Dialog dialog) {

            }
        }, null, true);
    }

    public void show(String text, CustomDialogListener closeListener, String closeText, Boolean isCancelable) {
        Button closeBtn = dialogView.findViewById(R.id.closeBtn);
        if (closeText != null) {
            closeBtn.setText(closeText);
        }
        closeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        closeListener.close(dialog);
                        dialog.dismiss();
                    }
                });

        TextView label = dialogView.findViewById(R.id.customLbl);
        label.setText(text);

        dialog.setCancelable(isCancelable);
        dialog.show();
    }
}
