package com.example.an.myapplication;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 15900 on 2018/4/16.
 */

public class myview extends View {

    public static final float RADIUS = 70f;// 圆的半径 = 70
    private point currentPoint;// 当前点坐标
    private Paint mPaint;// 绘图画笔


    // 构造方法(初始化画笔)
    public myview(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 初始化画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        // 如果当前点坐标为空(即第一次)
        if (currentPoint == null) {
            currentPoint = new point(RADIUS, RADIUS);
            // 创建一个点对象(坐标是(70,70))

            // 在该点画一个圆:圆心 = (70,70),半径 = 70
            float x = currentPoint.getX();
            float y = currentPoint.getY();
            canvas.drawCircle(x, y, RADIUS, mPaint);

            point startPoint = new point(RADIUS, RADIUS);// 初始点为圆心(70,70)
            point endPoint = new point(700, 1000);// 结束点为(700,1000)

            // 步骤2:创建动画对象 & 设置初始值 和 结束值
            ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);

            anim.setDuration(5000);
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {

                    currentPoint = (point) animation.getAnimatedValue();
                    invalidate();
                }
            });

            anim.start();
            // 启动动画


        } else {
            float x = currentPoint.getX();
            float y = currentPoint.getY();
            canvas.drawCircle(x, y, RADIUS, mPaint);
        }
    }

}
