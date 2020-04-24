package dk.via.range;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;

public class RangeTest {
    private Range range;
    private Range empty;

    @Before
    public void setUp() {
        range = new Range(2, 7);
        empty = new Range(0, 0);
    }

    @Test
    public void aRangeFromZeroToZeroIsEmpty() {
        assertFalse(empty.contains(0));
    }

    @Test
    public void aRangeContainsItsStartingPoint() {
        assertTrue(range.contains(2));
    }

    @Test
    public void aRangeContainsItsInternalPoint() {
        assertTrue(range.contains(4));
    }

    @Test
    public void aRangeDoesntContainItsEndingPoint() {
        assertFalse(range.contains(7));
    }

    @Test
    public void aRangeDoesntContainValuesLowerThanTheStartingPoint() {
        assertFalse(range.contains(1));
    }

    @Test
    public void aRangeDoesntContainValuesHigherThanTheEndPoint() {
        assertFalse(range.contains(8));
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorThrowsExceptionIfFromIsBiggerThanTo() {
        new Range(7, 2);
    }

    @Test
    public void emptyRangesAreEqual() {
        assertEquals(empty, new Range(3, 3));
    }

    @Test
    public void rangesAreEqualIfTheirStartAndEndPointAreTheSame() {
        assertEquals(range, new Range(2, 7));
    }

    @Test
    public void nonEmptyRangesAreNotEqualIfTheirStartPointsAreDifferent() {
        assertNotEquals(range, new Range(3, 7));
    }

    @Test
    public void nonEmptyRangesAreNotEqualIfTheirEndPointsAreDifferent() {
        assertNotEquals(range, new Range(2, 8));
    }

    @Test
    public void aRangeIsNotEqualToAString() {
        assertNotEquals(range, "[2, 7)");
    }

    @Test
    public void aRangesIntersectionWithItselfIsItself() {
        assertEquals(range, range.intersectionWith(range));
    }

    @Test
    public void intersectionOfOverlappingRangesIsSetIntersection() {
        assertEquals(new Range(4, 7), range.intersectionWith(new Range(4, 10)));
    }

    @Test
    public void intersectionOfNonOverlappingRangesIsEmpty() {
        assertEquals(empty, range.intersectionWith(new Range(8, 10)));
    }

    @Test
    public void emptyRangesDoNotOverlap() {
        assertFalse(empty.overlaps(empty));
    }

    @Test
    public void rangesThatAreLowerDontOverlapRangesThatAreHigher() {
        assertFalse(range.overlaps(new Range(8, 10)));
        assertFalse(new Range(8, 10).overlaps(range));
    }

    @Test
    public void rangesThatHaveElementsInCommonOverlap() {
        assertTrue(range.overlaps(new Range(4, 10)));
    }

    @Test
    public void rangesThatShareABoundaryDoNotOverlap() {
        assertFalse(range.overlaps(new Range(7, 10)));
    }
}
