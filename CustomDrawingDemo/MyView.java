package com.example.hp.customdrawingdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.SurfaceHolder.Callback;

public class MyView extends SurfaceView{

    SurfaceHolder sh;
    Canvas c;
    public MyView(Context context){
        super(context);


        sh = getHolder();
        sh.addCallback(new Callback() {
            @SuppressLint("WrongCall")
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                c = sh.lockCanvas();
                onDraw(c);
                sh.unlockCanvasAndPost(c);
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setTextSize(100f);
        canvas.drawText("Hello",100,100,p);

        p.setColor(Color.YELLOW);
        canvas.drawCircle(100,100,50,p);

        float f[] = {0,0,20,33,4,5,0,0};
        p.setColor(Color.GRAY);
        canvas.drawLines(f,p);
    }
}
