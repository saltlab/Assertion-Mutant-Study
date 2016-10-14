package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for {@link DefaultWindDataset}.
 */
public class DefaultWindDatasetTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DefaultWindDataset d1 = new DefaultWindDataset();
        DefaultWindDataset d2 = new DefaultWindDataset();
        d1 = createSampleDataset1();
        d2 = createSampleDataset1();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultWindDataset d1 = new DefaultWindDataset();
        DefaultWindDataset d2 = (DefaultWindDataset) d1.clone();
        d1 = createSampleDataset1();
        d2 = (DefaultWindDataset) d1.clone();
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        DefaultWindDataset d1 = new DefaultWindDataset();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultWindDataset d1 = new DefaultWindDataset();
        DefaultWindDataset d2 = (DefaultWindDataset) TestUtilities.serialised(d1);
        d1 = createSampleDataset1();
        d2 = (DefaultWindDataset) TestUtilities.serialised(d1);
    }

    /**
     * Some checks for the getSeriesKey(int) method.
     */
    public void testGetSeriesKey() {
        DefaultWindDataset d = createSampleDataset1();
        boolean pass = false;
        try {
            d.getSeriesKey(-1);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        pass = false;
        try {
            d.getSeriesKey(2);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the indexOf(Comparable) method.
     */
    public void testIndexOf() {
        DefaultWindDataset d = createSampleDataset1();
    }

    /**
     * Creates a sample dataset for testing.
     *
     * @return A sample dataset.
     */
    public DefaultWindDataset createSampleDataset1() {
        Day t = new Day(1, 4, 2006);
        Object[] item1 = createItem(t, 3, 7);
        Object[] item2 = createItem(t.next(), 4, 8);
        Object[] item3 = createItem(t.next(), 5, 9);
        Object[][] series1 = new Object[][] { item1, item2, item3 };
        Object[] item1b = createItem(t, 6, 10);
        Object[] item2b = createItem(t.next(), 7, 11);
        Object[] item3b = createItem(t.next(), 8, 12);
        Object[][] series2 = new Object[][] { item1b, item2b, item3b };
        Object[][][] data = new Object[][][] { series1, series2 };
        return new DefaultWindDataset(data);
    }

    /**
     * Creates an array representing one item in a series.
     *
     * @param t  the time period.
     * @param dir  the wind direction.
     * @param force  the wind force.
     *
     * @return An array containing the specified items.
     */
    private Object[] createItem(RegularTimePeriod t, int dir, int force) {
        return new Object[] { new Long(t.getMiddleMillisecond()), new Integer(dir), new Integer(force) };
    }
}
