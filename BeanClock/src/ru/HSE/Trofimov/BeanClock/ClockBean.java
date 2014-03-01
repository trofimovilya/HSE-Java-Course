package ru.HSE.Trofimov.BeanClock;

// Author: Ilya Trofimov
// Group: 272(2)
// Date: 2 Mar 2013

import java.awt.*;
import java.io.Serializable;

public class ClockBean extends ClockPanel implements Serializable {
    public ClockBean() {}

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public void stop() {
        timer.stop();
    }

    public void start() {
        timer.start();
    }
}
