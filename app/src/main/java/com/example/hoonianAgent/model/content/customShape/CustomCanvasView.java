package com.example.hoonianAgent.model.content.customShape;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.hoonianAgent.model.content.property.Unit;

import java.util.ArrayList;

public class CustomCanvasView extends View {
    private ArrayList<Unit> units = new ArrayList<>();

    public CustomCanvasView(Context context) {
        super(context);
    }

    public CustomCanvasView(Context context, Unit unit) {
        super(context);
        this.units.add(unit);
    }

    public CustomCanvasView(Context context, ArrayList<Unit> units) {
        super(context);
        this.units = units;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float scale = 0.5f;

        int px = getMeasuredWidth() / 2;
        int py = getMeasuredHeight() / 2;

        //canvas.scale(scale, scale, px, py);

        for (Unit unit : units) {
            String colorCode;
            if (unit.getStatus() == null) {
                colorCode = unit.getColorCode();
            }
            else {
                colorCode = unit.getStatus().getColor();
            }

            drawPoly(canvas,
                    Color.parseColor(colorCode),
                    unit.getCoordinate());
        }
    }

    private void drawPoly(Canvas canvas, int color, ArrayList<Point> points) {
        float alphaModifier = 0.7f;
        // line at minimum...
        if (points.size() < 2) {
            return;
        }

        // paint
        Paint polyPaint = new Paint();
        polyPaint.setColor(color);
        polyPaint.setStyle(Paint.Style.FILL);
        polyPaint.setAlpha((int)(alphaModifier * 255));

        // path
        Path polyPath = new Path();
        polyPath.moveTo(points.get(0).x, points.get(0).y);
        int i, len;
        len = points.size();
        for (i = 0; i < len; i++) {
            polyPath.lineTo(points.get(i).x, points.get(i).y);
        }
        polyPath.lineTo(points.get(0).x, points.get(0).y);

        // draw
        canvas.drawPath(polyPath, polyPaint);
    }
}
