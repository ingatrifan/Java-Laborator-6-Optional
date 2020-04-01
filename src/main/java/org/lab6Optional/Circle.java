package org.lab6Optional;

import java.awt.*;

public class Circle implements Shape {
    private int x;
    private int y;
    private int radius;
    Graphics2D graphics2D;

    Circle(int x,int y,int radius,Graphics2D graphics2D){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.graphics2D = graphics2D;
        drawShape();
    }
    public void drawShape(){
        graphics2D.fillOval(x,y,radius,radius);
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public int getRadius() {
        return radius;
    }
}
