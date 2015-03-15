package com.example.anwesh.graderimpl;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.content.pm.*;
import android.view.animation.Animation.*;
import android.view.animation.*;
public class BrioTo extends Activity {
    GameView gameView;
    GameOverView gameOverView;
    int highestScore;
    GameOptionsView gameOptionsView;
    SqliteDbConnector sqldbc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this,this);
        gameOverView = new GameOverView(this,this);
        gameOptionsView = new GameOptionsView(this,this);
        sqldbc = new SqliteDbConnector(this);
        setContentView(gameOptionsView);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
    public void changeToGameOverView(View view) {
        fetchAndUpdateScore();
        AnimationListener listener = new AnimationListener() {
            public void onAnimationStart(Animation animation) {

            }
            public void onAnimationEnd(Animation animation) {
                gameOverView = new GameOverView(BrioTo.this,BrioTo.this);
                setContentView(gameOverView);
                TranslateAnimation translateAnimationEntering = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,-1,Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0);
                translateAnimationEntering.setDuration(500);
                gameOverView.startAnimation(translateAnimationEntering);
            }
            public void onAnimationRepeat(Animation animation) {

            }
        };
        TranslateAnimation translateAnimationLeaving = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,1,Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0);
        translateAnimationLeaving.setDuration(500);
        translateAnimationLeaving.setAnimationListener(listener);
        view.startAnimation(translateAnimationLeaving);
    }
    public void changeToGameView(View view) {
        AnimationListener listener = new AnimationListener() {
            public void onAnimationStart(Animation animation) {

            }
            public void onAnimationEnd(Animation animation) {
                gameView = new GameView(BrioTo.this,BrioTo.this);
                setContentView(gameView);
                TranslateAnimation translateAnimationEntering = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,-1,Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0);
                translateAnimationEntering.setDuration(500);
                gameView.startAnimation(translateAnimationEntering);
            }
            public void onAnimationRepeat(Animation animation) {

            }
        };
        TranslateAnimation translateAnimationLeaving = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,1,Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0);
        translateAnimationLeaving.setDuration(500);
        translateAnimationLeaving.setAnimationListener(listener);
        view.startAnimation(translateAnimationLeaving);

    }
    public void changeToGameOptionsView(View view) {
        AnimationListener listener = new AnimationListener() {
            public void onAnimationStart(Animation animation) {

            }
            public void onAnimationEnd(Animation animation) {
                gameOptionsView = new GameOptionsView(BrioTo.this,BrioTo.this);
                setContentView(gameOptionsView);
                TranslateAnimation translateAnimationEntering = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,-1,Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0);
                translateAnimationEntering.setDuration(500);
                gameOptionsView.startAnimation(translateAnimationEntering);
            }
            public void onAnimationRepeat(Animation animation) {

            }
        };
        TranslateAnimation translateAnimationLeaving = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,1,Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0);
        translateAnimationLeaving.setDuration(500);
        translateAnimationLeaving.setAnimationListener(listener);
        view.startAnimation(translateAnimationLeaving);
    }

    public void fetchAndUpdateScore() {
        sqldbc.open();
        int score = sqldbc.fetchHighestScore();
        sqldbc.close();
        if(score!=-1) {
            if(gameView.score>score) {
                highestScore = gameView.score;
                sqldbc.open();
                sqldbc.update(highestScore);
                sqldbc.close();
            }
            else {
                highestScore = score;

            }
        }
        else {
            highestScore = gameView.score;
            sqldbc.open();
            sqldbc.insert(highestScore);
            sqldbc.close();
        }
    }
}
