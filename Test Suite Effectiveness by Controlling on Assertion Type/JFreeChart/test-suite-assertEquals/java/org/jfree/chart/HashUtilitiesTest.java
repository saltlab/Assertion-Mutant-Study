package org.jfree.chart;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Tests for the {@link HashUtilities} class.
 */
public class HashUtilitiesTest {

    /**
     * Some sanity checks for the hashCodeForDoubleArray() method.
     */
    public void testHashCodeForDoubleArray() {
        double[] a1 = new double[] { 1.0 };
        double[] a2 = new double[] { 1.0 };
        int h1 = HashUtilities.hashCodeForDoubleArray(a1);
        int h2 = HashUtilities.hashCodeForDoubleArray(a2);
        double[] a3 = new double[] { 0.5, 1.0 };
        int h3 = HashUtilities.hashCodeForDoubleArray(a3);
    }
}
