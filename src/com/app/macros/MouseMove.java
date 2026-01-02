package com.app.macros;

import javax.swing.*;

import com.app.config.UIConfig;

public class MouseMove extends Macro {

    private JTextField tfPosX;
    private JTextField tfPosY;

    public MouseMove() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        tfPosX = new JTextField();
        tfPosY = new JTextField();

        tfPosX.setPreferredSize(UIConfig.DEFAULT_COMPONENT_SIZE);
        tfPosX.setMinimumSize(UIConfig.DEFAULT_COMPONENT_SIZE);
        tfPosX.setMaximumSize(UIConfig.DEFAULT_COMPONENT_SIZE);

        tfPosY.setPreferredSize(UIConfig.DEFAULT_COMPONENT_SIZE);
        tfPosY.setMinimumSize(UIConfig.DEFAULT_COMPONENT_SIZE);
        tfPosY.setMaximumSize(UIConfig.DEFAULT_COMPONENT_SIZE);

        add(new JLabel("X Position"));
        add(tfPosX);
        add(new JLabel("Y Position"));
        add(tfPosY);
    }

    @Override
    public void launch() {
        int x = Integer.parseInt(tfPosX.getText());
        int y = Integer.parseInt(tfPosY.getText());
        robot.mouseMove(x, y);
    }
}
