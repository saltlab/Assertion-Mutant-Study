package org.jfree.chart.renderer.xy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import java.awt.Color;
import java.awt.GradientPaint;
import java.util.Date;
import org.jfree.chart.TestUtilities;
import org.jfree.data.Range;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.OHLCDataItem;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link CandlestickRenderer} class.
 */
public class CandlestickRendererTest {

    private static final double EPSILON = 0.0000000001;

    /**
     * Some checks for the constructor.
     */
    public void testConstructor() {
        CandlestickRenderer r1 = new CandlestickRenderer();
    }

    /**
     * Check that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        CandlestickRenderer r1 = new CandlestickRenderer();
        CandlestickRenderer r2 = new CandlestickRenderer();
        r1.setUpPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white));
        r2.setUpPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white));
        r1.setDownPaint(new GradientPaint(5.0f, 6.0f, Color.green, 7.0f, 8.0f, Color.yellow));
        r2.setDownPaint(new GradientPaint(5.0f, 6.0f, Color.green, 7.0f, 8.0f, Color.yellow));
        r1.setDrawVolume(false);
        r2.setDrawVolume(false);
        r1.setCandleWidth(3.3);
        r2.setCandleWidth(3.3);
        r1.setMaxCandleWidthInMilliseconds(123);
        r2.setMaxCandleWidthInMilliseconds(123);
        r1.setAutoWidthMethod(CandlestickRenderer.WIDTHMETHOD_SMALLEST);
        r2.setAutoWidthMethod(CandlestickRenderer.WIDTHMETHOD_SMALLEST);
        r1.setAutoWidthFactor(0.22);
        r2.setAutoWidthFactor(0.22);
        r1.setAutoWidthGap(1.1);
        r2.setAutoWidthGap(1.1);
        r1.setUseOutlinePaint(true);
        r2.setUseOutlinePaint(true);
        r1.setVolumePaint(Color.blue);
        r2.setVolumePaint(Color.blue);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        CandlestickRenderer r1 = new CandlestickRenderer();
        CandlestickRenderer r2 = new CandlestickRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        CandlestickRenderer r1 = new CandlestickRenderer();
        CandlestickRenderer r2 = (CandlestickRenderer) r1.clone();
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    public void testPublicCloneable() {
        CandlestickRenderer r1 = new CandlestickRenderer();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        CandlestickRenderer r1 = new CandlestickRenderer();
        CandlestickRenderer r2 = (CandlestickRenderer) TestUtilities.serialised(r1);
    }

    /**
     * Some checks for the findRangeBounds() method.
     */
    public void testFindRangeBounds() {
        CandlestickRenderer renderer = new CandlestickRenderer();
        OHLCDataItem item1 = new OHLCDataItem(new Date(1L), 2.0, 4.0, 1.0, 3.0, 100);
        OHLCDataset dataset = new DefaultOHLCDataset("S1", new OHLCDataItem[] { item1 });
        Range range = renderer.findRangeBounds(dataset);
        OHLCDataItem item2 = new OHLCDataItem(new Date(1L), -1.0, 3.0, -1.0, 3.0, 100);
        dataset = new DefaultOHLCDataset("S1", new OHLCDataItem[] { item1, item2 });
        range = renderer.findRangeBounds(dataset);
        dataset = new DefaultOHLCDataset("S1", new OHLCDataItem[] {});
        range = renderer.findRangeBounds(dataset);
        range = renderer.findRangeBounds(null);
    }
}
