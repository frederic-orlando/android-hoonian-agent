package com.example.hoonianAgent.view.adapter.recycler.itemDecoration;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemDecorationVertical extends RecyclerView.ItemDecoration {
    private int padding;
    private int paddingHorizontal;

    public ItemDecorationVertical(Activity context, int paddingDimen) {
        this.padding = (int) context.getResources().getDimension(paddingDimen);
    }
    public ItemDecorationVertical(Activity context, int paddingDimen, int paddingHDimen) {
        this.padding = (int) context.getResources().getDimension(paddingDimen);
        this.paddingHorizontal = (int) context.getResources().getDimension(paddingHDimen);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = padding;
        }

        outRect.bottom = padding;
        if (paddingHorizontal != 0) {
            outRect.left = paddingHorizontal;
            outRect.right = paddingHorizontal;
        }
    }
}
