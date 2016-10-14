package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.jfree.data.general.DefaultValueDataset;
import org.junit.Test;

/**
 * Tests for the {@link CompassPlot} class.
 */
public class CompassPlotTest {

    /**
     * Test the equals() method.
     */
    public void testEquals() {
        CompassPlot plot1 = new CompassPlot();
        CompassPlot plot2 = new CompassPlot();
        plot1.setLabelType(CompassPlot.VALUE_LABELS);
        plot2.setLabelType(CompassPlot.VALUE_LABELS);
        plot1.setLabelFont(new Font("Serif", Font.PLAIN, 10));
        plot2.setLabelFont(new Font("Serif", Font.PLAIN, 10));
        plot1.setDrawBorder(true);
        plot2.setDrawBorder(true);
        plot1.setRosePaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.yellow));
        plot2.setRosePaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.yellow));
        plot1.setRoseCenterPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        plot2.setRoseCenterPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        plot1.setRoseHighlightPaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.yellow));
        plot2.setRoseHighlightPaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.yellow));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    @Test
    public void testSerialization() {
        CompassPlot p1 = new CompassPlot(null);
        p1.setRosePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        p1.setRoseCenterPaint(new GradientPaint(4.0f, 3.0f, Color.red, 2.0f, 1.0f, Color.green));
        p1.setRoseHighlightPaint(new GradientPaint(4.0f, 3.0f, Color.red, 2.0f, 1.0f, Color.green));
        CompassPlot p2 = (CompassPlot) TestUtilities.serialised(p1);
        assertEquals(p1, p2);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        CompassPlot p1 = new CompassPlot(new DefaultValueDataset(15.0));
        CompassPlot p2 = (CompassPlot) p1.clone();
    }
}
