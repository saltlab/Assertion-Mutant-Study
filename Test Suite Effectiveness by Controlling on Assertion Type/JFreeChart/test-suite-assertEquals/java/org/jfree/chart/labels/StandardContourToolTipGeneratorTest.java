package org.jfree.chart.labels;

import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@code StandardContourToolTipGenerator} class.
 */
public class StandardContourToolTipGeneratorTest {

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardContourToolTipGenerator g1 = new StandardContourToolTipGenerator();
        StandardContourToolTipGenerator g2 = (StandardContourToolTipGenerator) TestUtilities.serialised(g1);
    }
}
