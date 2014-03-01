package ru.HSE.Trofimov.BeanClock;

// Author: Ilya Trofimov
// Group: 272(2)
// Date: 2 Mar 2013

import javax.swing.*;
import java.awt.*;

public class ClockFrame extends javax.swing.JFrame {
    public ClockFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        getContentPane().add(new ClockPanel());
        setVisible(true);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClockFrame();
            }
        });
    }
}
