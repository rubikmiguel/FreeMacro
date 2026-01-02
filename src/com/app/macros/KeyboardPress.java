package com.app.macros;

public class KeyboardPress extends Keyboard{

    @Override
    public void launch() {
        keyboardAction("Press", cbKeys.getSelectedItem());
    }
}
