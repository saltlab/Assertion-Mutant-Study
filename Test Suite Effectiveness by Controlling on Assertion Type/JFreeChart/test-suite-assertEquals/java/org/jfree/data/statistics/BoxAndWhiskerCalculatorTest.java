package org.jfree.data.statistics;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Tests for the {@link BoxAndWhiskerCalculator} class.
 */
public class BoxAndWhiskerCalculatorTest {

    /**
     * Some checks for the calculateBoxAndWhiskerStatistics() method.
     */
    public void testCalculateBoxAndWhiskerStatistics() {
        boolean pass = false;
        try {
            BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        List values = new ArrayList();
        values.add(new Double(1.1));
        BoxAndWhiskerItem item = BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(values);
    }

    private static final double EPSILON = 0.000000001;

    /**
     * Tests the Q1 calculation.
     */
    @Test
    public void testCalculateQ1() {
        boolean pass = false;
        try {
            BoxAndWhiskerCalculator.calculateQ1(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        List values = new ArrayList();
        double q1 = BoxAndWhiskerCalculator.calculateQ1(values);
        values.add(new Double(1.0));
        q1 = BoxAndWhiskerCalculator.calculateQ1(values);
        values.add(new Double(2.0));
        q1 = BoxAndWhiskerCalculator.calculateQ1(values);
        values.add(new Double(3.0));
        q1 = BoxAndWhiskerCalculator.calculateQ1(values);
        assertEquals(q1, 1.5, EPSILON);
        values.add(new Double(4.0));
        q1 = BoxAndWhiskerCalculator.calculateQ1(values);
    }

    /**
     * Tests the Q3 calculation.
     */
    @Test
    public void testCalculateQ3() {
        boolean pass = false;
        try {
            BoxAndWhiskerCalculator.calculateQ3(null);
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        List values = new ArrayList();
        double q3 = BoxAndWhiskerCalculator.calculateQ3(values);
        values.add(new Double(1.0));
        q3 = BoxAndWhiskerCalculator.calculateQ3(values);
        values.add(new Double(2.0));
        q3 = BoxAndWhiskerCalculator.calculateQ3(values);
        values.add(new Double(3.0));
        q3 = BoxAndWhiskerCalculator.calculateQ3(values);
        assertEquals(q3, 2.5, EPSILON);
        values.add(new Double(4.0));
        q3 = BoxAndWhiskerCalculator.calculateQ3(values);
    }

    /**
     * The test case included in bug report 1593149.
     */
    public void test1593149() {
        ArrayList theList = new ArrayList(5);
        theList.add(0, new Double(1.0));
        theList.add(1, new Double(2.0));
        theList.add(2, new Double(Double.NaN));
        theList.add(3, new Double(3.0));
        theList.add(4, new Double(4.0));
        BoxAndWhiskerItem theItem = BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(theList);
    }
}
