package org.jfree.chart.plot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.Align;
import org.jfree.ui.RectangleInsets;
import org.junit.Test;

/**
 * Some tests for the {@link Plot} class.
 */
public class PlotTest {

    /**
     * Check that the equals() method can distinguish all fields (note that
     * the dataset is NOT considered in the equals() method).
     */
    public void testEquals() {
        PiePlot plot1 = new PiePlot();
        PiePlot plot2 = new PiePlot();
        plot1.setNoDataMessage("No data XYZ");
        plot2.setNoDataMessage("No data XYZ");
        plot1.setNoDataMessageFont(new Font("SansSerif", Font.PLAIN, 13));
        plot2.setNoDataMessageFont(new Font("SansSerif", Font.PLAIN, 13));
        plot1.setNoDataMessagePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        plot2.setNoDataMessagePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        plot1.setInsets(new RectangleInsets(1.0, 2.0, 3.0, 4.0));
        plot2.setInsets(new RectangleInsets(1.0, 2.0, 3.0, 4.0));
        plot1.setOutlineVisible(false);
        plot2.setOutlineVisible(false);
        BasicStroke s = new BasicStroke(1.23f);
        plot1.setOutlineStroke(s);
        plot2.setOutlineStroke(s);
        plot1.setOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.green));
        plot2.setOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.green));
        plot1.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.cyan, 3.0f, 4.0f, Color.green));
        plot2.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.cyan, 3.0f, 4.0f, Color.green));
        plot1.setBackgroundImage(JFreeChart.INFO.getLogo());
        plot2.setBackgroundImage(JFreeChart.INFO.getLogo());
        plot1.setBackgroundImageAlignment(Align.BOTTOM_RIGHT);
        plot2.setBackgroundImageAlignment(Align.BOTTOM_RIGHT);
        plot1.setBackgroundImageAlpha(0.77f);
        plot2.setBackgroundImageAlpha(0.77f);
        plot1.setForegroundAlpha(0.99f);
        plot2.setForegroundAlpha(0.99f);
        plot1.setBackgroundAlpha(0.99f);
        plot2.setBackgroundAlpha(0.99f);
        plot1.setDrawingSupplier(new DefaultDrawingSupplier(new Paint[] { Color.blue }, new Paint[] { Color.red }, new Stroke[] { new BasicStroke(1.1f) }, new Stroke[] { new BasicStroke(9.9f) }, new Shape[] { new Rectangle(1, 2, 3, 4) }));
        plot2.setDrawingSupplier(new DefaultDrawingSupplier(new Paint[] { Color.blue }, new Paint[] { Color.red }, new Stroke[] { new BasicStroke(1.1f) }, new Stroke[] { new BasicStroke(9.9f) }, new Shape[] { new Rectangle(1, 2, 3, 4) }));
    }
}
