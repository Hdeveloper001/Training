package com.training.jkn_first.training;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Terms_Activity extends AppCompatActivity {

    Drawable background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        StringBuilder text = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(getApplicationContext().getAssets().open("term.txt")));
            String line;
            while ((line = br.readLine()) != null){
                text.append(line);
                text.append('\n');
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        TextView tv = (TextView) findViewById(R.id.term_text);
        tv.setText(text.toString());

        ImageButton term = (ImageButton) findViewById(R.id.term_button);
        term.setOnTouchListener(new View.OnTouchListener(){
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
                        finish();
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
