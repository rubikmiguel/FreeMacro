package com.app.macros;

import com.app.config.UIConfig;

import javax.swing.*;

public class MouseRelease extends Mouse {

    public MouseRelease() {
        cbButtons = new JComboBox(getButtons());
        UIConfig.setSize(cbButtons, 150, 30);
        add(new JLabel("Button "));
        add(cbButtons);
    }

    @Override
    public void launch() {
        mouseClick("Release", (String)cbButtons.getSelectedItem());
    }
}
