package dk.via.immutable.geometry;

import java.util.Objects;

public final class Vector {
    private final double dx;
    private final double dy;

    public Vector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public double getLength() {
        return Math.sqrt(dx * dx + dy * dy);
    }

    public Vector hat() {
        return new Vector(-dy, dx);
    }

    public double dot(Vector v) {
        return dx*v.dx + dy*v.dy;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector)) return false;
        Vector other = (Vector) obj;
        return dx == other.dx && dy == other.dy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dx, dy);
    }
}
