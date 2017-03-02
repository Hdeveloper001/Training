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

public class Test_Data_Fragment extends Fragment {

    Drawable background;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_test_data, container, false);

        ImageButton[]ib = new ImageButton[20];
        ib[0] = (ImageButton) v.findViewById(R.id.test_cholesterol_delete_button);
        ib[1] = (ImageButton) v.findViewById(R.id.test_cholesterol_edit_button);
        ib[2] = (ImageButton) v.findViewById(R.id.test_cholesterol_add_button);
        ib[3] = (ImageButton) v.findViewById(R.id.test_cholesterol_previous_button);
        ib[4] = (ImageButton) v.findViewById(R.id.test_cholesterol_next_button);

        ib[5] = (ImageButton) v.findViewById(R.id.test_blood_delete_button);
        ib[6] = (ImageButton) v.findViewById(R.id.test_blood_edit_button);
        ib[7] = (ImageButton) v.findViewById(R.id.test_blood_add_button);
        ib[8] = (ImageButton) v.findViewById(R.id.test_blood_previous_button);
        ib[9] = (ImageButton) v.findViewById(R.id.test_blood_next_button);

        ib[10] = (ImageButton) v.findViewById(R.id.test_diabetes_delete_button);
        ib[11] = (ImageButton) v.findViewById(R.id.test_diabetes1_edit_button);
        ib[12] = (ImageButton) v.findViewById(R.id.test_diabetes2_edit_button);
        ib[13] = (ImageButton) v.findViewById(R.id.test_diabetes1_add_button);
        ib[14] = (ImageButton) v.findViewById(R.id.test_diabetes2_add_button);
        ib[15] = (ImageButton) v.findViewById(R.id.test_diabetes1_previous_button);
        ib[16] = (ImageButton) v.findViewById(R.id.test_diabetes2_previous_button);
        ib[17] = (ImageButton) v.findViewById(R.id.test_diabetes1_next_button);
        ib[18] = (ImageButton) v.findViewById(R.id.test_diabetes2_next_button);

        ib[19] = (ImageButton) v.findViewById(R.id.test_button);

        for(int i = 0;i < 20 ;i ++){
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

    private void process(int id){
        switch(id){
            case R.id.test_cholesterol_delete_button:

                break;
            case R.id.test_cholesterol_edit_button:

                break;
            case R.id.test_cholesterol_add_button:

                break;
            case R.id.test_cholesterol_previous_button:

                break;
            case R.id.test_cholesterol_next_button:

                break;
            case R.id.test_blood_delete_button:

                break;
            case R.id.test_blood_edit_button:

                break;
            case R.id.test_blood_add_button:

                break;
            case R.id.test_blood_previous_button:

                break;
            case R.id.test_blood_next_button:

                break;
            case R.id.test_diabetes_delete_button:

                break;
            case R.id.test_diabetes1_edit_button:

                break;
            case R.id.test_diabetes2_edit_button:

                break;
            case R.id.test_diabetes1_add_button:

                break;
            case R.id.test_diabetes2_add_button:

                break;
            case R.id.test_diabetes1_previous_button:

                break;
            case R.id.test_diabetes2_previous_button:

                break;
            case R.id.test_diabetes1_next_button:

                break;
            case R.id.test_diabetes2_next_button:

                break;
            case R.id.test_button:
                Main_Activity.click();
                break;
        }
    }
}
