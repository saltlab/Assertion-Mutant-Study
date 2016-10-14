package org.jfree.data.gantt;

import java.util.Date;
import org.jfree.chart.TestUtilities;
import org.jfree.data.time.SimpleTimePeriod;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the {@link TaskSeriesCollection} class.
 */
public class TaskSeriesCollectionTest {

    /**
     * Creates a sample collection for testing purposes.
     *
     * @return A sample collection.
     */
    private TaskSeriesCollection createCollection1() {
        TaskSeriesCollection result = new TaskSeriesCollection();
        TaskSeries s1 = new TaskSeries("S1");
        s1.add(new Task("Task 1", new Date(1), new Date(2)));
        s1.add(new Task("Task 2", new Date(3), new Date(4)));
        result.add(s1);
        TaskSeries s2 = new TaskSeries("S2");
        s2.add(new Task("Task 3", new Date(5), new Date(6)));
        result.add(s2);
        return result;
    }

    /**
     * Creates a sample collection for testing purposes.
     *
     * @return A sample collection.
     */
    private TaskSeriesCollection createCollection2() {
        TaskSeriesCollection result = new TaskSeriesCollection();
        TaskSeries s1 = new TaskSeries("S1");
        Task t1 = new Task("Task 1", new Date(10), new Date(20));
        t1.addSubtask(new Task("Task 1A", new Date(10), new Date(15)));
        t1.addSubtask(new Task("Task 1B", new Date(16), new Date(20)));
        t1.setPercentComplete(0.10);
        s1.add(t1);
        Task t2 = new Task("Task 2", new Date(30), new Date(40));
        t2.addSubtask(new Task("Task 2A", new Date(30), new Date(35)));
        t2.addSubtask(new Task("Task 2B", new Date(36), new Date(40)));
        t2.setPercentComplete(0.20);
        s1.add(t2);
        result.add(s1);
        TaskSeries s2 = new TaskSeries("S2");
        Task t3 = new Task("Task 3", new Date(50), new Date(60));
        t3.addSubtask(new Task("Task 3A", new Date(50), new Date(55)));
        t3.addSubtask(new Task("Task 3B", new Date(56), new Date(60)));
        t3.setPercentComplete(0.30);
        s2.add(t3);
        result.add(s2);
        return result;
    }

    /**
     * Creates a sample collection for testing purposes.
     *
     * @return A sample collection.
     */
    private TaskSeriesCollection createCollection3() {
        Task sub1 = new Task("Sub1", new Date(11), new Date(111));
        Task sub2 = new Task("Sub2", new Date(22), new Date(222));
        Task sub3 = new Task("Sub3", new Date(33), new Date(333));
        Task sub4 = new Task("Sub4", new Date(44), new Date(444));
        Task sub5 = new Task("Sub5", new Date(55), new Date(555));
        Task sub6 = new Task("Sub6", new Date(66), new Date(666));
        sub1.setPercentComplete(0.111);
        sub2.setPercentComplete(0.222);
        sub3.setPercentComplete(0.333);
        sub4.setPercentComplete(0.444);
        sub5.setPercentComplete(0.555);
        sub6.setPercentComplete(0.666);
        TaskSeries seriesA = new TaskSeries("Series A");
        Task taskA1 = new Task("Task 1", new SimpleTimePeriod(new Date(100), new Date(200)));
        taskA1.setPercentComplete(0.1);
        taskA1.addSubtask(sub1);
        Task taskA2 = new Task("Task 2", new SimpleTimePeriod(new Date(220), new Date(350)));
        taskA2.setPercentComplete(0.2);
        taskA2.addSubtask(sub2);
        taskA2.addSubtask(sub3);
        seriesA.add(taskA1);
        seriesA.add(taskA2);
        TaskSeries seriesB = new TaskSeries("Series B");
        Task taskB2 = new Task("Task 2", new SimpleTimePeriod(new Date(2220), new Date(3350)));
        taskB2.setPercentComplete(0.3);
        taskB2.addSubtask(sub4);
        taskB2.addSubtask(sub5);
        taskB2.addSubtask(sub6);
        seriesB.add(taskB2);
        TaskSeriesCollection tsc = new TaskSeriesCollection();
        tsc.add(seriesA);
        tsc.add(seriesB);
        return tsc;
    }

    /**
     * A test for the getSeriesCount() method.
     */
    public void testGetSeriesCount() {
        TaskSeriesCollection c = createCollection1();
    }

    /**
     * Some tests for the getSeriesKey() method.
     */
    public void testGetSeriesKey() {
        TaskSeriesCollection c = createCollection1();
    }

    /**
     * A test for the getRowCount() method.
     */
    public void testGetRowCount() {
        TaskSeriesCollection c = createCollection1();
    }

    /**
     * Some tests for the getRowKey() method.
     */
    public void testGetRowKey() {
        TaskSeriesCollection c = createCollection1();
    }

    /**
     * Some tests for the getRowIndex() method.
     */
    public void testGetRowIndex() {
        TaskSeriesCollection c = createCollection1();
    }

    /**
     * Some tests for the getValue() method.
     */
    public void testGetValue() {
        TaskSeriesCollection c = createCollection1();
    }

    /**
     * Some tests for the getStartValue() method.
     */
    public void testGetStartValue() {
        TaskSeriesCollection c = createCollection1();
        TaskSeriesCollection c3 = createCollection3();
    }

    /**
     * Some tests for the getStartValue() method for sub-intervals.
     */
    public void testGetStartValue2() {
        TaskSeriesCollection c = createCollection2();
        TaskSeriesCollection c3 = createCollection3();
    }

    /**
     * A check for a null task duration.
     */
    public void testGetStartValue3() {
        TaskSeriesCollection c = new TaskSeriesCollection();
        TaskSeries s = new TaskSeries("Series 1");
        s.add(new Task("Task with null duration", null));
        c.add(s);
        Number millis = c.getStartValue("Series 1", "Task with null duration");
    }

    /**
     * Some tests for the getEndValue() method.
     */
    public void testGetEndValue() {
        TaskSeriesCollection c = createCollection1();
        TaskSeriesCollection c3 = createCollection3();
    }

    /**
     * Some tests for the getEndValue() method for sub-intervals.
     */
    @Test
    public void testGetEndValue2() {
        TaskSeriesCollection c = createCollection2();
        assertEquals(new Long(55L), c.getEndValue("S2", "Task 3", 0));
        TaskSeriesCollection c3 = createCollection3();
    }

    /**
     * A check for a null task duration.
     */
    public void testGetEndValue3() {
        TaskSeriesCollection c = new TaskSeriesCollection();
        TaskSeries s = new TaskSeries("Series 1");
        s.add(new Task("Task with null duration", null));
        c.add(s);
        Number millis = c.getEndValue("Series 1", "Task with null duration");
    }

    /**
     * Some tests for the getPercentComplete() method.
     */
    @Test
    public void testGetPercentComplete() {
        TaskSeriesCollection c = createCollection2();
        TaskSeriesCollection c3 = createCollection3();
        assertEquals(new Double(0.111), c3.getPercentComplete(0, 0, 0));
    }

    /**
     * A test for the getColumnCount() method.
     */
    public void testGetColumnCount() {
        TaskSeriesCollection c = createCollection1();
    }

    /**
     * Some tests for the getColumnKey() method.
     */
    public void testGetColumnKey() {
        TaskSeriesCollection c = createCollection1();
        assertEquals("Task 1", c.getColumnKey(0));
        assertEquals("Task 2", c.getColumnKey(1));
        assertEquals("Task 3", c.getColumnKey(2));
    }

    /**
     * Some tests for the getColumnIndex() method.
     */
    public void testGetColumnIndex() {
        TaskSeriesCollection c = createCollection1();
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        TaskSeries s1 = new TaskSeries("S");
        s1.add(new Task("T1", new Date(1), new Date(2)));
        s1.add(new Task("T2", new Date(11), new Date(22)));
        TaskSeries s2 = new TaskSeries("S");
        s2.add(new Task("T1", new Date(1), new Date(2)));
        s2.add(new Task("T2", new Date(11), new Date(22)));
        TaskSeriesCollection c1 = new TaskSeriesCollection();
        c1.add(s1);
        c1.add(s2);
        TaskSeries s1b = new TaskSeries("S");
        s1b.add(new Task("T1", new Date(1), new Date(2)));
        s1b.add(new Task("T2", new Date(11), new Date(22)));
        TaskSeries s2b = new TaskSeries("S");
        s2b.add(new Task("T1", new Date(1), new Date(2)));
        s2b.add(new Task("T2", new Date(11), new Date(22)));
        TaskSeriesCollection c2 = new TaskSeriesCollection();
        c2.add(s1b);
        c2.add(s2b);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        TaskSeries s1 = new TaskSeries("S1");
        s1.add(new Task("T1", new Date(1), new Date(2)));
        s1.add(new Task("T2", new Date(11), new Date(22)));
        TaskSeries s2 = new TaskSeries("S2");
        s2.add(new Task("T1", new Date(33), new Date(44)));
        s2.add(new Task("T2", new Date(55), new Date(66)));
        TaskSeriesCollection c1 = new TaskSeriesCollection();
        c1.add(s1);
        c1.add(s2);
        TaskSeriesCollection c2 = (TaskSeriesCollection) c1.clone();
        s1.add(new Task("T3", new Date(21), new Date(33)));
        TaskSeries series = c2.getSeries("S1");
        series.add(new Task("T3", new Date(21), new Date(33)));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        TaskSeries s1 = new TaskSeries("S");
        s1.add(new Task("T1", new Date(1), new Date(2)));
        s1.add(new Task("T2", new Date(11), new Date(22)));
        TaskSeries s2 = new TaskSeries("S");
        s2.add(new Task("T1", new Date(1), new Date(2)));
        s2.add(new Task("T2", new Date(11), new Date(22)));
        TaskSeriesCollection c1 = new TaskSeriesCollection();
        c1.add(s1);
        c1.add(s2);
        TaskSeriesCollection c2 = (TaskSeriesCollection) TestUtilities.serialised(c1);
    }

    /**
     * A test for bug report 697153.
     */
    public void test697153() {
        TaskSeries s1 = new TaskSeries("S1");
        s1.add(new Task("Task 1", new SimpleTimePeriod(new Date(), new Date())));
        s1.add(new Task("Task 2", new SimpleTimePeriod(new Date(), new Date())));
        s1.add(new Task("Task 3", new SimpleTimePeriod(new Date(), new Date())));
        TaskSeries s2 = new TaskSeries("S2");
        s2.add(new Task("Task 2", new SimpleTimePeriod(new Date(), new Date())));
        s2.add(new Task("Task 3", new SimpleTimePeriod(new Date(), new Date())));
        s2.add(new Task("Task 4", new SimpleTimePeriod(new Date(), new Date())));
        TaskSeriesCollection tsc = new TaskSeriesCollection();
        tsc.add(s1);
        tsc.add(s2);
        s1.removeAll();
        int taskCount = tsc.getColumnCount();
    }

    /**
     * A test for bug report 800324.
     */
    public void test800324() {
        TaskSeries s1 = new TaskSeries("S1");
        s1.add(new Task("Task 1", new SimpleTimePeriod(new Date(), new Date())));
        s1.add(new Task("Task 2", new SimpleTimePeriod(new Date(), new Date())));
        s1.add(new Task("Task 3", new SimpleTimePeriod(new Date(), new Date())));
        TaskSeriesCollection tsc = new TaskSeriesCollection();
        tsc.add(s1);
        try {
            tsc.getStartValue(0, 3);
            assertTrue(false);
        } catch (IndexOutOfBoundsException e) {
        }
        try {
            tsc.getEndValue(0, 3);
            assertTrue(false);
        } catch (IndexOutOfBoundsException e) {
        }
        try {
            tsc.getSubIntervalCount(0, 3);
            assertTrue(false);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    /**
     * Some tests for the bug report 1099331.  We create a TaskSeriesCollection
     * with two series - the first series has two tasks, but the second has
     * only one.  The key is to ensure that the methods in TaskSeriesCollection
     * translate the index values to key values *before* accessing the tasks
     * in the series.
     */
    public void testGetSubIntervalCount() {
        TaskSeriesCollection tsc = createCollection3();
    }

    /**
     * Some basic tests for the getSeries() methods.
     */
    public void testGetSeries() {
        TaskSeries s1 = new TaskSeries("S1");
        TaskSeries s2 = new TaskSeries("S2");
        TaskSeriesCollection c = new TaskSeriesCollection();
        c.add(s1);
        c.add(s2);
        boolean pass = false;
        try {
            c.getSeries(null);
        } catch (NullPointerException e) {
            pass = true;
        }
    }

    /**
     * Some basic checks for the remove() method.
     */
    public void testRemove() {
        TaskSeriesCollection c = new TaskSeriesCollection();
        TaskSeries s1 = new TaskSeries("S1");
        c.add(s1);
        c.remove(0);
        c.add(s1);
        boolean pass = false;
        try {
            c.remove(-1);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        pass = false;
        try {
            c.remove(1);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }
}
