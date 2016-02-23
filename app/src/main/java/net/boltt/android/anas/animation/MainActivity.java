package net.boltt.android.anas.animation;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivityAnas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View animationView = findViewById(R.id.animation_view);
        final RotateAnimation rotateAnimation = new RotateAnimation(0, 63,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 1);
        rotateAnimation.setDuration(1000);

        final TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, -900);
        translateAnimation.setDuration(1000);

        final ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 2.0f, 1.0f, 1.9f);
        scaleAnimation.setDuration(1000);


        final TranslateAnimation translateAnimation2 = new TranslateAnimation(0, -430, 0, -350);
        translateAnimation2.setDuration(1000);
        translateAnimation2.setStartOffset(1000);

        final RotateAnimation rotateAnimation2 = new RotateAnimation(0, 10,
                Animation.RELATIVE_TO_SELF, 1,
                Animation.RELATIVE_TO_SELF, 1);
        rotateAnimation2.setDuration(1000);
        rotateAnimation2.setStartOffset(2000);


        final AnimationSet set = new AnimationSet(true);
        set.addAnimation(rotateAnimation);
        set.addAnimation(translateAnimation);
        set.addAnimation(scaleAnimation);

        set.addAnimation(translateAnimation2);
//        set.addAnimation(rotateAnimation2);
        set.setFillAfter(true);

        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d(TAG, "PivotX: " + animationView.getPivotX());
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationView.startAnimation(set);
            }
        });
//        rotateAnimation.setFillAfter(true);

    }
}
