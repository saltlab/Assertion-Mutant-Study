package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link NumberAxis3D} class.
 */
public class NumberAxis3DTest {

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        NumberAxis3D a1 = new NumberAxis3D("Test Axis");
        NumberAxis3D a2 = (NumberAxis3D) TestUtilities.serialised(a1);
    }
}
