package com.chinaitop.linxia.demo.activity;

import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.AppStore.AppInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoju on 2017/12/26.
 */

public class Apps {
    public static AppInfo[] twoLeft = new AppInfo[]{
//            new AppInfo(R.mipmap.adobe, "移动监管APP", 2.28, 19, AppInfo.DOWNLOAD),
//            new AppInfo(R.mipmap.word, "档案管理APP", 2.28, 54, AppInfo.YI_DOWNLOAD),
//            new AppInfo(R.mipmap.excel, "移动办公APP", 1.93, 21, AppInfo.UPDATE),

            new AppInfo(R.mipmap.main1, "应急预案移动应用", 1.00, 21, AppInfo.YI_DOWNLOAD),
            new AppInfo(R.mipmap.main2, "协同办公移动应用", 3.01, 123, AppInfo.DOWNLOAD),
            new AppInfo(R.mipmap.main3, "库级监管移动应用", 1.02, 23, AppInfo.UPDATE),
            new AppInfo(R.mipmap.main4, "价格报送移动应用", 2.51, 88, AppInfo.YI_DOWNLOAD),
            new AppInfo(R.mipmap.main5, "综合分析移动应用", 2.10, 12, AppInfo.YI_DOWNLOAD),
            new AppInfo(R.mipmap.main6, "质量安全移动应用", 3.00, 25, AppInfo.DOWNLOAD),
            new AppInfo(R.mipmap.main7, "移动执法移动应用", 1.1, 121, AppInfo.UPDATE),

    };

    public static AppInfo[] one = new AppInfo[]{
            new AppInfo(R.mipmap.main1, "应急预案移动应用", 1.00, 21, AppInfo.OPEN),
            new AppInfo(R.mipmap.main2, "协同办公移动应用", 3.01, 123, AppInfo.OPEN),
            new AppInfo(R.mipmap.main3, "库级监管移动应用", 1.02, 23, AppInfo.OPEN),
            new AppInfo(R.mipmap.main4, "价格报送移动应用", 2.51, 88, AppInfo.OPEN),
            new AppInfo(R.mipmap.main5, "综合分析移动应用", 2.10, 12, AppInfo.OPEN),
            new AppInfo(R.mipmap.main6, "质量安全移动应用", 3.00, 25, AppInfo.OPEN),
            new AppInfo(R.mipmap.main7, "移动执法移动应用", 1.1, 121, AppInfo.OPEN),

    };

    public static AppInfo[] threeLeft=new AppInfo[]{
            new AppInfo(R.mipmap.adobe,"SSO客户端流程图",2.28,"2016-09-27 15:33",AppInfo.YI_DOWNLOAD),
            new AppInfo(R.mipmap.word,"安卓M指纹登录用...",2.28,"2016-07-30 11:07",AppInfo.OPEN),
            new AppInfo(R.mipmap.folder,"iOS 设计规范",1.93,"2016-08-02 15:09",AppInfo.YI_DOWNLOAD),
            new AppInfo(R.mipmap.ppt,"EMM下载压缩包",1.22,"2016-07-29 15:26",AppInfo.DOWNLOAD),
            new AppInfo(R.mipmap.excel,"中科电人员数据",3.07,"2016-07-30 11:07",AppInfo.OPEN),
            new AppInfo(R.mipmap.picture,"团体合照",2.05,"2016-07-29 19:26",AppInfo.YI_DOWNLOAD),
    };

    public static AppInfo[] threeRight=new AppInfo[]{
            new AppInfo(R.mipmap.adobe,"SSO客户端流程图",2.28,"2016-09-27 15:33",AppInfo.YI_DOWNLOAD),
            new AppInfo(R.mipmap.folder,"iOS 设计规范",1.93,"2016-08-02 15:09",AppInfo.YI_DOWNLOAD),
            new AppInfo(R.mipmap.picture,"团体合照",2.05,"2016-07-29 19:26",AppInfo.YI_DOWNLOAD),
    };
}
