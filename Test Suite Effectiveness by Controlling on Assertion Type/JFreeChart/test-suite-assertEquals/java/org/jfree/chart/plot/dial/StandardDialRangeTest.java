package org.jfree.chart.plot.dial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Color;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link StandardDialRange} class.
 */
public class StandardDialRangeTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        StandardDialRange r1 = new StandardDialRange();
        StandardDialRange r2 = new StandardDialRange();
        r1.setLowerBound(1.1);
        r2.setLowerBound(1.1);
        r1.setUpperBound(11.1);
        r2.setUpperBound(11.1);
        r1.setPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        r2.setPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        r1.setVisible(false);
        r2.setVisible(false);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        StandardDialRange r1 = new StandardDialRange();
        StandardDialRange r2 = new StandardDialRange();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        StandardDialRange r1 = new StandardDialRange();
        StandardDialRange r2 = (StandardDialRange) r1.clone();
        MyDialLayerChangeListener l1 = new MyDialLayerChangeListener();
        r1.addChangeListener(l1);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardDialRange r1 = new StandardDialRange();
        StandardDialRange r2 = (StandardDialRange) TestUtilities.serialised(r1);
    }
}
