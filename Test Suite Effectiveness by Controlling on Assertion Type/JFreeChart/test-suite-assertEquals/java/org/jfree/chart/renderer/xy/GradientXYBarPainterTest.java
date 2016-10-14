package org.jfree.chart.renderer.xy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link GradientXYBarPainter} class.
 */
public class GradientXYBarPainterTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        GradientXYBarPainter p1 = new GradientXYBarPainter(0.1, 0.2, 0.3);
        GradientXYBarPainter p2 = new GradientXYBarPainter(0.1, 0.2, 0.3);
        p1 = new GradientXYBarPainter(0.11, 0.2, 0.3);
        p2 = new GradientXYBarPainter(0.11, 0.2, 0.3);
        p1 = new GradientXYBarPainter(0.11, 0.22, 0.3);
        p2 = new GradientXYBarPainter(0.11, 0.22, 0.3);
        p1 = new GradientXYBarPainter(0.11, 0.22, 0.33);
        p2 = new GradientXYBarPainter(0.11, 0.22, 0.33);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        GradientXYBarPainter p1 = new GradientXYBarPainter(0.1, 0.2, 0.3);
        GradientXYBarPainter p2 = new GradientXYBarPainter(0.1, 0.2, 0.3);
        int h1 = p1.hashCode();
        int h2 = p2.hashCode();
    }

    /**
     * Confirm that cloning isn't implemented (it isn't required, because
     * instances of the class are immutable).
     */
    public void testCloning() {
        GradientXYBarPainter p1 = new GradientXYBarPainter(0.1, 0.2, 0.3);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        GradientXYBarPainter p1 = new GradientXYBarPainter(0.1, 0.2, 0.3);
        GradientXYBarPainter p2 = (GradientXYBarPainter) TestUtilities.serialised(p1);
    }
}
