package org.jfree.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link Range} class.
 */
public class RangeTest {

    /**
     * Confirm that the constructor initializes all the required fields.
     */
    public void testConstructor() {
        Range r1 = new Range(0.1, 1000.0);
        try {
            new Range(10.0, 0.0);
            fail("Lower bound cannot be greater than the upper");
        } catch (Exception e) {
        }
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        Range r1 = new Range(0.0, 1.0);
        Range r2 = new Range(0.0, 1.0);
        r1 = new Range(0.0, 1.0);
        r2 = new Range(0.5, 1.0);
        r1 = new Range(0.0, 1.0);
        r2 = new Range(0.0, 2.0);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    @Test
    public void testHashCode() {
        Range a1 = new Range(1.0, 100.0);
        Range a2 = new Range(1.0, 100.0);
        a1 = new Range(-100.0, 2.0);
        a2 = new Range(-100.0, 2.0);
        assertEquals(a1.hashCode(), a2.hashCode());
    }

    /**
     * Simple tests for the contains() method.
     */
    public void testContains() {
        Range r1 = new Range(0.0, 1.0);
    }

    /**
     * Tests the constrain() method for various values.
     */
    public void testConstrain() {
        Range r1 = new Range(0.0, 1.0);
        double d = r1.constrain(0.5);
        d = r1.constrain(0.0);
        d = r1.constrain(1.0);
        d = r1.constrain(-1.0);
        d = r1.constrain(2.0);
        d = r1.constrain(Double.POSITIVE_INFINITY);
        d = r1.constrain(Double.NEGATIVE_INFINITY);
        d = r1.constrain(Double.NaN);
    }

    /**
     * Simple tests for the intersects() method.
     */
    public void testIntersects() {
        Range r1 = new Range(0.0, 1.0);
    }

    /**
     * A simple test for the expand() method.
     */
    public void testExpand() {
        Range r1 = new Range(0.0, 100.0);
        Range r2 = Range.expand(r1, 0.10, 0.10);
        r2 = Range.expand(r1, 0.0, 0.0);
        try {
            Range.expand(null, 0.1, 0.1);
            fail("Null value is accepted");
        } catch (Exception e) {
        }
        r2 = Range.expand(r1, -0.8, -0.5);
    }

    /**
     * A simple test for the scale() method.
     */
    @Test
    public void testShift() {
        Range r1 = new Range(10.0, 20.0);
        Range r2 = Range.shift(r1, 20.0);
        r1 = new Range(0.0, 100.0);
        r2 = Range.shift(r1, -50.0, true);
        r1 = new Range(-10.0, 20.0);
        r2 = Range.shift(r1, 20.0, true);
        assertEquals(40.0, r2.getUpperBound(), 0.001);
        r1 = new Range(-10.0, 20.0);
        r2 = Range.shift(r1, -30.0, true);
        r1 = new Range(-10.0, 20.0);
        r2 = Range.shift(r1, 20.0, false);
        r1 = new Range(-10.0, 20.0);
        r2 = Range.shift(r1, -30.0, false);
        r2 = Range.shift(r1, 0.0);
        try {
            Range.shift(null, 0.1);
            fail("Null value is accepted");
        } catch (Exception e) {
        }
    }

    /**
     * A simple test for the scale() method.
     */
    public void testScale() {
        Range r1 = new Range(0.0, 100.0);
        Range r2 = Range.scale(r1, 0.10);
        r1 = new Range(-10.0, 100.0);
        r2 = Range.scale(r1, 2.0);
        r2 = Range.scale(r1, 1.0);
        try {
            Range.scale(null, 0.1);
            fail("Null value is accepted");
        } catch (Exception e) {
        }
        try {
            Range.scale(r1, -0.5);
            fail("Negative factor accepted");
        } catch (Exception e) {
        }
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        Range r1 = new Range(25.0, 133.42);
        Range r2 = (Range) TestUtilities.serialised(r1);
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * Some checks for the combine method.
     */
    public void testCombine() {
        Range r1 = new Range(1.0, 2.0);
        Range r2 = new Range(1.5, 2.5);
        Range r3 = new Range(Double.NaN, 1.3);
        Range rr = Range.combine(r1, r3);
        Range r4 = new Range(1.7, Double.NaN);
        rr = Range.combine(r4, r1);
    }

    /**
     * Some checks for the combineIgnoringNaN() method.
     */
    public void testCombineIgnoringNaN() {
        Range r1 = new Range(1.0, 2.0);
        Range r2 = new Range(1.5, 2.5);
        Range r3 = new Range(Double.NaN, 1.3);
        Range rr = Range.combineIgnoringNaN(r1, r3);
        Range r4 = new Range(1.7, Double.NaN);
        rr = Range.combineIgnoringNaN(r4, r1);
    }

    public void testIsNaNRange() {
    }
}
