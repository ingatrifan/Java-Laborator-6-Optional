package org.lab6Optional;

import java.awt.*;

public class Snowflake implements Shape {
    private int minRadius;
    private int x;
    private int y;
    private int radius;
    private Graphics2D g;
    public Snowflake(int x, int y, int radius, Graphics2D g){
        minRadius = 1;
        this.x =x;
        this.y = y;
        this.radius = radius;
        this.g=g;
        drawSnowflake(x,y,radius);
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

    public void drawShape(){
        drawSnowflake(x,y,radius);
    }

    public void drawSnowflake(int x, int y, int radius) {
        g.drawLine(x, y, x + radius, y);  // 1
        g.drawLine(x, y, x + (radius / 2), y - ((int) ((radius / 2) * Math.sqrt(3))));  // 2
        g.drawLine(x, y, x - (radius / 2), y - ((int) ((radius / 2) * Math.sqrt(3))));  // 3
        g.drawLine(x, y, x - radius, y); // 4
        g.drawLine(x, y, x - (radius / 2), y + ((int) ((radius / 2) * Math.sqrt(3))));  // 5
        g.drawLine(x, y, x + (radius / 2), y + ((int) ((radius / 2) * Math.sqrt(3))));  // 6
        //recursion
        int newRadius = radius / 3;

        if (newRadius >= minRadius) {
            drawSnowflake(x + radius, y, newRadius);
            drawSnowflake(x + (radius / 2), y - ((int) ((radius / 2) * Math.sqrt(3))), newRadius);
            drawSnowflake(x - (radius / 2), y - ((int) ((radius / 2) * Math.sqrt(3))), newRadius);
            drawSnowflake(x - radius, y, newRadius);
            drawSnowflake(x - (radius / 2), y + ((int) ((radius / 2) * Math.sqrt(3))), newRadius);
            drawSnowflake(x + (radius / 2), y + ((int) ((radius / 2) * Math.sqrt(3))), newRadius);
        }
    }
}
