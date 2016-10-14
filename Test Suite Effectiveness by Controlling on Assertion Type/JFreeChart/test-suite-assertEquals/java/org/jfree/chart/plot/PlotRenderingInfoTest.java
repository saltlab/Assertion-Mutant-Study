package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link PlotRenderingInfo} class.
 */
public class PlotRenderingInfoTest {

    /**
     * Test the equals() method.
     */
    public void testEquals() {
        PlotRenderingInfo p1 = new PlotRenderingInfo(new ChartRenderingInfo());
        PlotRenderingInfo p2 = new PlotRenderingInfo(new ChartRenderingInfo());
        p1.setPlotArea(new Rectangle(2, 3, 4, 5));
        p2.setPlotArea(new Rectangle(2, 3, 4, 5));
        p1.setDataArea(new Rectangle(2, 4, 6, 8));
        p2.setDataArea(new Rectangle(2, 4, 6, 8));
        p1.addSubplotInfo(new PlotRenderingInfo(null));
        p2.addSubplotInfo(new PlotRenderingInfo(null));
        p1.getSubplotInfo(0).setDataArea(new Rectangle(1, 2, 3, 4));
        p2.getSubplotInfo(0).setDataArea(new Rectangle(1, 2, 3, 4));
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        PlotRenderingInfo p1 = new PlotRenderingInfo(new ChartRenderingInfo());
        p1.setPlotArea(new Rectangle2D.Double());
        PlotRenderingInfo p2 = (PlotRenderingInfo) p1.clone();
        p1.getPlotArea().setRect(1.0, 2.0, 3.0, 4.0);
        p2.getPlotArea().setRect(1.0, 2.0, 3.0, 4.0);
        p1.getDataArea().setRect(4.0, 3.0, 2.0, 1.0);
        p2.getDataArea().setRect(4.0, 3.0, 2.0, 1.0);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        PlotRenderingInfo p1 = new PlotRenderingInfo(new ChartRenderingInfo());
        PlotRenderingInfo p2 = (PlotRenderingInfo) TestUtilities.serialised(p1);
    }
}
