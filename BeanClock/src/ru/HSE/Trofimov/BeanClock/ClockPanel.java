package ru.HSE.Trofimov.BeanClock;

// Author: Ilya Trofimov
// Group: 272(2)
// Date: 2 Mar 2013

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClockPanel extends JPanel {
    Timer timer;

    public ClockPanel() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClockPanel.this.repaint();
            }
        });
        timer.start();
    }

    private void drawArrow(Graphics2D g, int stroke, int value, Color color, double length_mult) {
        double angle = -Math.PI / 2 + 2 * Math.PI / 60 * value;
        int c1 = (getWidth() - stroke) / 2, c2 = (getHeight() - stroke) / 2;
        int t1 = (int) (c1 * Math.cos(angle)), t2 = (int) (c2 * Math.sin(angle));
        g.setColor(color);
        g.setStroke(new BasicStroke(stroke));
        g.drawLine(c1 + stroke / 2, c2 + stroke / 2, c1 + (int) (t1 * length_mult) - stroke / 2, c2 + (int) (t2 * length_mult) - stroke / 2);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = ((Graphics2D) g);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int stroke = 8;

        g2.setColor(new Color(220, 220, 220));
        g2.fillOval(stroke / 2, stroke / 2, getWidth() - stroke, getHeight() - stroke);

        g2.setColor(new Color(0, 0, 0));
        int c1 = (getWidth() - stroke) / 2 - stroke / 4, c2 = (getHeight() - stroke) / 2 - stroke / 4;
        g2.setFont(new Font("serif", Font.BOLD, 18));
        for (int i = 0, j = 0; i < 360; i += (360 / 12), ++j) {
            if (j % 3 == 0)
                g2.setStroke(new BasicStroke(5));
            else
                g2.setStroke(new BasicStroke(2));
            double angle = i * Math.PI / 180.0;
            int t1 = (int) (c1 * Math.sin(angle)), t2 = (int) (c2 * Math.cos(angle));
            g2.drawLine(c1 + t1 - t1 / 8 + stroke / 2, c2 + t2 - t2 / 8 + stroke / 2,
                    c1 + t1 + stroke / 2, c2 + t2 + stroke / 2);
            g2.drawString(String.valueOf(Math.abs(12 - j + 6 - 1) % 12 + 1), c1 + t1 - t1 / 4 + stroke / 2, c2 + t2 - t2 / 4 + stroke / 2);
        }
        stroke = 5;
        g2.setStroke(new BasicStroke(stroke));
        g2.setColor(new Color(0, 0, 0));
        g2.drawOval(c1 + stroke / 2, c2 + stroke / 2, stroke * 2, stroke * 2);

        GregorianCalendar calendar = new GregorianCalendar();
        drawArrow(g2, 2, calendar.get(Calendar.SECOND), new Color(255, 0, 0), 0.98);
        drawArrow(g2, 3, calendar.get(Calendar.MINUTE), new Color(0, 0, 0), 0.85);
        drawArrow(g2, 5, calendar.get(Calendar.HOUR) * 5 + calendar.get(Calendar.MINUTE) * 5 / 60, new Color(0, 0, 0), 0.75);

        stroke = 10;
        g2.setStroke(new BasicStroke(stroke));
        g2.setColor(new Color(255, 0, 0));
        g2.fillOval(c1 + stroke / 3, c2 + stroke / 3, stroke, stroke);

        stroke = 8;
        g2.setStroke(new BasicStroke(stroke));
        g2.setColor(new Color(120, 120, 120));
        g2.drawOval(stroke / 2, stroke / 2, getWidth() - stroke, getHeight() - stroke);
    }

}
