package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.text.DecimalFormat;
import org.jfree.chart.TestUtilities;
import org.jfree.data.Range;
import org.jfree.data.general.DefaultValueDataset;
import org.junit.Test;

/**
 * Tests for the {@link MeterPlot} class.
 */
public class MeterPlotTest {

    /**
     * Test the equals method to ensure that it can distinguish the required
     * fields.  Note that the dataset is NOT considered in the equals test.
     */
    public void testEquals() {
        MeterPlot plot1 = new MeterPlot();
        MeterPlot plot2 = new MeterPlot();
        plot1.setUnits("mph");
        plot2.setUnits("mph");
        plot1.setRange(new Range(50.0, 70.0));
        plot2.setRange(new Range(50.0, 70.0));
        plot1.addInterval(new MeterInterval("Normal", new Range(55.0, 60.0)));
        plot2.addInterval(new MeterInterval("Normal", new Range(55.0, 60.0)));
        plot1.setDialOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        plot2.setDialOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        plot1.setDialShape(DialShape.CHORD);
        plot2.setDialShape(DialShape.CHORD);
        plot1.setDialBackgroundPaint(new GradientPaint(9.0f, 8.0f, Color.red, 7.0f, 6.0f, Color.blue));
        plot2.setDialBackgroundPaint(new GradientPaint(9.0f, 8.0f, Color.red, 7.0f, 6.0f, Color.blue));
        plot1.setDialOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.red));
        plot2.setDialOutlinePaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.red));
        plot1.setNeedlePaint(new GradientPaint(9.0f, 8.0f, Color.red, 7.0f, 6.0f, Color.blue));
        plot2.setNeedlePaint(new GradientPaint(9.0f, 8.0f, Color.red, 7.0f, 6.0f, Color.blue));
        plot1.setValueFont(new Font("Serif", Font.PLAIN, 6));
        plot2.setValueFont(new Font("Serif", Font.PLAIN, 6));
        plot1.setValuePaint(new GradientPaint(1.0f, 2.0f, Color.black, 3.0f, 4.0f, Color.white));
        plot2.setValuePaint(new GradientPaint(1.0f, 2.0f, Color.black, 3.0f, 4.0f, Color.white));
        plot1.setTickLabelsVisible(false);
        plot2.setTickLabelsVisible(false);
        plot1.setTickLabelFont(new Font("Serif", Font.PLAIN, 6));
        plot2.setTickLabelFont(new Font("Serif", Font.PLAIN, 6));
        plot1.setTickLabelPaint(Color.red);
        plot2.setTickLabelPaint(Color.red);
        plot1.setTickLabelFormat(new DecimalFormat("0"));
        plot2.setTickLabelFormat(new DecimalFormat("0"));
        plot1.setTickPaint(Color.green);
        plot2.setTickPaint(Color.green);
        plot1.setTickSize(1.23);
        plot2.setTickSize(1.23);
        plot1.setDrawBorder(!plot1.getDrawBorder());
        plot2.setDrawBorder(plot1.getDrawBorder());
        plot1.setMeterAngle(22);
        plot2.setMeterAngle(22);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        MeterPlot p1 = new MeterPlot();
        MeterPlot p2 = (MeterPlot) p1.clone();
        p1.getTickLabelFormat().setMinimumIntegerDigits(99);
        p2.getTickLabelFormat().setMinimumIntegerDigits(99);
        p1.addInterval(new MeterInterval("Test", new Range(1.234, 5.678)));
        p2.addInterval(new MeterInterval("Test", new Range(1.234, 5.678)));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization1() {
        MeterPlot p1 = new MeterPlot(null);
        p1.setDialBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        p1.setDialOutlinePaint(new GradientPaint(4.0f, 3.0f, Color.red, 2.0f, 1.0f, Color.blue));
        p1.setNeedlePaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        p1.setTickLabelPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        p1.setTickPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        MeterPlot p2 = (MeterPlot) TestUtilities.serialised(p1);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization2() {
        MeterPlot p1 = new MeterPlot(new DefaultValueDataset(1.23));
        MeterPlot p2 = (MeterPlot) TestUtilities.serialised(p1);
    }
}
