package com.chinaitop.linxia.demo.activity.JianGuan.LiangQing;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.chinaitop.linxia.demo.R;
/**
 * Created by mq on 2017/10/21 0021.
 * 三温图类  7天内的三温
 */

public class ThreeChartTwo {

    private LineChart mThreeChart;
    private Context mContext;

    private List<String> timeList = new ArrayList<>();
    private List<ThreeChartBean> cangWen;
    private List<ThreeChartBean> liangWen;
    private List<ThreeChartBean> waiWen;

    public ThreeChartTwo(LineChart lineChart) {
        this.mThreeChart = lineChart;
        mContext = mThreeChart.getContext();
        //获取前七天
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        String today = sdf.format(c.getTime());
        setTimeReverse(today, 7);

    }

    /**
     * @param firstDay  第一天 格式 2013-02-09
     * @param dayLength 一共几天
     * @return
     */
    public ThreeChartTwo setTime(String firstDay, int dayLength) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date firstDate = sdfIn.parse(firstDay);
            Calendar c = Calendar.getInstance();
            c.setTime(firstDate);
            timeList.clear();

            for (int i = 1; i <= dayLength; i++) {
                c.add(Calendar.DATE, 1);
                String time = sdf.format(c.getTime());
                timeList.add(time);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return this;
    }

    /**
     * 倒序设置日期列表
     *
     * @param lastDay   最后一天 格式 2013-02-09
     * @param dayLength 一共几天
     * @return
     */
    public ThreeChartTwo setTimeReverse(String lastDay, int dayLength) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date lastDate = sdfIn.parse(lastDay);
            Calendar c = Calendar.getInstance();
            c.setTime(lastDate);
            timeList.clear();

            for (int i = dayLength - 1; i >= 0; i--) {
                Calendar tmp = (Calendar) c.clone();
                tmp.add(Calendar.DATE, -i);
                String time = sdf.format(tmp.getTime());
                timeList.add(time);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return this;
    }

    public ThreeChartTwo setData(List<ThreeChartBean> cangWen, List<ThreeChartBean> liangWen, List<ThreeChartBean> waiWen) {
        this.cangWen = cangWen;
        this.liangWen = liangWen;
        this.waiWen = waiWen;
        return this;
    }

    public ThreeChartTwo show() {
        initThreeChart();
        if (liangWen != null)
            createThreeData();
        //设置悬浮
        ThreeMarkerView mv = new ThreeMarkerView(mContext, mThreeChart);
        mv.setChartView(mThreeChart);
        mThreeChart.setMarker(mv);
        mThreeChart.invalidate();
        return this;
    }

    //初始化
    private void createThreeData() {

        //仓温
        ArrayList<Entry> list1 = new ArrayList<>();
        for (int i = 0; i < cangWen.size(); i++) {
            list1.add(new Entry(cangWen.get(i).getIndex(), cangWen.get(i).getValue()));
        }
        //粮温
        ArrayList<Entry> list2 = new ArrayList<>();
        for (int i = 0; i < liangWen.size(); i++) {
            list2.add(new Entry(liangWen.get(i).getIndex(), liangWen.get(i).getValue()));
        }
        //外温
        ArrayList<Entry> list3 = new ArrayList<>();
        for (int i = 0; i < waiWen.size(); i++) {
            list3.add(new Entry(waiWen.get(i).getIndex(), waiWen.get(i).getValue()));
        }

        LineDataSet set1, set2, set3;

        if (mThreeChart.getData() != null && mThreeChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) mThreeChart.getData().getDataSetByIndex(0);
            set2 = (LineDataSet) mThreeChart.getData().getDataSetByIndex(1);
            set3 = (LineDataSet) mThreeChart.getData().getDataSetByIndex(2);
            set1.setValues(list1);
            set2.setValues(list2);
            set3.setValues(list3);
            mThreeChart.getData().notifyDataChanged();
            mThreeChart.notifyDataSetChanged();
        } else {
            // 创建一个数据集,并给它一个类型
            set1 = new LineDataSet(list1, "仓温");
            setLineDataSet(set1);
            set1.setColor(ContextCompat.getColor(mContext, R.color.line_cw_d));
            set1.setCircleColor(ContextCompat.getColor(mContext, R.color.line_cw_d));//圆点颜色
            set1.setFillColor(ContextCompat.getColor(mContext, R.color.line_cw_d));

            set2 = new LineDataSet(list2, "粮温");
            setLineDataSet(set2);
            set2.setColor(ContextCompat.getColor(mContext, R.color.line_lw_d));
            set2.setCircleColor(ContextCompat.getColor(mContext, R.color.line_lw_d));//圆点颜色
            set2.setFillColor(ContextCompat.getColor(mContext, R.color.line_lw_d));

            set3 = new LineDataSet(list3, "外温");
            setLineDataSet(set3);
            set3.setColor(ContextCompat.getColor(mContext, R.color.line_ww_d));
            set3.setCircleColor(ContextCompat.getColor(mContext, R.color.line_ww_d));//圆点颜色
            set3.setFillColor(ContextCompat.getColor(mContext, R.color.line_ww_d));

            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            //添加数据集
            dataSets.add(set1);
            dataSets.add(set2);
            dataSets.add(set3);
            //创建一个数据集的数据对象
            LineData data = new LineData(dataSets);
            //设置数据
            mThreeChart.setData(data);
        }

        // 得到图表类型
        Legend l = mThreeChart.getLegend();
        // 修改图表类型
        l.setForm(Legend.LegendForm.LINE);
        l.setTextColor(getColor(R.color.legend_text));
        l.setTextSize(12);
    }

    private void setLineDataSet(LineDataSet set) {
        set.setLineWidth(1.5f);
        set.setValueTextSize(9f);
//        set.setFormLineWidth(1f);
        set.setForm(Legend.LegendForm.LINE);
        set.setDrawValues(false);//显示顶点数值
        set.setDrawCircles(true);//显示顶点圆点
        set.setDrawCircleHole(false);//顶点画洞
        set.setCircleRadius(3f);//圆点的半径
        //设置折线样式
        // CUBIC_BEZIER曲线  LINEAR折线  STEPPED矩形 HORIZONTAL_BEZIER横向立方
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setDrawFilled(false);//填充背景
    }

    //初始化三温图
    private void initThreeChart() {
        //设置手势滑动事件
//        mThreeChart.setOnChartGestureListener();
        //设置数值选择监听
//        mThreeChart.setOnChartValueSelectedListener();
        //后台绘制开关
        mThreeChart.setDrawGridBackground(false);
        //设置描述文本
        mThreeChart.getDescription().setEnabled(false);
        //设置支持控制手势
        mThreeChart.setTouchEnabled(true);
        //设置是否可滑动
        mThreeChart.setDragEnabled(true);
        //设置是否可缩放
        mThreeChart.setScaleEnabled(false);
        //如果禁用,扩展可以在x轴和y轴分别完成
        mThreeChart.setPinchZoom(true);
        mThreeChart.getAxisRight().setEnabled(false);
        mThreeChart.setNoDataText("暂无数据");
        mThreeChart.setNoDataTextColor(getColor(R.color.legend_text));

        //x动画时间
        mThreeChart.animateXY(2000, 2000);

        float axisTextSize = 10f;
        float axisWidth = 1f;
        int axisColor = ContextCompat.getColor(mContext, R.color.line_XY);
        int axisTextColor = ContextCompat.getColor(mContext, R.color.legend_text);
        int gridColor = ContextCompat.getColor(mContext, R.color.line_chlidXY);
        int zeroColor = ContextCompat.getColor(mContext, R.color.line_zero);

        LimitLine zeroLine = new LimitLine(0f, "");
        zeroLine.enableDashedLine(10f, 10f, 0f);
        zeroLine.setLineColor(zeroColor);
        //设置X轴 横轴
        XAxis xAxis = mThreeChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setTextColor(axisTextColor);
        xAxis.setTextSize(axisTextSize);
        xAxis.setGridColor(gridColor);
        xAxis.setAxisLineColor(axisColor);
        xAxis.setAxisLineWidth(axisWidth);
        xAxis.setLabelCount(7, true);
        xAxis.setAxisMaximum(6);
        xAxis.setAxisMinimum(0);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return timeList.get((int) value);
            }
        });
        //设置Y轴 竖轴
        YAxis yAxis = mThreeChart.getAxisLeft();
        yAxis.setLabelCount(10, false);
        yAxis.enableGridDashedLine(10f, 10f, 0f);
        yAxis.setGridColor(gridColor);
        yAxis.setAxisLineColor(axisColor);
        yAxis.setAxisLineWidth(axisWidth);
        yAxis.setTextColor(axisTextColor);
        yAxis.setTextSize(axisTextSize);
        yAxis.removeAllLimitLines();
        yAxis.addLimitLine(zeroLine);
        yAxis.setDrawLimitLinesBehindData(true);//特殊线在数据后面画
        yAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return ((int) value) + "℃";
            }
        });


    }

    public int getColor(@ColorRes int colorId) {
        int color = ContextCompat.getColor(mContext, colorId);
        return color;
    }
    public void clear(){
        if (mThreeChart!=null){
            mThreeChart.clear();
        }
    }
    public void clearValues(){
        if (mThreeChart!=null){
            mThreeChart.clearValues();
        }
    }
}
