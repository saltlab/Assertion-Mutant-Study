package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for {@link DefaultTableXYDataset}.
 */
public class TableXYDatasetTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DefaultTableXYDataset d1 = new DefaultTableXYDataset();
        DefaultTableXYDataset d2 = new DefaultTableXYDataset();
        d1.addSeries(createSeries1());
        d2.addSeries(createSeries1());
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultTableXYDataset d1 = new DefaultTableXYDataset();
        d1.addSeries(createSeries1());
        DefaultTableXYDataset d2 = (DefaultTableXYDataset) d1.clone();
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        DefaultTableXYDataset d1 = new DefaultTableXYDataset();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultTableXYDataset d1 = new DefaultTableXYDataset();
        d1.addSeries(createSeries2());
        DefaultTableXYDataset d2 = (DefaultTableXYDataset) TestUtilities.serialised(d1);
    }

    /**
     * Assorted tests.
     */
    public void testTableXYDataset() {
        XYSeries series1 = createSeries1();
        XYSeries series2 = createSeries2();
        DefaultTableXYDataset dataset = new DefaultTableXYDataset();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        series2.add(7, 2);
        dataset.removeSeries(series1);
        dataset.removeSeries(series2);
        series1 = createSeries1();
        dataset.addSeries(series1);
    }

    /**
     * A test for bug report 788597.
     */
    public void test788597() {
        DefaultTableXYDataset dataset = new DefaultTableXYDataset();
        dataset.addSeries(createSeries1());
        dataset.removeAllSeries();
    }

    /**
     * Test that removing all values for a given x works.
     */
    public void testRemoveAllValuesForX() {
        DefaultTableXYDataset dataset = new DefaultTableXYDataset();
        dataset.addSeries(createSeries1());
        dataset.addSeries(createSeries2());
        dataset.removeAllValuesForX(new Double(2.0));
    }

    /**
     * Tests to see that pruning removes unwanted x values.
     */
    public void testPrune() {
        DefaultTableXYDataset dataset = new DefaultTableXYDataset();
        dataset.addSeries(createSeries1());
        dataset.addSeries(createSeries2());
        dataset.removeSeries(1);
        dataset.prune();
    }

    /**
     * Tests the auto-pruning feature.
     */
    @Test
    public void testAutoPrune() {
        DefaultTableXYDataset dataset = new DefaultTableXYDataset(true);
        dataset.addSeries(createSeriesA());
        dataset.addSeries(createSeriesB());
        dataset.removeSeries(1);
        DefaultTableXYDataset dataset2 = new DefaultTableXYDataset(true);
        dataset2.addSeries(createSeriesA());
        dataset2.addSeries(createSeriesB());
        assertEquals(2, dataset2.getItemCount());
        dataset2.removeSeries(1);
    }

    /**
     * Creates a series for testing.
     *
     * @return A series.
     */
    private XYSeries createSeriesA() {
        XYSeries s = new XYSeries("A", true, false);
        s.add(1.0, 1.1);
        s.add(2.0, null);
        return s;
    }

    /**
     * Creates a series for testing.
     *
     * @return A series.
     */
    private XYSeries createSeriesB() {
        XYSeries s = new XYSeries("B", true, false);
        s.add(1.0, null);
        s.add(2.0, 2.2);
        return s;
    }

    /**
     * Creates a series for testing.
     *
     * @return A series.
     */
    private XYSeries createSeries1() {
        XYSeries series1 = new XYSeries("Series 1", true, false);
        series1.add(1.0, 1.0);
        series1.add(2.0, 1.0);
        series1.add(4.0, 1.0);
        series1.add(5.0, 1.0);
        return series1;
    }

    /**
     * Creates a series for testing.
     *
     * @return A series.
     */
    private XYSeries createSeries2() {
        XYSeries series2 = new XYSeries("Series 2", true, false);
        series2.add(2.0, 2.0);
        series2.add(3.0, 2.0);
        series2.add(4.0, 2.0);
        series2.add(5.0, 2.0);
        series2.add(6.0, 2.0);
        return series2;
    }
}
