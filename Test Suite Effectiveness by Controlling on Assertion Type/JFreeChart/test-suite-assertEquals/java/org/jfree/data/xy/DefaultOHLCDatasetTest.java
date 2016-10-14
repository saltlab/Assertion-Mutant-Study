package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import java.util.Date;
import org.jfree.chart.TestUtilities;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link DefaultOHLCDataset} class.
 */
public class DefaultOHLCDatasetTest {

    private static final double EPSILON = 0.0000000001;

    /**
     * A small test for the data range calculated on this dataset.
     */
    public void testDataRange() {
        OHLCDataItem[] data = new OHLCDataItem[3];
        data[0] = new OHLCDataItem(new Date(11L), 2.0, 4.0, 1.0, 3.0, 100.0);
        data[1] = new OHLCDataItem(new Date(22L), 4.0, 9.0, 2.0, 5.0, 120.0);
        data[2] = new OHLCDataItem(new Date(33L), 3.0, 7.0, 3.0, 6.0, 140.0);
        DefaultOHLCDataset d = new DefaultOHLCDataset("S1", data);
        Range r = DatasetUtilities.findRangeBounds(d, true);
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DefaultOHLCDataset d1 = new DefaultOHLCDataset("Series 1", new OHLCDataItem[0]);
        DefaultOHLCDataset d2 = new DefaultOHLCDataset("Series 1", new OHLCDataItem[0]);
        d1 = new DefaultOHLCDataset("Series 2", new OHLCDataItem[0]);
        d2 = new DefaultOHLCDataset("Series 2", new OHLCDataItem[0]);
        d1 = new DefaultOHLCDataset("Series 2", new OHLCDataItem[] { new OHLCDataItem(new Date(123L), 1.2, 3.4, 5.6, 7.8, 99.9) });
        d2 = new DefaultOHLCDataset("Series 2", new OHLCDataItem[] { new OHLCDataItem(new Date(123L), 1.2, 3.4, 5.6, 7.8, 99.9) });
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultOHLCDataset d1 = new DefaultOHLCDataset("Series 1", new OHLCDataItem[0]);
        DefaultOHLCDataset d2 = (DefaultOHLCDataset) d1.clone();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning2() throws CloneNotSupportedException {
        OHLCDataItem item1 = new OHLCDataItem(new Date(1L), 1.0, 2.0, 3.0, 4.0, 5.0);
        OHLCDataItem item2 = new OHLCDataItem(new Date(2L), 6.0, 7.0, 8.0, 9.0, 10.0);
        OHLCDataItem[] items = new OHLCDataItem[] { item2, item1 };
        DefaultOHLCDataset d1 = new DefaultOHLCDataset("Series 1", items);
        DefaultOHLCDataset d2 = (DefaultOHLCDataset) d1.clone();
        d1.sortDataByDate();
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        DefaultOHLCDataset d1 = new DefaultOHLCDataset("Series 1", new OHLCDataItem[0]);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultOHLCDataset d1 = new DefaultOHLCDataset("Series 1", new OHLCDataItem[0]);
        DefaultOHLCDataset d2 = (DefaultOHLCDataset) TestUtilities.serialised(d1);
    }
}
