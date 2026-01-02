package com.app;

import java.awt.*;

public class MacrosManager {

    private Thread thread;

    public MacrosManager() {

    }

    public void startMacros(Component[] macros, int startDelay, int delay) {

        if (thread != null && thread.isAlive()) {
            return;
        }

        thread = new Thread(() -> {
            try {
                Thread.sleep(startDelay);
                while (!Thread.currentThread().isInterrupted()) {
                    for (Component macro : macros) {
                        if (macro instanceof Macro) {
                            Macro m = (Macro) macro;
                            int macroDelay = 0;
                            try {
                                macroDelay = Integer.parseInt(m.getTfStartDelay().getText());
                            } catch (Exception e) {
                                System.out.println("Invalid Delay Argument");
                            }
                            Thread.sleep(macroDelay);
                            m.launch();
                        }
                    }
                    Thread.sleep(delay);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        thread.start();
    }
    public void stop() {
        System.out.println("stopping");
        if (thread != null) {
            thread.interrupt();
        }
    }
}
