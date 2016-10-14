package org.jfree.data.statistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link MeanAndStandardDeviation} class.
 */
public class MeanAndStandardDeviationTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        MeanAndStandardDeviation m1 = new MeanAndStandardDeviation(1.2, 3.4);
        MeanAndStandardDeviation m2 = new MeanAndStandardDeviation(1.2, 3.4);
        m1 = new MeanAndStandardDeviation(1.0, 3.4);
        m2 = new MeanAndStandardDeviation(1.0, 3.4);
        m1 = new MeanAndStandardDeviation(1.0, 3.0);
        m2 = new MeanAndStandardDeviation(1.0, 3.0);
    }

    /**
     * Immutable class - should not be cloneable.
     */
    public void testCloning() {
        MeanAndStandardDeviation m1 = new MeanAndStandardDeviation(1.2, 3.4);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        MeanAndStandardDeviation m1 = new MeanAndStandardDeviation(1.2, 3.4);
        MeanAndStandardDeviation m2 = (MeanAndStandardDeviation) TestUtilities.serialised(m1);
    }
}
