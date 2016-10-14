package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link MatrixSeriesCollection} class.
 */
public class MatrixSeriesCollectionTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        MatrixSeries s1 = new MatrixSeries("Series", 2, 3);
        s1.update(0, 0, 1.1);
        MatrixSeriesCollection c1 = new MatrixSeriesCollection();
        c1.addSeries(s1);
        MatrixSeries s2 = new MatrixSeries("Series", 2, 3);
        s2.update(0, 0, 1.1);
        MatrixSeriesCollection c2 = new MatrixSeriesCollection();
        c2.addSeries(s2);
        c1.addSeries(new MatrixSeries("Empty Series", 1, 1));
        c2.addSeries(new MatrixSeries("Empty Series", 1, 1));
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        MatrixSeries s1 = new MatrixSeries("Series", 2, 3);
        s1.update(0, 0, 1.1);
        MatrixSeriesCollection c1 = new MatrixSeriesCollection();
        c1.addSeries(s1);
        MatrixSeriesCollection c2 = (MatrixSeriesCollection) c1.clone();
        s1.setDescription("XYZ");
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        MatrixSeriesCollection c1 = new MatrixSeriesCollection();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        MatrixSeries s1 = new MatrixSeries("Series", 2, 3);
        s1.update(0, 0, 1.1);
        MatrixSeriesCollection c1 = new MatrixSeriesCollection();
        c1.addSeries(s1);
        MatrixSeriesCollection c2 = (MatrixSeriesCollection) TestUtilities.serialised(c1);
    }
}
