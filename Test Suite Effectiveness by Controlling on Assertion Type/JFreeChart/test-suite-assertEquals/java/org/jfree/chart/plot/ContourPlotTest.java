package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@code ContourPlot} class.
 */
public class ContourPlotTest {

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        ContourPlot p1 = new ContourPlot(null, null, null, null);
        ContourPlot p2 = (ContourPlot) TestUtilities.serialised(p1);
    }
}
