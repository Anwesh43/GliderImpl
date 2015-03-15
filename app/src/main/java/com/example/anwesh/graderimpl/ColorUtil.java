package com.example.anwesh.graderimpl;

/**
 * Created by Anwesh on 14-03-2015.
 */
import android.graphics.*;
import java.util.*;
public class ColorUtil {
    public static int getColor(int index) {
        int colors[] = new int[]{Color.rgb(69,228,106),Color.rgb(228,96,69),Color.rgb(80,125,209),Color.rgb(230,249,88)};
        return colors[index];
    }
    public static int getRandomColorIndex() {
        Random random = new Random();
        int index = random.nextInt(1000)%4;
        return index;
    }
}
