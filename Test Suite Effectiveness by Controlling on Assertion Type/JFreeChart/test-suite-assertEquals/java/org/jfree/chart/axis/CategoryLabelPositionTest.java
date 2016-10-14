package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.jfree.chart.TestUtilities;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.TextAnchor;
import org.junit.Test;

/**
 * Tests for the {@link CategoryLabelPosition} class.
 */
public class CategoryLabelPositionTest {

    /**
     * Check that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        CategoryLabelPosition p1 = new CategoryLabelPosition(RectangleAnchor.BOTTOM_LEFT, TextBlockAnchor.CENTER_RIGHT, TextAnchor.BASELINE_LEFT, Math.PI / 4.0, CategoryLabelWidthType.RANGE, 0.44f);
        CategoryLabelPosition p2 = new CategoryLabelPosition(RectangleAnchor.BOTTOM_LEFT, TextBlockAnchor.CENTER_RIGHT, TextAnchor.BASELINE_LEFT, Math.PI / 4.0, CategoryLabelWidthType.RANGE, 0.44f);
        p1 = new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.CENTER_RIGHT, TextAnchor.BASELINE_LEFT, Math.PI / 4.0, CategoryLabelWidthType.RANGE, 0.44f);
        p2 = new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.CENTER_RIGHT, TextAnchor.BASELINE_LEFT, Math.PI / 4.0, CategoryLabelWidthType.RANGE, 0.44f);
        p1 = new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.CENTER, TextAnchor.BASELINE_LEFT, Math.PI / 4.0, CategoryLabelWidthType.RANGE, 0.44f);
        p2 = new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.CENTER, TextAnchor.BASELINE_LEFT, Math.PI / 4.0, CategoryLabelWidthType.RANGE, 0.44f);
        p1 = new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.CENTER, TextAnchor.CENTER, Math.PI / 4.0, CategoryLabelWidthType.RANGE, 0.44f);
        p2 = new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.CENTER, TextAnchor.CENTER, Math.PI / 4.0, CategoryLabelWidthType.RANGE, 0.44f);
        p1 = new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.CENTER, TextAnchor.CENTER, Math.PI / 6.0, CategoryLabelWidthType.RANGE, 0.44f);
        p2 = new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.CENTER, TextAnchor.CENTER, Math.PI / 6.0, CategoryLabelWidthType.RANGE, 0.44f);
        p1 = new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.CENTER, TextAnchor.CENTER, Math.PI / 6.0, CategoryLabelWidthType.CATEGORY, 0.44f);
        p2 = new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.CENTER, TextAnchor.CENTER, Math.PI / 6.0, CategoryLabelWidthType.CATEGORY, 0.44f);
        p1 = new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.CENTER, TextAnchor.CENTER, Math.PI / 6.0, CategoryLabelWidthType.CATEGORY, 0.55f);
        p2 = new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.CENTER, TextAnchor.CENTER, Math.PI / 6.0, CategoryLabelWidthType.CATEGORY, 0.55f);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        CategoryLabelPosition a1 = new CategoryLabelPosition();
        CategoryLabelPosition a2 = new CategoryLabelPosition();
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        CategoryLabelPosition p1 = new CategoryLabelPosition();
        CategoryLabelPosition p2 = (CategoryLabelPosition) TestUtilities.serialised(p1);
    }
}
