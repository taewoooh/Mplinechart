package com.example.graph;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<Upitem> upitems = new ArrayList<>();
    private LineChart chart;
    XAxis xAxis;
    YAxis yLAxis;
    Description des;
    Legend l;
    LineData dat;
    Retrofit retrofit;

    private final String BASE_URL = "https://taewoooh88.cafe24.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chart = (LineChart) findViewById(R.id.chart);
        dat = new LineData();

        xAxis = chart.getXAxis();
        yLAxis = chart.getAxisLeft();
        des = chart.getDescription();
        des.setEnabled(false);
        l = chart.getLegend();
        l.setEnabled(false);

        chart.setTouchEnabled(false);
        chart.setClickable(false);
        chart.setDoubleTapToZoomEnabled(false);
        chart.setDoubleTapToZoomEnabled(false);
        chart.setDrawBorders(false);
        chart.setDrawGridBackground(false);
        chart.getDescription().setEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getAxisLeft().setDrawLabels(false);
        chart.getAxisLeft().setDrawAxisLine(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.getXAxis().setDrawLabels(false);
        chart.getXAxis().setDrawAxisLine(false);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getAxisRight().setDrawLabels(false);
        chart.getAxisRight().setDrawAxisLine(false);
        chart.setData(dat);

        yLAxis.setLabelCount(2,false);
        xAxis.setLabelCount(2,false);

        dat = chart.getData();

                if (dat != null) {
            ILineDataSet set = dat.getDataSetByIndex(0);

            if (set == null) {
                set = createSet();
                dat.addDataSet(set);
            }
        dat.addEntry(new Entry(2017, 120000, 3), 0);
        dat.addEntry(new Entry(2018, 125000, 3), 0);
        dat.addEntry(new Entry(2019, 130000, 3), 0);
        dat.addEntry(new Entry(2020, 135000, 3), 0);
        dat.addEntry(new Entry(2021, 140000, 3), 0);
        dat.addEntry(new Entry(2022, 145000, 3), 0);


         }



      //  addEntry();

    }
    public void init() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public void Buyminichart(String name, String pyeungsu, String area, String jiyeokcode, String jibun) { // 서버로 전달할 파라미터
        //upitems.clear();

        init();
        Upgithub BgitHub2 = retrofit.create(Upgithub.class);
        Call<List<Upitem>> call = BgitHub2.contributors(name, pyeungsu, area, jiyeokcode, jibun);
        call.enqueue(new Callback<List<Upitem>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            // 성공시
            public void onResponse(Call<List<Upitem>> call, Response<List<Upitem>> result) {
                List<Upitem> contributors = result.body();
                // 받아온 리스트를 순회하면서


                for (Upitem contributor : contributors) {


                    int up = contributor.getUp();


                    upitems.add(new Upitem(up));

                    Log.e("up확인", ""+ upitems.get(0).getUp());
                }


            }

            @Override
            public void onFailure(Call<List<Upitem>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "up 정보 받아오기 실패 다시 시도해주세요.", Toast.LENGTH_LONG)
                        .show();


            }
        });

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