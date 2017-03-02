package com.training.jkn_first.training;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

/**
 * Created by JKN-Mac on 8/27/16.
 */
public class Alert_View extends RelativeLayout {

    Drawable background;
    RelativeLayout disp;
    public static String state;
    public static int first, second, third;
    ImageButton[]ib;

    public Alert_View(Context context) {
        super(context);
        init(context);
    }

    public Alert_View(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.alert_view, this, true);

        disp = (RelativeLayout) findViewById(R.id.disp);
        state = "start";
        first = second = third = 3;

        ib=new ImageButton[7];
        ib[0] = (ImageButton) findViewById(R.id.survey_button);
        ib[1] = (ImageButton) findViewById(R.id.survey_button_0);
        ib[2] = (ImageButton) findViewById(R.id.survey_button_1);
        ib[3] = (ImageButton) findViewById(R.id.survey_button_2);
        ib[4] = (ImageButton) findViewById(R.id.survey_button_3);
        ib[5] = (ImageButton) findViewById(R.id.survey_button_4);
        ib[6] = (ImageButton) findViewById(R.id.survey_button_5);
        for(int i = 0;i < 7; i++) {
            ib[i].setOnTouchListener(new View.OnTouchListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageButton b = (ImageButton)view;
                    int event = motionEvent.getAction();
                    switch (event) {
                        case 0:
                            background = b.getBackground();
                            b.setBackground(null);
                            break;
                        case 1:
                            b.setBackground(background);
                            process(b.getId());
                            break;
                        default:
                            b.setBackground(background);
                            break;
                    }
                    return false;
                }
            });
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void process(int id){
        ImageButton b = (ImageButton) findViewById(R.id.survey_button);
        RelativeLayout l = (RelativeLayout) findViewById(R.id.survey_button_group);
        switch(id){
            case R.id.survey_button:
                switch (state){
                    case "start":
                        disp.setBackground(getResources().getDrawable(R.drawable.survey_text_1));
                        b.setBackground(getResources().getDrawable(R.drawable.survey_button_next));
                        l.setVisibility(View.VISIBLE);
                        state = "1/3";
                        break;
                    case "1/3":
                        disp.setBackground(getResources().getDrawable(R.drawable.survey_text_2));
                        state = "2/3";
                        break;
                    case "2/3":
                        disp.setBackground(getResources().getDrawable(R.drawable.survey_text_3));
                        state = "3/3";
                        break;
                    case "3/3":
                        disp.setBackground(getResources().getDrawable(R.drawable.survey_text_4));
                        b.setVisibility(View.INVISIBLE);
                        l.setVisibility(View.INVISIBLE);
                        state = "thank";
                        clear_button();
                        break;
                    case "thank":
                        state = "start";
                        clear_button();
                        break;
                }
                //disp.setBackground(getResources().getDrawable(survey_0));
                break;
            case R.id.survey_button_0:
                set_state(1);
                break;
            case R.id.survey_button_1:
                set_state(2);
                break;
            case R.id.survey_button_2:
                set_state(3);
                break;
            case R.id.survey_button_3:
                set_state(4);
                break;
            case R.id.survey_button_4:
                set_state(5);
                break;
            case R.id.survey_button_5:
                Main_Activity.alertDialog.dismiss();
                break;
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    void set_state(int sel){
        switch (state){
            case "1/3":
                first = sel;
                clear_button();
                ib[sel].setBackground(getResources().getDrawable(R.drawable.survey_ling));
                break;
            case "2/3":
                second = sel;
                clear_button();
                ib[sel].setBackground(getResources().getDrawable(R.drawable.survey_ling));
                break;
            case "3/3":
                third = sel;
                clear_button();
                ib[sel].setBackground(getResources().getDrawable(R.drawable.survey_ling));
                break;
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    void clear_button(){
        for(int i = 1; i < 6; i++) ib[i].setBackground(null);
    }
}
