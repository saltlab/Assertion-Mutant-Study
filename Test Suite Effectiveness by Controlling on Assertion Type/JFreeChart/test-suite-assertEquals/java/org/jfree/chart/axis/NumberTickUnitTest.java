package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.DecimalFormat;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Some tests for the {@link NumberTickUnit} class.
 */
public class NumberTickUnitTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        NumberTickUnit t1 = new NumberTickUnit(1.23, new DecimalFormat("0.00"));
        NumberTickUnit t2 = new NumberTickUnit(1.23, new DecimalFormat("0.00"));
        t1 = new NumberTickUnit(3.21, new DecimalFormat("0.00"));
        t2 = new NumberTickUnit(3.21, new DecimalFormat("0.00"));
        t1 = new NumberTickUnit(3.21, new DecimalFormat("0.000"));
        t2 = new NumberTickUnit(3.21, new DecimalFormat("0.000"));
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        NumberTickUnit t1 = new NumberTickUnit(1.23, new DecimalFormat("0.00"));
        NumberTickUnit t2 = new NumberTickUnit(1.23, new DecimalFormat("0.00"));
        int h1 = t1.hashCode();
        int h2 = t2.hashCode();
    }

    /**
     * This is an immutable class so it doesn't need to be cloneable.
     */
    public void testCloning() {
        NumberTickUnit t1 = new NumberTickUnit(1.23, new DecimalFormat("0.00"));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        NumberTickUnit t1 = new NumberTickUnit(1.23, new DecimalFormat("0.00"));
        NumberTickUnit t2 = (NumberTickUnit) TestUtilities.serialised(t1);
    }
}
