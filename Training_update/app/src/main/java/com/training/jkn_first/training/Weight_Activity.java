package com.training.jkn_first.training;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class Weight_Activity extends AppCompatActivity {

    Drawable background;
    ImageButton[]ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        ib = new ImageButton[5];
        ib[0] = (ImageButton) findViewById(R.id.setting_unit_escape_button);
        ib[1] = (ImageButton) findViewById(R.id.unit_weight_kilo_button);
        ib[2] = (ImageButton) findViewById(R.id.unit_weight_pond_button);
        ib[3] = (ImageButton) findViewById(R.id.unit_weight_kilo_check);
        ib[4] = (ImageButton) findViewById(R.id.unit_weight_pond_check);

        for(int i = 0;i < ib.length ;i ++){
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
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void process(int id){
        switch(id){
            case R.id.setting_unit_escape_button:
                finish();
                break;
            case R.id.unit_weight_kilo_button:
                ib[3].setBackground(getResources().getDrawable(R.drawable.unit_check));
                ib[4].setBackground(null);
                break;
            case R.id.unit_weight_kilo_check:
                ib[3].setBackground(getResources().getDrawable(R.drawable.unit_check));
                ib[4].setBackground(null);
                break;
            case R.id.unit_weight_pond_button:
                ib[4].setBackground(getResources().getDrawable(R.drawable.unit_check));
                ib[3].setBackground(null);
                break;
            case R.id.unit_weight_pond_check:
                ib[4].setBackground(getResources().getDrawable(R.drawable.unit_check));
                ib[3].setBackground(null);
                break;
        }
    }
}
