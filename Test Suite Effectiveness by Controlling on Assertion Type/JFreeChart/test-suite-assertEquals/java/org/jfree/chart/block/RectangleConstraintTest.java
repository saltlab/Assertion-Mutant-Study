package org.jfree.chart.block;

import static org.junit.Assert.assertEquals;
import org.jfree.data.Range;
import org.jfree.ui.Size2D;
import org.junit.Test;

/**
 * Tests for the {@link RectangleConstraint} class.
 */
public class RectangleConstraintTest {

    private static final double EPSILON = 0.0000000001;

    /**
     * Run some checks on the constrained size calculation.
     */
    public void testCalculateConstrainedSize() {
        Size2D s;
        RectangleConstraint c1 = RectangleConstraint.NONE;
        s = c1.calculateConstrainedSize(new Size2D(1.2, 3.4));
        RectangleConstraint c2 = new RectangleConstraint(0.0, new Range(0.0, 0.0), LengthConstraintType.NONE, 0.0, new Range(2.0, 3.0), LengthConstraintType.RANGE);
        s = c2.calculateConstrainedSize(new Size2D(1.2, 3.4));
        RectangleConstraint c3 = new RectangleConstraint(0.0, null, LengthConstraintType.NONE, 9.9, null, LengthConstraintType.FIXED);
        s = c3.calculateConstrainedSize(new Size2D(1.2, 3.4));
        RectangleConstraint c4 = new RectangleConstraint(0.0, new Range(2.0, 3.0), LengthConstraintType.RANGE, 0.0, new Range(0.0, 0.0), LengthConstraintType.NONE);
        s = c4.calculateConstrainedSize(new Size2D(1.2, 3.4));
        RectangleConstraint c5 = new RectangleConstraint(0.0, new Range(2.0, 3.0), LengthConstraintType.RANGE, 0.0, new Range(2.0, 3.0), LengthConstraintType.RANGE);
        s = c5.calculateConstrainedSize(new Size2D(1.2, 3.4));
        RectangleConstraint c6 = new RectangleConstraint(0.0, null, LengthConstraintType.NONE, 9.9, null, LengthConstraintType.FIXED);
        s = c6.calculateConstrainedSize(new Size2D(1.2, 3.4));
        RectangleConstraint c7 = RectangleConstraint.NONE;
        s = c7.calculateConstrainedSize(new Size2D(1.2, 3.4));
        RectangleConstraint c8 = new RectangleConstraint(0.0, new Range(0.0, 0.0), LengthConstraintType.NONE, 0.0, new Range(2.0, 3.0), LengthConstraintType.RANGE);
        s = c8.calculateConstrainedSize(new Size2D(1.2, 3.4));
        RectangleConstraint c9 = new RectangleConstraint(0.0, null, LengthConstraintType.NONE, 9.9, null, LengthConstraintType.FIXED);
        s = c9.calculateConstrainedSize(new Size2D(1.2, 3.4));
    }
}
