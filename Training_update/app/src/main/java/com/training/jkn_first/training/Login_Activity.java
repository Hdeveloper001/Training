package com.training.jkn_first.training;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class Login_Activity extends AppCompatActivity {

    Drawable background;
    static EditText username,password;
    String user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //startActivity(new Intent(getBaseContext(), Terms_Activity.class));
        username = (EditText) findViewById(R.id.login_username);
        password = (EditText) findViewById(R.id.login_password);

        ImageButton[] ib = new ImageButton[3];
        ib[0] = (ImageButton) findViewById(R.id.login_button);
        ib[1] = (ImageButton) findViewById(R.id.login_privacy);
        ib[2] = (ImageButton) findViewById(R.id.login_terms);

        for (int i = 0; i < 3; i++) {
            ib[i].setOnTouchListener(new View.OnTouchListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageButton b = (ImageButton) view;
                    int event = motionEvent.getAction();
                    switch (event) {
                        case 0:
                            background = b.getBackground();
                            /*switch (b.getId()){
                                case R.id.login_button:
                                    b.setBackground(null);
                                    break;
                                default:
                                    b.setBackgroundColor(Color.rgb(90,150,90));
                                    break;
                            }*/
                            b.setBackgroundColor(Color.rgb(221,221,221));
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
    }

    void process(int id){
        switch (id){
            case R.id.login_button:
                user = username.getText().toString();
                pass = password.getText().toString();
                if(!user.equals("") && !pass.equals("")){
                    startActivity(new Intent(getBaseContext(), Main_Activity.class));
                }
                break;
            case R.id.login_terms:
                startActivity(new Intent(getBaseContext(), Terms_Activity.class));
                break;
            case R.id.login_privacy:

                break;
        }
    }

    public static void clear(){
        username.setText("");
        password.setText("");
    }
}
