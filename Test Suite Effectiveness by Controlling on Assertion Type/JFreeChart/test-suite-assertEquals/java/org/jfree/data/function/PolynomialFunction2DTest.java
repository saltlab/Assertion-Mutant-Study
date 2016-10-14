package org.jfree.data.function;

import java.util.Arrays;
import org.jfree.chart.TestUtilities;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the {@link PolynomialFunction2D} class.
 */
public class PolynomialFunction2DTest {

    /**
     * Some tests for the constructor.
     */
    public void testConstructor() {
        PolynomialFunction2D f = new PolynomialFunction2D(new double[] { 1.0, 2.0 });
        boolean pass = false;
        try {
            f = new PolynomialFunction2D(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Some checks for the getCoefficients() method.
     */
    public void testGetCoefficients() {
        PolynomialFunction2D f = new PolynomialFunction2D(new double[] { 1.0, 2.0 });
        double[] c = f.getCoefficients();
        c[0] = 99.9;
    }

    /**
     * Some checks for the getOrder() method.
     */
    public void testGetOrder() {
        PolynomialFunction2D f = new PolynomialFunction2D(new double[] { 1.0, 2.0 });
    }

    /**
     * For datasets, the equals() method just checks keys and values.
     */
    public void testEquals() {
        PolynomialFunction2D f1 = new PolynomialFunction2D(new double[] { 1.0, 2.0 });
        PolynomialFunction2D f2 = new PolynomialFunction2D(new double[] { 1.0, 2.0 });
        f1 = new PolynomialFunction2D(new double[] { 2.0, 3.0 });
        f2 = new PolynomialFunction2D(new double[] { 2.0, 3.0 });
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        PolynomialFunction2D f1 = new PolynomialFunction2D(new double[] { 1.0, 2.0 });
        PolynomialFunction2D f2 = (PolynomialFunction2D) TestUtilities.serialised(f1);
    }

    /**
     * Objects that are equal should have the same hash code otherwise FindBugs
     * will tell on us...
     */
    public void testHashCode() {
        PolynomialFunction2D f1 = new PolynomialFunction2D(new double[] { 1.0, 2.0 });
        PolynomialFunction2D f2 = new PolynomialFunction2D(new double[] { 1.0, 2.0 });
    }
}
