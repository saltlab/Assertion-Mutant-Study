package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Font;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link MarkerAxisBand} class.
 */
public class MarkerAxisBandTest {

    /**
     * Test that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        Font font1 = new Font("SansSerif", Font.PLAIN, 12);
        Font font2 = new Font("SansSerif", Font.PLAIN, 14);
        MarkerAxisBand a1 = new MarkerAxisBand(null, 1.0, 1.0, 1.0, 1.0, font1);
        MarkerAxisBand a2 = new MarkerAxisBand(null, 1.0, 1.0, 1.0, 1.0, font1);
        a1 = new MarkerAxisBand(null, 2.0, 1.0, 1.0, 1.0, font1);
        a2 = new MarkerAxisBand(null, 2.0, 1.0, 1.0, 1.0, font1);
        a1 = new MarkerAxisBand(null, 2.0, 3.0, 1.0, 1.0, font1);
        a2 = new MarkerAxisBand(null, 2.0, 3.0, 1.0, 1.0, font1);
        a1 = new MarkerAxisBand(null, 2.0, 3.0, 4.0, 1.0, font1);
        a2 = new MarkerAxisBand(null, 2.0, 3.0, 4.0, 1.0, font1);
        a1 = new MarkerAxisBand(null, 2.0, 3.0, 4.0, 5.0, font1);
        a2 = new MarkerAxisBand(null, 2.0, 3.0, 4.0, 5.0, font1);
        a1 = new MarkerAxisBand(null, 2.0, 3.0, 4.0, 5.0, font2);
        a2 = new MarkerAxisBand(null, 2.0, 3.0, 4.0, 5.0, font2);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        Font font1 = new Font("SansSerif", Font.PLAIN, 12);
        MarkerAxisBand a1 = new MarkerAxisBand(null, 1.0, 1.0, 1.0, 1.0, font1);
        MarkerAxisBand a2 = new MarkerAxisBand(null, 1.0, 1.0, 1.0, 1.0, font1);
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        MarkerAxisBand a1 = new MarkerAxisBand(null, 1.0, 1.0, 1.0, 1.0, null);
        MarkerAxisBand a2 = (MarkerAxisBand) TestUtilities.serialised(a1);
    }
}
