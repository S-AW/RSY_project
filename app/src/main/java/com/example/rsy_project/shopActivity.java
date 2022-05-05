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


public class shopActivity extends AppCompatActivity {
    ImageButton buy1;
    ImageButton buy2;
    ImageButton buy3;
    Button bt1;
    //Button bt2; // “喜欢” 按钮暂时不设置功能
    Button bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        buy1 = (ImageButton)findViewById(R.id.buy1);
        buy2 = (ImageButton)findViewById(R.id.buy2);
        buy3 = (ImageButton)findViewById(R.id.buy3);

        bt1 = (Button)findViewById(R.id.bt1);
        //bt2 = (Button)findViewById(R.id.bt2);
        bt3 = (Button)findViewById(R.id.bt3);

        buy1.setOnClickListener(new buy1());
        buy2.setOnClickListener(new buy2());
        buy3.setOnClickListener(new buy3());
        bt1.setOnClickListener(new tuijian());
        bt3.setOnClickListener(new my());
    }
    //定义实现监听接口的内部类

    class my implements View.OnClickListener{

    //实现接口的方法

        @Override

        public void onClick(View v) {

            startActivity(new Intent(getApplicationContext(),myActivity.class));

        }

    }

    class tuijian implements View.OnClickListener{

        //实现接口的方法

        @Override

        public void onClick(View v) {

            startActivity(new Intent(getApplicationContext(),shopActivity.class));

        }

    }

    class buy1 implements View.OnClickListener{

        //实现接口的方法

        @Override

        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), catAttributeActivity.class);
            intent.putExtra("catNum", 1);
            startActivity(intent);

        }

    }
    class buy2 implements View.OnClickListener{

        //实现接口的方法

        @Override

        public void onClick(View v) {

            Intent intent = new Intent(getApplicationContext(), catAttributeActivity.class);
            intent.putExtra("catNum", 2);
            startActivity(intent);

        }

    }
    class buy3 implements View.OnClickListener{

        //实现接口的方法

        @Override

        public void onClick(View v) {

            Intent intent = new Intent(getApplicationContext(), catAttributeActivity.class);
            intent.putExtra("catNum", 3);
            startActivity(intent);

        }

    }
}
