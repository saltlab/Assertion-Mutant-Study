package org.jfree.chart;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.StandardEntityCollection;
import org.junit.Test;

/**
 * Tests for the {@link ChartRenderingInfo} class.
 */
public class ChartRenderingInfoTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        ChartRenderingInfo i1 = new ChartRenderingInfo();
        ChartRenderingInfo i2 = new ChartRenderingInfo();
        i1.setChartArea(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        i2.setChartArea(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        i1.getPlotInfo().setDataArea(new Rectangle(1, 2, 3, 4));
        i2.getPlotInfo().setDataArea(new Rectangle(1, 2, 3, 4));
        StandardEntityCollection e1 = new StandardEntityCollection();
        e1.add(new ChartEntity(new Rectangle(1, 2, 3, 4)));
        i1.setEntityCollection(e1);
        StandardEntityCollection e2 = new StandardEntityCollection();
        e2.add(new ChartEntity(new Rectangle(1, 2, 3, 4)));
        i2.setEntityCollection(e2);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        ChartRenderingInfo i1 = new ChartRenderingInfo();
        ChartRenderingInfo i2 = (ChartRenderingInfo) i1.clone();
        i1.getChartArea().setRect(4.0, 3.0, 2.0, 1.0);
        i2.getChartArea().setRect(4.0, 3.0, 2.0, 1.0);
        i1.getEntityCollection().add(new ChartEntity(new Rectangle(1, 2, 2, 1)));
        i2.getEntityCollection().add(new ChartEntity(new Rectangle(1, 2, 2, 1)));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        ChartRenderingInfo i1 = new ChartRenderingInfo();
        i1.setChartArea(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        ChartRenderingInfo i2 = (ChartRenderingInfo) TestUtilities.serialised(i1);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization2() {
        ChartRenderingInfo i1 = new ChartRenderingInfo();
        i1.getPlotInfo().setDataArea(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        ChartRenderingInfo i2 = (ChartRenderingInfo) TestUtilities.serialised(i1);
    }
}
