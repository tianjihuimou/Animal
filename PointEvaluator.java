package com.example.an.myapplication;


import android.animation.TypeEvaluator;

/**
 * Created by 15900 on 2018/4/16.
 */

public class PointEvaluator implements TypeEvaluator {

    @Override
    public Object evaluate(float v, Object o, Object t1) {
        point startPoint = (point) o;
        point endPoint = (point) t1;

        // 根据fraction来计算当前动画的x和y的值
        float x = startPoint.getX() + v * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + v * (endPoint.getY() - startPoint.getY());

        // 将计算后的坐标封装到一个新的Point对象中并返回
        point point = new point(x, y);
        return point;
    }
}
