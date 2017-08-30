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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameRandomAnimal extends AppCompatActivity {


    private  Button setmode,home,settime,nextGame;
    private ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9;
    Intent intent;
    TextView textView1,textName1;
    public int counter ;
    private int Timer_srtting = 10000 ;
    CountDownTimer count;
    Random r ;
    int PicketImage=0, LastpicketImage=0;


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
            R.id.imageView3,
            R.id.imageView4,
            R.id.imageView5,
            R.id.imageView6,
            R.id.imageView7,
            R.id.imageView8,
            R.id.imageView9

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_random_game);
        textView1= (TextView) findViewById(R.id.textView1);
        textName1= (TextView) findViewById(R.id.textName1);
        counter = Timer_srtting/1000;
        timeCount();
        r = new Random();


        image1 = (ImageView) findViewById(R.id.imageView1);
        image2 = (ImageView) findViewById(R.id.imageView2);
        image3 = (ImageView) findViewById(R.id.imageView3);
        image4 = (ImageView) findViewById(R.id.imageView4);
        image5 = (ImageView) findViewById(R.id.imageView5);
        image6 = (ImageView) findViewById(R.id.imageView6);
        image7 = (ImageView) findViewById(R.id.imageView7);
        image8 = (ImageView) findViewById(R.id.imageView8);
        image9 = (ImageView) findViewById(R.id.imageView9);



//        image1.setImageResource(R.drawable.animals_1);
//        image2.setImageResource(R.drawable.animals_2);
//        image3.setImageResource(R.drawable.animals_3);
//        image4.setImageResource(R.drawable.animals_4);
//        image5.setImageResource(R.drawable.animals_5);
//        image6.setImageResource(R.drawable.animals_6);
//        image7.setImageResource(R.drawable.animals_7);
//        image8.setImageResource(R.drawable.animals_8);
//        image9.setImageResource(R.drawable.animals_9);

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
                intent.putExtra("name",textName1.getText().toString());


             //   startActivity(intent);
            }
        });






        nextGame = (Button) findViewById(R.id.nextGame) ;
        nextGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//
//               do{
//
//                    PicketImage = r.nextInt(image.length);
//
//
//                }while (PicketImage == LastpicketImage);
//
//                //Display Image
//                image1.setImageResource(image[r.nextInt(image.length)]);
//                image2.setImageResource(image[r.nextInt(image.length)]);
//                image3.setImageResource(image[r.nextInt(image.length)]);
//                image4.setImageResource(image[r.nextInt(image.length)]);
//                image5.setImageResource(image[r.nextInt(image.length)]);
//                image6.setImageResource(image[r.nextInt(image.length)]);
//                image7.setImageResource(image[r.nextInt(image.length)]);
//                image8.setImageResource(image[r.nextInt(image.length)]);
//                image9.setImageResource(image[r.nextInt(image.length)]);
//
//
//                LastpicketImage = PicketImage ;

                Random random = new Random(System.currentTimeMillis());
                List<Integer> generated = new ArrayList<Integer>();
                for (int v : imageViews) {
                    int next = random.nextInt(27)+1;
                    if (!generated.contains(next)) {
                        generated.add(next);
                        ImageView iv = (ImageView) findViewById(v);
                        iv.setImageResource(image[next]);

                    }
                }



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
                textView1.setText("หมดเวลา");
            }
        }.start();

    }

}