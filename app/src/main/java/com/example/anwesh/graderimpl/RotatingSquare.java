package com.example.anwesh.graderimpl;

/**
 * Created by Anwesh on 14-03-2015.
 */
import android.util.*;
import android.graphics.*;
public class RotatingSquare {
    float x,y,rot,deg;
    int w,h;
    public RotatingSquare(float x,float y,float deg,float rot,int w,int h) {
        this.x = x;
        this.y = y;
        this.deg = deg;
        this.rot = rot;
        this.w = w;
        this.h = h;
    }
    public void draw(Canvas canvas,Paint paint) {
        for(int i=0;i<4;i++) {
            paint.setColor(ColorUtil.getColor(i));
            canvas.save();
            canvas.translate(x,y);
            canvas.rotate(deg-90*i);
            canvas.drawPath(definePath(),paint);
            canvas.restore();

        }
    }
    public Path definePath() {
        Path path = new Path();
        path.moveTo(0,0);
        path.lineTo(-w/2,-h/2);
        path.lineTo(w/2,-h/2);
        path.lineTo(0,0);
        return path;
    }
    public void rotate() {
        this.deg+=this.rot;
        this.deg%=360;
        if((deg-30)%90 == 0) {
            Log.e("deg",""+deg);
        }
    }
}
