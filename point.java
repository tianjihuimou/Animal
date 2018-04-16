package com.example.an.myapplication;

/**
 * Created by 15900 on 2018/4/16.
 */

public class point {


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    private float x;
    private float y;
    public point(float x,float y){
        this.x =x;
        this.y =y;
    }



    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


}
