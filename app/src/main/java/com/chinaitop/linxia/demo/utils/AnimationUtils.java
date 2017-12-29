package com.chinaitop.linxia.demo.utils;

import android.content.Context;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

/**
 * Created by mq on 2017/10/24 0024.
 */

public class AnimationUtils {

    //动画持续时间
    public final static int ANIMATION_IN_TIME=250;
    public final static int ANIMATION_OUT_TIME=250;

    public static Animation createInAnimation(Context context, int fromYDelta){
        AnimationSet set=new AnimationSet(context,null);
        set.setFillAfter(true);

        TranslateAnimation animation=new TranslateAnimation(0,0,fromYDelta,0);
        animation.setDuration(ANIMATION_IN_TIME);
        set.addAnimation(animation);

        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
        alphaAnimation.setDuration(ANIMATION_IN_TIME);
        set.addAnimation(alphaAnimation);


        return set;
    }

    public static Animation createOutAnimation(Context context,int toYDelta){
        AnimationSet set=new AnimationSet(context,null);
        set.setFillAfter(true);

        TranslateAnimation animation=new TranslateAnimation(0,0,0,toYDelta);
        animation.setDuration(ANIMATION_OUT_TIME);
        set.addAnimation(animation);

        AlphaAnimation alphaAnimation=new AlphaAnimation(1,0);
        alphaAnimation.setDuration(ANIMATION_OUT_TIME);
        set.addAnimation(alphaAnimation);


        return set;
    }
}
