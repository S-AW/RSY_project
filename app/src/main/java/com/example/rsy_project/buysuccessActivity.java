package com.example.rsy_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class buysuccessActivity extends Activity {
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buysuccess);
        //获取选购（catAttribute）页面传入参数“txt”
        String s = getIntent().getStringExtra("txt");
        txt = (TextView) findViewById(R.id.buysuccess);
        txt.setText(s);

    }

}
