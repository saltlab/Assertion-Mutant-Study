package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link VectorSeriesCollection} class.
 */
public class VectorSeriesCollectionTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        VectorSeries s1 = new VectorSeries("Series");
        s1.add(1.0, 1.1, 1.2, 1.3);
        VectorSeriesCollection c1 = new VectorSeriesCollection();
        c1.addSeries(s1);
        VectorSeries s2 = new VectorSeries("Series");
        s2.add(1.0, 1.1, 1.2, 1.3);
        VectorSeriesCollection c2 = new VectorSeriesCollection();
        c2.addSeries(s2);
        c1.addSeries(new VectorSeries("Empty Series"));
        c2.addSeries(new VectorSeries("Empty Series"));
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        VectorSeries s1 = new VectorSeries("Series");
        s1.add(1.0, 1.1, 1.2, 1.3);
        VectorSeriesCollection c1 = new VectorSeriesCollection();
        c1.addSeries(s1);
        VectorSeriesCollection c2 = (VectorSeriesCollection) c1.clone();
        s1.setDescription("XYZ");
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        VectorSeriesCollection d1 = new VectorSeriesCollection();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        VectorSeries s1 = new VectorSeries("Series");
        s1.add(1.0, 1.1, 1.2, 1.3);
        VectorSeriesCollection c1 = new VectorSeriesCollection();
        c1.addSeries(s1);
        VectorSeriesCollection c2 = (VectorSeriesCollection) TestUtilities.serialised(c1);
    }

    /**
     * Some checks for the removeSeries() method.
     */
    public void testRemoveSeries() {
        VectorSeries s1 = new VectorSeries("S1");
        VectorSeries s2 = new VectorSeries("S2");
        VectorSeriesCollection vsc = new VectorSeriesCollection();
        vsc.addSeries(s1);
        vsc.addSeries(s2);
        boolean b = vsc.removeSeries(s1);
        b = vsc.removeSeries(new VectorSeries("NotInDataset"));
        b = vsc.removeSeries(s2);
    }
}
