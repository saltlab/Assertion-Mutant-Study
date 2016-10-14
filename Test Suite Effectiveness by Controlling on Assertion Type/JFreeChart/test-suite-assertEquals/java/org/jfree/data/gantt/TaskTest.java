package org.jfree.data.gantt;

import java.util.Date;
import org.jfree.chart.TestUtilities;
import org.jfree.data.time.SimpleTimePeriod;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Tests for the {@link Task} class.
 */
public class TaskTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        Task t1 = new Task("T", new Date(1), new Date(2));
        Task t2 = new Task("T", new Date(1), new Date(2));
        t1.setDescription("X");
        t2.setDescription("X");
        t1.setDuration(new SimpleTimePeriod(new Date(2), new Date(3)));
        t2.setDuration(new SimpleTimePeriod(new Date(2), new Date(3)));
        t1.setPercentComplete(0.5);
        t2.setPercentComplete(0.5);
        t1.addSubtask(new Task("T", new Date(22), new Date(33)));
        t2.addSubtask(new Task("T", new Date(22), new Date(33)));
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        Task t1 = new Task("T", new Date(1), new Date(2));
        Task t2 = (Task) t1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        Task t1 = new Task("T", new Date(1), new Date(2));
        Task t2 = (Task) TestUtilities.serialised(t1);
    }

    /**
     * Check the getSubTaskCount() method.
     */
    public void testGetSubTaskCount() {
        Task t1 = new Task("T", new Date(100), new Date(200));
        t1.addSubtask(new Task("S1", new Date(100), new Date(110)));
        Task s2 = new Task("S2", new Date(111), new Date(120));
        t1.addSubtask(s2);
        t1.addSubtask(new Task("S3", new Date(121), new Date(130)));
        t1.removeSubtask(s2);
    }
}
