package org.jfree.chart.renderer.category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link StandardBarPainter} class.
 */
public class StandardBarPainterTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        StandardBarPainter p1 = new StandardBarPainter();
        StandardBarPainter p2 = new StandardBarPainter();
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        StandardBarPainter p1 = new StandardBarPainter();
        StandardBarPainter p2 = new StandardBarPainter();
        int h1 = p1.hashCode();
        int h2 = p2.hashCode();
    }

    /**
     * Confirm that cloning isn't implemented (it isn't required, because
     * instances of the class are immutable).
     */
    public void testCloning() {
        StandardBarPainter p1 = new StandardBarPainter();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardBarPainter p1 = new StandardBarPainter();
        StandardBarPainter p2 = (StandardBarPainter) TestUtilities.serialised(p1);
    }
}
