package org.lab6Optional;

import java.awt.*;

public class RegularPolygon extends Polygon implements Shape {
    private int x;
    private int y;
    private int radius;
    private int sides;
    Graphics2D graphics2D;

    public RegularPolygon(int x0, int y0, int radius, int sides,Graphics2D graphics) {
        this.x = x0;
        this.y = y0;
        this.radius = radius;
        this.sides = sides;
        this.graphics2D = graphics;
        drawShape();
    }
    public void drawShape(){
        double alpha = 2 * Math.PI / sides;
        for (int i = 0; i < sides; i++) {
            double x1 = x + radius * Math.cos(alpha * i);
            double y1 = y + radius * Math.sin(alpha * i);
            this.addPoint((int) x1, (int) y1);
        }
        graphics2D.fill(this);
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

    public int getSides() {
        return sides;
    }
}