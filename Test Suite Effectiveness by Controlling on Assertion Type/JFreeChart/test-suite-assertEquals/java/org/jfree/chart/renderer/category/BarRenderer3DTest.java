package org.jfree.chart.renderer.category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.awt.Color;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link BarRenderer3D} class.
 */
public class BarRenderer3DTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        BarRenderer3D r1 = new BarRenderer3D(1.0, 2.0);
        BarRenderer3D r2 = new BarRenderer3D(1.0, 2.0);
        r1 = new BarRenderer3D(1.1, 2.0);
        r2 = new BarRenderer3D(1.1, 2.0);
        r1 = new BarRenderer3D(1.1, 2.2);
        r2 = new BarRenderer3D(1.1, 2.2);
        r1.setWallPaint(new GradientPaint(1.0f, 2.0f, Color.red, 4.0f, 3.0f, Color.blue));
        r2.setWallPaint(new GradientPaint(1.0f, 2.0f, Color.red, 4.0f, 3.0f, Color.blue));
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        BarRenderer3D r1 = new BarRenderer3D();
        BarRenderer3D r2 = new BarRenderer3D();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        BarRenderer3D r1 = new BarRenderer3D();
        BarRenderer3D r2 = (BarRenderer3D) r1.clone();
    }

    /**
     * Check that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        BarRenderer3D r1 = new BarRenderer3D();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        BarRenderer3D r1 = new BarRenderer3D();
        r1.setWallPaint(new GradientPaint(1.0f, 2.0f, Color.red, 4.0f, 3.0f, Color.blue));
        BarRenderer3D r2 = (BarRenderer3D) TestUtilities.serialised(r1);
    }
}
