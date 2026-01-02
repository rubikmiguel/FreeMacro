package com.app.macros;

import com.app.config.UIConfig;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.util.Vector;

public class Mouse extends Macro {

    protected JComboBox cbButtons;
    protected JSpinner sScroll;

    public Mouse() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    protected Vector<String> getButtons() {
        Vector<String> buttons = new Vector<>();
        buttons.add("Left Click");
        buttons.add("Right Click");
        buttons.add("Scroll Click");
        return buttons;
    }

    protected void mouseClick(String action, String selectedButton) {
        int button;
        switch (selectedButton) {
            case "Left Click":
                button = InputEvent.BUTTON1_DOWN_MASK;
                break;
            case "Right Click":
                button = InputEvent.BUTTON3_DOWN_MASK;
                break;
            case "Scroll Click":
                button = InputEvent.BUTTON2_DOWN_MASK;
                break;
            default: button = InputEvent.BUTTON1_DOWN_MASK;
        }

        if (action.equals("Press"))
            robot.mousePress(button);
        else
            robot.mouseRelease(button);
    }
    protected void mouseScroll(int detents, int delay) {
        int direction = detents > 0 ? 1 : -1;
        int absoluteDetents = Math.abs(detents);

        for (int i = 0; i < absoluteDetents; i++) {
            robot.mouseWheel(-direction);
            robot.delay(delay);
        }
    }
}
