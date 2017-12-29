package com.chinaitop.linxia.demo.activity.AnQuan.LuJing;

import com.chinaitop.linxia.demo.BaseModel;

/**
 * Created by yaoju on 2017/12/29.
 */

public class LujingList extends BaseModel{
    public String id;
    public int erweimaRes;
    public String xingzhi;
    public String pinzhong;
    public String dengji;

    public LujingList(String id, int erweimaRes, String xingzhi, String pinzhong, String dengji) {
        this.id = id;
        this.erweimaRes = erweimaRes;
        this.xingzhi = xingzhi;
        this.pinzhong = pinzhong;
        this.dengji = dengji;
    }

    public LujingList(String type) {
        this.modelType =type;
    }
}
