package com.training.jkn_first.training;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class Units_Activity extends AppCompatActivity {

    Drawable background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units);

        ImageButton[]ib = new ImageButton[4];
        ib[0] = (ImageButton) findViewById(R.id.setting_unit_weight_button);
        ib[1] = (ImageButton) findViewById(R.id.setting_unit_distance_button);
        ib[2] = (ImageButton) findViewById(R.id.setting_unit_energy_button);
        ib[3] = (ImageButton) findViewById(R.id.units_button);

        for(int i = 0;i < 4 ;i ++){
            ib[i].setOnTouchListener(new View.OnTouchListener(){
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageButton bu = (ImageButton) view;
                    int event = motionEvent.getAction();
                    switch(event){
                        case 0:
                            background = bu.getBackground();
                            bu.setBackgroundColor(Color.rgb(221,221,221));
                            break;
                        case 1:
                            bu.setBackground(background);
                            process(bu.getId());
                            break;
                        default:
                            bu.setBackground(background);
                            break;
                    }
                    return false;
                }
            });
        }
    }

    private void process(int id){
        switch(id){
            case R.id.setting_unit_weight_button:
                startActivity(new Intent(getApplicationContext(), Weight_Activity.class));
                break;
            case R.id.setting_unit_distance_button:

                break;
            case R.id.setting_unit_energy_button:

                break;
            case R.id.units_button:
                finish();
                break;
        }
    }
}
