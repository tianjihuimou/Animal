package com.example.an.myapplication;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {
    private Button mybutton;
    private MyView2 myView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        mybutton = (Button) findViewById (R.id.button);
        mybutton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                animatorset();
            }
        });
        myView2 = (MyView2) findViewById(R.id.myview2);
        ObjectAnimator anim = ObjectAnimator.ofObject(myView2, "color", new ColorEvaluator(), "#0000FF", "#FF0000");
        anim.setDuration(8000);
        anim.start();
    }
    private void newPP(){
        mybutton.animate().alpha(0f).x(500).y(500);
    }
    private void animatorset(){
        float curTranslationX = mybutton.getTranslationX();
        ObjectAnimator translation = ObjectAnimator.ofFloat(mybutton, "translationX", curTranslationX, 300,curTranslationX);
        //translation.setDuration (3000);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(mybutton, "rotation", 0f, 360f,0f);
        //rotate.setDuration (3000);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(mybutton, "alpha", 1f, 0f, 1f);



        AnimatorSet animSet = new AnimatorSet();


        animSet.play(translation).with(rotate).with(alpha);
        animSet.setDuration(6000);

        animSet.start();
        animSet.addListener (new AnimatorListenerAdapter () {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd (animation);
                Log.e("-----------","------------");
            }
        });
    }

    private void ainm(){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(mybutton.getLayoutParams().width, 500);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener () {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {

                int currentValue = (Integer) animator.getAnimatedValue();
                System.out.println(currentValue);
                mybutton.getLayoutParams().width = currentValue;
                mybutton.requestLayout();

            }
        });
        valueAnimator.start();

    }
    private void alpha(){
        //常规-->全透明--->常规。
        ObjectAnimator animator = ObjectAnimator.ofFloat(mybutton, "alpha", 1f, 0f, 1f);
        animator.setDuration(5000);
        animator.start();
    }
    private void rotation(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(mybutton, "rotation", 0f,360f);
        animator.setDuration(5000);
        animator.setRepeatCount (-1);
        animator.setRepeatMode (ValueAnimator.RESTART);
        animator.start();
    }
    private void translationX(){

        float curTranslationX = mybutton.getTranslationX();
        // 获得当前按钮的位置
        ObjectAnimator animator = ObjectAnimator.ofFloat(mybutton, "translationX", curTranslationX, 300,curTranslationX);

        animator.setDuration(5000);
        animator.start();

    }
    private void scaleX(){
        //明白了这些参数的意义。
        ObjectAnimator animator = ObjectAnimator.ofFloat(mybutton, "scaleX", 1f, 3f, 2f);
        animator.setDuration(5000);
        animator.start();
    }
}
