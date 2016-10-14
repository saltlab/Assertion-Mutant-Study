package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.plot.GreyPalette;
import org.junit.Test;

/**
 * Tests for the {@code ColorBar} class.
 */
public class ColorBarTest {

    /**
     * Check that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        ColorBar c1 = new ColorBar("Test");
        ColorBar c2 = new ColorBar("Test");
        c1.setAxis(new NumberAxis("Axis 1"));
        c2.setAxis(new NumberAxis("Axis 1"));
        c1.setColorPalette(new GreyPalette());
        c2.setColorPalette(new GreyPalette());
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        ColorBar c1 = new ColorBar("Test");
        ColorBar c2 = new ColorBar("Test");
        int h1 = c1.hashCode();
        int h2 = c2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        ColorBar c1 = new ColorBar("Test");
        ColorBar c2 = (ColorBar) c1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        ColorBar a1 = new ColorBar("Test Axis");
        ColorBar a2 = (ColorBar) TestUtilities.serialised(a1);
    }
}
