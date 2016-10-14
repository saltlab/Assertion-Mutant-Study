package org.jfree.data.category;

import java.util.List;
import org.jfree.chart.TestUtilities;
import org.jfree.data.DataUtilities;
import org.jfree.data.UnknownKeyException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Tests for the {@link DefaultIntervalCategoryDataset} class.
 */
public class DefaultIntervalCategoryDatasetTest {

    /**
     * Some checks for the getValue() method.
     */
    public void testGetValue() {
        double[] starts_S1 = new double[] { 0.1, 0.2, 0.3 };
        double[] starts_S2 = new double[] { 0.3, 0.4, 0.5 };
        double[] ends_S1 = new double[] { 0.5, 0.6, 0.7 };
        double[] ends_S2 = new double[] { 0.7, 0.8, 0.9 };
        double[][] starts = new double[][] { starts_S1, starts_S2 };
        double[][] ends = new double[][] { ends_S1, ends_S2 };
        DefaultIntervalCategoryDataset d = new DefaultIntervalCategoryDataset(new Comparable[] { "Series 1", "Series 2" }, new Comparable[] { "Category 1", "Category 2", "Category 3" }, DataUtilities.createNumberArray2D(starts), DataUtilities.createNumberArray2D(ends));
        boolean pass = false;
        try {
            d.getValue("XX", "Category 1");
        } catch (UnknownKeyException e) {
            pass = true;
        }
        pass = false;
        try {
            d.getValue("Series 1", "XX");
        } catch (UnknownKeyException e) {
            pass = true;
        }
    }

    /**
     * Some tests for the getRowCount() method.
     */
    public void testGetRowAndColumnCount() {
        double[] starts_S1 = new double[] { 0.1, 0.2, 0.3 };
        double[] starts_S2 = new double[] { 0.3, 0.4, 0.5 };
        double[] ends_S1 = new double[] { 0.5, 0.6, 0.7 };
        double[] ends_S2 = new double[] { 0.7, 0.8, 0.9 };
        double[][] starts = new double[][] { starts_S1, starts_S2 };
        double[][] ends = new double[][] { ends_S1, ends_S2 };
        DefaultIntervalCategoryDataset d = new DefaultIntervalCategoryDataset(starts, ends);
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        double[] starts_S1A = new double[] { 0.1, 0.2, 0.3 };
        double[] starts_S2A = new double[] { 0.3, 0.4, 0.5 };
        double[] ends_S1A = new double[] { 0.5, 0.6, 0.7 };
        double[] ends_S2A = new double[] { 0.7, 0.8, 0.9 };
        double[][] startsA = new double[][] { starts_S1A, starts_S2A };
        double[][] endsA = new double[][] { ends_S1A, ends_S2A };
        DefaultIntervalCategoryDataset dA = new DefaultIntervalCategoryDataset(startsA, endsA);
        double[] starts_S1B = new double[] { 0.1, 0.2, 0.3 };
        double[] starts_S2B = new double[] { 0.3, 0.4, 0.5 };
        double[] ends_S1B = new double[] { 0.5, 0.6, 0.7 };
        double[] ends_S2B = new double[] { 0.7, 0.8, 0.9 };
        double[][] startsB = new double[][] { starts_S1B, starts_S2B };
        double[][] endsB = new double[][] { ends_S1B, ends_S2B };
        DefaultIntervalCategoryDataset dB = new DefaultIntervalCategoryDataset(startsB, endsB);
        DefaultIntervalCategoryDataset empty1 = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]);
        DefaultIntervalCategoryDataset empty2 = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        double[] starts_S1 = new double[] { 0.1, 0.2, 0.3 };
        double[] starts_S2 = new double[] { 0.3, 0.4, 0.5 };
        double[] ends_S1 = new double[] { 0.5, 0.6, 0.7 };
        double[] ends_S2 = new double[] { 0.7, 0.8, 0.9 };
        double[][] starts = new double[][] { starts_S1, starts_S2 };
        double[][] ends = new double[][] { ends_S1, ends_S2 };
        DefaultIntervalCategoryDataset d1 = new DefaultIntervalCategoryDataset(starts, ends);
        DefaultIntervalCategoryDataset d2 = (DefaultIntervalCategoryDataset) TestUtilities.serialised(d1);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        double[] starts_S1 = new double[] { 0.1, 0.2, 0.3 };
        double[] starts_S2 = new double[] { 0.3, 0.4, 0.5 };
        double[] ends_S1 = new double[] { 0.5, 0.6, 0.7 };
        double[] ends_S2 = new double[] { 0.7, 0.8, 0.9 };
        double[][] starts = new double[][] { starts_S1, starts_S2 };
        double[][] ends = new double[][] { ends_S1, ends_S2 };
        DefaultIntervalCategoryDataset d1 = new DefaultIntervalCategoryDataset(new Comparable[] { "Series 1", "Series 2" }, new Comparable[] { "Category 1", "Category 2", "Category 3" }, DataUtilities.createNumberArray2D(starts), DataUtilities.createNumberArray2D(ends));
        DefaultIntervalCategoryDataset d2 = null;
        d2 = (DefaultIntervalCategoryDataset) d1.clone();
        d1.setStartValue(0, "Category 1", new Double(0.99));
        d2.setStartValue(0, "Category 1", new Double(0.99));
    }

    /**
     * A check to ensure that an empty dataset can be cloned.
     */
    public void testCloning2() throws CloneNotSupportedException {
        DefaultIntervalCategoryDataset d1 = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]);
        DefaultIntervalCategoryDataset d2 = null;
        d2 = (DefaultIntervalCategoryDataset) d1.clone();
    }

    /**
     * Some basic checks for the setStartValue() method.
     */
    public void testSetStartValue() {
        double[] starts_S1 = new double[] { 0.1, 0.2, 0.3 };
        double[] starts_S2 = new double[] { 0.3, 0.4, 0.5 };
        double[] ends_S1 = new double[] { 0.5, 0.6, 0.7 };
        double[] ends_S2 = new double[] { 0.7, 0.8, 0.9 };
        double[][] starts = new double[][] { starts_S1, starts_S2 };
        double[][] ends = new double[][] { ends_S1, ends_S2 };
        DefaultIntervalCategoryDataset d1 = new DefaultIntervalCategoryDataset(new Comparable[] { "Series 1", "Series 2" }, new Comparable[] { "Category 1", "Category 2", "Category 3" }, DataUtilities.createNumberArray2D(starts), DataUtilities.createNumberArray2D(ends));
        d1.setStartValue(0, "Category 2", new Double(99.9));
        boolean pass = false;
        try {
            d1.setStartValue(-1, "Category 2", new Double(99.9));
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        pass = false;
        try {
            d1.setStartValue(2, "Category 2", new Double(99.9));
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Some basic checks for the setEndValue() method.
     */
    public void testSetEndValue() {
        double[] starts_S1 = new double[] { 0.1, 0.2, 0.3 };
        double[] starts_S2 = new double[] { 0.3, 0.4, 0.5 };
        double[] ends_S1 = new double[] { 0.5, 0.6, 0.7 };
        double[] ends_S2 = new double[] { 0.7, 0.8, 0.9 };
        double[][] starts = new double[][] { starts_S1, starts_S2 };
        double[][] ends = new double[][] { ends_S1, ends_S2 };
        DefaultIntervalCategoryDataset d1 = new DefaultIntervalCategoryDataset(new Comparable[] { "Series 1", "Series 2" }, new Comparable[] { "Category 1", "Category 2", "Category 3" }, DataUtilities.createNumberArray2D(starts), DataUtilities.createNumberArray2D(ends));
        d1.setEndValue(0, "Category 2", new Double(99.9));
        boolean pass = false;
        try {
            d1.setEndValue(-1, "Category 2", new Double(99.9));
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        pass = false;
        try {
            d1.setEndValue(2, "Category 2", new Double(99.9));
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getSeriesCount() method.
     */
    public void testGetSeriesCount() {
        DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]);
    }

    /**
     * Some checks for the getCategoryCount() method.
     */
    public void testGetCategoryCount() {
        DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]);
    }

    /**
     * Some checks for the getSeriesIndex() method.
     */
    public void testGetSeriesIndex() {
        DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]);
    }

    /**
     * Some checks for the getRowIndex() method.
     */
    public void testGetRowIndex() {
        DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]);
    }

    /**
     * Some checks for the setSeriesKeys() method.
     */
    public void testSetSeriesKeys() {
        DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]);
        boolean pass = true;
        try {
            empty.setSeriesKeys(new String[0]);
        } catch (RuntimeException e) {
            pass = false;
        }
    }

    /**
     * Some checks for the getCategoryIndex() method.
     */
    public void testGetCategoryIndex() {
        DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]);
    }

    /**
     * Some checks for the getColumnIndex() method.
     */
    public void testGetColumnIndex() {
        DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]);
    }

    /**
     * Some checks for the setCategoryKeys() method.
     */
    public void testSetCategoryKeys() {
        DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]);
        boolean pass = true;
        try {
            empty.setCategoryKeys(new String[0]);
        } catch (RuntimeException e) {
            pass = false;
        }
    }

    /**
     * Some checks for the getColumnKeys() method.
     */
    public void testGetColumnKeys() {
        DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]);
        List keys = empty.getColumnKeys();
    }

    /**
     * Some checks for the getRowKeys() method.
     */
    public void testGetRowKeys() {
        DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]);
        List keys = empty.getRowKeys();
    }

    /**
     * Some checks for the getColumnCount() method.
     */
    public void testGetColumnCount() {
        DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]);
    }

    /**
     * Some checks for the getRowCount() method.
     */
    public void testGetRowCount() {
        DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]);
    }
}
