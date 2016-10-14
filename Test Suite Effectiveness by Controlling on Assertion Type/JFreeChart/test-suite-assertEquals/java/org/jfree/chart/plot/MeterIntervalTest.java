package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import org.jfree.chart.TestUtilities;
import org.jfree.data.Range;
import org.junit.Test;

/**
 * Tests for the {@link MeterInterval} class.
 */
public class MeterIntervalTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        MeterInterval m1 = new MeterInterval("Label 1", new Range(1.2, 3.4), Color.red, new BasicStroke(1.0f), Color.blue);
        MeterInterval m2 = new MeterInterval("Label 1", new Range(1.2, 3.4), Color.red, new BasicStroke(1.0f), Color.blue);
        m1 = new MeterInterval("Label 2", new Range(1.2, 3.4), Color.red, new BasicStroke(1.0f), Color.blue);
        m2 = new MeterInterval("Label 2", new Range(1.2, 3.4), Color.red, new BasicStroke(1.0f), Color.blue);
    }

    /**
     * This class is immutable so cloning isn't required.
     */
    public void testCloning() {
        MeterInterval m1 = new MeterInterval("X", new Range(1.0, 2.0));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        MeterInterval m1 = new MeterInterval("X", new Range(1.0, 2.0));
        MeterInterval m2 = (MeterInterval) TestUtilities.serialised(m1);
    }
}
