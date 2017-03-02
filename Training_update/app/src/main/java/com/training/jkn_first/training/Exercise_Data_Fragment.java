package com.training.jkn_first.training;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
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

public class Exercise_Data_Fragment extends Fragment {

    Drawable background;
    RelativeLayout step_contain, distance_contain, flights_contain;
    View v;
    Button week, month, year;
    int dark, bright;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_exercise_data, container, false);
        ImageButton button = (ImageButton)v.findViewById(R.id.exercise_button);
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

        ImageButton sync = (ImageButton) v.findViewById(R.id.exercise_sync_button);
        sync.setOnTouchListener(new View.OnTouchListener(){
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ImageButton b = (ImageButton) view;
                int event = motionEvent.getAction();
                switch(event){
                    case 0:
                        background = b.getBackground();
                        b.setBackgroundColor(Color.rgb(221,221,221));
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

        double[]t={4000, 3000, 6000, 4500, 7000, 2000, 3000};
        double[]t1={3, 2, 4, 3.5, 3.2, 3.1, 3,5};
        double[]t2={10, 3, 8, 3, 9, 7, 2};
        grid("week", t, t1, t2);
        dark = Color.rgb(92,92,92);
        bright = Color.rgb(255,255,255);

        week = (Button) v.findViewById(R.id.exercise_week_button);
        week.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                week.setBackgroundColor(dark); week.setTextColor(bright);
                month.setBackgroundColor(bright); month.setTextColor(dark);
                year.setBackgroundColor(bright); year.setTextColor(dark);
                double[]t={4000, 3000, 6000, 4500, 7000, 2000, 3000};
                double[]t1={3, 2, 4, 3.5, 3.2, 3.1, 3,5};
                double[]t2={10, 3, 8, 3, 9, 7, 2};
                grid("week", t, t1, t2);
            }
        });

        month = (Button) v.findViewById(R.id.exercise_month_button);
        month.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                month.setBackgroundColor(dark); month.setTextColor(bright);
                week.setBackgroundColor(bright); week.setTextColor(dark);
                year.setBackgroundColor(bright); year.setTextColor(dark);
                double[]t={5000, 6500, 7200, 3700, 4900, 4000, 3000, 6000, 4500, 7000, 2000, 3000, 7200, 3700, 4900, 4000, 3000, 6000, 4500, 7000, 2000, 3000, 7200, 3700, 4900, 4000, 3000, 6000, 4500, 7000, 2000};
                double[]t1={2, 4, 3.9, 6.8, 4, 3, 2, 4, 3.5, 3.2, 3.1, 3,5, 3.9, 6.8, 4, 3, 2, 4, 3.5, 3.2, 3.1, 3,5, 3.9, 6.8, 4, 3, 2, 4, 3.5, 3.2, 3.1};
                double[]t2={5, 6, 4, 7, 9, 10, 3, 8, 3, 9, 7, 2, 4, 7, 9, 10, 3, 8, 3, 9, 7, 2, 4, 7, 9, 10, 3, 8, 3, 9, 7};
                grid("month", t, t1, t2);
            }
        });

        year = (Button) v.findViewById(R.id.exercise_year_button);
        year.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                year.setBackgroundColor(dark); year.setTextColor(bright);
                month.setBackgroundColor(bright); month.setTextColor(dark);
                week.setBackgroundColor(bright); week.setTextColor(dark);
                double[]t={5000, 6500, 7200, 3700, 4900, 4000, 3000, 6000, 4500, 7000, 2000, 3000};
                double[]t1={2, 4, 3.9, 6.8, 4, 3, 2, 4, 3.5, 3.2, 3.1, 3,5};
                double[]t2={5, 6, 4, 7, 9, 10, 3, 8, 3, 9, 7, 2};
                grid("year", t, t1, t2);
            }
        });

        return v;
    }

    void grid(String age, double[]step, double[]distance, double[]flights){
        step_contain = (RelativeLayout) v.findViewById(R.id.exercise_step_container);
        step_contain.removeAllViews();
        step_contain.addView(new CustomView(getContext(), age, "step", step));

        distance_contain = (RelativeLayout) v.findViewById(R.id.exercise_distance_container);
        distance_contain.removeAllViews();
        distance_contain.addView(new CustomView(getContext(), age, "distance", distance));

        flights_contain = (RelativeLayout) v.findViewById(R.id.exercise_flights_container);
        flights_contain.removeAllViews();
        flights_contain.addView(new CustomView(getContext(), age, "flights", flights));
    }

    public class CustomView extends View{

        Paint paint_line, paint_text, paint_grad, paint_graph, paint_back;
        Bitmap mBitmap;
        Canvas mCanvas;
        int ymax, ymid;
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
                case "step":
                    dy = 0.042; ymax = 10000; ymid = 5000;
                    break;
                case "distance":
                    dy = 52; ymax = 8; ymid = 4;
                    break;
                case "flights":
                    dy = 35; ymax = 12; ymid = 6;
                    break;
            }
            ndata = data;
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
                paint_text.setAntiAlias(true); paint_text.setColor(Color.rgb(67,67,67)); paint_text.setTextSize(45);
            paint_grad = new Paint();
                paint_grad.setAntiAlias(true); paint_grad.setColor(Color.rgb(133,205,236)); paint_grad.setStrokeWidth(1);
            paint_graph = new Paint();
                paint_graph.setAntiAlias(true); paint_graph.setColor(Color.rgb(13,163,227)); paint_graph.setStrokeWidth(6); paint_graph.setStyle(Paint.Style.STROKE);
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
            int i; double x = 0; float y = 0, height = 350, xo = 100, width = 1000;
            Path path = new Path();
            for(i = 0;i < count - 1; i++) {
                for (x = 0; x < width / count; x+=1) {
                    y = (float) (dy * (ndata[i] + (x * (ndata[i+1] - ndata[i]) / (width / count))));
                    LinearGradient gradient1 = new LinearGradient((float)(xo + i * width / count + x), height - y, (float)(xo + i * width / count + x), height, paint_grad.getColor(), Color.argb(255, 255, 255, 255), Shader.TileMode.CLAMP);
                    paint_grad.setShader(gradient1);
                    mCanvas.drawLine((float)(xo + i * width / count + x), height - y, (float)(xo + i * width / count + x), height, paint_grad);
                }
            }
            for(i = 0;i < count; i++){
                mCanvas.drawLine(xo + i * width / count, 50, xo + i * width / count, height, paint_line);
                mCanvas.drawText(str[i], 70 + i * width / count, height + 60, paint_text);
                mCanvas.drawCircle(xo + i * width / count, (float)(height - ndata[i] * dy), 9, paint_graph);
                if(i > 0) mCanvas.drawLine(xo + (i - 1) * width / count, (float)(height - ndata[i-1] * dy), xo + i * width / count, (float)(height - ndata[i] * dy), paint_graph);
            }
            for(i = 0;i < count; i++){
                mCanvas.drawCircle(xo + i * width / count, (float)(height - ndata[i] * dy), 5, paint_back);
            }
            mCanvas.drawLine(0, height, 1100, height, paint_line);
            mCanvas.drawText(""+ymax,35,50,paint_text);
            mCanvas.drawText(""+ymid,35,height/2+50,paint_text);
            mCanvas.drawText("0",35,height,paint_text);
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
