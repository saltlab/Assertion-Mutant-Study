package org.jfree.chart.plot.dial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link DialCap} class.
 */
public class DialCapTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DialCap c1 = new DialCap();
        DialCap c2 = new DialCap();
        c1.setRadius(0.5);
        c2.setRadius(0.5);
        c1.setFillPaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.green));
        c2.setFillPaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.green));
        c1.setOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.gray));
        c2.setOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.gray));
        c1.setOutlineStroke(new BasicStroke(1.1f));
        c2.setOutlineStroke(new BasicStroke(1.1f));
        c1.setVisible(false);
        c2.setVisible(false);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        DialCap c1 = new DialCap();
        DialCap c2 = new DialCap();
        int h1 = c1.hashCode();
        int h2 = c2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DialCap c1 = new DialCap();
        DialCap c2 = (DialCap) c1.clone();
        c1 = new DialCap();
        c1.setFillPaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.green));
        c1.setOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.gray));
        c1.setOutlineStroke(new BasicStroke(2.0f));
        c2 = (DialCap) c1.clone();
        MyDialLayerChangeListener l1 = new MyDialLayerChangeListener();
        c1.addChangeListener(l1);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DialCap c1 = new DialCap();
        DialCap c2 = (DialCap) TestUtilities.serialised(c1);
        c1 = new DialCap();
        c1.setFillPaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.green));
        c1.setOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.gray));
        c1.setOutlineStroke(new BasicStroke(2.0f));
        c2 = (DialCap) TestUtilities.serialised(c1);
    }
}
