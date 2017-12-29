package com.chinaitop.linxia.demo.activity.JianGuan.LiangQing;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yaoju on 2017/11/1.
 */

public class AirBean implements Serializable {

    /**
     * pageNum : 1
     * pageSize : 1
     * size : 1
     * startRow : 1
     * endRow : 1
     * total : 1
     * pages : 1
     * list : [{"id":4,"taskCode":"TF-TASK_20171101085539","houseId":2,"houseType":63,"houseSize":12,"goodsKinds":"稻谷","goodsNum":100,"keeperName":"23r23","bearingUnit":"23r2","depositoryUnit":"XXXXX直属库","aerationTarget":101,"ladeLineHeight":13,"aerationMachineCode":"23r","aerationType":null,"blowernetSumResistance":2323,"airflowDirection":"23","sumAirVolume":2423,"unitAerationSum":2324,"aerationPower":2323,"aerationPlaceMode":"22424","aerationSize":232,"airPathRatio":232,"orificeCoefficient":242,"startAerationTime":1509494400000,"stopAerationTime":232,"endAerationTime":1509494400000,"sumAerationTime":2323,"aeratingMaxAirTemperature":23,"aeratingMinAirTemperature":23,"aeratingAvgAirTemperature":23,"aeratingMaxAirHumidity":23,"aeratingMinAirHumidity":23,"aeratingAvgAirHumidity":23,"aerFrontMaxFoodstuffTem":23,"aerFrontMinFoodstuffTem":23,"aerFrontAvgFoodstuffTem":23,"tfqTemMaxTd":23,"aerAfterMaxFoodstuffTem":23,"aerAfterMinFoodstuffTem":24,"aerAfterAvgFoodstuffTem":23,"tfhTemMaxTd":23,"tfqFoodAndWaterMaxVal":23,"tfqFoodAndWaterMinVal":424,"tfqFoodAndWaterVagVal":232,"tfqWaterMaxTd":23,"tfhFoodAndWaterMaxVal":232,"tfhFoodAndWaterMinVal":23,"tfhFoodAndWaterAvgVal":32,"tfhWaterMaxTd":22,"sumConsume":23,"unitConsume":24,"remark":"24234","taskStatus":null,"operator":"2323","personLiable":"2324","orgId":null,"depotName":null,"inputDate":null}]
     * prePage : 0
     * nextPage : 0
     * isFirstPage : true
     * isLastPage : true
     * hasPreviousPage : false
     * hasNextPage : false
     * navigatePages : 8
     * navigatepageNums : [1]
     * navigateFirstPage : 1
     * navigateLastPage : 1
     * firstPage : 1
     * lastPage : 1
     */

    private String pageNum;
    private String pageSize;
    private String size;
    private String startRow;
    private String endRow;
    private String total;
    private String pages;
    private String prePage;
    private String nextPage;
    private boolean isFirstPage;
    private boolean isLastPage;
    private boolean hasPreviousPage;
    private boolean hasNextPage;
    private String navigatePages;
    private String navigateFirstPage;
    private String navigateLastPage;
    private String firstPage;
    private String lastPage;
    private List<ListBean> list;
    private List<String> navigatepageNums;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements Serializable {
        /**
         * id : 4
         * taskCode : TF-TASK_20171101085539
         * houseId : 2
         * houseType : 63
         * houseSize : 12.0
         * goodsKinds : 稻谷
         * goodsNum : 100.0
         * keeperName : 23r23
         * bearingUnit : 23r2
         * depositoryUnit : XXXXX直属库
         * aerationTarget : 101
         * ladeLineHeight : 13.0
         * aerationMachineCode : 23r
         * aerationType : null
         * blowernetSumResistance : 2323.0
         * airflowDirection : 23
         * sumAirVolume : 2423.0
         * unitAerationSum : 2324.0
         * aerationPower : 2323.0
         * aerationPlaceMode : 22424
         * aerationSize : 232.0
         * airPathRatio : 232.0
         * orificeCoefficient : 242.0
         * startAerationTime : 1509494400000
         * stopAerationTime : 232.0
         * endAerationTime : 1509494400000
         * sumAerationTime : 2323.0
         * aeratingMaxAirTemperature : 23.0
         * aeratingMinAirTemperature : 23.0
         * aeratingAvgAirTemperature : 23.0
         * aeratingMaxAirHumidity : 23.0
         * aeratingMinAirHumidity : 23.0
         * aeratingAvgAirHumidity : 23.0
         * aerFrontMaxFoodstuffTem : 23.0
         * aerFrontMinFoodstuffTem : 23.0
         * aerFrontAvgFoodstuffTem : 23.0
         * tfqTemMaxTd : 23.0
         * aerAfterMaxFoodstuffTem : 23.0
         * aerAfterMinFoodstuffTem : 24.0
         * aerAfterAvgFoodstuffTem : 23.0
         * tfhTemMaxTd : 23.0
         * tfqFoodAndWaterMaxVal : 23.0
         * tfqFoodAndWaterMinVal : 424.0
         * tfqFoodAndWaterVagVal : 232.0
         * tfqWaterMaxTd : 23.0
         * tfhFoodAndWaterMaxVal : 232.0
         * tfhFoodAndWaterMinVal : 23.0
         * tfhFoodAndWaterAvgVal : 32.0
         * tfhWaterMaxTd : 22.0
         * sumConsume : 23.0
         * unitConsume : 24.0
         * remark : 24234
         * taskStatus : null
         * operator : 2323
         * personLiable : 2324
         * orgId : null
         * depotName : null
         * inputDate : null
         */

        private String id;
        private String taskCode;
        private String houseId;
        private String houseType;
        private String houseSize;
        private String goodsKinds;
        private String goodsNum;
        private String keeperName;
        private String bearingUnit;
        private String depositoryUnit;
        private String aerationTarget;
        private String ladeLineHeight;
        private String aerationMachineCode;
        private String aerationType;
        private String blowernetSumResistance;
        private String airflowDirection;
        private String sumAirVolume;
        private String unitAerationSum;
        private String aerationPower;
        private String aerationPlaceMode;
        private String aerationSize;
        private String airPathRatio;
        private String orificeCoefficient;
        private String startAerationTime;
        private String stopAerationTime;
        private String endAerationTime;
        private String sumAerationTime;
        private String aeratingMaxAirTemperature;
        private String aeratingMinAirTemperature;
        private String aeratingAvgAirTemperature;
        private String aeratingMaxAirHumidity;
        private String aeratingMinAirHumidity;
        private String aeratingAvgAirHumidity;
        private String aerFrontMaxFoodstuffTem;
        private String aerFrontMinFoodstuffTem;
        private String aerFrontAvgFoodstuffTem;
        private String tfqTemMaxTd;
        private String aerAfterMaxFoodstuffTem;
        private String aerAfterMinFoodstuffTem;
        private String aerAfterAvgFoodstuffTem;
        private String tfhTemMaxTd;
        private String tfqFoodAndWaterMaxVal;
        private String tfqFoodAndWaterMinVal;
        private String tfqFoodAndWaterVagVal;
        private String tfqWaterMaxTd;
        private String tfhFoodAndWaterMaxVal;
        private String tfhFoodAndWaterMinVal;
        private String tfhFoodAndWaterAvgVal;
        private String tfhWaterMaxTd;
        private String sumConsume;
        private String unitConsume;
        private String remark;
        private String taskStatus;
        private String operator;
        private String personLiable;
        private String orgId;
        private String depotName;
        private String inputDate;

        public String getHouseId() {
            return houseId;
        }

        public void setHouseId(String houseId) {
            this.houseId = houseId;
        }

        public String getGoodsKinds() {
            return goodsKinds;
        }

        public String getAerationTarget() {
            return aerationTarget;
        }

        public void setAerationTarget(String aerationTarget) {
            this.aerationTarget = aerationTarget;
        }

        public String getStartAerationTime() {
            return startAerationTime;
        }

        public void setStartAerationTime(String startAerationTime) {
            this.startAerationTime = startAerationTime;
        }

        public String getEndAerationTime() {
            return endAerationTime;
        }

        public void setEndAerationTime(String endAerationTime) {
            this.endAerationTime = endAerationTime;
        }

        public String getAerFrontAvgFoodstuffTem() {
            return aerFrontAvgFoodstuffTem;
        }

        public String getAerAfterAvgFoodstuffTem() {
            return aerAfterAvgFoodstuffTem;
        }

        public String getTfqFoodAndWaterVagVal() {
            return tfqFoodAndWaterVagVal;
        }

        public String getTfhFoodAndWaterAvgVal() {
            return tfhFoodAndWaterAvgVal;
        }

        public String getSumConsume() {
            return sumConsume;
        }

        public String getPersonLiable() {
            return personLiable;
        }

        public String getDepotName() {
            return depotName;
        }

        public void setDepotName(String depotName) {
            this.depotName = depotName;
        }

    }
}
