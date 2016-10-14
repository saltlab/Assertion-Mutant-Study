package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.event.MarkerChangeEvent;
import org.jfree.chart.event.MarkerChangeListener;
import org.junit.Test;

/**
 * Some tests for the {@link CategoryMarker} class.
 */
public class CategoryMarkerTest implements MarkerChangeListener {

    MarkerChangeEvent lastEvent;

    /**
     * Records the last event.
     *
     * @param event  the last event.
     */
    @Override
    public void markerChanged(MarkerChangeEvent event) {
        this.lastEvent = event;
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        CategoryMarker m1 = new CategoryMarker("A");
        CategoryMarker m2 = new CategoryMarker("A");
        m1 = new CategoryMarker("B");
        m2 = new CategoryMarker("B");
        m1 = new CategoryMarker("A", new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.yellow), new BasicStroke(1.1f));
        m2 = new CategoryMarker("A", new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.yellow), new BasicStroke(1.1f));
        m1 = new CategoryMarker("A", new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.yellow), new BasicStroke(2.2f));
        m2 = new CategoryMarker("A", new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.yellow), new BasicStroke(2.2f));
        m1 = new CategoryMarker("A", new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.yellow), new BasicStroke(2.2f), Color.red, new BasicStroke(1.0f), 1.0f);
        m2 = new CategoryMarker("A", new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.yellow), new BasicStroke(2.2f), Color.red, new BasicStroke(1.0f), 1.0f);
        m1 = new CategoryMarker("A", new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.yellow), new BasicStroke(2.2f), Color.red, new BasicStroke(3.3f), 1.0f);
        m2 = new CategoryMarker("A", new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.yellow), new BasicStroke(2.2f), Color.red, new BasicStroke(3.3f), 1.0f);
        m1 = new CategoryMarker("A", new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.yellow), new BasicStroke(2.2f), Color.red, new BasicStroke(1.0f), 0.5f);
        m2 = new CategoryMarker("A", new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.yellow), new BasicStroke(2.2f), Color.red, new BasicStroke(1.0f), 0.5f);
    }

    /**
     * Check cloning.
     */
    public void testCloning() throws CloneNotSupportedException {
        CategoryMarker m1 = new CategoryMarker("A", new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.yellow), new BasicStroke(1.1f));
        CategoryMarker m2 = (CategoryMarker) m1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        CategoryMarker m1 = new CategoryMarker("A", new GradientPaint(1.0f, 2.0f, Color.white, 3.0f, 4.0f, Color.yellow), new BasicStroke(1.1f));
        CategoryMarker m2 = (CategoryMarker) TestUtilities.serialised(m1);
    }

    /**
     * Some checks for the getKey() and setKey() methods.
     */
    public void testGetSetKey() {
        CategoryMarker m = new CategoryMarker("X");
        m.addChangeListener(this);
        this.lastEvent = null;
        m.setKey("Y");
        try {
            m.setKey(null);
            fail("Expected an IllegalArgumentException for null.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Some checks for the getDrawAsLine() and setDrawAsLine() methods.
     */
    public void testGetSetDrawAsLine() {
        CategoryMarker m = new CategoryMarker("X");
        m.addChangeListener(this);
        this.lastEvent = null;
        m.setDrawAsLine(true);
    }
}
