package com.example.hoonianAgent.model.custom;

import android.content.Context;
import android.util.AttributeSet;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.hoonianAgent.model.content.customShape.CustomCanvasView;

public class FloorPlanConstraint extends ConstraintLayout {
    CustomCanvasView customCanvasView;

    public FloorPlanConstraint(Context context) {
        super(context);
    }

    public FloorPlanConstraint(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FloorPlanConstraint(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setCustomCanvasView(CustomCanvasView customCanvasView) {
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        customCanvasView.measure(width, height);
        addView(customCanvasView);
    }
}
