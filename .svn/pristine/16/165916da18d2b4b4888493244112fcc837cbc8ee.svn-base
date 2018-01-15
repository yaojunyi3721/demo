package com.chinaitop.linxia.demo.utils;

/**
 * Created by mq on 2017/10/26 0026.
 */

public class UrlPath {

    //    http://192.168.0.199:8080/userInfo/login?username=123456&password=1
    private static String IPPort;//ip和端口号

    //登录
    private static final String LOGIN = "/ggs/temperature.do";

    //仓房列表
    private static final String HOUSE = "/Storehouse/getList";

    //仓房维修记录
    private static final String HOUSE_REPAIR = "/houseRepair/getList";

    //计划 审批通过列表
    private static final String PLAN = "/depot/business/plan/getAuditPassList";

    //计划 详情
    private static final String PLAN_DETAIL = "/depot/business/plan/edit";

    //合同 审批通过列表
    private static final String CONTRACT = "/depot/business/contract/getAuditPassList";

    //合同 详情
    private static final String CONTRACT_DETAIL = "/depot/business/contract/edit";

    //出入库通知单 审批通过列表
    private static final String OUT_PUT_NOTICE = "/depot/business/deliveryStorageNotice/getAuditPassList/";

    //出入库通知单 详情
    private static final String OUT_PUT_NOTICE_DETAIL = "/depot/business/deliveryStorageNotice/edit";
    //出入库记录 详情
    private static final String CRK_DETAIL = "/crkRecord/detail";
    //人员 列表
    private static final String PERSON = "/Keeper/getList";

    //人员 详情
    private static final String PERSON_DETAIL = "/Keeper/findBasicKeeper";

    //枚举数据
    private static final String ENUM_ALL = "/Enum/findEnumObj";

    //获取枚举列表
    private static final String ENUM_LIST = "/Enum/getList";

    //质量检查列表
    private static final String QUALITY = "/qualitycheck/getList";

    //获取粮食专卡列表
    private static final String FOODINFO = "/foodbasicinfo/getFoodbasicInfoByHouseId";

    //熏蒸列表
    private static final String FUMIGATION = "/depot/storage/fumigation";

    //熏蒸 详情
    private static final String FUMIGATION_DETAIL = "/depot/storage/fumigation";

    //通风列表
    private static final String AIR = "/AerationSummary/getList";

    //获取登录人信息
    private static final String LOGIN_INFO = "/userInfo/getLoginInfo";

    //检验信息
    private static final String FOOD_CHECK = "/foodbasicinfocheck/getList";

    //货位变更记录
    private static final String FOOD_LOCATION = "/foodbasicinfolocation/getList";

    //货位信息
    private static final String WARE_HOUSE = "/Warehouse/getWarehouse";

    //单位信息
    private static final String ORG_INFO = "/orgInfo/edit";

    //计划进度
    private static final String PLAN_PROGRESS = "/depot/business/plan/getScheduleList";

    //通知单进度
    private static final String NOTICE_PROGRESS = "/depot/business/deliveryStorageNotice/getScheduleList";

    /**
     * 待办事项
     */
    private static final String WAIT_DEAL = "/depot/business/select/getList";

    private static final String MOVE_IN = "/crkRecord/list";

    /**
     * 获取ip和端口号
     *
     * @return
     */
    public static String getIPPort() {
        String host = SPUtils.get(SPConstant.HOST);
        String port = SPUtils.get(SPConstant.PORT);
        IPPort = host + ":" + port;
        if (StringUtils.isEmpty(host) || StringUtils.isEmpty(port)) {
            IPPort = "";
            return IPPort;
        } else {
            return "http://" + IPPort;
        }

    }

    /**
     * 登录地址
     *
     * @return
     */
    public static String getLOGIN() {
        return getIPPort() + LOGIN;
    }

    /**
     * 仓房列表
     *
     * @return
     */
    public static String getHouse() {
        return getIPPort() + HOUSE;
    }

    /**
     * 仓房维修记录
     *
     * @return
     */
    public static String getHouseRepair() {
        return getIPPort() + HOUSE_REPAIR;
    }

    /**
     * 计划列表
     *
     * @return
     */
    public static String getPlanList() {
        return getIPPort() + PLAN;
    }

    /**
     * 计划详情
     *
     * @return
     */
    public static String getPlanDetail() {
        return getIPPort() + PLAN_DETAIL;
    }

    /**
     * 合同列表
     *
     * @return
     */
    public static String getContract() {
        return getIPPort() + CONTRACT;
    }

    /**
     * 合同详情
     *
     * @return
     */
    public static String getContractDetail() {
        return getIPPort() + CONTRACT_DETAIL;
    }

    /**
     * 出入库通知单列表
     *
     * @return
     */
    public static String getOutPutNotice() {
        return getIPPort() + OUT_PUT_NOTICE;
    }

    /**
     * 出入库通知单详情
     *
     * @return
     */
    public static String getOutPutNoticeDetail() {
        return getIPPort() + OUT_PUT_NOTICE_DETAIL;
    }

    /**
     * 出入库记录详情
     *
     * @return
     */
    public static String getCRKDetail() {
        return getIPPort() + CRK_DETAIL;
    }

    /**
     * 三温图
     *
     * @return
     */
    public static String getThreeTemp() {
        return getIPPort() + "/grainCondition/getThreeConditionForPad";
    }

    /**
     * 人员
     *
     * @return
     */
    public static String getPerson() {
        return getIPPort() + PERSON;
    }

    /**
     * 人员 详情
     *
     * @return
     */
    public static String getPersonDetail() {
        return getIPPort() + PERSON_DETAIL;
    }

    /**
     * 枚举 全部
     *
     * @return
     */
    public static String getEnumAll() {
        return getIPPort() + ENUM_ALL;
    }

    /**
     * 质量检查列表
     *
     * @return
     */
    public static String getQuality() {
        return getIPPort() + QUALITY;
    }

    /**
     * 粮食专卡列表
     *
     * @return
     */
    public static String getFoodInfo() {
        return getIPPort() + FOODINFO;
    }

    /**
     * 熏蒸列表
     *
     * @return
     */
    public static String getFumigation() {
        return getIPPort() + FUMIGATION;
    }

    /**
     * 熏蒸详情
     *
     * @return
     */
    public static String getFumigationDetail() {
        return getIPPort() + FUMIGATION_DETAIL;
    }

    /**
     * 通风列表
     *
     * @return
     */
    public static String getAir() {
        return getIPPort() + AIR;
    }

    /**
     * 获取登录人信息
     *
     * @return
     */
    public static String getLoginInfo() {
        return getIPPort() + LOGIN_INFO;
    }

    /**
     * 检验信息
     *
     * @return
     */
    public static String getFoodCheck() {
        return getIPPort() + FOOD_CHECK;
    }

    /**
     * 货位变更记录
     *
     * @return
     */
    public static String getFoodLocation() {
        return getIPPort() + FOOD_LOCATION;
    }

    /**
     * 获取枚举列表
     *
     * @return
     */
    public static String getEnumList() {
        return getIPPort() + ENUM_LIST;
    }

    /**
     * 获取货位列表
     *
     * @return
     */
    public static String getWareHouse() {
        return getIPPort() + WARE_HOUSE;
    }

    /**
     * 获取单位信息
     *
     * @return
     */
    public static String getOrgInfo() {
        return getIPPort() + ORG_INFO;
    }

    /**
     * 获取计划进度百分比
     *
     * @return
     */
    public static String getPlanProgress() {
        return getIPPort() + PLAN_PROGRESS;
    }

    /**
     * 获取通知单进度百分比
     *
     * @return
     */
    public static String getNoticeProgress() {
        return getIPPort() + NOTICE_PROGRESS;
    }

    /**
     * 获取待办事项
     *
     * @return
     */
    public static String getWaitDeal() {
        return getIPPort() + WAIT_DEAL;
    }

    /**
     * 入库记录
     *
     * @return
     */
    public static String getMoveIn() {
        return getIPPort() + MOVE_IN;
    }
}
