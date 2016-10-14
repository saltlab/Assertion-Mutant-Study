package org.jfree.data.general;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link DefaultKeyedValueDataset} class.
 */
public class DefaultKeyedValueDatasetTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DefaultKeyedValueDataset d1 = new DefaultKeyedValueDataset("Test", new Double(45.5));
        DefaultKeyedValueDataset d2 = new DefaultKeyedValueDataset("Test", new Double(45.5));
        d1 = new DefaultKeyedValueDataset("Test 1", new Double(45.5));
        d2 = new DefaultKeyedValueDataset("Test 2", new Double(45.5));
        d1 = new DefaultKeyedValueDataset("Test", new Double(45.5));
        d2 = new DefaultKeyedValueDataset("Test", new Double(45.6));
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultKeyedValueDataset d1 = new DefaultKeyedValueDataset("Test", new Double(45.5));
        DefaultKeyedValueDataset d2 = (DefaultKeyedValueDataset) d1.clone();
    }

    /**
     * Confirm that the clone is independent of the original.
     */
    public void testCloneIndependence() throws CloneNotSupportedException {
        DefaultKeyedValueDataset d1 = new DefaultKeyedValueDataset("Key", new Double(10.0));
        DefaultKeyedValueDataset d2 = (DefaultKeyedValueDataset) d1.clone();
        d2.updateValue(new Double(99.9));
        d2.updateValue(new Double(10.0));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultKeyedValueDataset d1 = new DefaultKeyedValueDataset("Test", new Double(25.3));
        DefaultKeyedValueDataset d2 = (DefaultKeyedValueDataset) TestUtilities.serialised(d1);
    }
}
