package com.example.yui.games;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Game_Animal__3_picture extends AppCompatActivity {


    private Button  startTime,  home;
    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;
    Intent intent;
    TextView textView1, textName1, textName2, textName3, textName4, textName5, textName6, textName7, textName8, textName9, textnamepicture;
    public int counter;
    private int i, im;
    int Timer_srtting = 1000 ;
    CountDownTimer count;
    String name1, name2, name3, name4, name5, name6, name7, name8, name9;
    private ImageView mylay;
    private ImageView mylay1;
    private ImageView mylay2;
    private ImageView mylay3;
    private Chronometer mChronometer;
    private long lastPause;

    String imageName[] ={
            "ไก่แจ้",
            "ไก่",
            "ลูกเจี๊ยบ",
            "นกยูง",
            "ลา",
            "วัว",
            "ควาย",
            "กระทิง",
            "แกะ",
            "หนู",
            "กระต่าย",
            "แพะ",
            "หมู",
            "นก",
            "ผึ้ง",
            "ห่าน",
            "นกกระจอก",
            "นกแก้ว",
            "แมลงกวาง",
            "จามรี",
            "แมว",
            "หนูขาว",
            "หนูน้ำเงิน",
            "หนูน้ำตาล",
            "เต่า",
            "แมวน้ำ",
            "หนูนา",
            "กิ้งก่า"
    };

    int randomName [] = {
            0,0,0,0,0,0,0,0,0





    };


    int[] image = {
            R.drawable.animals_1,
            R.drawable.animals_2,
            R.drawable.animals_3,
            R.drawable.animals_4,
            R.drawable.animals_5,
            R.drawable.animals_6,
            R.drawable.animals_7,
            R.drawable.animals_8,
            R.drawable.animals_9,
            R.drawable.animals_10,
            R.drawable.animals_11,
            R.drawable.animals_12,
            R.drawable.animals_13,
            R.drawable.animals_14,
            R.drawable.animals_15,
            R.drawable.animals_16,
            R.drawable.animals_17,
            R.drawable.animals_18,
            R.drawable.animals_19,
            R.drawable.animals_20,
            R.drawable.animals_21,
            R.drawable.animals_22,
            R.drawable.animals_23,
            R.drawable.animals_24,
            R.drawable.animals_25,
            R.drawable.animals_26,
            R.drawable.animals_27,
            R.drawable.animals_28

    };

    int[] imageViews = {
            R.id.imageView1,
            R.id.imageView2,
            R.id.imageView3

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_random_game_3);


        mylay = (ImageView) findViewById(R.id.imageView);
        mylay1 = (ImageView) findViewById(R.id.imageView1);
        mylay2 = (ImageView) findViewById(R.id.imageView2);
        mylay3 = (ImageView) findViewById(R.id.imageView3);

        Timer timer = new Timer();
        MyTimer mt = new MyTimer();
        timer.schedule(mt,0, 3000);

        Timer timer1 = new Timer();
        MyTimer1 mt1 = new MyTimer1();
        timer1.schedule(mt1, 3000, 3000);

        Timer timer2 = new Timer();
        MyTimer2 mt2 = new MyTimer2();
        timer2.schedule(mt2, 6000, 3000);

        Timer timer3 = new Timer();
        MyTimer3 mt3 = new MyTimer3();
        timer3.schedule(mt3, 9000, 3000);


        mChronometer = (Chronometer) findViewById(R.id.chronometer);



        textView1 = (TextView) findViewById(R.id.textView1);



        startTime = (Button) findViewById(R.id.startTime);
        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (lastPause != 0){
                    mChronometer.setBase(mChronometer.getBase() + SystemClock.elapsedRealtime() - lastPause);
                }
                else{
                    mChronometer.setBase(SystemClock.elapsedRealtime());
                }

                mChronometer.start();
            }
        })
        ;




        home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplication(), ModeGame.class);
                startActivity(intent);

            }
        })
        ;

    }
    public void timeCount() {


        count = new CountDownTimer(Timer_srtting, 1000) {
            public void onTick(long millisUntilFinished) {
                textView1.setText(String.valueOf(counter));
                counter++;
            }

            public void onFinish() {
                textView1.setText("หมดเวลา");
            }
        }.start();


    }


    class MyTimer extends TimerTask {

        public void run() {

            runOnUiThread(new Runnable() {
                Random rand = new Random();
                public void run() {


                    int[] Images = {
                            R.drawable.animals_1,
                            R.drawable.animals_2,
                            R.drawable.animals_3,
                            R.drawable.animals_4,
                            R.drawable.animals_5,
                            R.drawable.animals_6,
                            R.drawable.animals_7,
                            R.drawable.animals_8,
                            R.drawable.animals_9,
                            R.drawable.animals_10,
                            R.drawable.animals_11,
                            R.drawable.animals_12,
                            R.drawable.animals_13,
                            R.drawable.animals_14,
                            R.drawable.animals_15,
                            R.drawable.animals_16,
                            R.drawable.animals_17,
                            R.drawable.animals_18,
                            R.drawable.animals_19,
                            R.drawable.animals_20,
                            R.drawable.animals_21,
                            R.drawable.animals_22,
                            R.drawable.animals_23,
                            R.drawable.animals_24,
                            R.drawable.animals_25,
                            R.drawable.animals_26,
                            R.drawable.animals_27,
                            R.drawable.animals_28

                    };


                    mylay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Log.d("show", imageName[getRandomNumber()]);

                        }
                    });

                    mylay.setBackgroundResource(Images[getRandomNumber()]) ;

                }

                private int getRandomNumber() {
                    // TODO Auto-generated method stub
                    return new Random().nextInt(28);


                }
            });
        }
    }




    class MyTimer1 extends TimerTask {

        public void run() {

            runOnUiThread(new Runnable() {
                Random rand = new Random();
                public void run() {
                    int[] Images1 = {
                            R.drawable.animals_1,
                            R.drawable.animals_2,
                            R.drawable.animals_3,
                            R.drawable.animals_4,
                            R.drawable.animals_5,
                            R.drawable.animals_6,
                            R.drawable.animals_7,
                            R.drawable.animals_8,
                            R.drawable.animals_9,
                            R.drawable.animals_10,
                            R.drawable.animals_11,
                            R.drawable.animals_12,
                            R.drawable.animals_13,
                            R.drawable.animals_14,
                            R.drawable.animals_15,
                            R.drawable.animals_16,
                            R.drawable.animals_17,
                            R.drawable.animals_18,
                            R.drawable.animals_19,
                            R.drawable.animals_20,
                            R.drawable.animals_21,
                            R.drawable.animals_22,
                            R.drawable.animals_23,
                            R.drawable.animals_24,
                            R.drawable.animals_25,
                            R.drawable.animals_26,
                            R.drawable.animals_27,
                            R.drawable.animals_28};

                    mylay1.setBackgroundResource(Images1[getRandomNumber()]);
                    mylay.setVisibility(View.INVISIBLE);


                }

                private int getRandomNumber() {
                    // TODO Auto-generated method stub
                    return new Random().nextInt(28);}
            });
        }
    }

    class MyTimer2 extends TimerTask {

        public void run() {

            runOnUiThread(new Runnable() {
                Random rand = new Random();

                public void run() {

                    int[] Images2 = {
                            R.drawable.animals_1,
                            R.drawable.animals_2,
                            R.drawable.animals_3,
                            R.drawable.animals_4,
                            R.drawable.animals_5,
                            R.drawable.animals_6,
                            R.drawable.animals_7,
                            R.drawable.animals_8,
                            R.drawable.animals_9,
                            R.drawable.animals_10,
                            R.drawable.animals_11,
                            R.drawable.animals_12,
                            R.drawable.animals_13,
                            R.drawable.animals_14,
                            R.drawable.animals_15,
                            R.drawable.animals_16,
                            R.drawable.animals_17,
                            R.drawable.animals_18,
                            R.drawable.animals_19,
                            R.drawable.animals_20,
                            R.drawable.animals_21,
                            R.drawable.animals_22,
                            R.drawable.animals_23,
                            R.drawable.animals_24,
                            R.drawable.animals_25,
                            R.drawable.animals_26,
                            R.drawable.animals_27,
                            R.drawable.animals_28
                    };

                    mylay2.setBackgroundResource(Images2[getRandomNumber()]);
                    mylay.setVisibility(View.INVISIBLE);
                    mylay1.setVisibility(View.INVISIBLE);

                }

                private int getRandomNumber() {
                    // TODO Auto-generated method stub
                    return new Random().nextInt(28);
                }
            });
        }
    }
    class MyTimer3 extends TimerTask {

        public void run() {

            runOnUiThread(new Runnable() {
                Random rand = new Random();
                public void run() {

                    int[] Images3 = {
                            R.drawable.animals_1,
                            R.drawable.animals_2,
                            R.drawable.animals_3,
                            R.drawable.animals_4,
                            R.drawable.animals_5,
                            R.drawable.animals_6,
                            R.drawable.animals_7,
                            R.drawable.animals_8,
                            R.drawable.animals_9,
                            R.drawable.animals_10,
                            R.drawable.animals_11,
                            R.drawable.animals_12,
                            R.drawable.animals_13,
                            R.drawable.animals_14,
                            R.drawable.animals_15,
                            R.drawable.animals_16,
                            R.drawable.animals_17,
                            R.drawable.animals_18,
                            R.drawable.animals_19,
                            R.drawable.animals_20,
                            R.drawable.animals_21,
                            R.drawable.animals_22,
                            R.drawable.animals_23,
                            R.drawable.animals_24,
                            R.drawable.animals_25,
                            R.drawable.animals_26,
                            R.drawable.animals_27,
                            R.drawable.animals_28
                    };

                    mylay3.setBackgroundResource(Images3[getRandomNumber()]);
                    mylay.setVisibility(View.INVISIBLE);
                    mylay1.setVisibility(View.INVISIBLE);
                    mylay2.setVisibility(View.INVISIBLE);

                }

                private int getRandomNumber() {
                    // TODO Auto-generated method stub
                    return new Random().nextInt(28);}
            });
        }
    }




}
