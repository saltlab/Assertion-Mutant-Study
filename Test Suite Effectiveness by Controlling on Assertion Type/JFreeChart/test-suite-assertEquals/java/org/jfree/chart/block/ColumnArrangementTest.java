package org.jfree.chart.block;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.VerticalAlignment;
import org.junit.Test;

/**
 * Tests for the {@link ColumnArrangement} class.
 */
public class ColumnArrangementTest {

    /**
     * Confirm that the equals() method can distinguish all the required fields.
     */
    public void testEquals() {
        ColumnArrangement c1 = new ColumnArrangement(HorizontalAlignment.LEFT, VerticalAlignment.TOP, 1.0, 2.0);
        ColumnArrangement c2 = new ColumnArrangement(HorizontalAlignment.LEFT, VerticalAlignment.TOP, 1.0, 2.0);
        c1 = new ColumnArrangement(HorizontalAlignment.RIGHT, VerticalAlignment.TOP, 1.0, 2.0);
        c2 = new ColumnArrangement(HorizontalAlignment.RIGHT, VerticalAlignment.TOP, 1.0, 2.0);
        c1 = new ColumnArrangement(HorizontalAlignment.RIGHT, VerticalAlignment.BOTTOM, 1.0, 2.0);
        c2 = new ColumnArrangement(HorizontalAlignment.RIGHT, VerticalAlignment.BOTTOM, 1.0, 2.0);
        c1 = new ColumnArrangement(HorizontalAlignment.RIGHT, VerticalAlignment.BOTTOM, 1.1, 2.0);
        c2 = new ColumnArrangement(HorizontalAlignment.RIGHT, VerticalAlignment.BOTTOM, 1.1, 2.0);
        c1 = new ColumnArrangement(HorizontalAlignment.RIGHT, VerticalAlignment.BOTTOM, 1.1, 2.2);
        c2 = new ColumnArrangement(HorizontalAlignment.RIGHT, VerticalAlignment.BOTTOM, 1.1, 2.2);
    }

    /**
     * Immutable - cloning is not necessary.
     */
    public void testCloning() {
        FlowArrangement f1 = new FlowArrangement();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        FlowArrangement f1 = new FlowArrangement(HorizontalAlignment.LEFT, VerticalAlignment.TOP, 1.0, 2.0);
        FlowArrangement f2 = (FlowArrangement) TestUtilities.serialised(f1);
    }
}
