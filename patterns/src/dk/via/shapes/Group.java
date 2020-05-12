package dk.via.shapes;

import java.awt.*;
import java.util.stream.Stream;

/**
 * Composite
 */
public class Group implements Shape {
    private final Shape[] shapes;

    public Group(Shape[] shapes) {
        this.shapes = shapes.clone();
    }

    @Override
    public double getX() {
        return Stream.of(shapes).mapToDouble(Shape::getX).min().orElse(0);
    }

    @Override
    public double getY() {
        return Stream.of(shapes).mapToDouble(Shape::getY).min().orElse(0);
    }

    @Override
    public double getWidth() {
        return Stream.of(shapes).mapToDouble(Shape::getX).max().orElse(0) - getX();
    }

    @Override
    public double getHeight() {
        return Stream.of(shapes).mapToDouble(Shape::getY).max().orElse(0) - getY();
    }

    @Override
    public void move(double dx, double dy) {
        for(Shape shape: shapes)
            shape.move(dx, dy);
    }

    @Override
    public void scale(double factor) {
        for(Shape shape: shapes)
            shape.scale(factor);
    }

    @Override
    public void paint(Graphics2D g) {
        for(Shape shape: shapes)
            shape.paint(g);
    }
}
