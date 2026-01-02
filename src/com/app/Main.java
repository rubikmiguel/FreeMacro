package com.app;

import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        try {
            FlatArcDarkIJTheme.setup();
        } catch (Exception ex) {
            System.err.println(ex);
        }

        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setLocationRelativeTo(null);
            mainWindow.setTitle("FreeMacro");
            mainWindow.setVisible(true);
        });

    }
}