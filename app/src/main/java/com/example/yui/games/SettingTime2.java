package com.example.yui.games;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SettingTime2 extends AppCompatActivity {
    private RadioButton radio_time1;
    private RadioButton radio_time2;
    private RadioButton radio_time3;
    private RadioGroup radiogroup;
    private int selectTime;
    Button save;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_time);


        save = (Button) findViewById(R.id.buttonsave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                intent = new Intent(getApplication(), Game_Animal__9_picture.class);
                intent.putExtra("timeset",selectTime);
                startActivity(intent);

            }
        })
        ;





        //radio_time1.setChecked(true);

//        radio_time1 = (RadioButton) findViewById(R.id.radio_time1);
//        radio_time1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                 selectTime = 10;
//                 Toast.makeText(SettingTime.this, " 10.",
//                 Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
//
//        radio_time2 = (RadioButton) findViewById(R.id.radio_time2);
//        radio_time2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                selectTime = 15;
//                Toast.makeText(SettingTime.this, " 15.",
//                        Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
//
//        radio_time3 = (RadioButton) findViewById(R.id.radio_time3);
//        radio_time3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                selectTime = 20;
//                Toast.makeText(SettingTime.this, " 20.",
//                        Toast.LENGTH_SHORT).show();
//
//            }
//        });


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();



        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_time1:
                if (checked)
                  selectTime = 10000;
               // intent.putExtra("timeset",selectTime);
                Toast.makeText(SettingTime2.this, " 10.",
                Toast.LENGTH_SHORT).show();

                    // Pirates are the best
                    break;
            case R.id.radio_time2:
                if (checked)
                    selectTime = 15000;
            // intent.putExtra("timeset",selectTime);
                Toast.makeText(SettingTime2.this, " 15.",
                    Toast.LENGTH_SHORT).show();
                    // Ninjas rule
                    break;
            case   R.id.radio_time3:
                if (checked)
                    selectTime = 20000;
             //  intent.putExtra("timeset",selectTime);
                Toast.makeText(SettingTime2.this, " 20.",
                        Toast.LENGTH_SHORT).show();

                    // Ninjas rule
                    break;
            default:  selectTime = 10000 ;
                break;
        }
    }
}