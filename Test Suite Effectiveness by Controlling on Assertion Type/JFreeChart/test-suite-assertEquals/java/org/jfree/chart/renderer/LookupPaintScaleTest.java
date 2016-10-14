package org.jfree.chart.renderer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Color;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link LookupPaintScale} class.
 */
public class LookupPaintScaleTest {

    /**
     * A test for the equals() method.
     */
    public void testEquals() {
        LookupPaintScale g1 = new LookupPaintScale();
        LookupPaintScale g2 = new LookupPaintScale();
        g1 = new LookupPaintScale(1.0, 2.0, Color.red);
        g2 = new LookupPaintScale(1.0, 2.0, Color.red);
        g1.add(1.5, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        g2.add(1.5, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        LookupPaintScale g1 = new LookupPaintScale();
        LookupPaintScale g2 = (LookupPaintScale) g1.clone();
        g1.add(0.5, Color.red);
        g2.add(0.5, Color.red);
        g1 = new LookupPaintScale(1.0, 2.0, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.green));
        g1.add(1.5, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        g2 = (LookupPaintScale) g1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        LookupPaintScale g1 = new LookupPaintScale();
        LookupPaintScale g2 = (LookupPaintScale) TestUtilities.serialised(g1);
        g1 = new LookupPaintScale(1.0, 2.0, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        g1.add(1.5, new GradientPaint(1.1f, 2.2f, Color.red, 3.3f, 4.4f, Color.blue));
        g2 = (LookupPaintScale) TestUtilities.serialised(g1);
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * Some checks for the default constructor.
     */
    public void testConstructor1() {
        LookupPaintScale s = new LookupPaintScale();
    }

    /**
     * Some checks for the other constructor.
     */
    public void testConstructor2() {
        LookupPaintScale s = new LookupPaintScale(1.0, 2.0, Color.red);
    }

    /**
     * Some general checks for the lookup table.
     */
    public void testGeneral() {
        LookupPaintScale s = new LookupPaintScale(0.0, 100.0, Color.black);
        s.add(50.0, Color.blue);
        s.add(50.0, Color.red);
        s.add(25.0, Color.green);
        s.add(75.0, Color.yellow);
    }
}
