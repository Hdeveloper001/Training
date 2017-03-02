package com.training.jkn_first.training;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class Progress_Data_Fragment extends Fragment {

    Drawable background;
    Button week, month, year;
    RelativeLayout step_contain, distance_contain, flights_contain;
    View v;
    int dark, bright;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_progress_data, container, false);
        ImageButton button = (ImageButton)v.findViewById(R.id.progress_button);
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

        double[]t={92, 91.5, 91.2, 91, 90.5, 91.5, 85, 70};
        double[]t1={3, 2, 4, 3.5, 3.2, 3.1, 3.5, 1.5};
        double[]t2={140, 130, 135, 120, 110, 130, 115, 105};
        double[]t3={110, 90, 95, 85, 90, 70, 85, 60};
        grid("week", t, t1, t2, t3);
        dark = Color.rgb(92,92,92);
        bright = Color.rgb(255,255,255);

        week = (Button) v.findViewById(R.id.progress_week_button);
        week.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                week.setBackgroundColor(dark); week.setTextColor(bright);
                month.setBackgroundColor(bright); month.setTextColor(dark);
                year.setBackgroundColor(bright); year.setTextColor(dark);
                double[]t={92, 91.5, 91.2, 91, 90.5, 91.5, 85, 70};
                double[]t1={3, 2, 4, 3.5, 3.2, 3.1, 3.5, 1.5};
                double[]t2={140, 130, 135, 120, 110, 130, 115, 105};
                double[]t3={110, 90, 95, 85, 90, 70, 85, 60};
                grid("week", t, t1, t2, t3);
            }
        });

        month = (Button) v.findViewById(R.id.progress_month_button);
        month.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                month.setBackgroundColor(dark); month.setTextColor(bright);
                week.setBackgroundColor(bright); week.setTextColor(dark);
                year.setBackgroundColor(bright); year.setTextColor(dark);
                double[]t={92, 91.5, 91.2, 91, 90.5, 91.5, 85,92, 91.5, 91.2, 91, 90.5, 91.5, 85,92, 91.5, 91.2, 91, 90.5, 91.5, 85,92, 91.5, 91.2, 91, 90.5, 91.5, 85, 90, 80, 85, 87.5};
                double[]t1={3, 2, 4, 3.5, 3.2, 3.1, 3.5, 3, 2, 4, 3.5, 3.2, 3.1, 3.5, 3, 2, 4, 3.5, 3.2, 3.1, 3.5, 3, 2, 4, 3.5, 3.2, 3.1, 3.5, 3, 4, 3.2, 3};
                double[]t2={140, 130, 135, 120, 110, 130, 115, 140, 130, 135, 120, 110, 130, 115, 140, 130, 135, 120, 110, 130, 115, 140, 130, 135, 120, 110, 130, 115, 140, 130, 135, 105};
                double[]t3={100, 90, 95, 80, 70, 90, 75, 100, 90, 95, 80, 70, 90, 75, 100, 90, 95, 80, 70, 90, 75, 100, 90, 95, 80, 70, 90, 75, 100, 90, 95, 70};
                grid("month", t, t1, t2, t3);
            }
        });

        year = (Button) v.findViewById(R.id.progress_year_button);
        year.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                year.setBackgroundColor(dark); year.setTextColor(bright);
                month.setBackgroundColor(bright); month.setTextColor(dark);
                week.setBackgroundColor(bright); week.setTextColor(dark);
                double[]t={92, 91.5, 91.2, 91, 90.5, 91.5, 85, 92, 91.5, 91.2, 91, 90.5, 87.5};
                double[]t1={3, 2, 4, 3.5, 3.2, 3.1, 3.5, 3, 2, 4, 3.5, 3.2, 3};
                double[]t2={140, 130, 135, 120, 110, 130, 115, 140, 130, 135, 120, 110, 105};
                double[]t3={100, 90, 95, 80, 70, 90, 75, 100, 90, 95, 80, 70, 70};
                grid("year", t, t1, t2, t3);
            }
        });

        return v;
    }

    void grid(String age, double[]weight, double[]cholesterol, double[]blood_high, double[]blood_low){
        step_contain = (RelativeLayout) v.findViewById(R.id.progress_weight_container);
        step_contain.removeAllViews();
        step_contain.addView(new CustomView(getContext(), age, "weight", weight));

        distance_contain = (RelativeLayout) v.findViewById(R.id.progress_cholesterol_container);
        distance_contain.removeAllViews();
        distance_contain.addView(new CustomView(getContext(), age, "cholesterol", cholesterol));

        flights_contain = (RelativeLayout) v.findViewById(R.id.progress_blood_container);
        flights_contain.removeAllViews();
        flights_contain.addView(new CustomView(getContext(), age, "blood", blood_high));
        flights_contain.addView(new CustomView(getContext(), age, "blood", blood_low));
    }

    public class CustomView extends View{

        Paint paint_line, paint_text, paint_grad, paint_graph, paint_back, paint_path;
        Bitmap mBitmap;
        Canvas mCanvas;
        float ymax, ymid;
        double dy, ndata[];
        int count;
        String str[];

        public CustomView(Context context, String age, String kinds, double[]data) {
            super(context);
            switch(age){
                case "week":
                    count = 7;
                    String[]str1 = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
                    str = str1;
                    break;
                case "month":
                    count = 31;
                    str = new String[count];
                    for(int i = 0; i < count; i++){
                        str[i] = "" + (i + 1);
                    }
                    break;
                case "year":
                    count = 12;
                    String[]str2 = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
                    str = str2;
                    break;
            }

            switch(kinds){
                case "weight":
                    dy = 3; ymax = 100; ymid = ymax/2;
                    break;
                case "cholesterol":
                    dy = 50; ymax = 6; ymid = ymax/2;
                    break;
                case "blood":
                    dy = 2; ymax = 150; ymid = ymax/2;
                    break;
            }
            ndata = data;
            /*(double min = data[0], max = data[0];
            for(int i = 0; i < data.length; i++){
                if(data[i] < min) min = data[i];
                if(data[i] > max) max = data[i];
            }
            for(int i = 0; i < data.length; i++){
                ndata[i] = data[i] - min;
            }
            dy = 300 / (max - min);*/
            init(context);
        }

        public CustomView(Context context, AttributeSet attrs) {
            super(context, attrs);
            init(context);
        }

        public void init(Context context){
            paint_line = new Paint();
            paint_line.setAntiAlias(true); paint_line.setColor(Color.rgb(148,148,148)); paint_line.setStrokeWidth(3);
            paint_text = new Paint();
            paint_text.setAntiAlias(true); paint_text.setColor(Color.rgb(67,67,67)); paint_text.setTextSize(40); paint_text.setFakeBoldText(true);
            paint_grad = new Paint();
            paint_grad.setAntiAlias(true); paint_grad.setColor(Color.rgb(133,205,236)); paint_grad.setStrokeWidth(1);
            paint_graph = new Paint();
            paint_graph.setAntiAlias(true); paint_graph.setColor(Color.rgb(13,163,227)); paint_graph.setStrokeWidth(6); paint_graph.setStyle(Paint.Style.STROKE);
            paint_back = new Paint();
            paint_back.setColor(Color.WHITE); paint_back.setStyle(Paint.Style.FILL);
            paint_path = new Paint();
            DashPathEffect effect = new DashPathEffect(new float[]{10,10}, 1);
            paint_path.setAntiAlias(true); paint_path.setColor(Color.rgb(13,163,227)); paint_path.setStrokeWidth(3); paint_path.setPathEffect(effect);

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
            int i;float height = 350, xo = 100, width = 1000, x = 0, y = 0;
            float goal = height - (float)(dy * ndata[count]);
            Path path = new Path();
            for(i = 0;i < count - 1; i++) {
                for (x = 0; x < width / count; x+=1) {
                    y = (float) (dy * (ndata[i] + (x * (ndata[i+1] - ndata[i]) / (width / count))));
                    LinearGradient gradient1 = new LinearGradient((float)(xo+ i * width / count + x), height - y, (float)(xo+ i * width / count + x), height, paint_grad.getColor(), Color.argb(255, 251, 251, 251), Shader.TileMode.CLAMP);
                    paint_grad.setShader(gradient1);
                    mCanvas.drawLine((float)(xo+ i * width / count + x), height - y, (float)(xo+ i * width / count + x), height, paint_grad);
                }
            }
            for(i = 0;i < count; i++){
                mCanvas.drawLine(xo+ i * width / count, 50, xo+ i * width / count, height, paint_line);
                mCanvas.drawText(str[i], 70 + i * width / count, height + 60, paint_text);
                mCanvas.drawCircle(xo+ i * width / count, (float)(height - ndata[i] * dy), 9, paint_graph);
                if(i > 0) mCanvas.drawLine(xo+ (i - 1) * width / count + 8, (float)(height - ndata[i-1] * dy), xo+ i * width / count - 8, (float)(height - ndata[i] * dy), paint_graph);
            }
            for(i = 0;i < count; i++){
                mCanvas.drawCircle(xo + i * width / count, (float)(height - ndata[i] * dy), 5, paint_back);
            }
            mCanvas.drawLine(0, height, 1100, height, paint_line);
            mCanvas.drawLine(100, goal, 1100, goal, paint_path);
            mCanvas.drawText(""+ymax,35,50,paint_text);
            mCanvas.drawText(""+ymid,35,height/2-50,paint_text);
            mCanvas.drawText("0",35,height,paint_text);
            mCanvas.drawText("GOAL",970,goal,paint_text);
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
