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
 * Tests for the {@link StandardDialFrame} class.
 */
public class StandardDialFrameTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        StandardDialFrame f1 = new StandardDialFrame();
        StandardDialFrame f2 = new StandardDialFrame();
        f1.setRadius(0.2);
        f2.setRadius(0.2);
        f1.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.yellow));
        f2.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.yellow));
        f1.setForegroundPaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.green));
        f2.setForegroundPaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.green));
        f1.setStroke(new BasicStroke(2.4f));
        f2.setStroke(new BasicStroke(2.4f));
        f1.setVisible(false);
        f2.setVisible(false);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        StandardDialFrame f1 = new StandardDialFrame();
        StandardDialFrame f2 = new StandardDialFrame();
        int h1 = f1.hashCode();
        int h2 = f2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        StandardDialFrame f1 = new StandardDialFrame();
        StandardDialFrame f2 = (StandardDialFrame) f1.clone();
        MyDialLayerChangeListener l1 = new MyDialLayerChangeListener();
        f1.addChangeListener(l1);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardDialFrame f1 = new StandardDialFrame();
        StandardDialFrame f2 = (StandardDialFrame) TestUtilities.serialised(f1);
    }
}
