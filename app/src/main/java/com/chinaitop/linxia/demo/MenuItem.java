package com.chinaitop.linxia.demo;

/**
 * Created by yaoju on 2017/12/25.
 */

public class MenuItem {
    public String title;
    public int drawableRes;
    public Class clazz;
    public MenuItem(String title, int drawableRes,Class clazz) {
        this.title = title;
        this.drawableRes = drawableRes;
        this.clazz=clazz;
    }
}
