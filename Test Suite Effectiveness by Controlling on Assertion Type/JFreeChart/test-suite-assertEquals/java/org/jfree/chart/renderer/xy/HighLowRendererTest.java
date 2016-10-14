package org.jfree.chart.renderer.xy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import java.awt.Color;
import java.util.Date;
import org.jfree.chart.TestUtilities;
import org.jfree.data.Range;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.OHLCDataItem;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link HighLowRenderer} class.
 */
public class HighLowRendererTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        HighLowRenderer r1 = new HighLowRenderer();
        HighLowRenderer r2 = new HighLowRenderer();
        r1.setDrawOpenTicks(false);
        r2.setDrawOpenTicks(false);
        r1.setDrawCloseTicks(false);
        r2.setDrawCloseTicks(false);
        r1.setOpenTickPaint(Color.red);
        r2.setOpenTickPaint(Color.red);
        r1.setCloseTickPaint(Color.blue);
        r2.setCloseTickPaint(Color.blue);
        r1.setTickLength(99.9);
        r2.setTickLength(99.9);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        HighLowRenderer r1 = new HighLowRenderer();
        HighLowRenderer r2 = new HighLowRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        HighLowRenderer r1 = new HighLowRenderer();
        r1.setCloseTickPaint(Color.green);
        HighLowRenderer r2 = (HighLowRenderer) r1.clone();
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        HighLowRenderer r1 = new HighLowRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        HighLowRenderer r1 = new HighLowRenderer();
        r1.setCloseTickPaint(Color.green);
        HighLowRenderer r2 = (HighLowRenderer) TestUtilities.serialised(r1);
    }

    /**
     * Some checks for the findRangeBounds() method.
     */
    public void testFindRangeBounds() {
        HighLowRenderer renderer = new HighLowRenderer();
        OHLCDataItem item1 = new OHLCDataItem(new Date(1L), 2.0, 4.0, 1.0, 3.0, 100);
        OHLCDataset dataset = new DefaultOHLCDataset("S1", new OHLCDataItem[] { item1 });
        Range range = renderer.findRangeBounds(dataset);
        OHLCDataItem item2 = new OHLCDataItem(new Date(1L), -1.0, 3.0, -1.0, 3.0, 100);
        dataset = new DefaultOHLCDataset("S1", new OHLCDataItem[] { item1, item2 });
        range = renderer.findRangeBounds(dataset);
        dataset = new DefaultOHLCDataset("S1", new OHLCDataItem[] {});
        range = renderer.findRangeBounds(dataset);
        range = renderer.findRangeBounds(null);
    }
}
