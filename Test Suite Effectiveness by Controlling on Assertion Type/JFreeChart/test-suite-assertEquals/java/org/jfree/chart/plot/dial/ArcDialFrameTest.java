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
 * Tests for the {@link ArcDialFrame} class.
 */
public class ArcDialFrameTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        ArcDialFrame f1 = new ArcDialFrame();
        ArcDialFrame f2 = new ArcDialFrame();
        f1.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        f2.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        f1.setForegroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        f2.setForegroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        f1.setStroke(new BasicStroke(1.1f));
        f2.setStroke(new BasicStroke(1.1f));
        f1.setInnerRadius(0.11);
        f2.setInnerRadius(0.11);
        f1.setOuterRadius(0.88);
        f2.setOuterRadius(0.88);
        f1.setStartAngle(99);
        f2.setStartAngle(99);
        f1.setExtent(33);
        f2.setExtent(33);
        f1.setVisible(false);
        f2.setVisible(false);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        ArcDialFrame f1 = new ArcDialFrame();
        ArcDialFrame f2 = new ArcDialFrame();
        int h1 = f1.hashCode();
        int h2 = f2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        ArcDialFrame f1 = new ArcDialFrame();
        ArcDialFrame f2 = (ArcDialFrame) f1.clone();
        MyDialLayerChangeListener l1 = new MyDialLayerChangeListener();
        f1.addChangeListener(l1);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        ArcDialFrame f1 = new ArcDialFrame();
        ArcDialFrame f2 = (ArcDialFrame) TestUtilities.serialised(f1);
    }
}
