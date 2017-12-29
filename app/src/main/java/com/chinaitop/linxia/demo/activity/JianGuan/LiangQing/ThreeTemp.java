package com.chinaitop.linxia.demo.activity.JianGuan.LiangQing;

/**
 * Created by yaoju on 2017/10/29.
 */

public class ThreeTemp {

    /**
     * days : 2017-10-16
     * lswd : 23.0
     * cnwd : 22.6
     * cwwd : 22.9
     */

    private String days;
    /**
     * 粮食温度
     */
    private Float lswd;
    /**
     * 仓内温度
     */
    private Float cnwd;
    /**
     * 仓外温度
     */
    private Float cwwd;

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Float getLswd() {
        return lswd;
    }

    public void setLswd(Float lswd) {
        this.lswd = lswd;
    }

    public Float getCnwd() {
        return cnwd;
    }

    public void setCnwd(Float cnwd) {
        this.cnwd = cnwd;
    }

    public Float getCwwd() {
        return cwwd;
    }

    public void setCwwd(Float cwwd) {
        this.cwwd = cwwd;
    }
}
