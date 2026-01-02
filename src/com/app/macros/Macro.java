package com.app.macros;

import javax.swing.*;
import java.awt.*;

public class Macro extends JPanel{

    Robot robot;

    public Macro() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public void launch() {
        System.out.println("Launching...");
    }
}
