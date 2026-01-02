package com.app;

import com.app.config.UIConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabMacros extends JPanel {

    private JPanel
            pHeader,
            pMacros,
            pFooter;
    private JButton
            bNewMacro;
    private JTextField
            tfStartDelay,
            tfDelay;
    private JToggleButton
            tbStart;
    private JLabel
            lCursorPosX,
            lCursorPosY;

    private MacrosManager macrosManager;

    public TabMacros() {
        setName("Macros");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(1080, 100));
        setAlignmentY(Component.TOP_ALIGNMENT);
        setAlignmentX(Component.LEFT_ALIGNMENT);

        macrosManager = new MacrosManager();

        pHeader = new JPanel();
        pMacros = new JPanel();
        pFooter = new JPanel();
        bNewMacro = new JButton("New Macro");
        tfStartDelay = new JTextField("2200");
        tfDelay = new JTextField("2200");
        tbStart = new JToggleButton("Start");
        lCursorPosX = new JLabel();
        lCursorPosY = new JLabel();

        pHeader.setLayout(new BoxLayout(pHeader, BoxLayout.X_AXIS));
        pHeader.setAlignmentX(Component.CENTER_ALIGNMENT);

        UIConfig.setSize(pHeader, UIConfig.HEADER_SIZE);
        UIConfig.setSize(bNewMacro, UIConfig.DEFAULT_COMPONENT_SIZE);
        UIConfig.setSize(tbStart, UIConfig.DEFAULT_COMPONENT_SIZE);

        pMacros.setPreferredSize(UIConfig.WINDOW_SIZE);
        pMacros.setLayout(new BoxLayout(pMacros, BoxLayout.Y_AXIS));

        UIConfig.setSize(pFooter, UIConfig.HEADER_SIZE);
        pFooter.setLayout(new BoxLayout(pFooter, BoxLayout.X_AXIS));

        bNewMacro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startMacros(false);
                pMacros.add(new Macro(pMacros));
                pMacros.revalidate();
                pMacros.repaint();
            }
        });

        tbStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tbStart.isSelected()){
                    startMacros(true);
                } else {
                    startMacros(false);
                }
            }
        });

        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point punto = MouseInfo.getPointerInfo().getLocation();
                lCursorPosX.setText(String.valueOf(punto.x));
                lCursorPosY.setText(String.valueOf(punto.y));
            }
        });
        timer.start();

        add(pHeader);
        add(new JSeparator());
        add(pMacros);
        add(new JSeparator());
        add(pFooter);
        pHeader.add(bNewMacro);
        pHeader.add(new JSeparator(SwingConstants.VERTICAL));
        pHeader.add(new Label("Start Delay"));
        pHeader.add(tfStartDelay);
        pHeader.add(new Label("Loop Delay"));
        pHeader.add(tfDelay);
        pHeader.add(tbStart);
        pFooter.add(new JLabel("Cursor Position | X-"));
        pFooter.add(lCursorPosX);
        pFooter.add(new JLabel(", Y-"));
        pFooter.add(lCursorPosY);
    }

    private void startMacros(boolean startMacros) {
        if (startMacros) {
            int startDelay = Integer.parseInt(tfStartDelay.getText());
            int delay = Integer.parseInt(tfDelay.getText());
            Component[] macros = pMacros.getComponents();
            if(macros.length != 0) {
                tbStart.setText("Stop");
                macrosManager.startMacros(macros, startDelay, delay);
            }
            else
                tbStart.setSelected(false);
        } else {
            tbStart.setText("Start");
            macrosManager.stop();
        }
    }
}
