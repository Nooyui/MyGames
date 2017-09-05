package com.example.yui.games;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


public class Result extends AppCompatActivity{

    Intent intent;
    private   TextView texttime, textname1,textname2,textname3,textname4,textname5,textname6,textname7,textname8,textname9;
    private  String timeResule,nameResule1,nameResule2,nameResule3,nameResule4,nameResule5,nameResule6,nameResule7,nameResule8,nameResule9;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_result);
        texttime = (TextView)findViewById(R.id.textTime);
        textname1 = (TextView)findViewById(R.id.textName1);
        textname2 = (TextView)findViewById(R.id.textName2);
        textname3 = (TextView)findViewById(R.id.textName3);
        textname4 = (TextView)findViewById(R.id.textName4);
        textname5 = (TextView)findViewById(R.id.textName5);
        textname6 = (TextView)findViewById(R.id.textName6);
        textname7 = (TextView)findViewById(R.id.textName7);
        textname8 = (TextView)findViewById(R.id.textName8);
        textname9 = (TextView)findViewById(R.id.textName9);

        intent = getIntent();
        timeResule = intent.getStringExtra("time");

        nameResule1 = intent.getStringExtra("nameimage1");
        nameResule2 = intent.getStringExtra("nameimage2");
        nameResule3 = intent.getStringExtra("nameimage3");
        nameResule4 = intent.getStringExtra("nameimage4");
        nameResule5 = intent.getStringExtra("nameimage5");
        nameResule6 = intent.getStringExtra("nameimage6");
        nameResule7 = intent.getStringExtra("nameimage7");
        nameResule8 = intent.getStringExtra("nameimage8");
        nameResule9 = intent.getStringExtra("nameimage9");

//        textname.setText(nameResule1);
//        textname.setText(nameResule2);
//        textname.setText(nameResule3);
//        textname.setText(nameResule4);
//        textname.setText(nameResule5);
//        textname.setText(nameResule6);
//        textname.setText(nameResule7);
//        textname.setText(nameResule8);
//        textname.setText(nameResule9);

        texttime.setText(" " + timeResule);

        textname1.setText(nameResule1);
        textname2.setText(nameResule2);
        textname3.setText(nameResule3);
        textname4.setText(nameResule4);
        textname5.setText(nameResule5);
        textname6.setText(nameResule6);
        textname7.setText(nameResule7);
        textname8.setText(nameResule8);
        textname9.setText(nameResule9);

        back = (Button) findViewById(R.id.button2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(getApplicationContext(),GameRandomAnimal.class);
                startActivity(intent);
            }
        });





    }
}
