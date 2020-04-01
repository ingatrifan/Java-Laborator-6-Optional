package org.lab6Optional;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        add(canvas, BorderLayout.CENTER);
        getContentPane().add(configPanel,BorderLayout.PAGE_START);
        getContentPane().add(controlPanel,BorderLayout.PAGE_END);
        pack();
        setVisible(true);
    }
}