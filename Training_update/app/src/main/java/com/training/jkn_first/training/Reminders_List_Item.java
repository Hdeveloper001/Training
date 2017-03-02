package com.training.jkn_first.training;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * TODO: document your custom view class.
 */
public class Reminders_List_Item extends RelativeLayout {

    TextView date_text, day_text, year_text, age_text, title_text;
    View v;

    public Reminders_List_Item(Context context) {
        super(context);
        init(context);
    }

    public Reminders_List_Item(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.reminders_list_item, this, true);

        date_text = (TextView) v.findViewById(R.id.reminders_list_date_text);
        day_text = (TextView) v.findViewById(R.id.reminders_list_day_text);
        year_text = (TextView) v.findViewById(R.id.reminders_list_year_text);
        age_text = (TextView) v.findViewById(R.id.reminders_list_age_text);
        title_text = (TextView) v.findViewById(R.id.reminders_list_title_text);
    }

    public void setData(String[]str){
        date_text.setText(str[0]);
        day_text.setText(str[1]);
        year_text.setText(str[2]);
        age_text.setText(str[3]);
        title_text.setText(str[4]);
    }

}
