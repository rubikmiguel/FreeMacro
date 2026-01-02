package com.app.macros;

import com.app.config.UIConfig;

import javax.swing.*;

public class MousePress extends Mouse{


    public MousePress() {
        cbButtons = new JComboBox(getButtons());
        UIConfig.setSize(cbButtons, 150, 30);
        add(new JLabel("Button "));
        add(cbButtons);
    }

    @Override
    public void launch() {
        mouseClick("Press", (String)cbButtons.getSelectedItem());
    }
}
