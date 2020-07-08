package com.company;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Window extends JFrame {
    private JPanel panelMain;
    private JButton loadTextButton;
    private JButton saveToFileButton;
    private JButton startButton;
    private JTextArea textIn;
    private JTextArea textN;
    private JTextArea textOut;
    private JPanel panelIn;
    private JScrollPane scrolIn;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;

    public static int workFlag = 0;

    public Window() {
        this.setTitle("таск 6.5");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(600, 250);

        setLocationRelativeTo(null); //запуск окна в центре

        textIn.setRows(1000);
        textIn.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        textIn.setLineWrap(true);


        textOut.setRows(1000);
        textOut.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        textOut.setLineWrap(true);

        final String[] text = {""};
        final String[] outText = {""};

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();

        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int n = Integer.parseInt(textN.getText());

                text[0] = " ";
                text[0] = textIn.getText();
                String goodOutText = text[0].replaceAll("[0-9.?!)(,:\"“”«©»]+", "");


                MyCounter.countMeeting(goodOutText, n);


                outText[0] = (MapCustom.outStr);

                if (goodOutText.length() > 1) {
                    textOut.setText(outText[0]);
                    workFlag = 1;
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Поле ввода пустое. Пожалуйста попробуйте ещё раз.", "Упс, ошибочка!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        saveToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (workFlag != 0) {
                        if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                            String file = fileChooserSave.getSelectedFile().getPath();
                            if (!file.toLowerCase().endsWith(".txt")) {
                                file += ".txt";
                            }
                            FileWriter fw = new FileWriter(file);
                            fw.write(outText[0]);
                            fw.flush();
                            fw.close();
                        }
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Кажется, поле ввода пустое. Пожалуйста попробуйте ещё раз.", "Упс, ошибочка!", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (
                        Exception e) {
                    JOptionPane.showMessageDialog(null, "Ошибка");
                }
            }
        });

        loadTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        FileReader fr = new FileReader(fileChooserOpen.getSelectedFile().getPath());
                        StringBuffer strBuffer = new StringBuffer();
                        int symbol;
                        while ((symbol = fr.read()) != -1) {
                            strBuffer.append((char) symbol);
                        }
                        textIn.setText(strBuffer.toString());
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ошибка");
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
        panelMain.setLayout(new GridLayoutManager(2, 3, new Insets(10, 10, 10, 10), -1, -1));
        panelIn = new JPanel();
        panelIn.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panelMain.add(panelIn, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(552, 247), null, 0, false));
        panelIn.setBorder(BorderFactory.createTitledBorder(""));
        final JLabel label1 = new JLabel();
        label1.setText("Введите ваш текст:");
        panelIn.add(label1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(243, 20), null, 0, false));
        scrolIn = new JScrollPane();
        panelIn.add(scrolIn, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textIn = new JTextArea();
        textIn.setText("");
        scrolIn.setViewportView(textIn);
        final JLabel label2 = new JLabel();
        label2.setText("Введите N:");
        panelIn.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(243, 20), null, 0, false));
        textN = new JTextArea();
        textN.setBackground(new Color(-1));
        textN.setText("");
        panelIn.add(textN, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(50, 50), null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelMain.add(panel1, new GridConstraints(0, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(552, 247), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Вывод:");
        panel1.add(label3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        panel1.add(scrollPane1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textOut = new JTextArea();
        textOut.setEditable(false);
        scrollPane1.setViewportView(textOut);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 3, new Insets(20, 0, 20, 0), -1, -1));
        panelMain.add(panel2, new GridConstraints(1, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 20), null, 0, false));
        loadTextButton = new JButton();
        loadTextButton.setAlignmentY(0.5f);
        loadTextButton.setIcon(new ImageIcon(getClass().getResource("/ico/import.png")));
        loadTextButton.setIconTextGap(20);
        loadTextButton.setInheritsPopupMenu(false);
        loadTextButton.setMargin(new Insets(0, 0, 0, 0));
        loadTextButton.setText("Загрузить текст из файла");
        loadTextButton.setVerticalTextPosition(0);
        panel2.add(loadTextButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(287, 38), null, 0, false));
        startButton = new JButton();
        startButton.setIcon(new ImageIcon(getClass().getResource("/ico/start.png")));
        startButton.setIconTextGap(20);
        startButton.setText("Выполнить");
        panel2.add(startButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(181, 38), null, 0, false));
        saveToFileButton = new JButton();
        saveToFileButton.setIcon(new ImageIcon(getClass().getResource("/ico/import.png")));
        saveToFileButton.setIconTextGap(20);
        saveToFileButton.setText("Сохранить в текстовый файл");
        panel2.add(saveToFileButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

}
