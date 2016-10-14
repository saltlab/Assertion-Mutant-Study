package org.jfree.chart.renderer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Color;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link GrayPaintScale} class.
 */
public class GrayPaintScaleTest {

    private static final double EPSILON = 0.000000001;

    /**
     * Simple check for the default constructor.
     */
    public void testConstructor() {
        GrayPaintScale gps = new GrayPaintScale();
    }

    /**
     * Some checks for the getPaint() method.
     */
    public void testGetPaint() {
        GrayPaintScale gps = new GrayPaintScale();
        Color c = (Color) gps.getPaint(0.0);
        c = (Color) gps.getPaint(1.0);
        c = (Color) gps.getPaint(-0.5);
        c = (Color) gps.getPaint(1.5);
    }

    /**
     * A test for the equals() method.
     */
    public void testEquals() {
        GrayPaintScale g1 = new GrayPaintScale();
        GrayPaintScale g2 = new GrayPaintScale();
        g1 = new GrayPaintScale(0.0, 1.0);
        g2 = new GrayPaintScale(0.0, 1.0);
        g1 = new GrayPaintScale(0.1, 1.0);
        g2 = new GrayPaintScale(0.1, 1.0);
        g1 = new GrayPaintScale(0.1, 0.9);
        g2 = new GrayPaintScale(0.1, 0.9);
        g1 = new GrayPaintScale(0.1, 0.9, 128);
        g2 = new GrayPaintScale(0.1, 0.9, 128);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        GrayPaintScale g1 = new GrayPaintScale();
        GrayPaintScale g2 = (GrayPaintScale) g1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        GrayPaintScale g1 = new GrayPaintScale();
        GrayPaintScale g2 = (GrayPaintScale) TestUtilities.serialised(g1);
    }
}
