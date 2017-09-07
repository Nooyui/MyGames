package com.example.yui.games;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SelectMode extends AppCompatActivity{
    Button go_3_game ;
    Button go_6_game ;
    Button go_9_game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode);

        go_3_game = (Button) findViewById(R.id.button3);
        go_3_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),Game_Animal__3_picture.class);
                startActivity(intent);
            }
        });

        go_6_game = (Button) findViewById(R.id.button4);
        go_6_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),Game_Animal__6_picture.class);
                startActivity(intent);
            }
        });

        go_9_game = (Button) findViewById(R.id.button5);
        go_9_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),Game_Animal__9_picture.class);
                startActivity(intent);
            }
        });







    }
}
