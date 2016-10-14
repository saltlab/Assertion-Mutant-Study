package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Date;
import org.jfree.chart.TestUtilities;
import org.jfree.ui.TextAnchor;
import org.junit.Test;

/**
 * Tests for the {@link DateTick} class.
 */
public class DateTickTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        Date d1 = new Date(0L);
        Date d2 = new Date(1L);
        String l1 = "Label 1";
        String l2 = "Label 2";
        TextAnchor ta1 = TextAnchor.CENTER;
        TextAnchor ta2 = TextAnchor.BASELINE_LEFT;
        DateTick t1 = new DateTick(d1, l1, ta1, ta1, Math.PI / 2.0);
        DateTick t2 = new DateTick(d1, l1, ta1, ta1, Math.PI / 2.0);
        t1 = new DateTick(d2, l1, ta1, ta1, Math.PI / 2.0);
        t2 = new DateTick(d2, l1, ta1, ta1, Math.PI / 2.0);
        t1 = new DateTick(d1, l2, ta1, ta1, Math.PI / 2.0);
        t2 = new DateTick(d1, l2, ta1, ta1, Math.PI / 2.0);
        t1 = new DateTick(d1, l1, ta2, ta1, Math.PI / 2.0);
        t2 = new DateTick(d1, l1, ta2, ta1, Math.PI / 2.0);
        t1 = new DateTick(d1, l1, ta1, ta2, Math.PI / 2.0);
        t2 = new DateTick(d1, l1, ta1, ta2, Math.PI / 2.0);
        t1 = new DateTick(d1, l1, ta1, ta1, Math.PI / 3.0);
        t2 = new DateTick(d1, l1, ta1, ta1, Math.PI / 3.0);
        t1 = new DateTick(TickType.MINOR, d1, l1, ta1, ta1, Math.PI);
        t2 = new DateTick(TickType.MAJOR, d1, l1, ta1, ta1, Math.PI);
        t2 = new DateTick(TickType.MINOR, d1, l1, ta1, ta1, Math.PI);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        Date d1 = new Date(0L);
        String l1 = "Label 1";
        TextAnchor ta1 = TextAnchor.CENTER;
        DateTick t1 = new DateTick(d1, l1, ta1, ta1, Math.PI / 2.0);
        DateTick t2 = new DateTick(d1, l1, ta1, ta1, Math.PI / 2.0);
        int h1 = t1.hashCode();
        int h2 = t2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DateTick t1 = new DateTick(new Date(0L), "Label", TextAnchor.CENTER, TextAnchor.CENTER, 10.0);
        DateTick t2 = (DateTick) t1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DateTick t1 = new DateTick(new Date(0L), "Label", TextAnchor.CENTER, TextAnchor.CENTER, 10.0);
        DateTick t2 = (DateTick) TestUtilities.serialised(t1);
    }
}
