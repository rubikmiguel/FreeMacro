package com.app.macros;

import com.app.config.UIConfig;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Vector;

public class Keyboard extends Macro{

    protected JComboBox<String> cbKeys;
    protected int selectedKeyCode = 0;

    public Keyboard() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        cbKeys = new JComboBox(getKeys());
        UIConfig.setSize(cbKeys, 150, 30);
        add(new JLabel("Key "));
        add(cbKeys);
    }

    protected Vector<String> getKeys() {
        Vector<String> keyNames = new Vector<>();
        Field[] fields = KeyEvent.class.getDeclaredFields();

        for (Field field : fields) {
            if (field.getName().startsWith("VK_")) {
                keyNames.add(field.getName().substring(3));
            }
        }
        //Collections.sort(keyNames);
        return keyNames;
    }

    protected void keyboardAction(String action, Object selectedItem) {
        int keyCode;
        try {
            keyCode = KeyEvent.class.getField("VK_" + (String) selectedItem).getInt(null);
            System.out.println(keyCode);
            switch (action) {
                case "Press":
                    robot.keyPress(keyCode);
                    break;
                case "Release":
                    robot.keyRelease(keyCode);
                    break;
            }
        }
        catch (IllegalAccessException | NoSuchFieldException e) {
            System.out.println("Invalid Key");
            throw new RuntimeException(e);
        }
    }
}
