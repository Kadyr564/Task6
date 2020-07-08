package com.company;

import java.util.Map;

public class MyCounter {

    public static String strOutMy = "";

    public  static Map countMeeting(String text, int n){
        int k =0;
        MyMap<String, Integer> myMap = new MapCustom<>();
        if (n>1){
            for (String word : text.replace(".", "").split(" ")){
                for (String word1 : text.replace(".", "").split(" ")) {
                    String w = word.toLowerCase();
                    String w1 = word1.toLowerCase();
                    if (w.equals(w1)) {
                        k++;
                    }
                    if (k == n) {
                        myMap.countMeeting(w);
                    }

                }
                k=0;
            }

        }
        else {
            String word = "Вы ввели количество повторов менее чем 2 раза";
            myMap.countMeeting(word);
        }
        return myMap.getAll();
    }
}
