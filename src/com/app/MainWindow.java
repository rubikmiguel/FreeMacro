package com.app;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private final int width = 1080;
    private final int height = 720;

    private final Dimension windowDefaultSize = new Dimension(width, height);

    private final int defaultTabIndex = 1;

    private JTabbedPane tpMain;

    JPanel[] tpOptions = {
            new TabWelcome(),
            new TabMacros()
    };

    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setMaximumSize(windowDefaultSize);
        setResizable(false);

        tpMain = new JTabbedPane();
        for (JPanel options : tpOptions) {
            tpMain.addTab(options.getName(), options);
        }

        tpMain.setEnabledAt(0, false);
        tpMain.setSelectedIndex(defaultTabIndex);

        add(tpMain);
    }
}
