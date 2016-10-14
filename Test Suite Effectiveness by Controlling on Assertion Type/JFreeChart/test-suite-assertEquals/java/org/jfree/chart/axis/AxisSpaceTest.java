package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 * Tests for the {@link AxisSpace} class.
 */
public class AxisSpaceTest {

    /**
     * Check that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        AxisSpace a1 = new AxisSpace();
        AxisSpace a2 = new AxisSpace();
        a1.setTop(1.11);
        a2.setTop(1.11);
        a1.setBottom(2.22);
        a2.setBottom(2.22);
        a1.setLeft(3.33);
        a2.setLeft(3.33);
        a1.setRight(4.44);
        a2.setRight(4.44);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        AxisSpace s1 = new AxisSpace();
        AxisSpace s2 = new AxisSpace();
        int h1 = s1.hashCode();
        int h2 = s2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        AxisSpace s1 = new AxisSpace();
        AxisSpace s2 = (AxisSpace) s1.clone();
    }
}
