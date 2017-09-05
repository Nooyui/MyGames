package com.example.yui.games;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Setting extends AppCompatActivity{
    Button setting_time ;
    Button setting_game ;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        setting_time = (Button) findViewById(R.id.setting_time);
        setting_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),SettingTime.class);
                startActivity(intent);
            }
        });

        setting_game = (Button) findViewById(R.id.setting_game);
        setting_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),SettingGame.class);
                startActivity(intent);
            }
        });

        back = (Button) findViewById(R.id.button_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),ModeGame.class);
                startActivity(intent);
            }
        });


    }
}
