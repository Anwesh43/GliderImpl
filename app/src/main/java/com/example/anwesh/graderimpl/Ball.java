package com.example.anwesh.graderimpl;

/**
 * Created by Anwesh on 14-03-2015.
 */
import android.graphics.*;
public class Ball {
    public float x,y,speed,scale,radius;
    public int colorIndex,motionId;
    public Ball(float x,float y,float speed,float scale,float radius,int colorIndex,int motionId) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.scale = scale;
        this.colorIndex = colorIndex;
        this.radius = radius;
        this.motionId = motionId;
    }
    public void draw(Canvas canvas,Paint paint) {
        paint.setColor(ColorUtil.getColor(colorIndex));
        canvas.save();
        canvas.translate(x,y);
        canvas.scale(scale,scale);
        canvas.drawCircle(0,0,radius,paint);
        canvas.restore();
    }
    public void grow() {
        scale += 0.1f;
        if(scale >= 1) {
            motionId = 1;
        }
    }
    public void translate() {
        y += speed;
    }
    public void move() {
        switch(motionId) {
            case 0:
                grow();
                break;
            case 2:
                translate();
               break;
            default:
                break;
        }
    }
}
