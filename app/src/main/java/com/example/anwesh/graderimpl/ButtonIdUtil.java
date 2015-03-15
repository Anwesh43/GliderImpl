package com.example.anwesh.graderimpl;

/**
 * Created by Anwesh on 14-03-2015.
 */
import java.util.*;
public class ButtonIdUtil {
    public static HashMap<String,Integer> getMap() {
        HashMap<String,Integer> idDescriptionMap = new HashMap<String,Integer>();
        idDescriptionMap.put("Play",1);
        idDescriptionMap.put("Exit",2);
        idDescriptionMap.put("Replay",3);
        idDescriptionMap.put("Main Menu",4);
        return idDescriptionMap;
    }
    public static int getIdGenerator(String description) {
        return getMap().get(description);
    }
}
