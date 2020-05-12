package dk.via.shapes;

import java.awt.*;

/**
 * Decorator
 */
public class RotatedShape {
    private final Shape delegate;
    private final double degrees;

    public RotatedShape(Shape delegate, double degrees) {
        this.delegate = delegate;
        this.degrees = degrees;
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
        double radians = Math.toRadians(degrees);
        g.rotate(radians);
        delegate.paint(g);
        g.rotate(-radians);
    }
}
