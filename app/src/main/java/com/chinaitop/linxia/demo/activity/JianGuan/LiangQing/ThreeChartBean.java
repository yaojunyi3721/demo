package com.chinaitop.linxia.demo.activity.JianGuan.LiangQing;

/**
 * Created by mq on 2017/10/30 0030.
 * 三温图实体类
 */

public class ThreeChartBean {

    private int index;

    private float value;

    public ThreeChartBean(int index, float value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
