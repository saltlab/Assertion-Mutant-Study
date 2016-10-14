package org.jfree.chart.plot.dial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import java.awt.Color;
import java.awt.GradientPaint;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.event.PlotChangeListener;
import org.junit.Test;

/**
 * Tests for the {@link DialPlot} class.
 */
public class DialPlotTest implements PlotChangeListener {

    /** The last plot change event received. */
    private PlotChangeEvent lastEvent;

    /**
     * Records the last plot change event received.
     *
     * @param event  the event.
     */
    @Override
    public void plotChanged(PlotChangeEvent event) {
        this.lastEvent = event;
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        DialPlot p1 = new DialPlot();
        DialPlot p2 = new DialPlot();
        p1.setBackground(new DialBackground(Color.green));
        p2.setBackground(new DialBackground(Color.green));
        p1.setBackground(null);
        p2.setBackground(null);
        DialCap cap1 = new DialCap();
        cap1.setFillPaint(Color.red);
        p1.setCap(cap1);
        DialCap cap2 = new DialCap();
        cap2.setFillPaint(Color.red);
        p2.setCap(cap2);
        p1.setCap(null);
        p2.setCap(null);
        StandardDialFrame f1 = new StandardDialFrame();
        f1.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white));
        p1.setDialFrame(f1);
        StandardDialFrame f2 = new StandardDialFrame();
        f2.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.white));
        p2.setDialFrame(f2);
        p1.setView(0.2, 0.0, 0.8, 1.0);
        p2.setView(0.2, 0.0, 0.8, 1.0);
        p1.addLayer(new StandardDialScale());
        p2.addLayer(new StandardDialScale());
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        DialPlot p1 = new DialPlot();
        DialPlot p2 = new DialPlot();
        int h1 = p1.hashCode();
        int h2 = p2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        DialPlot p1 = new DialPlot();
        DialPlot p2 = (DialPlot) p1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DialPlot p1 = new DialPlot();
        DialPlot p2 = (DialPlot) TestUtilities.serialised(p1);
    }

    /**
     * Check the notification event mechanism for the dial background.
     */
    public void testBackgroundListener() {
        DialPlot p = new DialPlot();
        DialBackground b1 = new DialBackground(Color.red);
        p.setBackground(b1);
        p.addChangeListener(this);
        this.lastEvent = null;
        b1.setPaint(Color.blue);
        DialBackground b2 = new DialBackground(Color.green);
        p.setBackground(b2);
        this.lastEvent = null;
        b1.setPaint(Color.red);
        b2.setPaint(Color.red);
    }

    /**
     * Check the notification event mechanism for the dial cap.
     */
    public void testCapListener() {
        DialPlot p = new DialPlot();
        DialCap c1 = new DialCap();
        p.setCap(c1);
        p.addChangeListener(this);
        this.lastEvent = null;
        c1.setFillPaint(Color.red);
        DialCap c2 = new DialCap();
        p.setCap(c2);
        this.lastEvent = null;
        c1.setFillPaint(Color.blue);
        c2.setFillPaint(Color.green);
    }

    /**
     * Check the notification event mechanism for the dial frame.
     */
    public void testFrameListener() {
        DialPlot p = new DialPlot();
        ArcDialFrame f1 = new ArcDialFrame();
        p.setDialFrame(f1);
        p.addChangeListener(this);
        this.lastEvent = null;
        f1.setBackgroundPaint(Color.gray);
        ArcDialFrame f2 = new ArcDialFrame();
        p.setDialFrame(f2);
        this.lastEvent = null;
        f1.setBackgroundPaint(Color.blue);
        f2.setBackgroundPaint(Color.green);
    }

    /**
     * Check the notification event mechanism for the dial scales.
     */
    public void testScaleListener() {
        DialPlot p = new DialPlot();
        StandardDialScale s1 = new StandardDialScale();
        p.addScale(0, s1);
        p.addChangeListener(this);
        this.lastEvent = null;
        s1.setStartAngle(22.0);
        StandardDialScale s2 = new StandardDialScale();
        p.addScale(0, s2);
        this.lastEvent = null;
        s1.setStartAngle(33.0);
        s2.setStartAngle(33.0);
    }

    /**
     * Check the notification event mechanism for a layer.
     */
    public void testLayerListener() {
        DialPlot p = new DialPlot();
        DialBackground b1 = new DialBackground(Color.red);
        p.addLayer(b1);
        p.addChangeListener(this);
        this.lastEvent = null;
        b1.setPaint(Color.blue);
        DialBackground b2 = new DialBackground(Color.green);
        p.addLayer(b2);
        this.lastEvent = null;
        b1.setPaint(Color.red);
        b2.setPaint(Color.green);
        p.removeLayer(b2);
        this.lastEvent = null;
        b2.setPaint(Color.red);
    }
}
