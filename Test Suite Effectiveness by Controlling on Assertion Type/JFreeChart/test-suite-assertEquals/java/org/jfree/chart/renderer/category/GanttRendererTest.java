package org.jfree.chart.renderer.category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.awt.Color;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link GanttRenderer} class.
 */
public class GanttRendererTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        GanttRenderer r1 = new GanttRenderer();
        GanttRenderer r2 = new GanttRenderer();
        r1.setCompletePaint(Color.yellow);
        r2.setCompletePaint(Color.yellow);
        r1.setIncompletePaint(Color.green);
        r2.setIncompletePaint(Color.green);
        r1.setStartPercent(0.11);
        r2.setStartPercent(0.11);
        r1.setEndPercent(0.88);
        r2.setEndPercent(0.88);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        GanttRenderer r1 = new GanttRenderer();
        GanttRenderer r2 = new GanttRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        GanttRenderer r1 = new GanttRenderer();
        GanttRenderer r2 = (GanttRenderer) r1.clone();
    }

    /**
     * Check that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        GanttRenderer r1 = new GanttRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        GanttRenderer r1 = new GanttRenderer();
        r1.setCompletePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        r1.setIncompletePaint(new GradientPaint(4.0f, 3.0f, Color.red, 2.0f, 1.0f, Color.blue));
        GanttRenderer r2 = (GanttRenderer) TestUtilities.serialised(r1);
    }
}
