package com.example.rsy_project;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class orderActivity extends Activity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        txt = (TextView) findViewById(R.id.order);
        String s = getIntent().getStringExtra("txt");
        txt.setText(s);
    }
}
