package com.company;

import java.awt.EventQueue;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.Locale;
import javax.swing.*;

import com.company.util.SwingUtils;

public class Main {

    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.ROOT);

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingUtils.setDefaultFont("Arial", 18);

                (new Choice()).setVisible(true);
            }
        });
    }
}
