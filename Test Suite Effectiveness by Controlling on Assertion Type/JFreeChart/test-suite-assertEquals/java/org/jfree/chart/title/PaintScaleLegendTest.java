package org.jfree.chart.title;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.GrayPaintScale;
import org.jfree.chart.renderer.LookupPaintScale;
import org.junit.Test;

/**
 * Tests for the {@link PaintScaleLegend} class.
 */
public class PaintScaleLegendTest {

    /**
     * Test that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        PaintScaleLegend l1 = new PaintScaleLegend(new GrayPaintScale(), new NumberAxis("X"));
        PaintScaleLegend l2 = new PaintScaleLegend(new GrayPaintScale(), new NumberAxis("X"));
        l1.setScale(new LookupPaintScale());
        l2.setScale(new LookupPaintScale());
        l1.setAxis(new NumberAxis("Axis 2"));
        l2.setAxis(new NumberAxis("Axis 2"));
        l1.setAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        l2.setAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        l1.setAxisOffset(99.0);
        l2.setAxisOffset(99.0);
        l1.setStripWidth(99.0);
        l2.setStripWidth(99.0);
        l1.setStripOutlineVisible(!l1.isStripOutlineVisible());
        l2.setStripOutlineVisible(l1.isStripOutlineVisible());
        l1.setStripOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        l2.setStripOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        l1.setStripOutlineStroke(new BasicStroke(1.1f));
        l2.setStripOutlineStroke(new BasicStroke(1.1f));
        l1.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        l2.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        l1.setSubdivisionCount(99);
        l2.setSubdivisionCount(99);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        PaintScaleLegend l1 = new PaintScaleLegend(new GrayPaintScale(), new NumberAxis("X"));
        PaintScaleLegend l2 = new PaintScaleLegend(new GrayPaintScale(), new NumberAxis("X"));
        int h1 = l1.hashCode();
        int h2 = l2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        PaintScaleLegend l1 = new PaintScaleLegend(new GrayPaintScale(), new NumberAxis("X"));
        PaintScaleLegend l2 = (PaintScaleLegend) l1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        PaintScaleLegend l1 = new PaintScaleLegend(new GrayPaintScale(), new NumberAxis("X"));
        PaintScaleLegend l2 = (PaintScaleLegend) TestUtilities.serialised(l1);
    }
}
