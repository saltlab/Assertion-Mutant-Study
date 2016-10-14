package org.jfree.chart;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.ui.RectangleInsets;
import org.junit.Test;

/**
 * Tests for the {@link StandardChartTheme} class.
 */
public class StandardChartThemeTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        StandardChartTheme t1 = new StandardChartTheme("Name");
        StandardChartTheme t2 = new StandardChartTheme("Name");
        t1 = new StandardChartTheme("t1");
        t2 = new StandardChartTheme("t1");
        t1.setExtraLargeFont(new Font("Dialog", Font.PLAIN, 21));
        t2.setExtraLargeFont(new Font("Dialog", Font.PLAIN, 21));
        t1.setLargeFont(new Font("Dialog", Font.PLAIN, 19));
        t2.setLargeFont(new Font("Dialog", Font.PLAIN, 19));
        t1.setRegularFont(new Font("Dialog", Font.PLAIN, 17));
        t2.setRegularFont(new Font("Dialog", Font.PLAIN, 17));
        t1.setTitlePaint(new GradientPaint(0f, 1f, Color.red, 2f, 3f, Color.blue));
        t2.setTitlePaint(new GradientPaint(0f, 1f, Color.red, 2f, 3f, Color.blue));
        t1.setSubtitlePaint(new GradientPaint(1f, 2f, Color.red, 3f, 4f, Color.blue));
        t2.setSubtitlePaint(new GradientPaint(1f, 2f, Color.red, 3f, 4f, Color.blue));
        t1.setChartBackgroundPaint(new GradientPaint(2f, 3f, Color.blue, 4f, 5f, Color.red));
        t2.setChartBackgroundPaint(new GradientPaint(2f, 3f, Color.blue, 4f, 5f, Color.red));
        t1.setLegendBackgroundPaint(new GradientPaint(3f, 4f, Color.gray, 1f, 2f, Color.red));
        t2.setLegendBackgroundPaint(new GradientPaint(3f, 4f, Color.gray, 1f, 2f, Color.red));
        t1.setLegendItemPaint(new GradientPaint(9f, 8f, Color.red, 7f, 6f, Color.blue));
        t2.setLegendItemPaint(new GradientPaint(9f, 8f, Color.red, 7f, 6f, Color.blue));
        t1.setDrawingSupplier(new DefaultDrawingSupplier(new Paint[] { Color.red }, new Paint[] { Color.blue }, new Stroke[] { new BasicStroke(1.0f) }, new Stroke[] { new BasicStroke(1.0f) }, new Shape[] { new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0) }));
        t2.setDrawingSupplier(new DefaultDrawingSupplier(new Paint[] { Color.red }, new Paint[] { Color.blue }, new Stroke[] { new BasicStroke(1.0f) }, new Stroke[] { new BasicStroke(1.0f) }, new Shape[] { new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0) }));
        t1.setPlotBackgroundPaint(new GradientPaint(4f, 3f, Color.red, 6f, 7f, Color.blue));
        t2.setPlotBackgroundPaint(new GradientPaint(4f, 3f, Color.red, 6f, 7f, Color.blue));
        t1.setPlotOutlinePaint(new GradientPaint(5f, 2f, Color.blue, 6f, 7f, Color.red));
        t2.setPlotOutlinePaint(new GradientPaint(5f, 2f, Color.blue, 6f, 7f, Color.red));
        t1.setLabelLinkStyle(PieLabelLinkStyle.STANDARD);
        t2.setLabelLinkStyle(PieLabelLinkStyle.STANDARD);
        t1.setLabelLinkPaint(new GradientPaint(4f, 3f, Color.red, 2f, 9f, Color.blue));
        t2.setLabelLinkPaint(new GradientPaint(4f, 3f, Color.red, 2f, 9f, Color.blue));
        t1.setDomainGridlinePaint(Color.blue);
        t2.setDomainGridlinePaint(Color.blue);
        t1.setRangeGridlinePaint(Color.red);
        t2.setRangeGridlinePaint(Color.red);
        t1.setAxisOffset(new RectangleInsets(1, 2, 3, 4));
        t2.setAxisOffset(new RectangleInsets(1, 2, 3, 4));
        t1.setAxisLabelPaint(new GradientPaint(8f, 4f, Color.gray, 2f, 9f, Color.blue));
        t2.setAxisLabelPaint(new GradientPaint(8f, 4f, Color.gray, 2f, 9f, Color.blue));
        t1.setTickLabelPaint(new GradientPaint(3f, 4f, Color.red, 5f, 6f, Color.yellow));
        t2.setTickLabelPaint(new GradientPaint(3f, 4f, Color.red, 5f, 6f, Color.yellow));
        t1.setItemLabelPaint(new GradientPaint(2f, 5f, Color.gray, 1f, 2f, Color.blue));
        t2.setItemLabelPaint(new GradientPaint(2f, 5f, Color.gray, 1f, 2f, Color.blue));
        t1.setShadowVisible(!t1.isShadowVisible());
        t2.setShadowVisible(t1.isShadowVisible());
        t1.setShadowPaint(new GradientPaint(7f, 1f, Color.blue, 4f, 6f, Color.red));
        t2.setShadowPaint(new GradientPaint(7f, 1f, Color.blue, 4f, 6f, Color.red));
        t1.setBarPainter(new StandardBarPainter());
        t2.setBarPainter(new StandardBarPainter());
        t1.setXYBarPainter(new StandardXYBarPainter());
        t2.setXYBarPainter(new StandardXYBarPainter());
        t1.setThermometerPaint(new GradientPaint(9f, 7f, Color.red, 5f, 1f, Color.blue));
        t2.setThermometerPaint(new GradientPaint(9f, 7f, Color.red, 5f, 1f, Color.blue));
        t1.setWallPaint(new GradientPaint(4f, 5f, Color.red, 1f, 0f, Color.gray));
        t2.setWallPaint(new GradientPaint(4f, 5f, Color.red, 1f, 0f, Color.gray));
        t1.setErrorIndicatorPaint(new GradientPaint(0f, 1f, Color.white, 2f, 3f, Color.blue));
        t2.setErrorIndicatorPaint(new GradientPaint(0f, 1f, Color.white, 2f, 3f, Color.blue));
        t1.setGridBandPaint(new GradientPaint(1f, 2f, Color.white, 4f, 8f, Color.red));
        t2.setGridBandPaint(new GradientPaint(1f, 2f, Color.white, 4f, 8f, Color.red));
        t1.setGridBandAlternatePaint(new GradientPaint(1f, 4f, Color.green, 1f, 2f, Color.red));
        t2.setGridBandAlternatePaint(new GradientPaint(1f, 4f, Color.green, 1f, 2f, Color.red));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardChartTheme t1 = new StandardChartTheme("Name");
        StandardChartTheme t2 = (StandardChartTheme) TestUtilities.serialised(t1);
    }

    /**
     * Basic checks for cloning.
     */
    public void testCloning() throws CloneNotSupportedException {
        StandardChartTheme t1 = new StandardChartTheme("Name");
        StandardChartTheme t2 = (StandardChartTheme) t1.clone();
    }
}
