package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.RectangleAnchor;
import org.junit.Test;

/**
 * Tests for the {@link CategoryLabelPositions} class.
 */
public class CategoryLabelPositionsTest {

    private static final RectangleAnchor RA_TOP = RectangleAnchor.TOP;

    private static final RectangleAnchor RA_BOTTOM = RectangleAnchor.BOTTOM;

    /**
     * Check that the equals method distinguishes all fields.
     */
    public void testEquals() {
        CategoryLabelPositions p1 = new CategoryLabelPositions(new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER));
        CategoryLabelPositions p2 = new CategoryLabelPositions(new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER));
        p1 = new CategoryLabelPositions(new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER));
        p2 = new CategoryLabelPositions(new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER));
        p1 = new CategoryLabelPositions(new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER));
        p2 = new CategoryLabelPositions(new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER));
        p1 = new CategoryLabelPositions(new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER));
        p2 = new CategoryLabelPositions(new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER));
        p1 = new CategoryLabelPositions(new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER));
        p2 = new CategoryLabelPositions(new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RA_BOTTOM, TextBlockAnchor.TOP_CENTER));
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        CategoryLabelPositions p1 = new CategoryLabelPositions(new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER));
        CategoryLabelPositions p2 = new CategoryLabelPositions(new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER), new CategoryLabelPosition(RA_TOP, TextBlockAnchor.CENTER));
        int h1 = p1.hashCode();
        int h2 = p2.hashCode();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    @Test
    public void testSerialization() {
        CategoryLabelPositions p1 = CategoryLabelPositions.STANDARD;
        CategoryLabelPositions p2 = (CategoryLabelPositions) TestUtilities.serialised(p1);
        assertEquals(p1, p2);
    }
}
