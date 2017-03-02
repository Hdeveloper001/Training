package com.training.jkn_first.training;

import android.annotation.TargetApi;
import android.content.Intent;
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

public class Setting_Data_Fragment extends Fragment {

    Drawable background;
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_setting_data, container, false);

        ImageButton[]ib = new ImageButton[7];
        ib[0] = (ImageButton) v.findViewById(R.id.setting_id_button);
        ib[1] = (ImageButton) v.findViewById(R.id.setting_unit_button);
        ib[2] = (ImageButton) v.findViewById(R.id.setting_help_button);
        ib[3] = (ImageButton) v.findViewById(R.id.setting_term_button);
        ib[4] = (ImageButton) v.findViewById(R.id.setting_policy_button);
        ib[5] = (ImageButton) v.findViewById(R.id.setting_logout_button);
        ib[6] = (ImageButton) v.findViewById(R.id.setting_button);

        for(int i = 0;i < 7 ;i ++){
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
                                case R.id.setting_button:
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
            case R.id.setting_id_button:

                break;
            case R.id.setting_unit_button:
                startActivity(new Intent(getContext(), Units_Activity.class));
                break;
            case R.id.setting_help_button:

                break;
            case R.id.setting_term_button:
                startActivity(new Intent(getContext(), Terms_Activity.class));
                break;
            case R.id.setting_policy_button:

                break;
            case R.id.setting_logout_button:
                Login_Activity.clear();
                getActivity().finish();
                break;
            case R.id.setting_button:
                Main_Activity.click();
                break;
        }
    }
}
