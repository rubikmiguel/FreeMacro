package com.app;

import com.app.config.UIConfig;
import com.app.macros.*;

import javax.swing.*;

public class Macro extends JPanel {

    private com.app.macros.Macro macro;

    private JPanel pHBox;
    private JComboBox<String> cbPeriferal;
    private JTextField tfStartDelay;
    private JButton bDelete;

    String[] cbOptions = {
            "Select Option",
            "Mouse Press",
            "Mouse Release",
            "Mouse Scroll",
            "Mouse Move",
            "Keyboard Press",
            "Keyboard Release"
    };

    public JTextField getTfStartDelay() {
        return tfStartDelay;
    }

    public Macro(JPanel parent) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        UIConfig.setSize(this, UIConfig.LIST_ITEM_SIZE);

        macro = new com.app.macros.Macro();

        pHBox = new JPanel();
        cbPeriferal = new JComboBox<>(cbOptions);
        tfStartDelay = new JTextField();
        bDelete = new JButton("Delete");

        UIConfig.setSize(cbPeriferal, UIConfig.MEDIUM_WIDTH_CONTAINER, UIConfig.SMALL_HEIGHT_CONTAINER);
        UIConfig.setSize(tfStartDelay, UIConfig.DEFAULT_COMPONENT_SIZE);
        UIConfig.setSize(bDelete, UIConfig.DEFAULT_COMPONENT_SIZE);

        cbPeriferal.addActionListener(e -> {
            String seleccion = (String) cbPeriferal.getSelectedItem();
            int indice = cbPeriferal.getSelectedIndex();

            switch(seleccion) {
                case "Mouse Press":
                    macro = new MousePress();
                    break;
                case "Mouse Release":
                    macro = new MouseRelease();
                    break;
                case "Mouse Move":
                    macro = new MouseMove();
                    break;
                case "Mouse Scroll":
                    macro = new MouseScroll();
                    break;
                case "Keyboard Press":
                    macro = new KeyboardPress();
                    break;
                case "Keyboard Release":
                    macro = new KeyboardRelease();
                    break;
            }
            remove(getComponentCount()-2);
            add(macro,getComponentCount()-1); //-2 and -1 represent the index in where the component must be.
            revalidate();
            repaint();
        });

        bDelete.addActionListener(e -> {
            parent.remove(this);
            parent.revalidate();
            parent.repaint();
        });

        add(cbPeriferal);
        add(new JLabel("Start Delay "));
        add(tfStartDelay);
        add(Box.createHorizontalGlue());
        add(macro);
        add(bDelete);
    }

    public void launch() {
        macro.launch();
    }
}
