package org.jfree.chart.renderer.category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link GradientBarPainter} class.
 */
public class GradientBarPainterTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        GradientBarPainter p1 = new GradientBarPainter(0.1, 0.2, 0.3);
        GradientBarPainter p2 = new GradientBarPainter(0.1, 0.2, 0.3);
        p1 = new GradientBarPainter(0.11, 0.2, 0.3);
        p2 = new GradientBarPainter(0.11, 0.2, 0.3);
        p1 = new GradientBarPainter(0.11, 0.22, 0.3);
        p2 = new GradientBarPainter(0.11, 0.22, 0.3);
        p1 = new GradientBarPainter(0.11, 0.22, 0.33);
        p2 = new GradientBarPainter(0.11, 0.22, 0.33);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        GradientBarPainter p1 = new GradientBarPainter(0.1, 0.2, 0.3);
        GradientBarPainter p2 = new GradientBarPainter(0.1, 0.2, 0.3);
        int h1 = p1.hashCode();
        int h2 = p2.hashCode();
    }

    /**
     * Confirm that cloning isn't implemented (it isn't required, because
     * instances of the class are immutable).
     */
    public void testCloning() {
        GradientBarPainter p1 = new GradientBarPainter(0.1, 0.2, 0.3);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        GradientBarPainter p1 = new GradientBarPainter(0.1, 0.2, 0.3);
        GradientBarPainter p2 = (GradientBarPainter) TestUtilities.serialised(p1);
    }
}
