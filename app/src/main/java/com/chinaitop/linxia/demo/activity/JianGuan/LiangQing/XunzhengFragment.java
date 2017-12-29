package com.chinaitop.linxia.demo.activity.JianGuan.LiangQing;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.chinaitop.linxia.demo.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class XunzhengFragment extends BaseFragment {

    @BindView(R.id.listTitleLayout)
    FrameLayout listTitleLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;
    private XunzhengAdapter mAdapter;

    public XunzhengFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child_list, container, false);
        unbinder = ButterKnife.bind(this, view);

        initView();
        String data="[{\"auditState\":\"2\",\"createTime\":\"1511490670000\",\"createUnit\":\"经营一部\",\"creater\":\"测试用户\",\"createrId\":\"17\",\"drugName\":\"3033\",\"fumigateProgramNumber\":\"XZFAZY2017112410311060\",\"fumigationChargePerson\":\"lili\",\"fumigationOperator\":\"lili\",\"fumigationPeopleNumber\":\"3\",\"fumigationType\":\"5245\",\"grainCount\":\"\",\"grainImpurity\":\"\",\"grainKind\":\"3164\",\"grainWater\":\"\",\"houseCapacity\":\"1728\",\"houseHeapGrainCapacity\":\"\",\"houseHeapGrainHeight\":\"\",\"houseId\":\"3\",\"houseSpaceCapacity\":\"1728\",\"houseType\":\"2971\",\"id\":\"50\",\"isCanFumigation\":\"1\",\"isCirculation\":\"1\",\"isDistanceBigTwenty\":\"1\",\"isFirstFumigation\":\"1\",\"isHaveSecuritySituation\":\"1\",\"isHaveTaskList\":\"16\",\"isHaveTaskRecord\":\"0\",\"isInsectCage\":\"1\",\"isLeakRain\":\"0\",\"isPowerSupplyLine\":\"1\",\"isSupplementDrug\":\"1\",\"isWallGetDamp\":\"0\",\"keeper\":\"37\",\"lastTimeFumigation\":\"1511222400000\",\"processInstanceId\":\"802539\",\"protectPerson\":\"大山\",\"taskStartTime\":\"1513753323000\",\"taskState\":\"1\",\"useDrugTotalCount\":\"10\",\"useDrugType\":\"1234\"},{\"airTightness\":\"11\",\"auditState\":\"2\",\"bulkGasDate\":\"1511222400000\",\"bulkGasType\":\"1\",\"circulationTime\":\"1511222400000\",\"circulationType\":\"111\",\"concentrationCheckType\":\"\",\"createTime\":\"1511255580000\",\"createUnit\":\"经营一部\",\"creater\":\"管理员\",\"createrId\":\"1\",\"drainageSituation\":\"良好\",\"drugName\":\"3035\",\"everyDayCirculationTime\":\"2\",\"firstUseDrugCount\":\"1\",\"firstUseDrugUnit\":\"1\",\"fumigateProgramNumber\":\"XZFAZY20171121171300355\",\"fumigationChargePerson\":\"孙小鹏\",\"fumigationOperator\":\"孙小鹏\",\"fumigationPeopleNumber\":\"1\",\"fumigationType\":\"5246\",\"grainCount\":\"1000\",\"grainImpurity\":\"1\",\"grainKind\":\"3166\",\"grainOther\":\"1\",\"grainProducingArea\":\"1151\",\"grainWater\":\"3\",\"houseAroundSituation\":\"稀少\",\"houseCapacity\":\"1728\",\"houseHeapGrainCapacity\":\"3\",\"houseHeapGrainHeight\":\"4\",\"houseHeapType\":\"5412\",\"houseId\":\"3\",\"houseSpaceCapacity\":\"1728\",\"houseType\":\"2971\",\"id\":\"48\",\"insectDensity\":\"200\",\"insectProductTime\":\"1510876800000\",\"isCanFumigation\":\"1\",\"isCirculation\":\"1\",\"isDistanceBigTwenty\":\"1\",\"isFirstFumigation\":\"1\",\"isHaveSecuritySituation\":\"1\",\"isHaveTaskList\":\"14\",\"isHaveTaskRecord\":\"25\",\"isInsectCage\":\"1\",\"isLeakRain\":\"0\",\"isPowerSupplyLine\":\"0\",\"isSupplementDrug\":\"1\",\"isWallGetDamp\":\"1\",\"keeper\":\"37\",\"lastTimeFumigation\":\"1509494400000\",\"leastDistanceHouse\":\"500\",\"occurrencePlace\":\"1\",\"processInstanceId\":\"752528\",\"protectPerson\":\"孙小鹏\",\"safePerson\":\"asss\",\"sealDays\":\"1\",\"sealType\":\"1\",\"settingConcentration\":\"122\",\"storageTime\":\"1510876800000\",\"supplementCount\":\"1\",\"supplementDrugType\":\"1\",\"supplementUnit\":\"1\",\"taskEndTime\":\"1511343692000\",\"taskStartTime\":\"1511259884000\",\"taskState\":\"2\",\"useDrugPowderCount\":\"1\",\"useDrugTabletCount\":\"1\",\"useDrugTotalCount\":\"1\",\"useDrugType\":\"补药\"},{\"auditState\":\"2\",\"createTime\":\"1511173639000\",\"createUnit\":\"经营一部\",\"creater\":\"管理员\",\"createrId\":\"1\",\"drugName\":\"3032\",\"fumigateProgramNumber\":\"XZFAZY20171120182719930\",\"fumigationChargePerson\":\"王晗\",\"fumigationOperator\":\"1\",\"fumigationPeopleNumber\":\"11\",\"fumigationType\":\"5245\",\"grainCount\":\"\",\"grainImpurity\":\"\",\"grainKind\":\"3165\",\"grainWater\":\"\",\"houseCapacity\":\"1728\",\"houseHeapGrainCapacity\":\"\",\"houseHeapGrainHeight\":\"\",\"houseId\":\"17\",\"houseSpaceCapacity\":\"1728\",\"houseType\":\"2971\",\"id\":\"47\",\"isCanFumigation\":\"1\",\"isCirculation\":\"1\",\"isDistanceBigTwenty\":\"1\",\"isFirstFumigation\":\"1\",\"isHaveSecuritySituation\":\"1\",\"isHaveTaskList\":\"15\",\"isHaveTaskRecord\":\"26\",\"isInsectCage\":\"1\",\"isLeakRain\":\"0\",\"isPowerSupplyLine\":\"1\",\"isSupplementDrug\":\"1\",\"isWallGetDamp\":\"0\",\"keeper\":\"37\",\"lastTimeFumigation\":\"1511136000000\",\"processInstanceId\":\"750275\",\"protectPerson\":\"1\",\"taskStartTime\":\"1511173674000\",\"taskState\":\"1\",\"useDrugTotalCount\":\"1\",\"useDrugType\":\"111\"},{\"airTightness\":\"21\",\"auditState\":\"2\",\"bulkGasDate\":\"1511136000000\",\"bulkGasType\":\"1234\",\"circulationTime\":\"1511136000000\",\"circulationType\":\"12345\",\"concentrationCheckType\":\"123456\",\"createTime\":\"1511166586000\",\"createUnit\":\"经营一部\",\"creater\":\"管理员\",\"createrId\":\"1\",\"drainageSituation\":\"123\",\"drugName\":\"3032\",\"everyDayCirculationTime\":\"1\",\"firstUseDrugCount\":\"12\",\"firstUseDrugUnit\":\"12\",\"fumigateProgramNumber\":\"XZFAZY20171120162946359\",\"fumigationChargePerson\":\"王芳\",\"fumigationOperator\":\"王晗\",\"fumigationPeopleNumber\":\"3\",\"fumigationType\":\"5245\",\"grainCount\":\"10000\",\"grainImpurity\":\"2\",\"grainKind\":\"3164\",\"grainOther\":\"123\",\"grainProducingArea\":\"1613\",\"grainWater\":\"12\",\"houseAroundSituation\":\"123\",\"houseCapacity\":\"1728\",\"houseHeapGrainCapacity\":\"10000\",\"houseHeapGrainHeight\":\"12\",\"houseHeapType\":\"5412\",\"houseId\":\"17\",\"houseSpaceCapacity\":\"1728\",\"houseType\":\"2971\",\"id\":\"46\",\"insectDensity\":\"1\",\"insectProductTime\":\"1511136000000\",\"isCanFumigation\":\"1\",\"isCirculation\":\"1\",\"isDistanceBigTwenty\":\"1\",\"isFirstFumigation\":\"0\",\"isHaveSecuritySituation\":\"1\",\"isHaveTaskList\":\"17\",\"isHaveTaskRecord\":\"27\",\"isInsectCage\":\"1\",\"isLeakRain\":\"0\",\"isPowerSupplyLine\":\"1\",\"isSupplementDrug\":\"1\",\"isWallGetDamp\":\"0\",\"keeper\":\"37\",\"lastTimeFumigation\":\"1510531200000\",\"leastDistanceHouse\":\"10\",\"occurrencePlace\":\"粮面\",\"processInstanceId\":\"750189\",\"protectPerson\":\"王芳\",\"safePerson\":\"李涵\",\"sealDays\":\"1\",\"sealType\":\"123\",\"settingConcentration\":\"12\",\"storageTime\":\"1508112000000\",\"supplementCount\":\"1234\",\"supplementDrugType\":\"12\",\"supplementUnit\":\"123\",\"taskStartTime\":\"1511166688000\",\"taskState\":\"1\",\"useDrugPowderCount\":\"8\",\"useDrugTabletCount\":\"2\",\"useDrugTotalCount\":\"10\",\"useDrugType\":\"123\"},{\"auditState\":\"2\",\"createTime\":\"1510905932000\",\"createUnit\":\"经营一部\",\"creater\":\"管理员\",\"createrId\":\"1\",\"drugName\":\"3035\",\"fumigateProgramNumber\":\"XZFAZY20171117160532506\",\"fumigationChargePerson\":\"范雄伟\",\"fumigationOperator\":\"范雄伟\",\"fumigationPeopleNumber\":\"10\",\"fumigationType\":\"5245\",\"grainCount\":\"1015000\",\"grainImpurity\":\"1\",\"grainKind\":\"3217\",\"grainProducingArea\":\"1366\",\"grainWater\":\"13.5\",\"houseCapacity\":\"1344431\",\"houseHeapGrainCapacity\":\"144\",\"houseId\":\"25\",\"houseSpaceCapacity\":\"1344431\",\"houseType\":\"2978\",\"id\":\"45\",\"isCanFumigation\":\"1\",\"isCirculation\":\"1\",\"isDistanceBigTwenty\":\"1\",\"isFirstFumigation\":\"0\",\"isHaveSecuritySituation\":\"1\",\"isHaveTaskList\":\"12\",\"isHaveTaskRecord\":\"31\",\"isInsectCage\":\"1\",\"isLeakRain\":\"0\",\"isPowerSupplyLine\":\"1\",\"isSupplementDrug\":\"1\",\"isWallGetDamp\":\"0\",\"keeper\":\"65\",\"processInstanceId\":\"735143\",\"protectPerson\":\"范雄伟\",\"storageTime\":\"1510876800000\",\"taskEndTime\":\"1514257380000\",\"taskStartTime\":\"1510906361000\",\"taskState\":\"2\",\"useDrugTotalCount\":\"10\",\"useDrugType\":\"敌敌畏\"},{\"auditState\":\"2\",\"createTime\":\"1510380171000\",\"createUnit\":\"经营一部\",\"creater\":\"管理员\",\"createrId\":\"1\",\"drugName\":\"3032\",\"fumigateProgramNumber\":\"XZFAZY20171111140251346\",\"fumigationChargePerson\":\"王林\",\"fumigationOperator\":\"王芳\",\"fumigationPeopleNumber\":\"2\",\"fumigationType\":\"5245\",\"grainCount\":\"1000\",\"grainImpurity\":\"8\",\"grainKind\":\"2777\",\"grainWater\":\"8\",\"houseCapacity\":\"4000\",\"houseHeapGrainCapacity\":\"50\",\"houseId\":\"2\",\"houseSpaceCapacity\":\"4000\",\"houseType\":\"2976\",\"id\":\"43\",\"isCanFumigation\":\"1\",\"isCirculation\":\"1\",\"isDistanceBigTwenty\":\"1\",\"isFirstFumigation\":\"0\",\"isHaveSecuritySituation\":\"1\",\"isHaveTaskList\":\"13\",\"isHaveTaskRecord\":\"28\",\"isInsectCage\":\"1\",\"isLeakRain\":\"0\",\"isPowerSupplyLine\":\"1\",\"isSupplementDrug\":\"1\",\"isWallGetDamp\":\"0\",\"keeper\":\"1\",\"processInstanceId\":\"690073\",\"protectPerson\":\"王芳\",\"storageTime\":\"1509667200000\",\"taskEndTime\":\"1511673253000\",\"taskStartTime\":\"1510380272000\",\"taskState\":\"2\",\"useDrugTotalCount\":\"10\",\"useDrugType\":\"人工\"},{\"auditState\":\"2\",\"createTime\":\"1510280883000\",\"createUnit\":\"经营一部\",\"creater\":\"管理员\",\"createrId\":\"1\",\"drugName\":\"3033\",\"fumigateProgramNumber\":\"XZFAZY20171110102803398\",\"fumigationChargePerson\":\"李安\",\"fumigationOperator\":\"1\",\"fumigationType\":\"5245\",\"grainCount\":\"1000\",\"grainImpurity\":\"0.1\",\"grainKind\":\"3166\",\"grainOther\":\"1\",\"grainProducingArea\":\"1187\",\"grainWater\":\"12\",\"houseCapacity\":\"400\",\"houseHeapGrainCapacity\":\"\",\"houseHeapGrainHeight\":\"\",\"houseId\":\"2\",\"houseSpaceCapacity\":\"400\",\"houseType\":\"58\",\"id\":\"42\",\"insectDensity\":\"1\",\"insectProductTime\":\"1510272000000\",\"isCanFumigation\":\"1\",\"isCirculation\":\"1\",\"isDistanceBigTwenty\":\"1\",\"isFirstFumigation\":\"0\",\"isHaveSecuritySituation\":\"1\",\"isHaveTaskList\":\"11\",\"isHaveTaskRecord\":\"30\",\"isInsectCage\":\"1\",\"isLeakRain\":\"0\",\"isPowerSupplyLine\":\"1\",\"isSupplementDrug\":\"1\",\"isWallGetDamp\":\"0\",\"keeper\":\"1\",\"occurrencePlace\":\"粮面\",\"processInstanceId\":\"682501\",\"taskEndTime\":\"1511673380000\",\"taskStartTime\":\"1510282817000\",\"taskState\":\"2\",\"useDrugTotalCount\":\"1\",\"useDrugType\":\"1\"},{\"airTightness\":\"80\",\"auditState\":\"2\",\"concentrationCheckType\":\"一般\",\"createTime\":\"1509961833000\",\"createUnit\":\"经营一部\",\"creater\":\"管理员\",\"createrId\":\"1\",\"drainageSituation\":\"正常\",\"drugName\":\"3032\",\"firstUseDrugCount\":\"50\",\"firstUseDrugUnit\":\"50\",\"fumigateProgramNumber\":\"XZFAZY20171106175033817\",\"fumigationChargePerson\":\"张明\",\"fumigationOperator\":\"张三\",\"fumigationPeopleNumber\":\"10\",\"fumigationType\":\"5246\",\"grainCount\":\"1000\",\"grainImpurity\":\"1\",\"grainKind\":\"3164\",\"grainProducingArea\":\"4877\",\"grainWater\":\"1\",\"houseAroundSituation\":\"安全\",\"houseCapacity\":\"240\",\"houseHeapGrainCapacity\":\"11\",\"houseHeapGrainHeight\":\"1\",\"houseHeapType\":\"5412\",\"houseId\":\"2\",\"houseSpaceCapacity\":\"240\",\"houseType\":\"5213\",\"id\":\"37\",\"insectDensity\":\"100\",\"insectProductTime\":\"1509494400000\",\"isCanFumigation\":\"1\",\"isCirculation\":\"1\",\"isDistanceBigTwenty\":\"1\",\"isFirstFumigation\":\"0\",\"isHaveSecuritySituation\":\"1\",\"isHaveTaskList\":\"8\",\"isHaveTaskRecord\":\"29\",\"isInsectCage\":\"1\",\"isLeakRain\":\"0\",\"isPowerSupplyLine\":\"1\",\"isSupplementDrug\":\"1\",\"isWallGetDamp\":\"0\",\"keeper\":\"1\",\"leastDistanceHouse\":\"50\",\"occurrencePlace\":\"中部\",\"processInstanceId\":\"635001\",\"protectPerson\":\"张三\",\"safePerson\":\"张三\",\"sealDays\":\"10\",\"sealType\":\"真空\",\"settingConcentration\":\"50\",\"storageTime\":\"1509494400000\",\"taskEndTime\":\"1511343719000\",\"taskStartTime\":\"1509962637000\",\"taskState\":\"2\",\"useDrugPowderCount\":\"20\",\"useDrugTabletCount\":\"30\",\"useDrugTotalCount\":\"50\",\"useDrugType\":\"一般\"}]";
        List<FumigationBean.ListBean> list=new ArrayList<>();
        Type type = new TypeToken<List<FumigationBean.ListBean>>() {
        }.getType();
        list= new Gson().fromJson(data, type);
        handleData(list);
        mAdapter.replaceData(list);
        return view;
    }

    private void initView() {
        //添加列表头
        listTitleLayout.addView(LayoutInflater.from(mContext).inflate(R.layout.work_title_layout, null));

        mAdapter = new XunzhengAdapter(null);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    void handleData(List<FumigationBean.ListBean> data) {
        for (FumigationBean.ListBean bean : data) {
            bean.setCreateDepot("河北省粮食仓库");
            bean.setHouseId(bean.getHouseId());
            bean.setGrainKind(bean.getGrainKind());
            String start = DateUtils.formatDateTime(bean.getTaskStartTime());
            String end = DateUtils.formatDateTime(bean.getTaskEndTime());
            bean.setTaskStartTime(start);
            bean.setTaskEndTime(end);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
