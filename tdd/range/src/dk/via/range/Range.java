package dk.via.range;

public class Range {
    private int from;
    private int to;

    public Range(int from, int to) {
        if (from > to) throw new IllegalArgumentException();
        if (from == to) {
            this.from = 0;
            this.to = 0;
        } else {
            this.from = from;
            this.to = to;
        }
    }

    public boolean contains(int i) {
        return from <= i && i < to;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Range))
            return false;
        Range other = (Range) obj;
        return from == other.from && to == other.to;
    }

    public Range intersectionWith(Range range) {
        int intersectFrom = Math.max(from, range.from);
        int intersectTo = Math.min(to, range.to);
        if (intersectFrom > intersectTo)
            return new Range(0, 0);
        else
            return new Range(intersectFrom, intersectTo);
    }

    public boolean overlaps(Range range) {
        return from < range.to && range.from < to;
    }
}
