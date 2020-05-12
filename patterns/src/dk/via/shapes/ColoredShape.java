package dk.via.shapes;

import java.awt.*;

/**
 * Decorator
 */
public class ColoredShape implements Shape {
    private final Color color;
    private final Shape delegate;

    public ColoredShape(Color color, Shape delegate) {
        this.color = color;
        this.delegate = delegate;
    }

    public double getX() {
        return delegate.getX();
    }

    public double getY() {
        return delegate.getY();
    }

    public double getWidth() {
        return delegate.getWidth();
    }

    public double getHeight() {
        return delegate.getHeight();
    }

    public void move(double dx, double dy) {
        delegate.move(dx, dy);
    }

    public void scale(double factor) {
        delegate.scale(factor);
    }

    public void paint(Graphics2D g) {
        Color oldColor = g.getColor();
        g.setColor(this.color);
        delegate.paint(g);
        g.setColor(oldColor);
    }
}
