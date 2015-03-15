package com.example.anwesh.graderimpl;

/**
 * Created by Anwesh on 14-03-2015.
 */
import android.view.*;
import android.content.*;
import android.graphics.*;
import java.util.*;
public class GameOverView extends View{
    ArrayList<CustomButton> buttons = new ArrayList<CustomButton>();
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    BrioTo brioTo;
    int pressedButtonIndex = -1;
    int updateTime = 0;
    public GameOverView(Context context,BrioTo brioTo) {
        super(context);
        this.brioTo = brioTo;

    }
    public void onDraw(Canvas canvas) {
        if(updateTime == 0) {
            buttons.add(new CustomButton(canvas.getWidth()/2,canvas.getHeight()/3+canvas.getHeight()/12,"Replay"));
            buttons.add(new CustomButton(canvas.getWidth()/2,2*canvas.getHeight()/3+canvas.getHeight()/12,"Main Menu"));
        }
        canvas.drawColor(Color.rgb(210,179,229));
        paint.setTextSize(canvas.getHeight()/20);
        paint.setColor(Color.WHITE);
        canvas.save();
        canvas.translate(canvas.getWidth()/2,canvas.getHeight()/12+canvas.getHeight()/14);
        canvas.drawText("HIGEST SCORE:"+brioTo.highestScore,-canvas.getWidth()/4,0,paint);
        canvas.restore();
        canvas.save();
        canvas.translate(canvas.getWidth()/2,canvas.getHeight()/12+canvas.getHeight()/7);
        canvas.drawText("YOUR SCORE:"+brioTo.gameView.score,-canvas.getWidth()/4,0,paint);
        canvas.restore();
        for(int i=0;i<buttons.size();i++) {
            CustomButton customButton = buttons.get(i);
            customButton.draw(canvas,paint);
            if(customButton.pressed && customButton.l >= canvas.getWidth()/2) {
                checkAction(customButton.id);
            }
        }
        updateTime++;
        try {
            Thread.sleep(100);
            invalidate();
        }
        catch(Exception exception) {

        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            for(int i=0;i<buttons.size();i++) {
                CustomButton button = buttons.get(i);
                if(button.contains(event.getX(),event.getY())) {
                    pressedButtonIndex = i;
                    button.pressed = true;
                }

            }
        }
        if(event.getAction() == MotionEvent.ACTION_UP) {
            if(pressedButtonIndex != -1) {
                CustomButton button = buttons.get(pressedButtonIndex);
                button.pressed = false;
                if(button.l>=button.w) {
                    checkAction(button.id);
                }
                else {
                    button.l = 0;
                    pressedButtonIndex = -1;
                }
            }
        }
        return true;
    }
    public void checkAction(int id) {
        switch(id) {
            case 3:
                brioTo.changeToGameView(this);
                break;
            case 4:
                brioTo.changeToGameOptionsView(this);
                break;
            default:
                break;
        }
    }
}
