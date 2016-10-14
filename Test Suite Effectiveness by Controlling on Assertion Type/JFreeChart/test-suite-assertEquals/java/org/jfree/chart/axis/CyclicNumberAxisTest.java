package org.jfree.chart.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Stroke;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link CyclicNumberAxis} class.
 */
public class CyclicNumberAxisTest {

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        CyclicNumberAxis a1 = new CyclicNumberAxis(10, 0, "Test");
        CyclicNumberAxis a2 = (CyclicNumberAxis) a1.clone();
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        CyclicNumberAxis a1 = new CyclicNumberAxis(10, 0, "Test");
        CyclicNumberAxis a2 = new CyclicNumberAxis(10, 0, "Test");
        a1.setPeriod(5);
        a2.setPeriod(5);
        a1.setOffset(2.0);
        a2.setOffset(2.0);
        a1.setAdvanceLinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.black));
        a2.setAdvanceLinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.black));
        Stroke stroke = new BasicStroke(0.2f);
        a1.setAdvanceLineStroke(stroke);
        a2.setAdvanceLineStroke(stroke);
        a1.setAdvanceLineVisible(!a1.isAdvanceLineVisible());
        a2.setAdvanceLineVisible(a1.isAdvanceLineVisible());
        a1.setBoundMappedToLastCycle(!a1.isBoundMappedToLastCycle());
        a2.setBoundMappedToLastCycle(a1.isBoundMappedToLastCycle());
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        CyclicNumberAxis a1 = new CyclicNumberAxis(10, 0, "Test");
        CyclicNumberAxis a2 = new CyclicNumberAxis(10, 0, "Test");
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        CyclicNumberAxis a1 = new CyclicNumberAxis(10, 0, "Test Axis");
        CyclicNumberAxis a2 = (CyclicNumberAxis) TestUtilities.serialised(a1);
    }
}
