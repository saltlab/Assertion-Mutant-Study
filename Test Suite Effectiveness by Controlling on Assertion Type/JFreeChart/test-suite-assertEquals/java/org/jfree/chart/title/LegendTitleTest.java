package org.jfree.chart.title;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.plot.XYPlot;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.SortOrder;
import org.junit.Test;

/**
 * Some tests for the {@link LegendTitle} class.
 */
public class LegendTitleTest {

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        XYPlot plot1 = new XYPlot();
        LegendTitle t1 = new LegendTitle(plot1);
        LegendTitle t2 = new LegendTitle(plot1);
        t1.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        t2.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        t1.setLegendItemGraphicEdge(RectangleEdge.BOTTOM);
        t2.setLegendItemGraphicEdge(RectangleEdge.BOTTOM);
        t1.setLegendItemGraphicAnchor(RectangleAnchor.BOTTOM_LEFT);
        t2.setLegendItemGraphicAnchor(RectangleAnchor.BOTTOM_LEFT);
        t1.setLegendItemGraphicLocation(RectangleAnchor.TOP_LEFT);
        t2.setLegendItemGraphicLocation(RectangleAnchor.TOP_LEFT);
        t1.setItemFont(new Font("Dialog", Font.PLAIN, 19));
        t2.setItemFont(new Font("Dialog", Font.PLAIN, 19));
        t1.setSortOrder(SortOrder.DESCENDING);
        t2.setSortOrder(SortOrder.DESCENDING);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        XYPlot plot1 = new XYPlot();
        LegendTitle t1 = new LegendTitle(plot1);
        LegendTitle t2 = new LegendTitle(plot1);
        int h1 = t1.hashCode();
        int h2 = t2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        XYPlot plot = new XYPlot();
        Rectangle2D bounds1 = new Rectangle2D.Double(10.0, 20.0, 30.0, 40.0);
        LegendTitle t1 = new LegendTitle(plot);
        t1.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        t1.setBounds(bounds1);
        LegendTitle t2 = (LegendTitle) t1.clone();
        bounds1.setFrame(40.0, 30.0, 20.0, 10.0);
        t2.setBounds(new Rectangle2D.Double(40.0, 30.0, 20.0, 10.0));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        XYPlot plot = new XYPlot();
        LegendTitle t1 = new LegendTitle(plot);
        LegendTitle t2 = (LegendTitle) TestUtilities.serialised(t1);
    }
}
