package org.jfree.data.general;

import org.jfree.chart.TestUtilities;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

/**
 * Tests for the {@link org.jfree.data.general.PieDataset} class.
 */
public class DefaultPieDatasetTest implements DatasetChangeListener {

    private DatasetChangeEvent lastEvent;

    /**
     * Records the last event.
     *
     * @param event  the last event.
     */
    @Override
    public void datasetChanged(DatasetChangeEvent event) {
        this.lastEvent = event;
    }

    /**
     * Some tests for the clear() method.
     */
    public void testClear() {
        DefaultPieDataset d = new DefaultPieDataset();
        d.addChangeListener(this);
        d.clear();
        d.setValue("A", 1.0);
        this.lastEvent = null;
        d.clear();
    }

    /**
     * Some checks for the getKey(int) method.
     */
    public void testGetKey() {
        DefaultPieDataset d = new DefaultPieDataset();
        d.setValue("A", 1.0);
        d.setValue("B", 2.0);
        assertEquals("A", d.getKey(0));
        assertEquals("B", d.getKey(1));
        boolean pass = false;
        try {
            d.getKey(-1);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        assertTrue(pass);
        pass = false;
        try {
            d.getKey(2);
        } catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        assertTrue(pass);
    }

    /**
     * Some checks for the getIndex() method.
     */
    public void testGetIndex() {
        DefaultPieDataset d = new DefaultPieDataset();
        d.setValue("A", 1.0);
        d.setValue("B", 2.0);
        assertEquals(0, d.getIndex("A"));
        assertEquals(1, d.getIndex("B"));
        assertEquals(-1, d.getIndex("XX"));
        boolean pass = false;
        try {
            d.getIndex(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        assertTrue(pass);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultPieDataset d1 = new DefaultPieDataset();
        d1.setValue("V1", new Integer(1));
        d1.setValue("V2", null);
        d1.setValue("V3", new Integer(3));
        DefaultPieDataset d2 = (DefaultPieDataset) d1.clone();
        assertTrue(d1 != d2);
        assertTrue(d1.getClass() == d2.getClass());
        assertTrue(d1.equals(d2));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultPieDataset d1 = new DefaultPieDataset();
        d1.setValue("C1", new Double(234.2));
        d1.setValue("C2", null);
        d1.setValue("C3", new Double(345.9));
        d1.setValue("C4", new Double(452.7));
        DefaultPieDataset d2 = (DefaultPieDataset) TestUtilities.serialised(d1);
        assertEquals(d1, d2);
    }
}
