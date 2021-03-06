package com.company;

import com.company.util.SwingUtils;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Choice extends JFrame {
    private JPanel panelMain;
    private JCheckBox consoleCheckBox;
    private JCheckBox windowCheckBox;
    private JButton startButton;
    private JTextPane textPane1;
    private JTextArea хныкинТаск618TextArea;
    public static boolean console1;
    public static boolean window1;


    public Choice() {
        this.setTitle("Выбор формата:");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(600, 330);

        setLocationRelativeTo(null); //запуск окна в центре

        final int[] console = new int[1];
        final int[] window = new int[1];

        String hello = "таск 6." + "\n" + "\n" + "5. Получить список слов, которые встречаются в тексте ровно N раз (N задается пользователем). Одни и те же слова в различной форме считаются разными словами. В качестве тестовых данных использовать литературные произведения (большие по объему тексты).";
        textPane1.setText(hello);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (console[0] == 1 && window[0] != 1) {
                    Choice.this.setVisible(false);
                    try {
                        Console.play();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(new JFrame(), "Кажется, что-то пошло не так. Пожалуйста, повторите попытку", "Ошибка!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (window[0] == 1 && console[0] != 1) {
                    Choice.this.setVisible(false);
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            JFrame window = null;
                            try {
                                SwingUtils.setDefaultFont("Arial", 18);
                                window = new Window();
                                window.setSize(1100, 600);
                                window.setVisible(true);
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(new JFrame(), "Кажется, что-то пошло не так. Пожалуйста, повторите попытку", "Ошибка!", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                }
                if (console[0] == 0 && window[0] == 0) {
                    JOptionPane.showMessageDialog(null, "Выбрано сразу два или не выбрано ничего, пожалуйста повторите");
                }
                if (console[0] == 1 && window[0] == 1) {
                    JOptionPane.showMessageDialog(null, "Выбрано сразу два или не выбрано ничего, пожалуйста повторите");
                }
                console[0] = 0;
                window[0] = 0;
            }
        });


        consoleCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    console[0] = 1;
                }
            }
        });

        windowCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    window[0] = 1;
                }
            }
        });

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelMain = new JPanel();
        panelMain.setLayout(new GridLayoutManager(5, 1, new Insets(20, 20, 20, 20), -1, -1));
        windowCheckBox = new JCheckBox();
        windowCheckBox.setText("Окно");
        panelMain.add(windowCheckBox, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        startButton = new JButton();
        startButton.setText("Старт");
        panelMain.add(startButton, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        consoleCheckBox = new JCheckBox();
        consoleCheckBox.setText("Консоль");
        panelMain.add(consoleCheckBox, new GridConstraints(2, 0, 2, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textPane1 = new JTextPane();
        textPane1.setEditable(false);
        panelMain.add(textPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

}
