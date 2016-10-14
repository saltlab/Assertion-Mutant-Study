package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Stroke;
import java.text.DecimalFormat;
import org.jfree.chart.TestUtilities;

/**
 * Tests for the {@link RingPlot} class.
 */
public class RingPlotTest {

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        RingPlot plot1 = new RingPlot(null);
        RingPlot plot2 = new RingPlot(null);
        plot1.setCenterTextMode(CenterTextMode.FIXED);
        plot2.setCenterTextMode(CenterTextMode.FIXED);
        plot1.setCenterText("ABC");
        plot2.setCenterText("ABC");
        plot1.setCenterTextColor(Color.RED);
        plot2.setCenterTextColor(Color.RED);
        plot1.setCenterTextFont(new Font(Font.SERIF, Font.PLAIN, 7));
        plot2.setCenterTextFont(new Font(Font.SERIF, Font.PLAIN, 7));
        plot1.setCenterTextFormatter(new DecimalFormat("0.000"));
        plot2.setCenterTextFormatter(new DecimalFormat("0.000"));
        plot1.setSeparatorsVisible(false);
        plot2.setSeparatorsVisible(false);
        Stroke s = new BasicStroke(1.1f);
        plot1.setSeparatorStroke(s);
        plot2.setSeparatorStroke(s);
        plot1.setSeparatorPaint(new GradientPaint(1.0f, 2.0f, Color.red, 2.0f, 1.0f, Color.blue));
        plot2.setSeparatorPaint(new GradientPaint(1.0f, 2.0f, Color.red, 2.0f, 1.0f, Color.blue));
        plot1.setInnerSeparatorExtension(0.01);
        plot2.setInnerSeparatorExtension(0.01);
        plot1.setOuterSeparatorExtension(0.02);
        plot2.setOuterSeparatorExtension(0.02);
        plot1.setSectionDepth(0.12);
        plot2.setSectionDepth(0.12);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        RingPlot p1 = new RingPlot(null);
        GradientPaint gp = new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.red);
        p1.setSeparatorPaint(gp);
        RingPlot p2 = (RingPlot) p1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        RingPlot p1 = new RingPlot(null);
        GradientPaint gp = new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.red);
        p1.setSeparatorPaint(gp);
        RingPlot p2 = (RingPlot) TestUtilities.serialised(p1);
    }
}
