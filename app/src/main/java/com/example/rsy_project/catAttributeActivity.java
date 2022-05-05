package com.example.rsy_project;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lwb.radarchart.RadarChartView;

import java.sql.SQLException;
import java.util.HashMap;


public class catAttributeActivity extends Activity {
    Button shoopingcart;
    Button buynow;
    TextView catName;
    TextView catid;
    ImageView img;
    int catNum = 0;

    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case 1:
                    Bundle bundle=msg.getData();
                    int[] data = bundle.getIntArray("data");
                    Log.e("msg","消息接受成功 " + data[0]);
                    final RadarChartView radar_chart_view = findViewById(R.id.radar_chart_view);
                    radar_chart_view.insertType("性格", data[0], 100);
                    radar_chart_view.insertType("价格", data[1], 5000);
                    radar_chart_view.insertType("评价", data[2], 100);
                    radar_chart_view.insertType("年龄", data[3], 20);
                    radar_chart_view.insertType("亲人度", data[4],100);

                    RadarChartView.Config config = new RadarChartView.Config()
                            .setMaxLevel(5)
                            .setCenterPointRadius(5)
                            .setChartWidget(0.8f)
                            .setFillColor(0xff268415)
                            .setSecondFillColor(0xffcd2626)
                            .setValueLineSize(1)
                            .setValuePointRadius(5)
                            .setBackgroundColor(0x88985615)
                            .setTextColor(0x88985615)
                            .setTextSize(40)
                            .setCanScroll(true)
                            .setCanFling(true)
                            .setValueBackgroundAlpha(0.2f)
                            .setTextPosition(1.1f)
                            .setPointRadius(2);
                    radar_chart_view.setConfig(config);
            }

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catattribute);
        //获取选购（shop）页面传入参数“catNum”
        catNum = getIntent().getIntExtra("catNum", 1);

        //-----------------------------------------------------------------------------------------------------
        //画属性雷达图

        new Thread(new Runnable() {

            @Override
            public void run() {

                HashMap<String, Integer> map = null;
                try {
                    map = DBUtils.getCatAttribute(catNum);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                Bundle bundle=new Bundle();
                Message message = Message.obtain();
                int[] data = {map.get("性格"), map.get("价格"), map.get("评价"), map.get("年龄"), map.get("亲人度")};
                bundle.putIntArray("data",data);
                message.what = 1;
                message.setData(bundle);
                handler.sendMessage(message);
                Log.e("msg", "消息发送成功");
            }
        }).start();
        //-----------------------------------------------------------------------------------------------------


        shoopingcart = (Button)findViewById(R.id.shoopingcart);
        buynow = (Button)findViewById(R.id.buynow);
        //修改activity_catAttribute.xml页面内容---------------------
        catName = (TextView) findViewById(R.id.text1);
        catid = (TextView) findViewById(R.id.catid);
        img = (ImageView) findViewById(R.id.cat2) ;
        switch (catNum){
            case 2 :
                catName.setText("小美");
                catid.setText("猫咪编号：02");
                img.setImageResource(R.drawable.cat3);
                break;
            case 3 :
                catName.setText("大春");
                catid.setText("猫咪编号：03");
                img.setImageResource(R.drawable.cat4);
                break;
        }
        //--------------------------------------------------------

        shoopingcart.setOnClickListener(new shoopingcart());
        buynow.setOnClickListener(new buynow());


    }
    //定义实现监听接口的内部类

    class buynow implements View.OnClickListener{

        //实现接口的方法

        @Override

        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), buysuccessActivity.class);
            intent.putExtra("txt", "购买成功");
            startActivity(intent);

        }

    }

    //定义实现监听接口的内部类

    class shoopingcart implements View.OnClickListener{

        //实现接口的方法

        @Override

        public void onClick(View v) {

            Intent intent = new Intent(getApplicationContext(), buysuccessActivity.class);
            intent.putExtra("txt", "加入购物车成功");
            startActivity(intent);

        }

    }
}
