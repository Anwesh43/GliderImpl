package com.example.anwesh.graderimpl;

/**
 * Created by Anwesh on 14-03-2015.
 */
import android.graphics.*;
public class CustomButton {
    String description;
    float x,y;
    float w,h;
    int id;
    float l = 0;
    boolean pressed = false;
    public CustomButton(float x,float y,String description) {
        this.x = x;
        this.y = y;
        this.description = description;
        this.id = ButtonIdUtil.getIdGenerator(description);
    }
    public void draw(Canvas canvas,Paint paint) {
        h = canvas.getHeight()/15;
        w = canvas.getHeight()/4;
        paint.setColor(Color.argb(200,76,228,101));
        canvas.drawRect(new RectF(x - canvas.getWidth()/4, y - canvas.getHeight() /15, x + canvas.getWidth()/4, y + canvas.getHeight()/15), paint);
        paint.setColor(Color.argb(200,83,78,181));
        canvas.drawRect(new RectF(x-canvas.getWidth()/4,y-canvas.getHeight()/15,x-canvas.getWidth()/4+l,y+canvas.getHeight()/15),paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(canvas.getHeight()/19);
        canvas.drawText(description, x - (2*canvas.getWidth())/13, y+canvas.getHeight()/48,paint);
        if(pressed) {
            if(l< canvas.getWidth()/2) {
                l += 25;
                if(l>canvas.getWidth()/2) {
                    l = canvas.getWidth()/2;
                }
            }
            else {
                l = canvas.getWidth()/2;
            }

        }
    }
    public boolean contains(float x1,float y1) {
        if(x-w<=x1 && x+w>=x1 && y-h<=y1 && y1<=y+h) {
            return true;
        }
        return false;
    }
}
