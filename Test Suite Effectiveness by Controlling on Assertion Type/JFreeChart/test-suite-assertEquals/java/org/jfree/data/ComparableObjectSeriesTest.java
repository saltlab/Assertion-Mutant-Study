package org.jfree.data;

import org.jfree.chart.TestUtilities;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

/**
 * Tests for the {@link ComparableObjectSeries} class.
 */
public class ComparableObjectSeriesTest {

    static class MyComparableObjectSeries extends ComparableObjectSeries {

        /**
         * Creates a new instance.
         *
         * @param key  the series key.
         */
        public MyComparableObjectSeries(Comparable key) {
            super(key);
        }

        /**
         * Creates a new instance.
         *
         * @param key  the series key.
         * @param autoSort  automatically sort by x-value?
         * @param allowDuplicateXValues  allow duplicate values?
         */
        public MyComparableObjectSeries(Comparable key, boolean autoSort, boolean allowDuplicateXValues) {
            super(key, autoSort, allowDuplicateXValues);
        }

        @Override
        public void add(Comparable x, Object y) {
            super.add(x, y);
        }

        @Override
        public ComparableObjectItem remove(Comparable x) {
            return super.remove(x);
        }
    }

    /**
     * Some checks for the constructor.
     */
    public void testConstructor1() {
        ComparableObjectSeries s1 = new ComparableObjectSeries("s1");
        boolean pass = false;
        try {
            new ComparableObjectSeries(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        MyComparableObjectSeries s1 = new MyComparableObjectSeries("A");
        MyComparableObjectSeries s2 = new MyComparableObjectSeries("A");
        s1 = new MyComparableObjectSeries("B");
        s2 = new MyComparableObjectSeries("B");
        s1 = new MyComparableObjectSeries("B", false, true);
        s2 = new MyComparableObjectSeries("B", false, true);
        s1 = new MyComparableObjectSeries("B", false, false);
        s2 = new MyComparableObjectSeries("B", false, false);
        s1.add(new Integer(1), "ABC");
        s2.add(new Integer(1), "ABC");
        s1.add(new Integer(0), "DEF");
        s2.add(new Integer(0), "DEF");
        s1.remove(new Integer(1));
        s2.remove(new Integer(1));
    }

    /**
     * Some checks for the clone() method.
     */
    public void testCloning() throws CloneNotSupportedException {
        MyComparableObjectSeries s1 = new MyComparableObjectSeries("A");
        s1.add(new Integer(1), "ABC");
        MyComparableObjectSeries s2 = (MyComparableObjectSeries) s1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        MyComparableObjectSeries s1 = new MyComparableObjectSeries("A");
        s1.add(new Integer(1), "ABC");
        MyComparableObjectSeries s2 = (MyComparableObjectSeries) TestUtilities.serialised(s1);
    }

    /**
     * Some simple checks for the hashCode() method.
     */
    @Test
    public void testHashCode() {
        MyComparableObjectSeries s1 = new MyComparableObjectSeries("Test");
        MyComparableObjectSeries s2 = new MyComparableObjectSeries("Test");
        assertEquals(s1.hashCode(), s2.hashCode());
        s1.add("A", "1");
        s2.add("A", "1");
        s1.add("B", null);
        s2.add("B", null);
        s1.add("C", "3");
        s2.add("C", "3");
        s1.add("D", "4");
        s2.add("D", "4");
    }
}
