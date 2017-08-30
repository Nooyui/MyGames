package com.example.yui.games;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;


public class Result extends AppCompatActivity{

    Intent intent;
    private   TextView texttime;
    private  String timeResule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_result);
        texttime = (TextView)findViewById(R.id.textTime);

        intent = getIntent();
        timeResule = intent.getStringExtra("time");
        texttime.setText(" " + timeResule);




    }
}
