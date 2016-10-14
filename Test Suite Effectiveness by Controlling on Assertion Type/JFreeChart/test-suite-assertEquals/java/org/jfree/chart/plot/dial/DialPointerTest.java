package org.jfree.chart.plot.dial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link DialPointer} class.
 */
public class DialPointerTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DialPointer i1 = new DialPointer.Pin(1);
        DialPointer i2 = new DialPointer.Pin(1);
        i1 = new DialPointer.Pin(2);
        i2 = new DialPointer.Pin(2);
        i1.setVisible(false);
        i2.setVisible(false);
    }

    /**
     * Check the equals() method for the DialPointer.Pin class.
     */
    public void testEqualsPin() {
        DialPointer.Pin p1 = new DialPointer.Pin();
        DialPointer.Pin p2 = new DialPointer.Pin();
        p1.setPaint(Color.green);
        p2.setPaint(Color.green);
        BasicStroke s = new BasicStroke(4.4f);
        p1.setStroke(s);
        p2.setStroke(s);
    }

    /**
     * Check the equals() method for the DialPointer.Pointer class.
     */
    public void testEqualsPointer() {
        DialPointer.Pointer p1 = new DialPointer.Pointer();
        DialPointer.Pointer p2 = new DialPointer.Pointer();
        p1.setFillPaint(Color.green);
        p2.setFillPaint(Color.green);
        p1.setOutlinePaint(Color.green);
        p2.setOutlinePaint(Color.green);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        DialPointer i1 = new DialPointer.Pin(1);
        DialPointer i2 = new DialPointer.Pin(1);
        int h1 = i1.hashCode();
        int h2 = i2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DialPointer i1 = new DialPointer.Pin(1);
        DialPointer i2 = (DialPointer) i1.clone();
        MyDialLayerChangeListener l1 = new MyDialLayerChangeListener();
        i1.addChangeListener(l1);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DialPointer i1 = new DialPointer.Pin(1);
        DialPointer i2 = (DialPointer) TestUtilities.serialised(i1);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization2() {
        DialPointer i1 = new DialPointer.Pointer(1);
        DialPointer i2 = (DialPointer) TestUtilities.serialised(i1);
    }
}
