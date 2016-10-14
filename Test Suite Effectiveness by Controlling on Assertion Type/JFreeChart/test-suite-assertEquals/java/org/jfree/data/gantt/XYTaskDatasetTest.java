package org.jfree.data.gantt;

import java.util.Date;
import org.jfree.chart.TestUtilities;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Tests for the {@link XYTaskDataset} class.
 */
public class XYTaskDatasetTest {

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        TaskSeries s1 = new TaskSeries("Series");
        s1.add(new Task("Task 1", new Date(0L), new Date(1L)));
        s1.add(new Task("Task 2", new Date(10L), new Date(11L)));
        s1.add(new Task("Task 3", new Date(20L), new Date(21L)));
        TaskSeriesCollection u1 = new TaskSeriesCollection();
        u1.add(s1);
        XYTaskDataset d1 = new XYTaskDataset(u1);
        TaskSeries s2 = new TaskSeries("Series");
        s2.add(new Task("Task 1", new Date(0L), new Date(1L)));
        s2.add(new Task("Task 2", new Date(10L), new Date(11L)));
        s2.add(new Task("Task 3", new Date(20L), new Date(21L)));
        TaskSeriesCollection u2 = new TaskSeriesCollection();
        u2.add(s2);
        XYTaskDataset d2 = new XYTaskDataset(u2);
        d1.setSeriesWidth(0.123);
        d2.setSeriesWidth(0.123);
        d1.setTransposed(true);
        d2.setTransposed(true);
        s1.add(new Task("Task 2", new Date(10L), new Date(11L)));
        s2.add(new Task("Task 2", new Date(10L), new Date(11L)));
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        TaskSeries s1 = new TaskSeries("Series");
        s1.add(new Task("Task 1", new Date(0L), new Date(1L)));
        TaskSeriesCollection u1 = new TaskSeriesCollection();
        u1.add(s1);
        XYTaskDataset d1 = new XYTaskDataset(u1);
        XYTaskDataset d2 = (XYTaskDataset) d1.clone();
        s1.add(new Task("Task 2", new Date(10L), new Date(11L)));
        TaskSeriesCollection u2 = d2.getTasks();
        TaskSeries s2 = u2.getSeries("Series");
        s2.add(new Task("Task 2", new Date(10L), new Date(11L)));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        TaskSeries s1 = new TaskSeries("Series");
        s1.add(new Task("Task 1", new Date(0L), new Date(1L)));
        TaskSeriesCollection u1 = new TaskSeriesCollection();
        u1.add(s1);
        XYTaskDataset d1 = new XYTaskDataset(u1);
        XYTaskDataset d2 = (XYTaskDataset) TestUtilities.serialised(d1);
        s1.add(new Task("Task 2", new Date(10L), new Date(11L)));
        TaskSeriesCollection u2 = d2.getTasks();
        TaskSeries s2 = u2.getSeries("Series");
        s2.add(new Task("Task 2", new Date(10L), new Date(11L)));
    }
}
