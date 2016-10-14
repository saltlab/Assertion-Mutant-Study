package org.jfree.chart.block;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Color;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.UnitType;
import org.junit.Test;

/**
 * Tests for the {@link BlockBorder} class.
 */
public class BlockBorderTest {

    /**
     * Confirm that the equals() method can distinguish all the required fields.
     */
    public void testEquals() {
        BlockBorder b1 = new BlockBorder(new RectangleInsets(1.0, 2.0, 3.0, 4.0), Color.red);
        BlockBorder b2 = new BlockBorder(new RectangleInsets(1.0, 2.0, 3.0, 4.0), Color.red);
        b1 = new BlockBorder(new RectangleInsets(UnitType.RELATIVE, 1.0, 2.0, 3.0, 4.0), Color.red);
        b2 = new BlockBorder(new RectangleInsets(UnitType.RELATIVE, 1.0, 2.0, 3.0, 4.0), Color.red);
        b1 = new BlockBorder(new RectangleInsets(1.0, 2.0, 3.0, 4.0), Color.blue);
        b2 = new BlockBorder(new RectangleInsets(1.0, 2.0, 3.0, 4.0), Color.blue);
    }

    /**
     * Immutable - cloning not necessary.
     */
    public void testCloning() {
        BlockBorder b1 = new BlockBorder();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        BlockBorder b1 = new BlockBorder(new RectangleInsets(1.0, 2.0, 3.0, 4.0), new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        BlockBorder b2 = (BlockBorder) TestUtilities.serialised(b1);
    }
}
