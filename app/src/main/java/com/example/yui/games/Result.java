package com.example.yui.games;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;


public class Result extends AppCompatActivity{

    Intent intent;
    private   TextView texttime, textname;
    private  String timeResule,nameResule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_result);
        texttime = (TextView)findViewById(R.id.textTime);
        textname = (TextView)findViewById(R.id.textname);

        intent = getIntent();
        timeResule = intent.getStringExtra("time");
        nameResule = intent.getStringExtra("name");
        textname.setText(nameResule);
        texttime.setText(" " + timeResule);




    }
}
