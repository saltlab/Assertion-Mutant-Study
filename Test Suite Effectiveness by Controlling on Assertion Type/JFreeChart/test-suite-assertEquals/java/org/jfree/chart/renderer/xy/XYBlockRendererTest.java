package org.jfree.chart.renderer.xy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import java.awt.Color;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.renderer.GrayPaintScale;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.data.Range;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link XYBlockRenderer} class.
 */
public class XYBlockRendererTest {

    private static final double EPSILON = 0.0000000001;

    /**
     * Test that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        XYBlockRenderer r1 = new XYBlockRenderer();
        XYBlockRenderer r2 = new XYBlockRenderer();
        r1.setBlockHeight(2.0);
        r2.setBlockHeight(2.0);
        r1.setBlockWidth(2.0);
        r2.setBlockWidth(2.0);
        r1.setPaintScale(new GrayPaintScale(0.0, 1.0));
        r2.setPaintScale(new GrayPaintScale(0.0, 1.0));
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        XYBlockRenderer r1 = new XYBlockRenderer();
        XYBlockRenderer r2 = new XYBlockRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYBlockRenderer r1 = new XYBlockRenderer();
        LookupPaintScale scale1 = new LookupPaintScale();
        r1.setPaintScale(scale1);
        XYBlockRenderer r2 = (XYBlockRenderer) r1.clone();
        scale1.add(0.5, Color.red);
        LookupPaintScale scale2 = (LookupPaintScale) r2.getPaintScale();
        scale2.add(0.5, Color.red);
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        XYBlockRenderer r1 = new XYBlockRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYBlockRenderer r1 = new XYBlockRenderer();
        XYBlockRenderer r2 = (XYBlockRenderer) TestUtilities.serialised(r1);
    }

    /**
     * A simple test for bug 1766646.
     */
    public void testBug1766646A() {
        XYBlockRenderer r = new XYBlockRenderer();
        Range range = r.findDomainBounds(null);
        DefaultXYZDataset emptyDataset = new DefaultXYZDataset();
        range = r.findDomainBounds(emptyDataset);
    }

    /**
     * A simple test for bug 1766646.
     */
    public void testBug1766646B() {
        XYBlockRenderer r = new XYBlockRenderer();
        Range range = r.findRangeBounds(null);
        DefaultXYZDataset emptyDataset = new DefaultXYZDataset();
        range = r.findRangeBounds(emptyDataset);
    }

    /**
     * Some tests for the findRangeBounds() method.
     */
    public void testFindRangeBounds() {
        XYBlockRenderer renderer = new XYBlockRenderer();
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("S1");
        series.add(1.0, null);
        dataset.addSeries(series);
        Range r = renderer.findRangeBounds(dataset);
    }

    /**
     * Some tests for the findDomainBounds() method.
     */
    public void testFindDomainBounds() {
        XYBlockRenderer renderer = new XYBlockRenderer();
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("S1");
        series.add(1.0, null);
        dataset.addSeries(series);
        Range r = renderer.findDomainBounds(dataset);
        dataset.removeAllSeries();
        r = renderer.findDomainBounds(dataset);
    }
}
