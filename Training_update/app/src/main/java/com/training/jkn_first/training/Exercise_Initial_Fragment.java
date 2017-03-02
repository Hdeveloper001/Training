package com.training.jkn_first.training;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class Exercise_Initial_Fragment extends Fragment {

    Drawable background;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_exercise_initial, container, false);

        ImageButton button = (ImageButton)v.findViewById(R.id.exercise_button);
        button.setOnTouchListener(new View.OnTouchListener(){
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ImageButton b = (ImageButton) view;
                int event = motionEvent.getAction();
                switch(event){
                    case 0:
                        background = b.getBackground();
                        b.setBackground(null);
                        break;
                    case 1:
                        b.setBackground(background);
                        Main_Activity.click();
                        break;
                    default:
                        b.setBackground(background);
                        break;
                }
                return false;
            }
        });

        ImageButton init = (ImageButton) v.findViewById(R.id.exercise_initial_button);
        init.setOnTouchListener(new View.OnTouchListener(){
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ImageButton b = (ImageButton) view;
                int event = motionEvent.getAction();
                switch(event){
                    case 0:
                        background = b.getBackground();
                        b.setBackgroundColor(Color.rgb(221,221,221));
                        break;
                    case 1:
                        b.setBackground(background);
                        click();
                        break;
                    default:
                        b.setBackground(background);
                        break;
                }
                return false;
            }
        });

        return v;
    }

    void click(){
        getFragmentManager().beginTransaction().replace(R.id.main, new Exercise_Data_Fragment()).commit();
    }
}
