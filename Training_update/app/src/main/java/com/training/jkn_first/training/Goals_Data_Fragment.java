package com.training.jkn_first.training;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class Goals_Data_Fragment extends Fragment {

    Drawable background;
    EditText weight_text, blood_text;
    View v;
    RelativeLayout weight_contain, blood_contain;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_goals_data, container, false);

        weight_text = (EditText)v.findViewById(R.id.weight_edit_text);
        weight_contain = (RelativeLayout) v.findViewById(R.id.weight_container);
        weight_contain.removeAllViews();
        weight_contain.addView(new CustomView(getContext(), (float)92.5, (float)85, (float) 91.5));

        blood_text = (EditText)v.findViewById(R.id.blood_edit_text);
        blood_contain = (RelativeLayout) v.findViewById(R.id.blood_container);
        blood_contain.removeAllViews();
        blood_contain.addView(new CustomView(getContext(), 134, 95, 120, 80, 130, 90));

        ImageButton[]ib = new ImageButton[7];
        ib[0] = (ImageButton) v.findViewById(R.id.goals_button);
        ib[1] = (ImageButton) v.findViewById(R.id.weight_delete_button);
        ib[2] = (ImageButton) v.findViewById(R.id.weight_edit_button);
        ib[3] = (ImageButton) v.findViewById(R.id.cholesterol_delete_button);
        ib[4] = (ImageButton) v.findViewById(R.id.cholesterol_edit_button);
        ib[5] = (ImageButton) v.findViewById(R.id.blood_delete_button);
        ib[6] = (ImageButton) v.findViewById(R.id.blood_edit_button);

        for(int i = 0; i < ib.length; i++){
            ib[i].setOnTouchListener(new View.OnTouchListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageButton b = (ImageButton) view;
                    int event = motionEvent.getAction();
                    switch(event){
                        case 0:
                            background = b.getBackground();
                            switch (b.getId()){
                                case R.id.goals_button:
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
            case R.id.goals_button:
                Main_Activity.click();
                break;
            case R.id.weight_delete_button:
                weight_text.setText("");
                break;
            case R.id.weight_edit_button:
                if(weight_text.isEnabled() && !weight_text.getText().toString().equals("")){
                    weight_text.setEnabled(false);
                    weight_contain.removeAllViews();
                    weight_contain.addView(new CustomView(getContext(), (float)92.5, (float) 85, Float.valueOf(weight_text.getText().toString()).floatValue()));
                }else if(!weight_text.isEnabled()){
                    weight_text.setEnabled(true);
                }
                break;
            case R.id.cholesterol_delete_button:

                break;
            case R.id.cholesterol_edit_button:

                break;
            case R.id.blood_delete_button:
                blood_text.setText("");
                break;
            case R.id.blood_edit_button:
                if(blood_text.isEnabled() && !blood_text.getText().toString().equals("")){
                    blood_text.setEnabled(false);
                    blood_contain.removeAllViews();
                    float n1 = Float.valueOf(blood_text.getText().toString().substring(blood_text.getText().toString().length()-2,blood_text.getText().toString().length())).floatValue(),
                            n2 = Float.valueOf(blood_text.getText().toString().substring(0,blood_text.getText().toString().length()-3)).floatValue();
                    blood_contain.addView(new CustomView(getContext(), 134, 95, 120, 80, n2, n1));
                }else if(!blood_text.isEnabled()){
                    blood_text.setEnabled(true);
                }
                break;
        }
    }

    public class CustomView extends View{

        Paint paint_line, paint_text, paint_grad, paint_graph, paint_back;
        Bitmap mBitmap;
        Canvas mCanvas;
        float nstart, nend, ntarget;
        float dy;
        String str0, str1;

        public CustomView(Context context, float start, float end, float target) {
            super(context);
            nstart = start; nend = end; ntarget = target;
            str0 = "" + start;
            str1 = "" + end;
            dy = 15;
            init(context);
        }

        public CustomView(Context context,  float start1, float start2, float end1, float end2, float target1, float target2) {
            super(context);
            nstart = (start1 + start2) / 2; nend = (end1 + end2) / 2; ntarget = (target1 + target2) / 2;
            str0 = (int)start1 + "/" + (int)start2;
            str1 = (int)end1 + "/" + (int)end2;
            dy = 10;
            init(context);
        }

        public CustomView(Context context, AttributeSet attrs) {
            super(context, attrs);
            init(context);
        }

        public void init(Context context){
            paint_text = new Paint();
            paint_text.setAntiAlias(true); paint_text.setColor(Color.rgb(67,67,67)); paint_text.setTextSize(35);
            paint_grad = new Paint();
            paint_grad.setAntiAlias(true); paint_grad.setColor(Color.rgb(133,205,236)); paint_grad.setStrokeWidth(1);
            paint_graph = new Paint();
            paint_graph.setAntiAlias(true); paint_graph.setColor(Color.rgb(13,163,227)); paint_graph.setStrokeWidth(3); paint_graph.setStyle(Paint.Style.STROKE);
            paint_back = new Paint();
            paint_back.setColor(Color.WHITE); paint_back.setStyle(Paint.Style.FILL);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            if(w > 0 && h > 0){
                mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
                mCanvas = new Canvas(mBitmap);
                draw();
            }
            super.onSizeChanged(w, h, oldw, oldh);
        }

        public void draw(){
            /*
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.BLACK);
            mCanvas.drawRect(100,100,200,200,paint);

            paint.setStyle(Paint.Style.STROKE);
            paint.setARGB(125,0,255,0);
            mCanvas.drawRect(300,300,400,400,paint);

            DashPathEffect effect = new DashPathEffect(new float[]{10,10}, 1);
            paint.setPathEffect(effect);
            paint.setColor(Color.BLUE);
            mCanvas.drawLine(300,100,400,400,paint);

            LinearGradient gradient1 = new LinearGradient(0,0,0,200,Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
            paint.setPathEffect(null);
            paint.setStyle(Paint.Style.FILL);
            paint.setShader(gradient1);
            mCanvas.drawRect(100,10,300,300,paint);

            Bitmap picture = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.login_login);
            mCanvas.drawBitmap(picture, 0, 0, paint);

            Matrix matrix = new Matrix();
            matrix.setScale(1, -1);
            Bitmap picture1 = Bitmap.createBitmap(picture, 0 , 0, picture.getWidth(), picture.getHeight(), matrix, false);
            mCanvas.drawBitmap(picture1, 50, 0, paint);
            */

            int get=0;
            float height = 200, width = 1100;
            for(float x = 0; x < 1100; x ++){
                float y = x * dy * (nstart - nend) / width;
                LinearGradient gradient1 = new LinearGradient(x, y, x, height-20, paint_grad.getColor(), Color.argb(255, 255, 255, 255), Shader.TileMode.CLAMP);
                if(y- dy * (nstart - ntarget) < 0){
                    paint_grad.setShader(null);
                } else{
                    if(get == 0){
                        get = (int)x - 5;
                        mCanvas.drawLine(get, y, get, height, paint_graph);
                    }
                    paint_grad.setShader(gradient1);
                }
                mCanvas.drawLine(x, y, x, height - 20, paint_grad);
            }
            mCanvas.drawLine(0, height - 20, 1100, height - 20, paint_graph);

            mCanvas.drawText("START",30,height/2,paint_text);
            mCanvas.drawText("GOAL",920,height/2,paint_text);
            paint_text.setTextSize(75);
            mCanvas.drawText(str0,30,height-30,paint_text);
            mCanvas.drawText(str1,1100-str1.length()*54,height-30,paint_text);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            if(mBitmap != null){
                canvas.drawBitmap(mBitmap,0,0,null);
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            return super.onTouchEvent(event);
        }
    }
}
