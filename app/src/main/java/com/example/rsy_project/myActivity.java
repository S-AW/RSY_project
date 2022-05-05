package com.example.rsy_project;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class myActivity extends AppCompatActivity {
    Button shop;
    Button my;

    ImageButton order;
    ImageButton shoopingcart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        shop = (Button)findViewById(R.id.bt1);
        my = (Button)findViewById(R.id.bt3);
        order = (ImageButton)findViewById(R.id.order);
        shoopingcart = (ImageButton)findViewById(R.id.shoopingcart);

        shop.setOnClickListener(new shop());
        my.setOnClickListener(new my());
        order.setOnClickListener(new order());
        shoopingcart.setOnClickListener(new shoopingcart());

    }
    //定义实现监听接口的内部类

    class my implements View.OnClickListener{

        //实现接口的方法

        @Override

        public void onClick(View v) {

            startActivity(new Intent(getApplicationContext(),myActivity.class));

        }

    }
    class shop implements View.OnClickListener{

        //实现接口的方法

        @Override

        public void onClick(View v) {

            startActivity(new Intent(getApplicationContext(),shopActivity.class));

        }

    }

    class shoopingcart implements View.OnClickListener{

        //实现接口的方法

        @Override

        public void onClick(View v) {

            Intent intent = new Intent(getApplicationContext(), orderActivity.class);
            intent.putExtra("txt", "购物车");
            startActivity(intent);

        }

    }
    class order implements View.OnClickListener{

        //实现接口的方法

        @Override

        public void onClick(View v) {

            Intent intent = new Intent(getApplicationContext(), orderActivity.class);
            intent.putExtra("txt", "全部订单");
            startActivity(intent);

        }

    }


}
