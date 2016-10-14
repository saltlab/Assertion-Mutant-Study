package org.jfree.chart.renderer.category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import java.awt.Color;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link WaterfallBarRenderer} class.
 */
public class WaterfallBarRendererTest {

    /**
     * Some tests for the findRangeBounds() method.
     */
    public void testFindRangeBounds() {
        WaterfallBarRenderer r = new WaterfallBarRenderer();
    }

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        WaterfallBarRenderer r1 = new WaterfallBarRenderer();
        WaterfallBarRenderer r2 = new WaterfallBarRenderer();
        r1.setFirstBarPaint(Color.cyan);
        r2.setFirstBarPaint(Color.cyan);
        r1.setLastBarPaint(Color.cyan);
        r2.setLastBarPaint(Color.cyan);
        r1.setPositiveBarPaint(Color.cyan);
        r2.setPositiveBarPaint(Color.cyan);
        r1.setNegativeBarPaint(Color.cyan);
        r2.setNegativeBarPaint(Color.cyan);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        WaterfallBarRenderer r1 = new WaterfallBarRenderer();
        WaterfallBarRenderer r2 = new WaterfallBarRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        WaterfallBarRenderer r1 = new WaterfallBarRenderer();
        WaterfallBarRenderer r2 = (WaterfallBarRenderer) r1.clone();
        r1.setFirstBarPaint(Color.yellow);
        r2.setFirstBarPaint(Color.yellow);
    }

    /**
     * Check that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        WaterfallBarRenderer r1 = new WaterfallBarRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        WaterfallBarRenderer r1 = new WaterfallBarRenderer();
        WaterfallBarRenderer r2 = (WaterfallBarRenderer) TestUtilities.serialised(r1);
    }
}
