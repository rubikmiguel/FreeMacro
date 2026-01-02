package com.app.macros;

import javax.swing.*;

public class MouseScroll extends Mouse{

    private JSpinner sDelay;

    public MouseScroll() {
        System.out.println("Mouse scroll");
        sScroll = new JSpinner();
        sDelay = new JSpinner();
        add(sDelay);
        add(sScroll);
    }

    @Override
    public void launch() {
        int detents = 0;
        int delay = 0;

        try {detents = (int)sScroll.getValue();} catch (Exception e){}
        try {delay = (int)sDelay.getValue();} catch (Exception e){}

        mouseScroll(detents, delay);
    }
}
