package com.example.hoonianAgent.view.adapter.recycler.itemDecoration;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemDecorationGrid extends RecyclerView.ItemDecoration {
    private int column;
    private int padding;

    public ItemDecorationGrid(Activity context, int paddingDimen, int column) {
        this.padding = (int) context.getResources().getDimension(paddingDimen)/2;
        this.column = column;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view) + 1;

        if (position % column == 1) {
            outRect.right = padding;
        }
        else if (position % column != 0) {
            outRect.left = padding;
            outRect.right = padding;
        }
        else {
            outRect.left = padding;
        }
    }
}
