package org.lab6Optional;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    private Graphics2D graphics;
    private List<Shape> shapeList;
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        shapeList = new ArrayList<>();
        createOffscreenImage();
        init();
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }
    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }
    private void drawShape(int x, int y) {
        int foundShape = 0;
        for (Shape shape : shapeList){
            foundShape++;
            if (shape.getX()-shape.getRadius()<x&& shape.getX()+shape.getRadius()>x
                    &&shape.getY()-shape.getRadius()<y&& shape.getY()+shape.getRadius()>y) {
                graphics.setColor(Color.WHITE);
                shape.drawShape();
                break;
            };
        }
        if (foundShape==shapeList.size()){
            Random rand = new Random();
            int radius = rand.nextInt(100);
            int sides = ConfigPanel.getSides();
            graphics.setColor(ConfigPanel.getColor());
            if (ConfigPanel.getShape() == "Poligon") {
                shapeList.add(new RegularPolygon(x, y, radius, sides, graphics));
            } else if (ConfigPanel.getShape() == "Circle") {
                shapeList.add(new Circle(x, y, radius, graphics));
            } else {
                shapeList.add(new Snowflake(x, y, radius, graphics));
            }
        } else {
            shapeList.remove(foundShape--);
        }
    }

    public void drawImage(Image image){
        graphics.drawImage(image,0,0,W,H,this);
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
    public void resetGraphics(){
        graphics.setColor(new Color(255,255,255,255));
        graphics.fillRect(0, 0, W, H);
        repaint();
    }
}