package org.lab6Optional;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

public class ConfigPanel extends JPanel {

    final MainFrame frame;
    private JLabel sidesLabel;
    private static JSpinner sidesField;
    private static JComboBox colorCombo;
    private static JComboBox shapesCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6);
        String[] colorStrings = { "Random","Black"};
        String[] shapes = {"Poligon", "Circle","Snowflake"};
        colorCombo = new JComboBox(colorStrings);
        colorCombo.setSelectedIndex(0);
        shapesCombo = new JComboBox(shapes);
        shapesCombo.setSelectedIndex(0);
        add(colorCombo);
        add(shapesCombo);
        add(sidesLabel);
        add(sidesField);
        adaptConfigPanel();

    }
    public static int getSides() {
        return (Integer)sidesField.getValue();
    }

    public static Color getColor() {
        if(colorCombo.getSelectedItem() == "Black"){
            return Color.BLACK;
        } else {
            Random rand = new Random();
            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);
            return new Color(r,g,b,150);
        }
    }
    public static  String getShape(){
        return (String) shapesCombo.getSelectedItem();
    }
    public void adaptConfigPanel(){
        shapesCombo.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange()==ItemEvent.SELECTED){
                    if (e.getItem() != "Poligon") {
                        remove(sidesLabel);
                        remove(sidesField);
                        revalidate();
                        repaint();
                    } else{
                        add(sidesLabel);
                        add(sidesField);
                        revalidate();
                        repaint();
                    }
                }
            }
        });
    }
}