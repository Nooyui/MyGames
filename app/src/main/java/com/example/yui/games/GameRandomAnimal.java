package com.example.yui.games;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameRandomAnimal extends AppCompatActivity {


    private Button settime ;
    private  Button setmode ;
    private Button home;
    private ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9;
    Intent intent;
    TextView textView1;
    public int counter ;
    private int Timer_srtting = 5000 ;
    CountDownTimer count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_random_game);
        textView1= (TextView) findViewById(R.id.textView1);
        counter = Timer_srtting/1000;
        timeCount();



        image1 = (ImageView) findViewById(R.id.imageView1);
        image2 = (ImageView) findViewById(R.id.imageView2);
        image3 = (ImageView) findViewById(R.id.imageView3);
        image4 = (ImageView) findViewById(R.id.imageView4);
        image5 = (ImageView) findViewById(R.id.imageView5);
        image6 = (ImageView) findViewById(R.id.imageView6);
        image7 = (ImageView) findViewById(R.id.imageView7);
        image8 = (ImageView) findViewById(R.id.imageView8);
        image9 = (ImageView) findViewById(R.id.imageView9);

        image1.setImageResource(R.drawable.animals_1);
        image2.setImageResource(R.drawable.animals_2);
        image3.setImageResource(R.drawable.animals_3);
        image4.setImageResource(R.drawable.animals_4);
        image5.setImageResource(R.drawable.animals_5);
        image6.setImageResource(R.drawable.animals_6);
        image7.setImageResource(R.drawable.animals_7);
        image8.setImageResource(R.drawable.animals_8);
        image9.setImageResource(R.drawable.animals_9);

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


        image1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                count.cancel();
                textView1.setTextColor(0xFFFF0000);
                intent = new Intent(getApplication(),Result.class);
                intent.putExtra("time",textView1.getText().toString());
                startActivity(intent);
            }
        });
    }

    public void  timeCount() {


            count = new CountDownTimer(Timer_srtting, 1000){
            public void onTick(long millisUntilFinished){
                textView1.setText(String.valueOf(counter));
                counter--;
            }
            public  void onFinish(){
                textView1.setText("FINISH!!");
            }
        }.start();

    }

}