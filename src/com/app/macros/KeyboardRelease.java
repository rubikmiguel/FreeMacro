package com.app.macros;

public class KeyboardRelease extends Keyboard {
    @Override
    public void launch() {
        keyboardAction("Release", cbKeys.getSelectedItem());
    }
}