package org.jfree.chart.util;

import java.text.DecimalFormat;
import org.jfree.chart.TestUtilities;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Tests for the {@link LogFormat} class.
 */
public class LogFormatTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        LogFormat f1 = new LogFormat(10.0, "10", true);
        LogFormat f2 = new LogFormat(10.0, "10", true);
        f1 = new LogFormat(11.0, "10", true);
        f2 = new LogFormat(11.0, "10", true);
        f1 = new LogFormat(11.0, "11", true);
        f2 = new LogFormat(11.0, "11", true);
        f1 = new LogFormat(11.0, "11", false);
        f2 = new LogFormat(11.0, "11", false);
        f1.setExponentFormat(new DecimalFormat("0.000"));
        f2.setExponentFormat(new DecimalFormat("0.000"));
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        LogFormat f1 = new LogFormat(10.0, "10", true);
        LogFormat f2 = new LogFormat(10.0, "10", true);
        assertTrue(f1.equals(f2));
        int h1 = f1.hashCode();
        int h2 = f2.hashCode();
        assertEquals(h1, h2);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() {
        LogFormat f1 = new LogFormat(10.0, "10", true);
        LogFormat f2 = (LogFormat) f1.clone();
        assertTrue(f1 != f2);
        assertTrue(f1.getClass() == f2.getClass());
        assertTrue(f1.equals(f2));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        LogFormat f1 = new LogFormat(10.0, "10", true);
        LogFormat f2 = (LogFormat) TestUtilities.serialised(f1);
        assertEquals(f1, f2);
    }
}
