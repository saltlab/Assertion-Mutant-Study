package org.jfree.data.gantt;

import java.util.Date;
import org.jfree.chart.TestUtilities;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the {@link SlidingGanttCategoryDataset} class.
 */
public class SlidingGanttCategoryDatasetTest {

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
        SlidingGanttCategoryDataset d1 = new SlidingGanttCategoryDataset(u1, 0, 5);
        TaskSeries s2 = new TaskSeries("Series");
        s2.add(new Task("Task 1", new Date(0L), new Date(1L)));
        s2.add(new Task("Task 2", new Date(10L), new Date(11L)));
        s2.add(new Task("Task 3", new Date(20L), new Date(21L)));
        TaskSeriesCollection u2 = new TaskSeriesCollection();
        u2.add(s2);
        SlidingGanttCategoryDataset d2 = new SlidingGanttCategoryDataset(u2, 0, 5);
        d1.setFirstCategoryIndex(1);
        d2.setFirstCategoryIndex(1);
        d1.setMaximumCategoryCount(99);
        d2.setMaximumCategoryCount(99);
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
        SlidingGanttCategoryDataset d1 = new SlidingGanttCategoryDataset(u1, 0, 5);
        SlidingGanttCategoryDataset d2 = (SlidingGanttCategoryDataset) d1.clone();
        s1.add(new Task("Task 2", new Date(10L), new Date(11L)));
        TaskSeriesCollection u2 = (TaskSeriesCollection) d2.getUnderlyingDataset();
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
        SlidingGanttCategoryDataset d1 = new SlidingGanttCategoryDataset(u1, 0, 5);
        SlidingGanttCategoryDataset d2 = (SlidingGanttCategoryDataset) TestUtilities.serialised(d1);
        s1.add(new Task("Task 2", new Date(10L), new Date(11L)));
        TaskSeriesCollection u2 = (TaskSeriesCollection) d2.getUnderlyingDataset();
        TaskSeries s2 = u2.getSeries("Series");
        s2.add(new Task("Task 2", new Date(10L), new Date(11L)));
    }
}
