package com.example.an.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 15900 on 2018/4/16.
 */

public class MyView2 extends View {
    // 设置需要用到的变量
    public static final float RADIUS = 100f;// 圆的半径 = 100
    private Paint mPaint;// 绘图画笔

    private String color;
    // 设置背景颜色属性

    // 设置背景颜色的get() & set()方法
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        mPaint.setColor(Color.parseColor(color));
        // 将画笔的颜色设置成方法参数传入的颜色
        invalidate();
    }


    // 构造方法(初始化画笔)
    public MyView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(500, 500, RADIUS, mPaint);
    }
}

