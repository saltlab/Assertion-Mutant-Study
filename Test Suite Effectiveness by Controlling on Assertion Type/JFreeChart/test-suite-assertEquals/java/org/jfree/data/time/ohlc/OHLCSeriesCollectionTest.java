package org.jfree.data.time.ohlc;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import org.jfree.chart.TestUtilities;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.time.TimePeriodAnchor;
import org.jfree.data.time.Year;
import org.junit.Test;

/**
 * Tests for the {@link OHLCSeriesCollectionTests} class.
 */
public class OHLCSeriesCollectionTest implements DatasetChangeListener {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        OHLCSeriesCollection c1 = new OHLCSeriesCollection();
        OHLCSeriesCollection c2 = new OHLCSeriesCollection();
        OHLCSeries s1 = new OHLCSeries("Series");
        s1.add(new Year(2006), 1.0, 1.1, 1.2, 1.3);
        c1.addSeries(s1);
        OHLCSeries s2 = new OHLCSeries("Series");
        s2.add(new Year(2006), 1.0, 1.1, 1.2, 1.3);
        c2.addSeries(s2);
        c1.addSeries(new OHLCSeries("Empty Series"));
        c2.addSeries(new OHLCSeries("Empty Series"));
        c1.setXPosition(TimePeriodAnchor.END);
        c2.setXPosition(TimePeriodAnchor.END);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        OHLCSeriesCollection c1 = new OHLCSeriesCollection();
        OHLCSeries s1 = new OHLCSeries("Series");
        s1.add(new Year(2006), 1.0, 1.1, 1.2, 1.3);
        c1.addSeries(s1);
        OHLCSeriesCollection c2 = (OHLCSeriesCollection) c1.clone();
        s1.setDescription("XYZ");
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        OHLCSeriesCollection c1 = new OHLCSeriesCollection();
        OHLCSeries s1 = new OHLCSeries("Series");
        s1.add(new Year(2006), 1.0, 1.1, 1.2, 1.3);
        c1.addSeries(s1);
        OHLCSeriesCollection c2 = (OHLCSeriesCollection) TestUtilities.serialised(c1);
    }

    /**
     * A test for bug report 1170825 (originally affected XYSeriesCollection,
     * this test is just copied over).
     */
    public void test1170825() {
        OHLCSeries s1 = new OHLCSeries("Series1");
        OHLCSeriesCollection dataset = new OHLCSeriesCollection();
        dataset.addSeries(s1);
        try {
            dataset.getSeries(1);
        } catch (IllegalArgumentException e) {
        } catch (IndexOutOfBoundsException e) {
            assertTrue(false);
        }
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        OHLCSeriesCollection c1 = new OHLCSeriesCollection();
        OHLCSeries s1 = new OHLCSeries("S");
        s1.add(new Year(2009), 1.0, 4.0, 0.5, 2.0);
        c1.addSeries(s1);
        OHLCSeriesCollection c2 = new OHLCSeriesCollection();
        OHLCSeries s2 = new OHLCSeries("S");
        s2.add(new Year(2009), 1.0, 4.0, 0.5, 2.0);
        c2.addSeries(s2);
        int h1 = c1.hashCode();
        int h2 = c2.hashCode();
    }

    /**
     * Some checks for the {@link OHLCSeriesCollection#removeSeries(int)}
     * method.
     */
    public void testRemoveSeries_int() {
        OHLCSeriesCollection c1 = new OHLCSeriesCollection();
        OHLCSeries s1 = new OHLCSeries("Series 1");
        OHLCSeries s2 = new OHLCSeries("Series 2");
        OHLCSeries s3 = new OHLCSeries("Series 3");
        OHLCSeries s4 = new OHLCSeries("Series 4");
        c1.addSeries(s1);
        c1.addSeries(s2);
        c1.addSeries(s3);
        c1.addSeries(s4);
        c1.removeSeries(2);
        c1.removeSeries(0);
    }

    /**
     * Some checks for the
     * {@link OHLCSeriesCollection#removeSeries(OHLCSeries)} method.
     */
    public void testRemoveSeries() {
        OHLCSeriesCollection c1 = new OHLCSeriesCollection();
        OHLCSeries s1 = new OHLCSeries("Series 1");
        OHLCSeries s2 = new OHLCSeries("Series 2");
        OHLCSeries s3 = new OHLCSeries("Series 3");
        OHLCSeries s4 = new OHLCSeries("Series 4");
        c1.addSeries(s1);
        c1.addSeries(s2);
        c1.addSeries(s3);
        c1.addSeries(s4);
        c1.removeSeries(s3);
        c1.removeSeries(s1);
    }

    /**
     * A simple check for the removeAllSeries() method.
     */
    public void testRemoveAllSeries() {
        OHLCSeriesCollection c1 = new OHLCSeriesCollection();
        c1.addChangeListener(this);
        this.lastEvent = null;
        c1.removeAllSeries();
        OHLCSeries s1 = new OHLCSeries("Series 1");
        OHLCSeries s2 = new OHLCSeries("Series 2");
        c1.addSeries(s1);
        c1.addSeries(s2);
        c1.removeAllSeries();
        this.lastEvent = null;
    }

    /** The last received event. */
    private DatasetChangeEvent lastEvent;

    /**
     * Receives dataset change events.
     *
     * @param event  the event.
     */
    @Override
    public void datasetChanged(DatasetChangeEvent event) {
        this.lastEvent = event;
    }
}
