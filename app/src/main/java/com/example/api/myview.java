package com.example.api;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class myview extends View {
    public myview(Context context) {
        super(context);
    }

    public myview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public myview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void onDraw(Canvas c) {
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setStrokeWidth(2);
        c.drawLine(100,100,200,200,p);
    }
}