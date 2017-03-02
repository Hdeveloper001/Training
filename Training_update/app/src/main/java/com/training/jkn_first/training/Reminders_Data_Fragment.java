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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class Reminders_Data_Fragment extends Fragment {

    Drawable background;
    Button week, month, year;
    View v;
    int dark, bright;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_reminders_data, container, false);

        ImageButton[]ib = new ImageButton[2];
        ib[0] = (ImageButton)v.findViewById(R.id.reminders_button);
        ib[1] = (ImageButton)v.findViewById(R.id.reminders_add_button);

        for(int i = 0; i < 2; i++){
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
                                case R.id.reminders_button:
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

        dark = Color.rgb(92,92,92);
        bright = Color.rgb(255,255,255);

        week = (Button) v.findViewById(R.id.reminders_week_button);
        week.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                week.setBackgroundColor(dark); week.setTextColor(bright);
                month.setBackgroundColor(bright); month.setTextColor(dark);
                year.setBackgroundColor(bright); year.setTextColor(dark);
                String[][]str={{"24", "September", "2015", "Wednesday 10:00am", "My next doctor's appointment"},
                        {"8", "October", "2015", "Tuesday 4:30pm", "Renew my prescription"},
                        {"12", "October", "2015", "Friday 12:00pm", "Scan"}};
                grid("week", str);
            }
        });

        month = (Button) v.findViewById(R.id.reminders_month_button);
        month.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                month.setBackgroundColor(dark); month.setTextColor(bright);
                week.setBackgroundColor(bright); week.setTextColor(dark);
                year.setBackgroundColor(bright); year.setTextColor(dark);
                String[][]str={{"24", "September", "2015", "Wednesday 10:00am", "My next doctor's appointment"},
                        {"8", "October", "2015", "Tuesday 4:30pm", "Renew my prescription"},
                        {"12", "October", "2015", "Friday 12:00pm", "Scan"},
                        {"24", "September", "2015", "Wednesday 10:00am", "My next doctor's appointment"},
                        {"8", "October", "2015", "Tuesday 4:30pm", "Renew my prescription"},
                        {"12", "October", "2015", "Friday 12:00pm", "Scan"}};
                grid("month", str);
            }
        });

        year = (Button) v.findViewById(R.id.reminders_year_button);
        year.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                year.setBackgroundColor(dark); year.setTextColor(bright);
                month.setBackgroundColor(bright); month.setTextColor(dark);
                week.setBackgroundColor(bright); week.setTextColor(dark);
                String[][]str={{"24", "September", "2015", "Wednesday 10:00am", "My next doctor's appointment"},
                        {"8", "October", "2015", "Tuesday 4:30pm", "Renew my prescription"},
                        {"12", "October", "2015", "Friday 12:00pm", "Scan"},
                        {"24", "September", "2015", "Wednesday 10:00am", "My next doctor's appointment"},
                        {"8", "October", "2015", "Tuesday 4:30pm", "Renew my prescription"},
                        {"12", "October", "2015", "Friday 12:00pm", "Scan"},
                        {"24", "September", "2015", "Wednesday 10:00am", "My next doctor's appointment"},
                        {"8", "October", "2015", "Tuesday 4:30pm", "Renew my prescription"},
                        {"12", "October", "2015", "Friday 12:00pm", "Scan"}};
                grid("year", str);
            }
        });

        String[][]str={{"24", "September", "2015", "Wednesday 10:00am", "My next doctor's appointment"},
                {"8", "October", "2015", "Tuesday 4:30pm", "Renew my prescription"},
                {"12", "October", "2015", "Friday 12:00pm", "Scan"}};
        grid("week", str);

        return v;
    }

    void process(int id){
        switch (id){
            case R.id.reminders_button:
                Main_Activity.click();
                break;
            default:

                break;
        }
    }

    private void grid(String age, String[][]str){
        BaseAdapter adapter = new MyAdapter(str);
        ListView list = (ListView) v.findViewById(R.id.reminders_list);
        list.setAdapter(adapter);
    }

    private class MyAdapter extends BaseAdapter {
        String[][]data;
        public MyAdapter(String[][]str) {
            data = str;
        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int i) {
            return data[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Reminders_List_Item item = new Reminders_List_Item(getContext());
            item.setData(data[i]);
            return item;
        }
    }
}
