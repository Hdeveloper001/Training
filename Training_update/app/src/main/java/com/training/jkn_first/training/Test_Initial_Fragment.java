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

public class Test_Initial_Fragment extends Fragment {

    Drawable background;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_test_initial, container, false);

        ImageButton[]ib = new ImageButton[4];
        ib[0] = (ImageButton)v.findViewById(R.id.test_button);
        ib[1] = (ImageButton)v.findViewById(R.id.test_cholesterol_button);
        ib[2] = (ImageButton)v.findViewById(R.id.test_blood_button);
        ib[3] = (ImageButton)v.findViewById(R.id.test_diabetes_button);

        for(int i = 0; i < 4; i++){
            ib[i].setOnTouchListener(new View.OnTouchListener(){
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageButton b = (ImageButton) view;
                    int event = motionEvent.getAction();
                    switch(event){
                        case 0:
                            background = b.getBackground();
                            switch (b.getId()){
                                case R.id.test_button:
                                    b.setBackground(null);
                                    break;
                                default:
                                    b.setBackgroundColor(Color.rgb(221,221,221));
                                    break;
                            }
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
        return v;
    }

    void process(int id){
        switch (id){
            case R.id.test_button:
                Main_Activity.click();
                break;
            default:
                getFragmentManager().beginTransaction().replace(R.id.main, new Test_Data_Fragment()).commit();
                break;
        }
    }
}
