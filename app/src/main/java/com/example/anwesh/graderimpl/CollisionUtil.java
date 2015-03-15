package com.example.anwesh.graderimpl;

/**
 * Created by Anwesh on 14-03-2015.
 */
public class CollisionUtil {
    public static boolean checkExactColorCollision(Ball ball,RotatingSquare rotatingSquare) {
        boolean isCollided = false;
        int ballColorIndex = ball.colorIndex;
        int squareColorIndex = (int)rotatingSquare.deg/90;
        if(squareColorIndex == ballColorIndex) {
            isCollided = true;
        }
        return isCollided;
    }
    public static boolean checkCollision(Ball ball,RotatingSquare rotatingSquare) {
        float ballHeight = ball.y;
        float ballLimit = rotatingSquare.y - rotatingSquare.h/2;
        if(ball.motionId ==2 && ballHeight>=ballLimit) {
            return true;
        }
        return false;
    }
}
