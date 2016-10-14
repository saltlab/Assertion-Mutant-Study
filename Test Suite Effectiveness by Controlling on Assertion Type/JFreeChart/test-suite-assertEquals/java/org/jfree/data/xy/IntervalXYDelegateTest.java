package org.jfree.data.xy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Some checks for the {@link IntervalXYDelegate} class.
 */
public class IntervalXYDelegateTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        XYSeries s1 = new XYSeries("Series");
        s1.add(1.2, 3.4);
        XYSeriesCollection c1 = new XYSeriesCollection();
        c1.addSeries(s1);
        IntervalXYDelegate d1 = new IntervalXYDelegate(c1);
        XYSeries s2 = new XYSeries("Series");
        XYSeriesCollection c2 = new XYSeriesCollection();
        s2.add(1.2, 3.4);
        c2.addSeries(s2);
        IntervalXYDelegate d2 = new IntervalXYDelegate(c2);
        d1.setAutoWidth(false);
        d2.setAutoWidth(false);
        d1.setIntervalPositionFactor(0.123);
        d2.setIntervalPositionFactor(0.123);
        d1.setFixedIntervalWidth(1.23);
        d2.setFixedIntervalWidth(1.23);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYSeries s1 = new XYSeries("Series");
        s1.add(1.2, 3.4);
        XYSeriesCollection c1 = new XYSeriesCollection();
        c1.addSeries(s1);
        IntervalXYDelegate d1 = new IntervalXYDelegate(c1);
        IntervalXYDelegate d2 = (IntervalXYDelegate) d1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYSeries s1 = new XYSeries("Series");
        s1.add(1.2, 3.4);
        XYSeriesCollection c1 = new XYSeriesCollection();
        c1.addSeries(s1);
        IntervalXYDelegate d1 = new IntervalXYDelegate(c1);
        IntervalXYDelegate d2 = (IntervalXYDelegate) TestUtilities.serialised(d1);
    }
}
