package org.jfree.data.general;

import org.jfree.chart.TestUtilities;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Tests for the {@link DefaultKeyedValuesDataset} class.
 */
public class DefaultKeyedValuesDatasetTest {

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultKeyedValuesDataset d1 = new DefaultKeyedValuesDataset();
        d1.setValue("V1", new Integer(1));
        d1.setValue("V2", null);
        d1.setValue("V3", new Integer(3));
        DefaultKeyedValuesDataset d2 = (DefaultKeyedValuesDataset) d1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultKeyedValuesDataset d1 = new DefaultKeyedValuesDataset();
        d1.setValue("C1", new Double(234.2));
        d1.setValue("C2", null);
        d1.setValue("C3", new Double(345.9));
        d1.setValue("C4", new Double(452.7));
        KeyedValuesDataset d2 = (KeyedValuesDataset) TestUtilities.serialised(d1);
        assertEquals(d1, d2);
    }
}
