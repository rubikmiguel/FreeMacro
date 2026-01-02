package com.app.config;

import java.awt.*;

public class UIConfig {
    public static final int APP_WIDTH = 1080;
    public static final int APP_HEIGHT = 720;

    public static final int SMALL_HEIGHT_CONTAINER = 30;
    public static final int SMALL_WIDTH_CONTAINER = 100;
    public static final int MEDIUM_HEIGHT_CONTAINER = 50;
    public static final int MEDIUM_WIDTH_CONTAINER = 200;

    public static final Dimension WINDOW_SIZE = new Dimension(APP_WIDTH, APP_HEIGHT);
    public static final Dimension HEADER_SIZE = new Dimension(APP_WIDTH, SMALL_HEIGHT_CONTAINER);

    public static final Dimension LIST_ITEM_SIZE = new Dimension(APP_WIDTH, SMALL_HEIGHT_CONTAINER);

    public static final Dimension DEFAULT_COMPONENT_SIZE = new Dimension(100,SMALL_HEIGHT_CONTAINER);


    public static void setSize(Component component, int width, int height) {
        Dimension dimension = new Dimension(width, height);
        component.setPreferredSize(dimension);
        component.setMinimumSize(dimension);
        component.setMaximumSize(dimension);
    }
    public static void setSize(Component component, Dimension dimension) {
        component.setPreferredSize(dimension);
        component.setMinimumSize(dimension);
        component.setMaximumSize(dimension);
    }
}
