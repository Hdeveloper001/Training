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
import android.widget.TextView;

/**
 * TODO: document your custom view class.
 */
public class Food_List_Item extends RelativeLayout {

    TextView kcal_text, name_text, kind_text, fat_text, carbs_text;
    Drawable background;
    View v;

    public Food_List_Item(Context context) {
        super(context);
        init(context);
    }

    public Food_List_Item(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.food_list_item, this, true);

        kcal_text = (TextView) v.findViewById(R.id.food_list_kcal_text);
        name_text = (TextView) v.findViewById(R.id.food_list_name_text);
        kind_text = (TextView) v.findViewById(R.id.food_list_kind_text);
        fat_text = (TextView) v.findViewById(R.id.food_list_fat_text);
        carbs_text = (TextView) v.findViewById(R.id.food_list_carbs_text);

        ImageButton button = (ImageButton) v.findViewById(R.id.food_list_add_button);
        button.setOnTouchListener(new OnTouchListener() {
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
                        TextView text = (TextView) v.findViewById(R.id.food_list_kcal_text);
                        text.setText("Click");
                        break;
                    default:
                        b.setBackground(background);
                        break;
                }
                return false;
            }
        });
    }

    public void setData(String[]str){
        kcal_text.setText(str[0]);
        name_text.setText(str[1]);
        kind_text.setText(str[2]);
        fat_text.setText(str[3]);
        carbs_text.setText(str[4]);
    }

}
