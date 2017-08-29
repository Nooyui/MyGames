package com.example.yui.games;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class GameRandomAnimal extends AppCompatActivity {


    private Button settime ;
    private  Button setmode ;
    private Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_random_game);


        setmode = (Button) findViewById(R.id.button2);
        setmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplication(),Result.class);
                startActivity(intent);
            }
        });


        settime = (Button) findViewById(R.id.button3);
        settime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplication(),Setting.class);
                startActivity(intent);
            }
        });

        home = (Button) findViewById(R.id.button4);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplication(),ModeGame.class);
                startActivity(intent);
            }
        });


    }



}