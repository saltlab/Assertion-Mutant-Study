package org.jfree.chart.plot.dial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link StandardDialScale} class.
 */
public class StandardDialScaleTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        StandardDialScale s1 = new StandardDialScale();
        StandardDialScale s2 = new StandardDialScale();
        s1 = new StandardDialScale(10.0, 100.0, 0.0, 270.0, 10.0, 4);
        s2 = new StandardDialScale(10.0, 100.0, 0.0, 270.0, 10.0, 4);
        s1 = new StandardDialScale(10.0, 200.0, 0.0, 270.0, 10.0, 4);
        s2 = new StandardDialScale(10.0, 200.0, 0.0, 270.0, 10.0, 4);
        s1 = new StandardDialScale(10.0, 200.0, 20.0, 270.0, 10.0, 4);
        s2 = new StandardDialScale(10.0, 200.0, 20.0, 270.0, 10.0, 4);
        s1 = new StandardDialScale(10.0, 200.0, 20.0, 99.0, 10.0, 4);
        s2 = new StandardDialScale(10.0, 200.0, 20.0, 99.0, 10.0, 4);
        s1.setTickRadius(0.99);
        s2.setTickRadius(0.99);
        s1.setMajorTickIncrement(11.1);
        s2.setMajorTickIncrement(11.1);
        s1.setMajorTickLength(0.09);
        s2.setMajorTickLength(0.09);
        s1.setMajorTickPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        s2.setMajorTickPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        s1.setMajorTickStroke(new BasicStroke(1.1f));
        s2.setMajorTickStroke(new BasicStroke(1.1f));
        s1.setMinorTickCount(7);
        s2.setMinorTickCount(7);
        s1.setMinorTickLength(0.09);
        s2.setMinorTickLength(0.09);
        s1.setTickLabelOffset(0.11);
        s2.setTickLabelOffset(0.11);
        s1.setTickLabelFont(new Font("Dialog", Font.PLAIN, 15));
        s2.setTickLabelFont(new Font("Dialog", Font.PLAIN, 15));
        s1.setTickLabelPaint(new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.green));
        s2.setTickLabelPaint(new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.green));
        s1.setTickLabelsVisible(false);
        s2.setTickLabelsVisible(false);
        s1.setVisible(false);
        s2.setVisible(false);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        StandardDialScale s1 = new StandardDialScale();
        StandardDialScale s2 = new StandardDialScale();
        int h1 = s1.hashCode();
        int h2 = s2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        StandardDialScale s1 = new StandardDialScale();
        StandardDialScale s2 = (StandardDialScale) s1.clone();
        s1 = new StandardDialScale();
        s1.setExtent(123.4);
        s1.setMajorTickPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white));
        s1.setMajorTickStroke(new BasicStroke(2.0f));
        s2 = (StandardDialScale) s1.clone();
        MyDialLayerChangeListener l1 = new MyDialLayerChangeListener();
        s1.addChangeListener(l1);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardDialScale s1 = new StandardDialScale();
        StandardDialScale s2 = (StandardDialScale) TestUtilities.serialised(s1);
        s1 = new StandardDialScale();
        s1.setExtent(123.4);
        s1.setMajorTickPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white));
        s1.setMajorTickStroke(new BasicStroke(2.0f));
        s2 = (StandardDialScale) TestUtilities.serialised(s1);
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * Some checks for the valueToAngle() method.
     */
    public void testValueToAngle() {
        StandardDialScale s = new StandardDialScale();
        s = new StandardDialScale(0, 20, 180, -180.0, 10, 3);
    }

    /**
     * Some checks for the angleToValue() method.
     */
    public void testAngleToValue() {
        StandardDialScale s = new StandardDialScale();
        s = new StandardDialScale(0, 20, 180, -180.0, 10, 3);
    }
}
