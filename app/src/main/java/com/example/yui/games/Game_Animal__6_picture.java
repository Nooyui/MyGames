package com.example.yui.games;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game_Animal__6_picture extends AppCompatActivity {


    private Button startGame, startTime, nextGame, stopgame,settime;
    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;
    Intent intent;
    TextView textView1, textName1, textName2, textName3, textName4, textName5, textName6, textName7, textName8, textName9, textnamepicture;
    public int counter;
    private int i, im;
    int Timer_srtting = 10000;
    CountDownTimer count;
    Random r;
    String name1, name2, name3, name4, name5, name6, name7, name8, name9;


    private boolean isCanceled = false;
    int PicketImage = 0, LastpicketImage = 0;

    String imageName[] = {

            "ค้างคาว","ควาย","จระเข้","วัว","ลิง","ปู","อูฐ","งู","หมา","ช้าง","กระทิง","อีกา","เป็ด","เสือดาว","ไก่","แมว","กวาง","ปลาทอง","กบ","แพะ",
            "อิปโป","จิงโจ้","สิงโต","นกฮูก","นกแก้ว","นกเพนกวิ้น","กระต่าย","หมู","หนู","ปลาฉลาม","แกะ","แมงมุม","เสือ","ม้าลาย","เต่า","หมี","หอยทาก","ปลาดาว","ม้าน้ำ","ปลาโลมา"
    };

    int randomName[] = {
            0, 0, 0, 0, 0, 0, 0, 0, 0


    };


    int[] image = {
            R.drawable.an1,
            R.drawable.an2,
            R.drawable.an3,
            R.drawable.an4,
            R.drawable.an5,
            R.drawable.an6,
            R.drawable.an7,
            R.drawable.an8,
            R.drawable.an9,
            R.drawable.an10,
            R.drawable.an11,
            R.drawable.an12,
            R.drawable.an13,
            R.drawable.an14,
            R.drawable.an15,
            R.drawable.an16,
            R.drawable.an17,
            R.drawable.an18,
            R.drawable.an19,
            R.drawable.an20,
            R.drawable.an21,
            R.drawable.an22,
            R.drawable.an23,
            R.drawable.an24,
            R.drawable.an25,
            R.drawable.an26,
            R.drawable.an27,
            R.drawable.an28,
            R.drawable.an29,
            R.drawable.an30,
            R.drawable.an31,
            R.drawable.an32,
            R.drawable.an33,
            R.drawable.an34,
            R.drawable.an35,
            R.drawable.an36,
            R.drawable.an37,
            R.drawable.an38,
            R.drawable.an39,
            R.drawable.an40

    };

    int[] imageViews = {
            R.id.imageView1,
            R.id.imageView2,
            R.id.imageView3,
            R.id.imageView4,
            R.id.imageView5,
            R.id.imageView6,

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_random_game_6);

        intent = getIntent();
        Timer_srtting = intent.getIntExtra("timeset",0);


        textView1 = (TextView) findViewById(R.id.textView1);


        image1 = (ImageView) findViewById(R.id.imageView1);
        image2 = (ImageView) findViewById(R.id.imageView2);
        image3 = (ImageView) findViewById(R.id.imageView3);
        image4 = (ImageView) findViewById(R.id.imageView4);
        image5 = (ImageView) findViewById(R.id.imageView5);
        image6 = (ImageView) findViewById(R.id.imageView6);


        textName1 = (TextView) findViewById(R.id.textName1);
        textName2 = (TextView) findViewById(R.id.textName2);
        textName3 = (TextView) findViewById(R.id.textName3);
        textName4 = (TextView) findViewById(R.id.textName4);
        textName5 = (TextView) findViewById(R.id.textName5);
        textName6 = (TextView) findViewById(R.id.textName6);


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

         intent = new Intent(getApplication(), ResultAnimal_2.class);
         startActivity(intent);
                                        }
                                    }
        )
        ;


        startTime = (Button) findViewById(R.id.startTime);
        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = Timer_srtting / 1000;
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

        settime = (Button) findViewById(R.id.settime);
        settime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplication(), SettingTime1.class);
                startActivity(intent);

            }
        })
        ;


        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.cancel();
                textView1.setTextColor(0xFFFF0000);
                intent = new Intent(getApplication(), ResultAnimal_2.class);
                intent.putExtra("time", textView1.getText().toString());
                intent.putExtra("nameimage1", textName1.getText().toString());


                // Drawable text = image1.getDrawable();

                //name = image1.getResources().getResourceEntryName(text);
                //text = image1.getTag().toString();
                // text=image1.getResources();


                //    Log.d("name",imageName[randomName[0]]);

                startActivity(intent);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.cancel();
                textView1.setTextColor(0xFFFF0000);
                intent = new Intent(getApplication(), ResultAnimal_2.class);
                intent.putExtra("time", textView1.getText().toString());
                intent.putExtra("nameimage2", textName2.getText().toString());

                startActivity(intent);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.cancel();
                textView1.setTextColor(0xFFFF0000);
                intent = new Intent(getApplication(), ResultAnimal_2.class);
                intent.putExtra("time", textView1.getText().toString());
                intent.putExtra("nameimage3", textName3.getText().toString());


                startActivity(intent);
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.cancel();
                textView1.setTextColor(0xFFFF0000);
                intent = new Intent(getApplication(), ResultAnimal_2.class);
                intent.putExtra("time", textView1.getText().toString());
                intent.putExtra("nameimage4", textName4.getText().toString());


                startActivity(intent);
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.cancel();
                textView1.setTextColor(0xFFFF0000);
                intent = new Intent(getApplication(), ResultAnimal_2.class);
                intent.putExtra("time", textView1.getText().toString());
                intent.putExtra("nameimage5", textName5.getText().toString());


                startActivity(intent);
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.cancel();
                textView1.setTextColor(0xFFFF0000);
                intent = new Intent(getApplication(), ResultAnimal_2.class);
                intent.putExtra("time", textView1.getText().toString());
                intent.putExtra("nameimage6", textName6.getText().toString());


                startActivity(intent);
            }
        });
//
//        image7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count.cancel();
//                textView1.setTextColor(0xFFFF0000);
//                intent = new Intent(getApplication(), Result.class);
//                intent.putExtra("time", textView1.getText().toString());
//                intent.putExtra("nameimage7", textName7.getText().toString());
//
//
//                startActivity(intent);
//            }
//        });
//
//        image8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count.cancel();
//                textView1.setTextColor(0xFFFF0000);
//                intent = new Intent(getApplication(), Result.class);
//                intent.putExtra("time", textView1.getText().toString());
//                intent.putExtra("nameimage8", textName8.getText().toString());
//
//
//                startActivity(intent);
//            }
//        });
//
//        image9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count.cancel();
//                textView1.setTextColor(0xFFFF0000);
//                intent = new Intent(getApplication(), Result.class);
//                intent.putExtra("time", textView1.getText().toString());
//                intent.putExtra("nameimage9", textName9.getText().toString());
//
//
//                startActivity(intent);
//            }
//        });


        nextGame = (Button) findViewById(R.id.nextGame);
        nextGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeCount();
                count.cancel();
                textView1.setText("TIME");
                textView1.setTextColor(0xFFFFFFFF);
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

    public void timeCount() {


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


    public void RandomImage() {

        Random random = new Random(System.currentTimeMillis());
        List<Integer> generated = new ArrayList<Integer>();


        i = 0;
        for (int v : imageViews) {
            int next = random.nextInt(40)+1;;
            if (!generated.contains(next)) {
                generated.add(next);
                ImageView iv = (ImageView) findViewById(v);
                iv.setImageResource(image[next]);

                randomName[i] = next;
                i++;

                name1 = imageName[randomName[0]];
                name2 = imageName[randomName[1]];
                name3 = imageName[randomName[2]];
                name4 = imageName[randomName[3]];
                name5 = imageName[randomName[4]];
                name6 = imageName[randomName[5]];
                name7 = imageName[randomName[6]];

                textName1.setText(name1);
                textName2.setText(name2);
                textName3.setText(name3);
                textName4.setText(name4);
                textName5.setText(name5);
                textName6.setText(name6);

                Log.d("show", imageName[next]);


            }
        }

    }



}
