package com.company;

import java.util.Scanner;

public class Console {
    public static void play() throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Пожалуйста, введите ваш текст: ");
        String text = sc.nextLine();
        String outTextConsole = text.replaceAll("[0-9.?!)(,:\"“”«©»]+", "");
        System.out.println();
        System.out.print("Пожалуйста, введите сколько количество повторов: ");
        int n = sc.nextInt();

        MyCounter.countMeeting(outTextConsole,n);

        System.out.println(MapCustom.outStr);

    }
}
