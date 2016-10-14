package org.jfree.data.statistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import org.jfree.chart.TestUtilities;
import org.jfree.data.Range;
import org.jfree.data.UnknownKeyException;
import org.junit.Test;

/**
 * Tests for the {@link DefaultBoxAndWhiskerCategoryDataset} class.
 */
public class DefaultBoxAndWhiskerCategoryDatasetTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DefaultBoxAndWhiskerCategoryDataset d1 = new DefaultBoxAndWhiskerCategoryDataset();
        d1.add(new BoxAndWhiskerItem(new Double(1.0), new Double(2.0), new Double(3.0), new Double(4.0), new Double(5.0), new Double(6.0), new Double(7.0), new Double(8.0), new ArrayList()), "ROW1", "COLUMN1");
        DefaultBoxAndWhiskerCategoryDataset d2 = new DefaultBoxAndWhiskerCategoryDataset();
        d2.add(new BoxAndWhiskerItem(new Double(1.0), new Double(2.0), new Double(3.0), new Double(4.0), new Double(5.0), new Double(6.0), new Double(7.0), new Double(8.0), new ArrayList()), "ROW1", "COLUMN1");
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultBoxAndWhiskerCategoryDataset d1 = new DefaultBoxAndWhiskerCategoryDataset();
        d1.add(new BoxAndWhiskerItem(new Double(1.0), new Double(2.0), new Double(3.0), new Double(4.0), new Double(5.0), new Double(6.0), new Double(7.0), new Double(8.0), new ArrayList()), "ROW1", "COLUMN1");
        DefaultBoxAndWhiskerCategoryDataset d2 = (DefaultBoxAndWhiskerCategoryDataset) TestUtilities.serialised(d1);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultBoxAndWhiskerCategoryDataset d1 = new DefaultBoxAndWhiskerCategoryDataset();
        d1.add(new BoxAndWhiskerItem(new Double(1.0), new Double(2.0), new Double(3.0), new Double(4.0), new Double(5.0), new Double(6.0), new Double(7.0), new Double(8.0), new ArrayList()), "ROW1", "COLUMN1");
        DefaultBoxAndWhiskerCategoryDataset d2 = (DefaultBoxAndWhiskerCategoryDataset) d1.clone();
        d1.add(new BoxAndWhiskerItem(new Double(1.0), new Double(2.0), new Double(3.0), new Double(4.0), new Double(5.0), new Double(6.0), new Double(7.0), new Double(8.0), new ArrayList()), "ROW2", "COLUMN1");
    }

    /**
     * A simple test for bug report 1701822.
     */
    public void test1701822() {
        DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
        try {
            dataset.add(new BoxAndWhiskerItem(new Double(1.0), new Double(2.0), new Double(3.0), new Double(4.0), new Double(5.0), new Double(6.0), null, new Double(8.0), new ArrayList()), "ROW1", "COLUMN1");
            dataset.add(new BoxAndWhiskerItem(new Double(1.0), new Double(2.0), new Double(3.0), new Double(4.0), new Double(5.0), new Double(6.0), new Double(7.0), null, new ArrayList()), "ROW1", "COLUMN2");
        } catch (NullPointerException e) {
            assertTrue(false);
        }
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * Some checks for the add() method.
     */
    public void testAdd() {
        DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
        BoxAndWhiskerItem item1 = new BoxAndWhiskerItem(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, new ArrayList());
        dataset.add(item1, "R1", "C1");
    }

    /**
     * Some checks for the add() method.
     */
    public void testAddUpdatesCachedRange() {
        DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
        BoxAndWhiskerItem item1 = new BoxAndWhiskerItem(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, new ArrayList());
        dataset.add(item1, "R1", "C1");
        BoxAndWhiskerItem item2 = new BoxAndWhiskerItem(1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 7.5, 8.5, new ArrayList());
        dataset.add(item2, "R1", "C1");
    }

    /**
     * Some basic checks for the constructor.
     */
    public void testConstructor() {
        DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
    }

    /**
     * Some checks for the getRangeBounds() method.
     */
    public void testGetRangeBounds() {
        DefaultBoxAndWhiskerCategoryDataset d1 = new DefaultBoxAndWhiskerCategoryDataset();
        d1.add(new BoxAndWhiskerItem(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, new ArrayList()), "R1", "C1");
        d1.add(new BoxAndWhiskerItem(1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 7.5, 8.5, new ArrayList()), "R1", "C1");
        d1.add(new BoxAndWhiskerItem(2.5, 3.5, 4.5, 5.5, 6.5, 7.5, 8.5, 9.5, new ArrayList()), "R2", "C1");
        d1.add(new BoxAndWhiskerItem(1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 8.6, 9.6, new ArrayList()), "R1", "C1");
    }

    /**
     * Some checks for the remove method.
     */
    public void testRemove() {
        DefaultBoxAndWhiskerCategoryDataset data = new DefaultBoxAndWhiskerCategoryDataset();
        boolean pass = false;
        try {
            data.remove("R1", "R2");
        } catch (UnknownKeyException e) {
            pass = true;
        }
        data.add(new BoxAndWhiskerItem(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, new ArrayList()), "R1", "C1");
        data.add(new BoxAndWhiskerItem(2.5, 3.5, 4.5, 5.5, 6.5, 7.5, 8.5, 9.5, new ArrayList()), "R2", "C1");
        data.remove("R1", "C1");
    }
}
