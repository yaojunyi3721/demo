package com.chinaitop.linxia.demo.activity.JianGuan.LiangQing;

import android.content.Context;
import android.widget.TextView;

import com.chinaitop.linxia.demo.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

/**
 * Created by mq on 2017/10/22 0022.
 */

public class ThreeMarkerView extends MarkerView {
    private final IAxisValueFormatter valueFormatter;
    private TextView tvContent;
    private LineChart chart;

    public ThreeMarkerView(Context context, LineChart chart) {
        super(context, R.layout.custom_marker_view);
        this.chart = chart;
        tvContent = findViewById(R.id.tvContent);
        valueFormatter = chart.getAxisLeft().getValueFormatter();

    }

    //回调函数每次MarkerView重绘,可以用来更新内容(用户界面)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        StringBuffer result = new StringBuffer();
        LineDataSet list1 = (LineDataSet) chart.getData().getDataSetByIndex(0);
        LineDataSet list2 = (LineDataSet) chart.getData().getDataSetByIndex(1);
        LineDataSet list3 = (LineDataSet) chart.getData().getDataSetByIndex(2);

        result.append("仓温: ");
        for (int i = 0; i < list1.getEntryCount(); i++) {
            Entry entry = list1.getEntryForIndex(i);
            if (entry.getX() == e.getX()) {
                result.append(valueFormatter.getFormattedValue(entry.getY(), null));
            }
        }
        result.append("\n粮温: ");
        for (int i = 0; i < list2.getEntryCount(); i++) {
            Entry entry = list2.getEntryForIndex(i);
            if (entry.getX() == e.getX()) {
                result.append(valueFormatter.getFormattedValue(entry.getY(), null));
            }
        }
        result.append("\n外温: ");
        for (int i = 0; i < list3.getEntryCount(); i++) {
            Entry entry = list3.getEntryForIndex(i);
            if (entry.getX() == e.getX()) {
                result.append(valueFormatter.getFormattedValue(entry.getY(), null));
            }
        }

        tvContent.setText(result.toString().replace("\n", "\n"));
        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }
}
