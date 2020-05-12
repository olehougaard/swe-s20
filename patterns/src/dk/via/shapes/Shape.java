package dk.via.shapes;

import java.awt.*;

public interface Shape {
    double getX();

    double getY();

    double getWidth();

    double getHeight();

    void move(double dx, double dy);
    void scale(double factor);
    void paint(Graphics2D g);
}
