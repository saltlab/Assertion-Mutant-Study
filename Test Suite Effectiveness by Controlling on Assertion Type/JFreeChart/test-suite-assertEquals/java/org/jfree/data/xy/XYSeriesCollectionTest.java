package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;
import org.jfree.chart.TestUtilities;
import org.jfree.data.Range;
import org.jfree.data.UnknownKeyException;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link XYSeriesCollection} class.
 */
public class XYSeriesCollectionTest {

    private static final double EPSILON = 0.0000000001;

    /**
     * Some checks for the constructor.
     */
    @Test
    public void testConstructor() {
        XYSeriesCollection xysc = new XYSeriesCollection();
        assertEquals(1.0, xysc.getIntervalWidth(), EPSILON);
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        XYSeries s1 = new XYSeries("Series");
        s1.add(1.0, 1.1);
        XYSeriesCollection c1 = new XYSeriesCollection();
        c1.addSeries(s1);
        XYSeries s2 = new XYSeries("Series");
        s2.add(1.0, 1.1);
        XYSeriesCollection c2 = new XYSeriesCollection();
        c2.addSeries(s2);
        c1.addSeries(new XYSeries("Empty Series"));
        c2.addSeries(new XYSeries("Empty Series"));
        c1.setIntervalWidth(5.0);
        c2.setIntervalWidth(5.0);
        c1.setIntervalPositionFactor(0.75);
        c2.setIntervalPositionFactor(0.75);
        c1.setAutoWidth(true);
        c2.setAutoWidth(true);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYSeries s1 = new XYSeries("Series");
        s1.add(1.0, 1.1);
        XYSeriesCollection c1 = new XYSeriesCollection();
        c1.addSeries(s1);
        XYSeriesCollection c2 = (XYSeriesCollection) c1.clone();
        s1.setDescription("XYZ");
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        Object c1 = new XYSeriesCollection();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYSeries s1 = new XYSeries("Series");
        s1.add(1.0, 1.1);
        XYSeriesCollection c1 = new XYSeriesCollection();
        c1.addSeries(s1);
        XYSeriesCollection c2 = (XYSeriesCollection) TestUtilities.serialised(c1);
    }

    /**
     * A test for bug report 1170825.
     */
    public void test1170825() {
        XYSeries s1 = new XYSeries("Series1");
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        try {
            dataset.getSeries(1);
        } catch (IllegalArgumentException e) {
        } catch (IndexOutOfBoundsException e) {
            assertTrue(false);
        }
    }

    /**
     * Some basic checks for the getSeries() method.
     */
    public void testGetSeries() {
        XYSeriesCollection c = new XYSeriesCollection();
        XYSeries s1 = new XYSeries("s1");
        c.addSeries(s1);
        try {
            c.getSeries(-1);
            fail("Should have thrown IndexOutOfBoundsException on negative key");
        } catch (IllegalArgumentException e) {
            assertEquals("Series index out of bounds", e.getMessage());
        }
        try {
            c.getSeries(1);
            fail("Should have thrown IndexOutOfBoundsException on key out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Series index out of bounds", e.getMessage());
        }
    }

    /**
     * Some checks for the getSeries(Comparable) method.
     */
    public void testGetSeriesByKey() {
        XYSeriesCollection c = new XYSeriesCollection();
        XYSeries s1 = new XYSeries("s1");
        c.addSeries(s1);
        try {
            c.getSeries("s2");
            fail("Should have thrown UnknownKeyException on unknown key");
        } catch (UnknownKeyException e) {
            assertEquals("Key not found: s2", e.getMessage());
        }
        try {
            c.getSeries(null);
            fail("Should have thrown IndexOutOfBoundsException on null key");
        } catch (IllegalArgumentException e) {
            assertEquals("Null 'key' argument.", e.getMessage());
        }
    }

    /**
     * Some basic checks for the addSeries() method.
     */
    public void testAddSeries() {
        XYSeriesCollection c = new XYSeriesCollection();
        XYSeries s1 = new XYSeries("s1");
        c.addSeries(s1);
        XYSeries s2 = new XYSeries("s1");
        try {
            c.addSeries(s2);
            fail("Should have thrown IllegalArgumentException on duplicate key");
        } catch (IllegalArgumentException e) {
            assertEquals("This dataset already contains a series with the key s1", e.getMessage());
        }
    }

    /**
     * Some basic checks for the removeSeries() method.
     */
    public void testRemoveSeries() {
        XYSeriesCollection c = new XYSeriesCollection();
        XYSeries s1 = new XYSeries("s1");
        c.addSeries(s1);
        c.removeSeries(0);
        c.addSeries(s1);
        try {
            c.removeSeries(-1);
            fail("Should have thrown IndexOutOfBoundsException on negative key");
        } catch (IllegalArgumentException e) {
            assertEquals("Series index out of bounds.", e.getMessage());
        }
        try {
            c.removeSeries(1);
            fail("Should have thrown IndexOutOfBoundsException on key out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Series index out of bounds.", e.getMessage());
        }
    }

    /**
     * Some tests for the indexOf() method.
     */
    public void testIndexOf() {
        XYSeries s1 = new XYSeries("S1");
        XYSeries s2 = new XYSeries("S2");
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);
        dataset.removeSeries(s1);
        XYSeries s2b = new XYSeries("S2");
    }

    /**
     * Some checks for the getDomainBounds() method.
     */
    public void testGetDomainBounds() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        Range r = dataset.getDomainBounds(false);
        r = dataset.getDomainBounds(true);
        XYSeries series = new XYSeries("S1");
        dataset.addSeries(series);
        r = dataset.getDomainBounds(false);
        r = dataset.getDomainBounds(true);
        series.add(1.0, 1.1);
        r = dataset.getDomainBounds(false);
        r = dataset.getDomainBounds(true);
        series.add(-1.0, -1.1);
        r = dataset.getDomainBounds(false);
        r = dataset.getDomainBounds(true);
    }

    /**
     * Some checks for the getRangeBounds() method.
     */
    public void testGetRangeBounds() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("S1");
        dataset.addSeries(series);
        series.add(1.0, 1.1);
        series.add(-1.0, -1.1);
        series.add(0.0, null);
        XYSeries s2 = new XYSeries("S2");
        dataset.addSeries(s2);
        s2.add(2.0, 5.0);
    }

    public void testGetRangeLowerBound() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("S1");
        dataset.addSeries(series);
        series.add(1.0, 1.1);
        series.add(-1.0, -1.1);
        series.add(0.0, null);
        XYSeries s2 = new XYSeries("S2");
        dataset.addSeries(s2);
        s2.add(2.0, 5.0);
    }

    public void testGetRangeUpperBound() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("S1");
        dataset.addSeries(series);
        series.add(1.0, 1.1);
        series.add(-1.0, -1.1);
        series.add(0.0, null);
        XYSeries s2 = new XYSeries("S2");
        dataset.addSeries(s2);
        s2.add(2.0, 5.0);
    }

    /**
     * A check that the dataset prevents renaming a series to the name of an 
     * existing series in the dataset.
     */
    public void testRenameSeries() {
        XYSeries s1 = new XYSeries("S1");
        XYSeries s2 = new XYSeries("S2");
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);
        try {
            s2.setKey("S1");
            fail("Should have thrown IllegalArgumentException on negative key");
        } catch (IllegalArgumentException e) {
            assertEquals("Duplicate key2", e.getMessage());
        }
    }

    /**
     * A test to cover bug 3445507.  The issue does not affect
     * XYSeriesCollection.
     */
    public void testBug3445507() {
        XYSeries s1 = new XYSeries("S1");
        s1.add(1.0, null);
        s1.add(2.0, null);
        XYSeries s2 = new XYSeries("S2");
        s1.add(1.0, 5.0);
        s1.add(2.0, 6.0);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);
        Range r = dataset.getRangeBounds(false);
    }

    /**
     * Test that a series belonging to a collection can be renamed (in fact, 
     * because of a bug this was not possible in JFreeChart 1.0.14).
     */
    public void testSeriesRename() {
        XYSeries series1 = new XYSeries("A");
        XYSeries series2 = new XYSeries("B");
        XYSeriesCollection collection = new XYSeriesCollection();
        collection.addSeries(series1);
        collection.addSeries(series2);
        series1.setKey("C");
        try {
            series2.setKey("C");
            fail("Expected an IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
        }
    }
}
