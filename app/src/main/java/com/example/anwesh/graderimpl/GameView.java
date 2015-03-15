package com.example.anwesh.graderimpl;

/**
 * Created by Anwesh on 14-03-2015.
 */
import android.view.*;
import android.content.*;
import android.graphics.*;
import java.util.*;
public class GameView extends View{
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    int gameTime = 0;
    int viewHeight,viewWidth;
    boolean scored = false;
    BrioTo brioTo;
    int score = 0,scoreTime = 0;
    ArrayList<Ball> balls;
    RotatingSquare rotatingSquare;
    boolean missed = false;
    int missedTime = 0;
    DisplayUtil displayUtil;
    int level = 1;
    public GameView(Context context,BrioTo brioTo) {
        super(context);
        this.brioTo = brioTo;
    }
    public void onDraw(Canvas canvas) {
        if(gameTime == 0) {
            initGameState(canvas);
        }
        canvas.drawColor(Color.rgb(210,179,229));
        displayUtil.displayBalls(balls,canvas,paint);
        displayUtil.displayRotatingSquare(rotatingSquare,canvas,paint);
        if(scored) {
            displayUtil.displayScore(score,canvas,paint);
            scoreTime++;
            if(scoreTime == 15) {
                scored = false;
                scoreTime = 0;
            }
        }
        if(missed) {
            missedTime++;
            displayUtil.displayMiss(canvas,paint);
            if(missedTime == 15) {
                missed = false;
                missedTime = 0;
            }
        }
        gameTime++;
        checkCollision();
        try {
            Thread.sleep(100);
            invalidate();
        }
        catch(Exception exception) {

        }

    }
    public void checkCollision() {
        if(balls.size()>0) {
            Ball movingBall = balls.get(0);
            if(CollisionUtil.checkCollision(movingBall,rotatingSquare)) {
                boolean colorMatched = CollisionUtil.checkExactColorCollision(movingBall,rotatingSquare);
                if(colorMatched) {
                    successAction();
                }
                else {
                    missAction();
                }
            }
        }
    }
    public void successAction() {
        score++;
        if(score%5 == 0) {
            level ++;
            rotatingSquare.rot = rotatingSquare.rot+(level-1)*3;
        }
        scored = true;
        scoreTime = 0;
        missed = false;
        missedTime = 0;
        balls.remove(0);
    }
    public void missAction() {
        balls.remove(0);
        rotatingSquare.rot = 0;
        missedTime = 0;
        scoreTime = 0;
        scored = false;
        missed = true;
        brioTo.changeToGameOverView(this);
    }
    public void initGameState(Canvas canvas) {
        viewWidth = canvas.getWidth();
        viewHeight = canvas.getHeight();
        balls = new ArrayList<Ball>();
        Ball ball = new Ball(viewWidth/2 , viewWidth/28, 40, 0.1f, viewWidth/28, ColorUtil.getRandomColorIndex(), 0);
        balls.add(ball);
        rotatingSquare = new RotatingSquare(viewWidth/2,viewHeight-viewHeight/7,0,20,viewHeight/7,viewHeight/7);
        displayUtil = new DisplayUtil(viewWidth,viewHeight);
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            if(balls.size()>0) {
                Ball currentBall = balls.get(balls.size()-1);
                if(currentBall.motionId == 1) {
                    currentBall.motionId = 2;
                    Ball ball = new Ball(viewWidth/2 , viewWidth/28,40, 0.1f, viewWidth/28, ColorUtil.getRandomColorIndex(), 0);
                    balls.add(ball);
                }
            }
        }
        return true;
    }
}
