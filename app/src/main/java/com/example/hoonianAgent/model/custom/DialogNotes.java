package com.example.hoonianAgent.model.custom;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.presenter.callback.CustomDialogListener;
import com.example.hoonianAgent.presenter.callback.DialogNotesListener;

public class DialogNotes {
    Activity activity;
    AlertDialog.Builder builder;
    LayoutInflater inflater;
    View dialogView;
    AlertDialog dialog;

    public DialogNotes(Activity activity) {
        this.activity = activity;
        init();
    }

    public void init() {
        builder = new AlertDialog.Builder(activity);
        dialog = builder.create();
        inflater = activity.getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_notes, null);
        dialog.setView(dialogView);
    }

    public void show(String currentNotes, DialogNotesListener listener) {
        EditText notesTxt = dialogView.findViewById(R.id.notesTxt);
        notesTxt.setText(currentNotes);

        dialogView.findViewById(R.id.saveBtn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.save(notesTxt.getText().toString());
                        dialog.dismiss();
                    }
                });
        dialogView.findViewById(R.id.cancelBtn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

        dialog.setCancelable(false);
        dialog.show();
    }
}
