package com.training.jkn_first.training;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Main_Activity extends AppCompatActivity {

    public static LinearLayout main_layout;
    public static ScrollView slide_layout;
    public static Animation slide_left, slide_right, main_left, main_right;
    public static boolean flag;
    public static AlertDialog alertDialog;

    Drawable background;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.main, new Goals_Initial_Fragment()).commit();

        ImageButton[]ib=new ImageButton[7];
        ib[0] = (ImageButton) findViewById(R.id.slide_goals);
        ib[1] = (ImageButton) findViewById(R.id.slide_exercise);
        ib[2] = (ImageButton) findViewById(R.id.slide_food);
        ib[3] = (ImageButton) findViewById(R.id.slide_progress);
        ib[4] = (ImageButton) findViewById(R.id.slide_reminders);
        ib[5] = (ImageButton) findViewById(R.id.slide_testresults);
        ib[6] = (ImageButton) findViewById(R.id.slide_settings);
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

        slide_left = AnimationUtils.loadAnimation(this, R.anim.slide_left);
        slide_right = AnimationUtils.loadAnimation(this, R.anim.slide_right);
        main_left = AnimationUtils.loadAnimation(this, R.anim.main_left);
        main_right = AnimationUtils.loadAnimation(this, R.anim.main_right);

        flag = true;

        /*Slide_Event
        slide_left.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });*/

        slide_layout = (ScrollView) findViewById(R.id.slide);
        main_layout = (LinearLayout) findViewById(R.id.main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        alertDialog = new AlertDialog.Builder(Main_Activity.this).create();
        alertDialog.setView((View)new Alert_View(this.getApplicationContext()));
        //alertDialog.setContentView((View)new Alert_View(this.getApplicationContext()), new RelativeLayout.LayoutParams(null));
        //alertDialog.show();

    }

    private void process(int id){
        switch(id){
            case R.id.slide_goals:
                getSupportFragmentManager().beginTransaction().replace(R.id.main, new Goals_Initial_Fragment()).commit();
                break;
            case R.id.slide_exercise:
                getSupportFragmentManager().beginTransaction().replace(R.id.main, new Exercise_Initial_Fragment()).commit();
                break;
            case R.id.slide_food:
                getSupportFragmentManager().beginTransaction().replace(R.id.main, new Food_Fragment()).commit();
                break;
            case R.id.slide_progress:
                getSupportFragmentManager().beginTransaction().replace(R.id.main, new Progress_Initial_Fragment()).commit();
                break;
            case R.id.slide_reminders:
                getSupportFragmentManager().beginTransaction().replace(R.id.main, new Reminders_Initial_Fragment()).commit();
                break;
            case R.id.slide_testresults:
                getSupportFragmentManager().beginTransaction().replace(R.id.main, new Test_Initial_Fragment()).commit();
                break;
            case R.id.slide_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.main, new Setting_Data_Fragment()).commit();
                break;
        }
        left();
    }

    public static void click() {
        if (flag) {
            right();
        } else if (!flag) {
            left();
        }
    }

    public static void right() {
        slide_layout.startAnimation(slide_right);
        main_layout.startAnimation(main_right);
        slide_layout.bringToFront();
        flag = !flag;
    }

    public static void left() {
        slide_layout.startAnimation(slide_left);
        main_layout.startAnimation(main_left);
        main_layout.bringToFront();
        flag = !flag;
        slide_layout.setScrollY(0);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main_ Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.training.jkn_first.training/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main_ Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.training.jkn_first.training/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
