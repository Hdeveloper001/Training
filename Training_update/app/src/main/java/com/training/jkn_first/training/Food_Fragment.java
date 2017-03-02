package com.training.jkn_first.training;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class Food_Fragment extends Fragment {

    Drawable background;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_food, container, false);

        ImageButton button = (ImageButton)v.findViewById(R.id.food_button);
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

        ImageButton edit = (ImageButton)v.findViewById(R.id.food_edit_button);
        edit.setOnTouchListener(new View.OnTouchListener(){
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

                        break;
                    default:
                        b.setBackground(background);
                        break;
                }
                return false;
            }
        });

        SearchView search = (SearchView) v.findViewById(R.id.food_search);
        search.setQueryHint("Search");
        search.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View view, boolean b) {
                Toast.makeText(getContext(), "onFocusChange:->"+String.valueOf(b), Toast.LENGTH_LONG).show();
            }
        });
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(getContext(), "onQueryTextSubmit:->"+s, Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Toast.makeText(getContext(), "onQueryTextChange:->"+s, Toast.LENGTH_LONG).show();
                return false;
            }
        });

        String[][]str={{"76", "Banana, raw", "Fruit, fresh", "0g", "17g"},
                {"184", "Banana, bread", "Cakes", "7g", "26g"},
                {"156", "Banana, dried", "Fruit, dried", "10g", "18g"},
                {"15", "Banana & walnut bread", "Cakes", "13g", "56g"},
                {"76", "Peanut butter & banana", "Sandwich", "23g", "48g"}};
        BaseAdapter adapter = new MyAdapter(str);
        ListView list = (ListView) v.findViewById(R.id.food_list);
        list.setAdapter(adapter);
        return v;
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
            Food_List_Item item = new Food_List_Item(getContext());
            item.setData(data[i]);
            return item;
        }
    }
}
