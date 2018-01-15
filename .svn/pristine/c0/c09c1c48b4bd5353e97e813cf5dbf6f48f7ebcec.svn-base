package com.chinaitop.linxia.demo.activity.AnQuan.LuJing;

import com.chinaitop.linxia.demo.BaseModel;

/**
 * Created by yaoju on 2017/12/29.
 */

public class LujingItem extends BaseModel {
    public static final String TYPE_RUKU = "入库";
    public static final String TYPE_CHUKU = "出库";
    public String parentId;
    public String type;
    public String pinzhong;
    public String dengji;
    public String zhiliang;
    public String canghao;
    public String huoweihao;
    public String liangshixingzhi;//出库是客户名称
    public String chandi;//出库是流向地点
    public String date;//入库时间 出库时间

    public LujingItem(String type) {
        this.type = type;
        this.modelType = BaseModel.TYPE_TITLE;
    }

    public LujingItem(String parentId, String type, String pinzhong, String dengji, String zhiliang, String canghao, String huoweihao, String liangshixingzhi, String chandi, String date) {
        this.parentId = parentId;
        this.type = type;
        this.pinzhong = pinzhong;
        this.dengji = dengji;
        this.zhiliang = zhiliang;
        this.canghao = canghao;
        this.huoweihao = huoweihao;
        this.liangshixingzhi = liangshixingzhi;
        this.chandi = chandi;
        this.date = date;
    }
}
