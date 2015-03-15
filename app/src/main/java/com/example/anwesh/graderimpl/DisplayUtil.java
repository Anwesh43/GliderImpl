package com.example.anwesh.graderimpl;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by Anwesh on 14-03-2015.
 */
public class DisplayUtil {
    int viewWidth,viewHeight;
    public DisplayUtil(int viewWidth,int viewHeight) {
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;
    }
    public void displayBalls(ArrayList<Ball> balls,Canvas canvas,Paint paint) {
        for(int i=0;i<balls.size();i++) {
            Ball ball = balls.get(i);
            ball.draw(canvas,paint);
            ball.move();
        }
    }
    public void displayRotatingSquare(RotatingSquare rotatingSquare,Canvas canvas,Paint paint) {
        rotatingSquare.draw(canvas,paint);
        rotatingSquare.rotate();
    }
    public void displayScore(int score,Canvas canvas,Paint paint) {
        paint.setColor(Color.BLACK);
        paint.setTextSize(canvas.getWidth()/6);
        canvas.drawText(""+score,viewWidth/2-20,viewHeight/2-20,paint);
    }
    public void displayMiss(Canvas canvas,Paint paint) {
        paint.setColor(Color.WHITE);
        paint.setTextSize(canvas.getWidth()/6);
        canvas.drawText("Miss!",viewWidth/2-20,viewHeight/2-20,paint);
    }
}
