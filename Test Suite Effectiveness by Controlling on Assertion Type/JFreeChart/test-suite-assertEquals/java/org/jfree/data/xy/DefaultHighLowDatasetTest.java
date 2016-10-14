package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import java.util.Date;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link DefaultHighLowDataset} class.
 */
public class DefaultHighLowDatasetTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DefaultHighLowDataset d1 = new DefaultHighLowDataset("Series 1", new Date[0], new double[0], new double[0], new double[0], new double[0], new double[0]);
        DefaultHighLowDataset d2 = new DefaultHighLowDataset("Series 1", new Date[0], new double[0], new double[0], new double[0], new double[0], new double[0]);
        d1 = new DefaultHighLowDataset("Series 2", new Date[0], new double[0], new double[0], new double[0], new double[0], new double[0]);
        d2 = new DefaultHighLowDataset("Series 2", new Date[0], new double[0], new double[0], new double[0], new double[0], new double[0]);
        d1 = new DefaultHighLowDataset("Series 2", new Date[] { new Date(123L) }, new double[1], new double[1], new double[1], new double[1], new double[1]);
        d2 = new DefaultHighLowDataset("Series 2", new Date[] { new Date(123L) }, new double[1], new double[1], new double[1], new double[1], new double[1]);
        d1 = new DefaultHighLowDataset("Series 2", new Date[] { new Date(123L) }, new double[] { 1.2 }, new double[1], new double[1], new double[1], new double[1]);
        d2 = new DefaultHighLowDataset("Series 2", new Date[] { new Date(123L) }, new double[] { 1.2 }, new double[1], new double[1], new double[1], new double[1]);
        d1 = new DefaultHighLowDataset("Series 2", new Date[] { new Date(123L) }, new double[] { 1.2 }, new double[] { 3.4 }, new double[1], new double[1], new double[1]);
        d2 = new DefaultHighLowDataset("Series 2", new Date[] { new Date(123L) }, new double[] { 1.2 }, new double[] { 3.4 }, new double[1], new double[1], new double[1]);
        d1 = new DefaultHighLowDataset("Series 2", new Date[] { new Date(123L) }, new double[] { 1.2 }, new double[] { 3.4 }, new double[] { 5.6 }, new double[1], new double[1]);
        d2 = new DefaultHighLowDataset("Series 2", new Date[] { new Date(123L) }, new double[] { 1.2 }, new double[] { 3.4 }, new double[] { 5.6 }, new double[1], new double[1]);
        d1 = new DefaultHighLowDataset("Series 2", new Date[] { new Date(123L) }, new double[] { 1.2 }, new double[] { 3.4 }, new double[] { 5.6 }, new double[] { 7.8 }, new double[1]);
        d2 = new DefaultHighLowDataset("Series 2", new Date[] { new Date(123L) }, new double[] { 1.2 }, new double[] { 3.4 }, new double[] { 5.6 }, new double[] { 7.8 }, new double[1]);
        d1 = new DefaultHighLowDataset("Series 2", new Date[] { new Date(123L) }, new double[] { 1.2 }, new double[] { 3.4 }, new double[] { 5.6 }, new double[] { 7.8 }, new double[] { 99.9 });
        d2 = new DefaultHighLowDataset("Series 2", new Date[] { new Date(123L) }, new double[] { 1.2 }, new double[] { 3.4 }, new double[] { 5.6 }, new double[] { 7.8 }, new double[] { 99.9 });
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultHighLowDataset d1 = new DefaultHighLowDataset("Series 1", new Date[] { new Date(123L) }, new double[] { 1.2 }, new double[] { 3.4 }, new double[] { 5.6 }, new double[] { 7.8 }, new double[] { 99.9 });
        DefaultHighLowDataset d2 = (DefaultHighLowDataset) d1.clone();
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        DefaultHighLowDataset d1 = new DefaultHighLowDataset("Series 1", new Date[0], new double[0], new double[0], new double[0], new double[0], new double[0]);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultHighLowDataset d1 = new DefaultHighLowDataset("Series 1", new Date[] { new Date(123L) }, new double[] { 1.2 }, new double[] { 3.4 }, new double[] { 5.6 }, new double[] { 7.8 }, new double[] { 99.9 });
        DefaultHighLowDataset d2 = (DefaultHighLowDataset) TestUtilities.serialised(d1);
    }
}
