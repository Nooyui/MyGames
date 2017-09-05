package com.example.yui.games;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameRandomAnimal extends AppCompatActivity {


    private  Button startGame,startTime,nextGame,stopgame;
    private ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9;
    Intent intent;
    TextView textView1,textName1,textName2,textName3,textName4,textName5,textName6,textName7,textName8,textName9,textnamepicture;
    public int counter ;
    private int i ,im ;
    private int Timer_srtting = 10000 ;
    CountDownTimer count;
    Random r ;
    String name1,name2,name3,name4,name5,name6,name7,name8,name9;


    private boolean isCanceled = false;
    int PicketImage=0, LastpicketImage=0;

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
            R.id.imageView1 ,
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
        textName2= (TextView) findViewById(R.id.textName2);
        textName3= (TextView) findViewById(R.id.textName3);
        textName4= (TextView) findViewById(R.id.textName4);
        textName5= (TextView) findViewById(R.id.textName5);
        textName6= (TextView) findViewById(R.id.textName6);
        textName7= (TextView) findViewById(R.id.textName7);
        textName8= (TextView) findViewById(R.id.textName8);
        textName9= (TextView) findViewById(R.id.textName9);



        image1 = (ImageView) findViewById(R.id.imageView1);
        image2 = (ImageView) findViewById(R.id.imageView2);
        image3 = (ImageView) findViewById(R.id.imageView3);
        image4 = (ImageView) findViewById(R.id.imageView4);
        image5 = (ImageView) findViewById(R.id.imageView5);
        image6 = (ImageView) findViewById(R.id.imageView6);
        image7 = (ImageView) findViewById(R.id.imageView7);
        image8 = (ImageView) findViewById(R.id.imageView8);
        image9 = (ImageView) findViewById(R.id.imageView9);





//
//           image1.setImageResource(R.drawable.animals_1);
//        image2.setImageResource(R.drawable.animals_2);
//        image3.setImageResource(R.drawable.animals_3);
//        image4.setImageResource(R.drawable.animals_4);
//        image5.setImageResource(R.drawable.animals_5);
//        image6.setImageResource(R.drawable.animals_6);
//        image7.setImageResource(R.drawable.animals_7);
//        image8.setImageResource(R.drawable.animals_8);
//        image9.setImageResource(R.drawable.animals_9);


//        image1.setImageResource(image[r.nextInt(image.length)]);
//        image2.setImageResource(image[r.nextInt(image.length)]);
//        image3.setImageResource(image[r.nextInt(image.length)]);
//        image4.setImageResource(image[r.nextInt(image.length)]);
//        image5.setImageResource(image[r.nextInt(image.length)]);
//        image6.setImageResource(image[r.nextInt(image.length)]);
//        image7.setImageResource(image[r.nextInt(image.length)]);
//        image8.setImageResource(image[r.nextInt(image.length)]);
//        image9.setImageResource(image[r.nextInt(image.length)]);
//        LastpicketImage = PicketImage ;

        stopgame = (Button) findViewById(R.id.stopGame);
        stopgame.setOnClickListener(new View.OnClickListener() {
          @Override
           public void onClick(View view) {
           intent = new Intent(getApplication(),Result.class);
              startActivity(intent);
           }
          }
        )
        ;





        startTime = (Button) findViewById(R.id.startTime);
        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = Timer_srtting/1000;
                timeCount();
                startGame.setEnabled(false);

            }
        })
        ;
        startGame = (Button) findViewById(R.id.startGame);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RandomImage();

            }
        })
        ;





        image1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                count.cancel();
                textView1.setTextColor(0xFFFF0000);
                intent = new Intent(getApplication(),Result.class);
                intent.putExtra("time",textView1.getText().toString());
                intent.putExtra("nameimage1",textName1.getText().toString());



               // Drawable text = image1.getDrawable();

                //name = image1.getResources().getResourceEntryName(text);
                //text = image1.getTag().toString();
               // text=image1.getResources();




            //    Log.d("name",imageName[randomName[0]]);

                  startActivity(intent);
            }
        });

        image2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                count.cancel();
                textView1.setTextColor(0xFFFF0000);
                intent = new Intent(getApplication(),Result.class);
                intent.putExtra("time",textView1.getText().toString());
                intent.putExtra("nameimage2",textName2.getText().toString());

                   startActivity(intent);
            }
        });

        image3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                count.cancel();
                textView1.setTextColor(0xFFFF0000);
                intent = new Intent(getApplication(),Result.class);
                intent.putExtra("time",textView1.getText().toString());
                intent.putExtra("nameimage3",textName3.getText().toString());


                   startActivity(intent);
            }
        });

        image4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                count.cancel();
                textView1.setTextColor(0xFFFF0000);
                intent = new Intent(getApplication(),Result.class);
                intent.putExtra("time",textView1.getText().toString());
                intent.putExtra("nameimage4",textName4.getText().toString());


                   startActivity(intent);
            }
        });

        image5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                count.cancel();
                textView1.setTextColor(0xFFFF0000);
                intent = new Intent(getApplication(),Result.class);
                intent.putExtra("time",textView1.getText().toString());
                intent.putExtra("nameimage5",textName5.getText().toString());


                   startActivity(intent);
            }
        });

        image6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                count.cancel();
                textView1.setTextColor(0xFFFF0000);
                intent = new Intent(getApplication(),Result.class);
                intent.putExtra("time",textView1.getText().toString());
                intent.putExtra("nameimage6",textName6.getText().toString());


                   startActivity(intent);
            }
        });

        image7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                count.cancel();
                textView1.setTextColor(0xFFFF0000);
                intent = new Intent(getApplication(),Result.class);
                intent.putExtra("time",textView1.getText().toString());
                intent.putExtra("nameimage7",textName7.getText().toString());


                   startActivity(intent);
            }
        });

        image8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                count.cancel();
                textView1.setTextColor(0xFFFF0000);
                intent = new Intent(getApplication(),Result.class);
                intent.putExtra("time",textView1.getText().toString());
                intent.putExtra("nameimage8",textName8.getText().toString());


                   startActivity(intent);
            }
        });

        image9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                count.cancel();
                textView1.setTextColor(0xFFFF0000);
                intent = new Intent(getApplication(),Result.class);
                intent.putExtra("time",textView1.getText().toString());
                intent.putExtra("nameimage9",textName9.getText().toString());


                   startActivity(intent);
            }
        });


        nextGame = (Button) findViewById(R.id.nextGame) ;
        nextGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeCount();
                count.cancel();
                textView1.setText("TIME");
                textView1.setTextColor(0xFFFFFFFF );
                RandomImage();

////
////               do{
////
////                    PicketImage = r.nextInt(image.length);
////
////
////                }while (PicketImage == LastpicketImage);
////
////                //Display Image
////                image1.setImageResource(image[r.nextInt(image.length)]);
////                image2.setImageResource(image[r.nextInt(image.length)]);
////                image3.setImageResource(image[r.nextInt(image.length)]);
////                image4.setImageResource(image[r.nextInt(image.length)]);
////                image5.setImageResource(image[r.nextInt(image.length)]);
////                image6.setImageResource(image[r.nextInt(image.length)]);
////                image7.setImageResource(image[r.nextInt(image.length)]);
////                image8.setImageResource(image[r.nextInt(image.length)]);
////                image9.setImageResource(image[r.nextInt(image.length)]);
////
////
////                LastpicketImage = PicketImage ;





          }
        });

    }

    public void  timeCount() {


            count = new CountDownTimer(Timer_srtting, 1000) {
                public void onTick(long millisUntilFinished) {
                    textView1.setText(String.valueOf(counter));
                    counter--;
                }

                public void onFinish() {
                    textView1.setText("หมดเวลา");
                }
            }.start();





    }

    public void RandomImage(){

        Random random = new Random(System.currentTimeMillis());
        List<Integer> generated = new ArrayList  <Integer>();


        i = 0;
        for (int v : imageViews) {
            int next = random.nextInt(28)+1;
            if (!generated.contains(next)) {
                generated.add(next);
                ImageView iv = (ImageView) findViewById(v);
                iv.setImageResource(image[next]);

                randomName[i] = next ;
                i++;

                name1 = imageName[randomName[0]];
                name2 = imageName[randomName[1]];
                name3 = imageName[randomName[2]];
                name4 = imageName[randomName[3]];
                name5 = imageName[randomName[4]];
                name6 = imageName[randomName[5]];
                name7 = imageName[randomName[6]];
                name8 = imageName[randomName[7]];
                name9 = imageName[randomName[8]];

                textName1.setText(name1);
                textName2.setText(name2);
                textName3.setText(name3);
                textName4.setText(name4);
                textName5.setText(name5);
                textName6.setText(name6);
                textName7.setText(name7);
                textName8.setText(name8);
                textName9.setText(name9);


                Log.d("show",imageName[next]);


            }
        }

    }
}
