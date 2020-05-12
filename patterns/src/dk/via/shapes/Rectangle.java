package dk.via.shapes;

import java.awt.*;

public class Rectangle implements Shape {
    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void scale(double factor) {
        width *= factor;
        height *= factor;
    }

    @Override
    public void paint(Graphics2D g) {
        g.drawRect((int) x, (int) y, (int) width, (int) height);
    }
}
