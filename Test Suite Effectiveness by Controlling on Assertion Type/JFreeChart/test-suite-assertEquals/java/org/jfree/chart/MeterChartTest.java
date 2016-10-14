package org.jfree.chart;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import org.jfree.chart.plot.MeterInterval;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.data.Range;
import org.jfree.data.general.DefaultValueDataset;
import org.junit.Test;

/**
 * Miscellaneous checks for meter charts.
 */
public class MeterChartTest {

    /**
     * Draws the chart with a single range.  At one point, this caused a null
     * pointer exception (fixed now).
     */
    public void testDrawWithNullInfo() {
        MeterPlot plot = new MeterPlot(new DefaultValueDataset(60.0));
        plot.addInterval(new MeterInterval("Normal", new Range(0.0, 80.0)));
        JFreeChart chart = new JFreeChart(plot);
        BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        chart.draw(g2, new Rectangle2D.Double(0, 0, 200, 100), null, null);
        g2.dispose();
    }
}
