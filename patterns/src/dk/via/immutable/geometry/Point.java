package dk.via.immutable.geometry;

import java.util.Objects;

public final class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point plus(Vector vector) {
        return new Point(x + vector.getDx(), y + vector.getDy());
    }

    public Point minus(Vector vector) {
        return new Point(x - vector.getDx(), y - vector.getDy());
    }

    public Vector to(Point p) {
        return new Vector(p.x - x, p.y - y);
    }

    public double distanceTo(Point p) {
        return this.to(p).getLength();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) return false;
        Point other = (Point) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
