package com.example.graph;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

public class MainActivity extends AppCompatActivity {

    private LineChart chart;
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        XAxis xAxis;

        YAxis yLAxis;
        chart = (LineChart) findViewById(R.id.chart);
        xAxis = chart.getXAxis();
        yLAxis = chart.getAxisLeft();
        Description des = chart.getDescription();
        des.setEnabled(false);


        chart.setTouchEnabled(true);
        chart.setClickable(false);
        chart.setDoubleTapToZoomEnabled(false);
        chart.setDoubleTapToZoomEnabled(false);

        chart.setDrawBorders(false);
        chart.setDrawGridBackground(false);

        chart.getDescription().setEnabled(false);
        chart.getLegend().setEnabled(false);

        chart.getAxisLeft().setDrawGridLines(true);
        chart.getAxisLeft().setDrawLabels(true);
        chart.getAxisLeft().setDrawAxisLine(true);

        chart.getXAxis().setDrawGridLines(false);
        chart.getXAxis().setDrawLabels(false);
        chart.getXAxis().setDrawAxisLine(false);

        chart.getAxisRight().setDrawGridLines(false);
        chart.getAxisRight().setDrawLabels(false);
        chart.getAxisRight().setDrawAxisLine(false);


        yLAxis.setLabelCount(2,false);
        xAxis.setLabelCount(2,false);


        Legend l = chart.getLegend();
        l.setEnabled(false);



        LineData data = new LineData();
        chart.setData(data);
        addEntry();

    }

    private void addEntry() {
        LineData data = chart.getData();
       // data.setDrawValues(false);

        if (data != null) {
            ILineDataSet set = data.getDataSetByIndex(0);

            if (set == null) {
                set = createSet();
                data.addDataSet(set);
            }
            data.addEntry(new Entry(2017, 120000, 3), 0);
            data.addEntry(new Entry(2018, 125000, 3), 0);
            data.addEntry(new Entry(2019, 130000, 3), 0);
            data.addEntry(new Entry(2020, 135000, 3), 0);
            data.addEntry(new Entry(2021, 140000, 3), 0);
            data.addEntry(new Entry(2022, 145000, 3), 0);
            data.notifyDataChanged();

            chart.moveViewToX(data.getEntryCount());
        }
    }

    private LineDataSet createSet() {

        LineDataSet set = new LineDataSet(null, "Dynamic Data");
        set.setFillAlpha(110);
        set.setFillColor(Color.parseColor("#d7e7fa"));
        set.setColor(Color.parseColor("#0B80C9"));
        set.setCircleColor(Color.parseColor("#FFA1B4DC"));
        set.setCircleColorHole(Color.BLUE);
        set.setValueTextColor(Color.WHITE);
        set.setDrawValues(false);
        set.setLineWidth(1);
        set.setCircleRadius(6);
        set.setDrawCircleHole(false);
        set.setDrawCircles(false);
        set.setValueTextSize(9f);
        set.setDrawFilled(true);


        return set;
    }


    @Override
    protected void onPause() {
        super.onPause();

    }
}