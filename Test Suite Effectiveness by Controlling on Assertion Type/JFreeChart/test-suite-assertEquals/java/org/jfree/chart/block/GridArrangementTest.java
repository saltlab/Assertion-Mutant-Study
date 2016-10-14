package org.jfree.chart.block;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.jfree.data.Range;
import org.jfree.ui.Size2D;
import org.junit.Test;

/**
 * Tests for the {@link GridArrangement} class.
 */
public class GridArrangementTest {

    /**
     * Confirm that the equals() method can distinguish all the required fields.
     */
    public void testEquals() {
        GridArrangement f1 = new GridArrangement(11, 22);
        GridArrangement f2 = new GridArrangement(11, 22);
        f1 = new GridArrangement(33, 22);
        f2 = new GridArrangement(33, 22);
        f1 = new GridArrangement(33, 44);
        f2 = new GridArrangement(33, 44);
    }

    /**
     * Immutable - cloning is not necessary.
     */
    public void testCloning() {
        GridArrangement f1 = new GridArrangement(1, 2);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        GridArrangement f1 = new GridArrangement(33, 44);
        GridArrangement f2 = (GridArrangement) TestUtilities.serialised(f1);
    }

    private static final double EPSILON = 0.000000001;

    /**
     * Test arrangement with no constraints.
     */
    public void testNN() {
        BlockContainer c = createTestContainer1();
        Size2D s = c.arrange(null, RectangleConstraint.NONE);
    }

    /**
     * Test arrangement with a fixed width and no height constraint.
     */
    public void testFN() {
        BlockContainer c = createTestContainer1();
        RectangleConstraint constraint = new RectangleConstraint(100.0, null, LengthConstraintType.FIXED, 0.0, null, LengthConstraintType.NONE);
        Size2D s = c.arrange(null, constraint);
    }

    /**
     * Test arrangement with a fixed height and no width constraint.
     */
    public void testNF() {
        BlockContainer c = createTestContainer1();
        RectangleConstraint constraint = RectangleConstraint.NONE.toFixedHeight(100.0);
        Size2D s = c.arrange(null, constraint);
    }

    /**
     * Test arrangement with a range for the width and a fixed height.
     */
    public void testRF() {
        BlockContainer c = createTestContainer1();
        RectangleConstraint constraint = new RectangleConstraint(new Range(40.0, 60.0), 100.0);
        Size2D s = c.arrange(null, constraint);
    }

    /**
     * Test arrangement with a range for the width and height.
     */
    @Test
    public void testRR() {
        BlockContainer c = createTestContainer1();
        RectangleConstraint constraint = new RectangleConstraint(new Range(40.0, 60.0), new Range(50.0, 70.0));
        Size2D s = c.arrange(null, constraint);
        assertEquals(50.0, s.height, EPSILON);
    }

    /**
     * Test arrangement with a range for the width and no height constraint.
     */
    public void testRN() {
        BlockContainer c = createTestContainer1();
        RectangleConstraint constraint = RectangleConstraint.NONE.toRangeWidth(new Range(40.0, 60.0));
        Size2D s = c.arrange(null, constraint);
    }

    /**
     * Test arrangement with a range for the height and no width constraint.
     */
    public void testNR() {
        BlockContainer c = createTestContainer1();
        RectangleConstraint constraint = RectangleConstraint.NONE.toRangeHeight(new Range(40.0, 60.0));
        Size2D s = c.arrange(null, constraint);
    }

    private BlockContainer createTestContainer1() {
        Block b1 = new EmptyBlock(10, 11);
        Block b2 = new EmptyBlock(20, 22);
        Block b3 = new EmptyBlock(30, 33);
        BlockContainer result = new BlockContainer(new GridArrangement(1, 3));
        result.add(b1);
        result.add(b2);
        result.add(b3);
        return result;
    }

    /**
     * The arrangement should be able to handle null blocks in the layout.
     */
    public void testNullBlock_FF() {
        BlockContainer c = new BlockContainer(new GridArrangement(1, 1));
        c.add(null);
        Size2D s = c.arrange(null, new RectangleConstraint(20, 10));
    }

    /**
     * The arrangement should be able to handle null blocks in the layout.
     */
    public void testNullBlock_FN() {
        BlockContainer c = new BlockContainer(new GridArrangement(1, 1));
        c.add(null);
        Size2D s = c.arrange(null, RectangleConstraint.NONE.toFixedWidth(10));
    }

    /**
     * The arrangement should be able to handle null blocks in the layout.
     */
    public void testNullBlock_FR() {
        BlockContainer c = new BlockContainer(new GridArrangement(1, 1));
        c.add(null);
        Size2D s = c.arrange(null, new RectangleConstraint(30.0, new Range(5.0, 10.0)));
    }

    /**
     * The arrangement should be able to handle null blocks in the layout.
     */
    public void testNullBlock_NN() {
        BlockContainer c = new BlockContainer(new GridArrangement(1, 1));
        c.add(null);
        Size2D s = c.arrange(null, RectangleConstraint.NONE);
    }

    /**
     * The arrangement should be able to handle less blocks than grid spaces.
     */
    public void testGridNotFull_FF() {
        Block b1 = new EmptyBlock(5, 5);
        BlockContainer c = new BlockContainer(new GridArrangement(2, 3));
        c.add(b1);
        Size2D s = c.arrange(null, new RectangleConstraint(200, 100));
    }

    /**
     * The arrangement should be able to handle less blocks than grid spaces.
     */
    public void testGridNotFull_FN() {
        Block b1 = new EmptyBlock(5, 5);
        BlockContainer c = new BlockContainer(new GridArrangement(2, 3));
        c.add(b1);
        Size2D s = c.arrange(null, RectangleConstraint.NONE.toFixedWidth(30.0));
    }

    /**
     * The arrangement should be able to handle less blocks than grid spaces.
     */
    public void testGridNotFull_FR() {
        Block b1 = new EmptyBlock(5, 5);
        BlockContainer c = new BlockContainer(new GridArrangement(2, 3));
        c.add(b1);
        Size2D s = c.arrange(null, new RectangleConstraint(30.0, new Range(5.0, 10.0)));
    }

    /**
     * The arrangement should be able to handle less blocks than grid spaces.
     */
    public void testGridNotFull_NN() {
        Block b1 = new EmptyBlock(5, 5);
        BlockContainer c = new BlockContainer(new GridArrangement(2, 3));
        c.add(b1);
        Size2D s = c.arrange(null, RectangleConstraint.NONE);
    }
}
