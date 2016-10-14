package org.jfree.data.general;

import org.jfree.chart.TestUtilities;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Tests for the {@link DefaultKeyedValues2DDataset} class.
 */
public class DefaultKeyedValues2DDatasetTest {

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultKeyedValues2DDataset d1 = new DefaultKeyedValues2DDataset();
        d1.setValue(new Integer(1), "V1", "C1");
        d1.setValue(null, "V2", "C1");
        d1.setValue(new Integer(3), "V3", "C2");
        DefaultKeyedValues2DDataset d2 = (DefaultKeyedValues2DDataset) d1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultKeyedValues2DDataset d1 = new DefaultKeyedValues2DDataset();
        d1.addValue(new Double(234.2), "Row1", "Col1");
        d1.addValue(null, "Row1", "Col2");
        d1.addValue(new Double(345.9), "Row2", "Col1");
        d1.addValue(new Double(452.7), "Row2", "Col2");
        DefaultKeyedValues2DDataset d2 = (DefaultKeyedValues2DDataset) TestUtilities.serialised(d1);
        assertEquals(d1, d2);
    }
}
