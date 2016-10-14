package org.jfree.chart.renderer;

import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link AreaRendererEndType} class.
 */
public class AreaRendererEndTypeTest {

    /**
     * A test for the equals() method.
     */
    public void testEquals() {
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        AreaRendererEndType t1 = AreaRendererEndType.TAPER;
        AreaRendererEndType t2 = (AreaRendererEndType) TestUtilities.serialised(t1);
        boolean same = t1 == t2;
    }
}
