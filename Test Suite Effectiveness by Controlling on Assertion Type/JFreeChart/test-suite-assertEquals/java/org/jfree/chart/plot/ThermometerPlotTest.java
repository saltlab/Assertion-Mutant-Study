package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.text.DecimalFormat;
import org.jfree.chart.TestUtilities;
import org.jfree.ui.RectangleInsets;
import org.junit.Test;

/**
 * Tests for the {@link ThermometerPlot} class.
 */
public class ThermometerPlotTest {

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        ThermometerPlot p1 = new ThermometerPlot();
        ThermometerPlot p2 = new ThermometerPlot();
        p1.setPadding(new RectangleInsets(1.0, 2.0, 3.0, 4.0));
        p2.setPadding(new RectangleInsets(1.0, 2.0, 3.0, 4.0));
        BasicStroke s = new BasicStroke(1.23f);
        p1.setThermometerStroke(s);
        p2.setThermometerStroke(s);
        p1.setThermometerPaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.red));
        p2.setThermometerPaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.red));
        p1.setUnits(ThermometerPlot.UNITS_KELVIN);
        p2.setUnits(ThermometerPlot.UNITS_KELVIN);
        p1.setValueLocation(ThermometerPlot.LEFT);
        p2.setValueLocation(ThermometerPlot.LEFT);
        p1.setAxisLocation(ThermometerPlot.RIGHT);
        p2.setAxisLocation(ThermometerPlot.RIGHT);
        p1.setValueFont(new Font("Serif", Font.PLAIN, 9));
        p2.setValueFont(new Font("Serif", Font.PLAIN, 9));
        p1.setValuePaint(new GradientPaint(4.0f, 5.0f, Color.red, 6.0f, 7.0f, Color.white));
        p2.setValuePaint(new GradientPaint(4.0f, 5.0f, Color.red, 6.0f, 7.0f, Color.white));
        p1.setValueFormat(new DecimalFormat("0.0000"));
        p2.setValueFormat(new DecimalFormat("0.0000"));
        p1.setMercuryPaint(new GradientPaint(9.0f, 8.0f, Color.red, 7.0f, 6.0f, Color.blue));
        p2.setMercuryPaint(new GradientPaint(9.0f, 8.0f, Color.red, 7.0f, 6.0f, Color.blue));
        p1.setShowValueLines(true);
        p2.setShowValueLines(true);
        p1.setSubrange(1, 1.0, 2.0);
        p2.setSubrange(1, 1.0, 2.0);
        p1.setSubrangePaint(1, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        p2.setSubrangePaint(1, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        p1.setBulbRadius(9);
        p2.setBulbRadius(9);
        p1.setColumnRadius(8);
        p2.setColumnRadius(8);
        p1.setGap(7);
        p2.setGap(7);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        ThermometerPlot p1 = new ThermometerPlot();
        ThermometerPlot p2 = (ThermometerPlot) p1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        ThermometerPlot p1 = new ThermometerPlot();
        ThermometerPlot p2 = (ThermometerPlot) TestUtilities.serialised(p1);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization2() {
        ThermometerPlot p1 = new ThermometerPlot();
        p1.setSubrangePaint(1, new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        ThermometerPlot p2 = (ThermometerPlot) TestUtilities.serialised(p1);
    }

    /**
     * Some checks for the setUnits() method.
     */
    public void testSetUnits() {
        ThermometerPlot p1 = new ThermometerPlot();
        p1.setUnits("FAHRENHEIT");
        p1.setUnits("°F");
    }
}
