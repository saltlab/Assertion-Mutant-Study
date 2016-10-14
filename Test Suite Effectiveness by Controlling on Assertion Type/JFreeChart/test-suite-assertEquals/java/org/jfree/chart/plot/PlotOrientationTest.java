package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link PlotOrientation} class.
 *
 */
public class PlotOrientationTest {

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        PlotOrientation orientation1 = PlotOrientation.HORIZONTAL;
        PlotOrientation orientation2 = (PlotOrientation) TestUtilities.serialised(orientation1);
        boolean same = orientation1 == orientation2;
    }
}
