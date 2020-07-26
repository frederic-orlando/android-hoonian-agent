package com.example.hoonianAgent.view.adapter.recycler.itemDecoration;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemDecorationHorizontal extends RecyclerView.ItemDecoration {
    private int padding;
    private int space;

    public ItemDecorationHorizontal(Activity context, int paddingDimen, int spaceDimen) {
        this.padding = (int) context.getResources().getDimension(paddingDimen);
        this.space = (int) context.getResources().getDimension(spaceDimen);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.left = padding;
        }

        if (parent.getChildAdapterPosition(view) == state.getItemCount() - 1) {
            outRect.right = padding;
        }
        else {
            outRect.right = space;
        }
    }
}
