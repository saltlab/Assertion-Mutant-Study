package org.jfree.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 * Some tests for the {@link DataUtilities} class.
 */
public class DataUtilitiesTest {

    /**
     * Tests the createNumberArray2D() method.
     */
    public void testCreateNumberArray2D() {
        double[][] d = new double[2][];
        d[0] = new double[] { 1.1, 2.2, 3.3, 4.4 };
        d[1] = new double[] { 1.1, 2.2, 3.3, 4.4, 5.5 };
        Number[][] n = DataUtilities.createNumberArray2D(d);
    }

    private static final double EPSILON = 0.000000001;

    /**
     * Some checks for the calculateColumnTotal() method.
     */
    public void testCalculateColumnTotal() {
        DefaultKeyedValues2D table = new DefaultKeyedValues2D();
        table.addValue(new Double(1.0), "R0", "C0");
        table.addValue(new Double(2.0), "R0", "C1");
        table.addValue(new Double(3.0), "R1", "C0");
        table.addValue(new Double(4.0), "R1", "C1");
        table.setValue(null, "R1", "C1");
    }

    /**
     * Some checks for the calculateColumnTotal() method.
     */
    public void testCalculateColumnTotal2() {
        DefaultKeyedValues2D table = new DefaultKeyedValues2D();
        table.addValue(new Double(1.0), "R0", "C0");
        table.addValue(new Double(2.0), "R0", "C1");
        table.addValue(new Double(3.0), "R1", "C0");
        table.addValue(new Double(4.0), "R1", "C1");
        table.setValue(null, "R1", "C1");
    }

    /**
     * Some checks for the calculateRowTotal() method.
     */
    public void testCalculateRowTotal() {
        DefaultKeyedValues2D table = new DefaultKeyedValues2D();
        table.addValue(new Double(1.0), "R0", "C0");
        table.addValue(new Double(2.0), "R0", "C1");
        table.addValue(new Double(3.0), "R1", "C0");
        table.addValue(new Double(4.0), "R1", "C1");
        table.setValue(null, "R1", "C1");
    }

    /**
     * Some checks for the calculateRowTotal() method.
     */
    public void testCalculateRowTotal2() {
        DefaultKeyedValues2D table = new DefaultKeyedValues2D();
        table.addValue(new Double(1.0), "R0", "C0");
        table.addValue(new Double(2.0), "R0", "C1");
        table.addValue(new Double(3.0), "R1", "C0");
        table.addValue(new Double(4.0), "R1", "C1");
        table.setValue(null, "R1", "C1");
    }

    /**
     * Some tests for the equal(double[][], double[][]) method.
     */
    public void testEqual() {
        double[][] a = new double[5][];
        double[][] b = new double[5][];
        a = new double[4][];
        b = new double[4][];
        a[0] = new double[6];
        b[0] = new double[6];
        a[0][0] = 1.0;
        b[0][0] = 1.0;
        a[0][1] = Double.NaN;
        b[0][1] = Double.NaN;
        a[0][2] = Double.NEGATIVE_INFINITY;
        b[0][2] = Double.NEGATIVE_INFINITY;
        a[0][3] = Double.POSITIVE_INFINITY;
        b[0][3] = Double.POSITIVE_INFINITY;
        a[0][4] = Double.POSITIVE_INFINITY;
        b[0][4] = Double.NEGATIVE_INFINITY;
        b[0][4] = Double.POSITIVE_INFINITY;
    }

    /**
     * Some tests for the clone() method.
     */
    public void testClone() {
        double[][] a = new double[1][];
        double[][] b = DataUtilities.clone(a);
        a[0] = new double[] { 3.0, 4.0 };
        b[0] = new double[] { 3.0, 4.0 };
        a = new double[2][3];
        a[0][0] = 1.23;
        a[1][1] = Double.NaN;
        b = DataUtilities.clone(a);
        a[0][0] = 99.9;
        b[0][0] = 99.9;
    }
}
