package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.jfree.chart.TestUtilities;
import org.jfree.data.general.SeriesException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 * Tests for the {@link XYSeries} class.
 */
public class XYSeriesTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        XYSeries s1 = new XYSeries("Series");
        s1.add(1.0, 1.1);
        XYSeries s2 = new XYSeries("Series");
        s2.add(1.0, 1.1);
        s1.setKey("Series X");
        s2.setKey("Series X");
        s1.add(2.0, 2.2);
        s2.add(2.0, 2.2);
    }

    /**
     * Some simple checks for the hashCode() method.
     */
    public void testHashCode() {
        XYSeries s1 = new XYSeries("Test");
        XYSeries s2 = new XYSeries("Test");
        s1.add(1.0, 500.0);
        s2.add(1.0, 500.0);
        s1.add(2.0, null);
        s2.add(2.0, null);
        s1.add(5.0, 111.0);
        s2.add(5.0, 111.0);
        s1.add(9.0, 1.0);
        s2.add(9.0, 1.0);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYSeries s1 = new XYSeries("Series");
        s1.add(1.0, 1.1);
        XYSeries s2 = (XYSeries) s1.clone();
    }

    /**
     * Another test of the clone() method.
     */
    public void testCloning2() throws CloneNotSupportedException {
        XYSeries s1 = new XYSeries("S1");
        s1.add(1.0, 100.0);
        s1.add(2.0, null);
        s1.add(3.0, 200.0);
        XYSeries s2 = (XYSeries) s1.clone();
        s2.add(4.0, 300.0);
        s1.add(4.0, 300.0);
    }

    /**
     * Another test of the clone() method.
     */
    public void testCloning3() throws CloneNotSupportedException {
        XYSeries s1 = new XYSeries("S1");
        XYSeries s2 = (XYSeries) s1.clone();
        s2.add(4.0, 300.0);
        s1.add(4.0, 300.0);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYSeries s1 = new XYSeries("Series");
        s1.add(1.0, 1.1);
        XYSeries s2 = (XYSeries) TestUtilities.serialised(s1);
    }

    /**
     * Simple test for the indexOf() method.
     */
    public void testIndexOf() {
        XYSeries s1 = new XYSeries("Series 1");
        s1.add(1.0, 1.0);
        s1.add(2.0, 2.0);
        s1.add(3.0, 3.0);
    }

    /**
     * A check for the indexOf() method for an unsorted series.
     */
    public void testIndexOf2() {
        XYSeries s1 = new XYSeries("Series 1", false, true);
        s1.add(1.0, 1.0);
        s1.add(3.0, 3.0);
        s1.add(2.0, 2.0);
    }

    /**
     * A check for the indexOf(Number) method when the series has duplicate
     * x-values.
     */
    public void testIndexOf3() {
        XYSeries s1 = new XYSeries("Series 1");
        s1.add(1.0, 1.0);
        s1.add(2.0, 2.0);
        s1.add(2.0, 3.0);
    }

    /**
     * Simple test for the remove() method.
     */
    public void testRemove() {
        XYSeries s1 = new XYSeries("Series 1");
        s1.add(1.0, 1.0);
        s1.add(2.0, 2.0);
        s1.add(3.0, 3.0);
        s1.remove(new Double(2.0));
        s1.remove(0);
    }

    /**
     * Some checks for the remove(int) method.
     */
    public void testRemove2() {
        XYSeries s1 = new XYSeries("S1");
        s1.add(1.0, 1.1);
        s1.add(2.0, 2.2);
        s1.add(3.0, 3.3);
        s1.add(4.0, 4.4);
        s1.add(5.0, 5.5);
        s1.add(6.0, 6.6);
        s1.remove(5);
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * When items are added with duplicate x-values, we expect them to remain
     * in the order they were added.
     */
    public void testAdditionOfDuplicateXValues() {
        XYSeries s1 = new XYSeries("Series 1");
        s1.add(1.0, 1.0);
        s1.add(2.0, 2.0);
        s1.add(2.0, 3.0);
        s1.add(2.0, 4.0);
        s1.add(3.0, 5.0);
    }

    /**
     * Some checks for the update(Number, Number) method.
     */
    public void testUpdate() {
        XYSeries series = new XYSeries("S1");
        series.add(new Integer(1), new Integer(2));
        series.update(new Integer(1), new Integer(3));
        try {
            series.update(new Integer(2), new Integer(99));
            assertTrue(false);
        } catch (SeriesException e) {
        }
    }

    /**
     * Some checks for the update() method for an unsorted series.
     */
    public void testUpdate2() {
        XYSeries series = new XYSeries("Series", false, true);
        series.add(5.0, 55.0);
        series.add(4.0, 44.0);
        series.add(6.0, 66.0);
        series.update(new Double(4.0), new Double(99.0));
    }

    /**
     * Some checks for the addOrUpdate() method.
     */
    public void testAddOrUpdate() {
        XYSeries series = new XYSeries("S1", true, false);
        XYDataItem old = series.addOrUpdate(new Long(1), new Long(2));
        old = series.addOrUpdate(new Long(2), new Long(3));
        old = series.addOrUpdate(new Long(1), new Long(99));
    }

    /**
     * Some checks for the addOrUpdate() method for an UNSORTED series.
     */
    public void testAddOrUpdate2() {
        XYSeries series = new XYSeries("Series", false, false);
        series.add(5.0, 5.5);
        series.add(6.0, 6.6);
        series.add(3.0, 3.3);
        series.add(4.0, 4.4);
        series.add(2.0, 2.2);
        series.add(1.0, 1.1);
        series.addOrUpdate(new Double(3.0), new Double(33.3));
        series.addOrUpdate(new Double(2.0), new Double(22.2));
    }

    /**
     * Another test for the addOrUpdate() method.
     */
    public void testAddOrUpdate3() {
        XYSeries series = new XYSeries("Series", false, true);
        series.addOrUpdate(1.0, 1.0);
        series.addOrUpdate(1.0, 2.0);
        series.addOrUpdate(1.0, 3.0);
    }

    /**
     * Some checks for the add() method for an UNSORTED series.
     */
    public void testAdd() {
        XYSeries series = new XYSeries("Series", false, true);
        series.add(5.0, 5.50);
        series.add(5.1, 5.51);
        series.add(6.0, 6.6);
        series.add(3.0, 3.3);
        series.add(4.0, 4.4);
        series.add(2.0, 2.2);
        series.add(1.0, 1.1);
    }

    /**
     * A simple check that the maximumItemCount attribute is working.
     */
    public void testSetMaximumItemCount() {
        XYSeries s1 = new XYSeries("S1");
        s1.setMaximumItemCount(2);
        s1.add(1.0, 1.1);
        s1.add(2.0, 2.2);
        s1.add(3.0, 3.3);
    }

    /**
     * Check that the maximum item count can be applied retrospectively.
     */
    public void testSetMaximumItemCount2() {
        XYSeries s1 = new XYSeries("S1");
        s1.add(1.0, 1.1);
        s1.add(2.0, 2.2);
        s1.add(3.0, 3.3);
        s1.setMaximumItemCount(2);
    }

    /**
     * Check that the item bounds are determined correctly when there is a
     * maximum item count.
     */
    public void testSetMaximumItemCount3() {
        XYSeries s1 = new XYSeries("S1");
        s1.add(1.0, 1.1);
        s1.add(2.0, 2.2);
        s1.add(3.0, 3.3);
        s1.add(4.0, 4.4);
        s1.add(5.0, 5.5);
        s1.add(6.0, 6.6);
        s1.setMaximumItemCount(2);
    }

    /**
     * Check that the item bounds are determined correctly when there is a
     * maximum item count.
     */
    public void testSetMaximumItemCount4() {
        XYSeries s1 = new XYSeries("S1");
        s1.setMaximumItemCount(2);
        s1.add(1.0, 1.1);
        s1.add(2.0, 2.2);
        s1.add(3.0, 3.3);
    }

    /**
     * Some checks for the toArray() method.
     */
    public void testToArray() {
        XYSeries s = new XYSeries("S1");
        double[][] array = s.toArray();
        s.add(1.0, 2.0);
        array = s.toArray();
        s.add(2.0, null);
        array = s.toArray();
    }

    /**
     * Some checks for an example using the toArray() method.
     */
    @Test
    public void testToArrayExample() {
        XYSeries s = new XYSeries("S");
        s.add(1.0, 11.0);
        s.add(2.0, 22.0);
        s.add(3.5, 35.0);
        s.add(5.0, null);
        DefaultXYDataset dataset = new DefaultXYDataset();
        dataset.addSeries("S", s.toArray());
        assertEquals(1, dataset.getSeriesCount());
    }

    /**
     * Another test for the addOrUpdate() method.
     */
    public void testBug1955483() {
        XYSeries series = new XYSeries("Series", true, true);
        series.addOrUpdate(1.0, 1.0);
        series.addOrUpdate(1.0, 2.0);
    }

    /**
     * Some checks for the delete(int, int) method.
     */
    public void testDelete() {
        XYSeries s1 = new XYSeries("S1");
        s1.add(1.0, 1.1);
        s1.add(2.0, 2.2);
        s1.add(3.0, 3.3);
        s1.add(4.0, 4.4);
        s1.add(5.0, 5.5);
        s1.add(6.0, 6.6);
        s1.delete(2, 5);
    }

    /**
     * Some checks for the getMinX() method.
     */
    public void testGetMinX() {
        XYSeries s1 = new XYSeries("S1");
        s1.add(1.0, 1.1);
        s1.add(2.0, 2.2);
        s1.add(Double.NaN, 99.9);
        s1.add(-1.0, -1.1);
        s1.add(0.0, null);
    }

    /**
     * Some checks for the getMaxX() method.
     */
    public void testGetMaxX() {
        XYSeries s1 = new XYSeries("S1");
        s1.add(1.0, 1.1);
        s1.add(2.0, 2.2);
        s1.add(Double.NaN, 99.9);
        s1.add(-1.0, -1.1);
        s1.add(0.0, null);
    }

    /**
     * Some checks for the getMinY() method.
     */
    public void testGetMinY() {
        XYSeries s1 = new XYSeries("S1");
        s1.add(1.0, 1.1);
        s1.add(2.0, 2.2);
        s1.add(Double.NaN, 99.9);
        s1.add(-1.0, -1.1);
        s1.add(0.0, null);
    }

    /**
     * Some checks for the getMaxY() method.
     */
    public void testGetMaxY() {
        XYSeries s1 = new XYSeries("S1");
        s1.add(1.0, 1.1);
        s1.add(2.0, 2.2);
        s1.add(Double.NaN, 99.9);
        s1.add(-1.0, -1.1);
        s1.add(0.0, null);
    }

    /**
     * A test for a bug reported in the forum:
     * 
     * http://www.jfree.org/forum/viewtopic.php?f=3&t=116601
     */
    public void testGetMaxY2() {
        XYSeries series = new XYSeries(1, true, false);
        series.addOrUpdate(1, 20);
        series.addOrUpdate(2, 30);
        series.addOrUpdate(3, 40);
        series.addOrUpdate(2, 22);
    }

    /**
     * A test for the clear method.
     */
    public void testClear() {
        XYSeries s1 = new XYSeries("S1");
        s1.add(1.0, 1.1);
        s1.add(2.0, 2.2);
        s1.add(3.0, 3.3);
        s1.clear();
    }

    /**
     * Some checks for the updateByIndex() method.
     */
    public void testUpdateByIndex() {
        XYSeries s1 = new XYSeries("S1");
        s1.add(1.0, 1.1);
        s1.add(2.0, 2.2);
        s1.add(3.0, 3.3);
        s1.updateByIndex(0, new Double(-5.0));
        s1.updateByIndex(0, null);
        s1.updateByIndex(2, null);
        s1.updateByIndex(1, null);
    }

    /**
     * Some checks for the updateByIndex() method.
     */
    public void testUpdateByIndex2() {
        XYSeries s1 = new XYSeries("S1");
        s1.add(1.0, Double.NaN);
        s1.updateByIndex(0, new Double(1.0));
        s1.updateByIndex(0, new Double(2.0));
        s1.add(-1.0, -1.0);
        s1.updateByIndex(0, new Double(0.0));
    }

    /**
     * Some checks for the updateByIndex() method.
     */
    public void testUpdateByIndex3() {
        XYSeries s1 = new XYSeries("S1");
        s1.add(1.0, 1.1);
        s1.add(2.0, 2.2);
        s1.add(3.0, 3.3);
        s1.updateByIndex(1, new Double(2.05));
    }

    /**
     * Some checks for the update(Number, Number) method.
     */
    public void testUpdateXY() {
        XYSeries s1 = new XYSeries("S1");
        s1.add(1.0, Double.NaN);
        s1.update(new Double(1.0), new Double(1.0));
        s1.update(new Double(1.0), new Double(2.0));
    }

    public void testSetKey() {
        XYSeries s1 = new XYSeries("S");
        s1.setKey("S1");
        XYSeriesCollection c = new XYSeriesCollection();
        c.addSeries(s1);
        XYSeries s2 = new XYSeries("S2");
        c.addSeries(s2);
        s1.setKey("OK");
        try {
            s1.setKey("S2");
            fail("Expect an exception here.");
        } catch (IllegalArgumentException e) {
        }
        c.removeSeries(s1);
        s1.setKey("S2");
        s1.setKey("S1");
        c.addSeries(s1);
        c.removeSeries(1);
        s1.setKey("S2");
    }
}
