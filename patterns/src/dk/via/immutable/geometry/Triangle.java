package dk.via.immutable.geometry;

import java.util.Objects;

public final class Triangle {
    private final Point p1, p2, p3;

    public Triangle(Point p1, Point p2, Point p3) {
        if (p1.to(p2).dot(p1.to(p3).hat()) == 0) throw new IllegalArgumentException();
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    public double circumference() {
        return p1.distanceTo(p2) + p2.distanceTo(p3) + p3.distanceTo(p1);
    }

    public double area() {
        double height = p1.to(p2).hat().dot(p1.to(p3));
        double baseline = p1.distanceTo(p2);
        return height * baseline / 2;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Triangle)) return false;
        Triangle other = (Triangle) obj;
        return p1.equals(other.p1) && p2.equals(other.p2) && p3.equals(other.p3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2, p3);
    }
}
