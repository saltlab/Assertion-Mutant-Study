package org.jfree.chart.title;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Color;
import java.awt.Font;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link DateTitle} class.
 */
public class DateTitleTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        DateTitle t1 = new DateTitle();
        DateTitle t2 = new DateTitle();
        t1.setText("Test 1");
        t2.setText("Test 1");
        Font f = new Font("SansSerif", Font.PLAIN, 15);
        t1.setFont(f);
        t2.setFont(f);
        t1.setPaint(Color.blue);
        t2.setPaint(Color.blue);
        t1.setBackgroundPaint(Color.blue);
        t2.setBackgroundPaint(Color.blue);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        DateTitle t1 = new DateTitle();
        DateTitle t2 = new DateTitle();
        int h1 = t1.hashCode();
        int h2 = t2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DateTitle t1 = new DateTitle();
        DateTitle t2 = (DateTitle) t1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DateTitle t1 = new DateTitle();
        DateTitle t2 = (DateTitle) TestUtilities.serialised(t1);
    }
}
