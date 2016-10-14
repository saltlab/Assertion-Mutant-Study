package org.jfree.data.time;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import java.util.TimeZone;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * A collection of test cases for the {@link TimeTableXYDataset} class.
 */
public class TimeTableXYDatasetTest {

    private static final double DELTA = 0.0000000001;

    /**
     * Some checks for a simple dataset.
     */
    public void testStandard() {
        TimeTableXYDataset d = new TimeTableXYDataset();
        d.add(new Year(1999), 1.0, "Series 1");
        d.add(new Year(2000), 2.0, "Series 2");
    }

    /**
     * Some checks for the getTimePeriod() method.
     */
    public void testGetTimePeriod() {
        TimeTableXYDataset d = new TimeTableXYDataset();
        d.add(new Year(1999), 1.0, "Series 1");
        d.add(new Year(1998), 2.0, "Series 1");
        d.add(new Year(1996), 3.0, "Series 1");
    }

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        TimeTableXYDataset d1 = new TimeTableXYDataset();
        TimeTableXYDataset d2 = new TimeTableXYDataset();
        d1.add(new Year(1999), 123.4, "S1");
        d2.add(new Year(1999), 123.4, "S1");
        d1.setDomainIsPointsInTime(!d1.getDomainIsPointsInTime());
        d2.setDomainIsPointsInTime(!d2.getDomainIsPointsInTime());
        d1 = new TimeTableXYDataset(TimeZone.getTimeZone("GMT"));
        d2 = new TimeTableXYDataset(TimeZone.getTimeZone("America/Los_Angeles"));
    }

    /**
     * Some checks for cloning.
     */
    public void testClone() {
        TimeTableXYDataset d = new TimeTableXYDataset();
        d.add(new Year(1999), 25.0, "Series");
        TimeTableXYDataset clone = null;
        try {
            clone = (TimeTableXYDataset) d.clone();
        } catch (CloneNotSupportedException e) {
            assertTrue(false);
        }
        clone.add(new Year(2004), 1.2, "SS");
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        TimeTableXYDataset d1 = new TimeTableXYDataset();
        d1.add(new Year(1999), 123.4, "S1");
        TimeTableXYDataset d2 = (TimeTableXYDataset) TestUtilities.serialised(d1);
    }

    /**
     * Test clearing data.
     */
    public void testClear() {
        TimeTableXYDataset d = new TimeTableXYDataset();
        d.add(new Year(1999), 1.0, "Series 1");
        d.add(new Year(2000), 2.0, "Series 2");
        d.clear();
    }
}
