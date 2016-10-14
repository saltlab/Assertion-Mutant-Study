package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.util.EventListener;
import org.jfree.chart.event.MarkerChangeEvent;
import org.jfree.chart.event.MarkerChangeListener;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.junit.Test;

/**
 * Tests for the {@link Marker} class.
 */
public class MarkerTest implements MarkerChangeListener {

    MarkerChangeEvent lastEvent;

    /**
     * Some checks for the getPaint() and setPaint() methods.
     */
    public void testGetSetPaint() {
        ValueMarker m = new ValueMarker(1.1);
        m.addChangeListener(this);
        this.lastEvent = null;
        m.setPaint(Color.blue);
        try {
            m.setPaint(null);
            fail("Expected an IllegalArgumentException for null.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Some checks for the getStroke() and setStroke() methods.
     */
    public void testGetSetStroke() {
        ValueMarker m = new ValueMarker(1.1);
        m.addChangeListener(this);
        this.lastEvent = null;
        m.setStroke(new BasicStroke(1.1f));
        try {
            m.setStroke(null);
            fail("Expected an IllegalArgumentException for null.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Some checks for the getOutlinePaint() and setOutlinePaint() methods.
     */
    public void testGetSetOutlinePaint() {
        ValueMarker m = new ValueMarker(1.1);
        m.addChangeListener(this);
        this.lastEvent = null;
        m.setOutlinePaint(Color.yellow);
        m.setOutlinePaint(null);
    }

    /**
     * Some checks for the getOutlineStroke() and setOutlineStroke() methods.
     */
    public void testGetSetOutlineStroke() {
        ValueMarker m = new ValueMarker(1.1);
        m.addChangeListener(this);
        this.lastEvent = null;
        m.setOutlineStroke(new BasicStroke(1.1f));
        m.setOutlineStroke(null);
    }

    private static final float EPSILON = 0.000000001f;

    /**
     * Some checks for the getAlpha() and setAlpha() methods.
     */
    public void testGetSetAlpha() {
        ValueMarker m = new ValueMarker(1.1);
        m.addChangeListener(this);
        this.lastEvent = null;
        m.setAlpha(0.5f);
    }

    /**
     * Some checks for the getLabel() and setLabel() methods.
     */
    public void testGetSetLabel() {
        ValueMarker m = new ValueMarker(1.1);
        m.addChangeListener(this);
        this.lastEvent = null;
        m.setLabel("XYZ");
        m.setLabel(null);
    }

    /**
     * Some checks for the getLabelFont() and setLabelFont() methods.
     */
    public void testGetSetLabelFont() {
        ValueMarker m = new ValueMarker(1.1);
        m.addChangeListener(this);
        this.lastEvent = null;
        m.setLabelFont(new Font("SansSerif", Font.BOLD, 10));
        try {
            m.setLabelFont(null);
            fail("Expected an IllegalArgumentException for null.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Some checks for the getLabelPaint() and setLabelPaint() methods.
     */
    public void testGetSetLabelPaint() {
        ValueMarker m = new ValueMarker(1.1);
        m.addChangeListener(this);
        this.lastEvent = null;
        m.setLabelPaint(Color.red);
        try {
            m.setLabelPaint(null);
            fail("Expected an IllegalArgumentException for null.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Some checks for the getLabelAnchor() and setLabelAnchor() methods.
     */
    public void testGetSetLabelAnchor() {
        ValueMarker m = new ValueMarker(1.1);
        m.addChangeListener(this);
        this.lastEvent = null;
        m.setLabelAnchor(RectangleAnchor.TOP);
        try {
            m.setLabelAnchor(null);
            fail("Expected an IllegalArgumentException for null.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Some checks for the getLabelOffset() and setLabelOffset() methods.
     */
    public void testGetSetLabelOffset() {
        ValueMarker m = new ValueMarker(1.1);
        m.addChangeListener(this);
        this.lastEvent = null;
        m.setLabelOffset(new RectangleInsets(1, 2, 3, 4));
        try {
            m.setLabelOffset(null);
            fail("Expected an IllegalArgumentException for null.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Some checks for the getLabelOffsetType() and setLabelOffsetType()
     * methods.
     */
    public void testGetSetLabelOffsetType() {
        ValueMarker m = new ValueMarker(1.1);
        m.addChangeListener(this);
        this.lastEvent = null;
        m.setLabelOffsetType(LengthAdjustmentType.EXPAND);
        try {
            m.setLabelOffsetType(null);
            fail("Expected an IllegalArgumentException for null.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Some checks for the getLabelTextAnchor() and setLabelTextAnchor()
     * methods.
     */
    public void testGetSetLabelTextAnchor() {
        ValueMarker m = new ValueMarker(1.1);
        m.addChangeListener(this);
        this.lastEvent = null;
        m.setLabelTextAnchor(TextAnchor.BASELINE_LEFT);
        try {
            m.setLabelTextAnchor(null);
            fail("Expected an IllegalArgumentException for null.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Checks that a CategoryPlot deregisters listeners when clearing markers.
     */
    public void testListenersWithCategoryPlot() {
        CategoryPlot plot = new CategoryPlot();
        CategoryMarker marker1 = new CategoryMarker("X");
        ValueMarker marker2 = new ValueMarker(1.0);
        plot.addDomainMarker(marker1);
        plot.addRangeMarker(marker2);
        EventListener[] listeners1 = marker1.getListeners(MarkerChangeListener.class);
        EventListener[] listeners2 = marker1.getListeners(MarkerChangeListener.class);
        plot.clearDomainMarkers();
        plot.clearRangeMarkers();
        listeners1 = marker1.getListeners(MarkerChangeListener.class);
        listeners2 = marker1.getListeners(MarkerChangeListener.class);
    }

    /**
     * Checks that an XYPlot deregisters listeners when clearing markers.
     */
    public void testListenersWithXYPlot() {
        XYPlot plot = new XYPlot();
        ValueMarker marker1 = new ValueMarker(1.0);
        ValueMarker marker2 = new ValueMarker(2.0);
        plot.addDomainMarker(marker1);
        plot.addRangeMarker(marker2);
        EventListener[] listeners1 = marker1.getListeners(MarkerChangeListener.class);
        EventListener[] listeners2 = marker1.getListeners(MarkerChangeListener.class);
        plot.clearDomainMarkers();
        plot.clearRangeMarkers();
        listeners1 = marker1.getListeners(MarkerChangeListener.class);
        listeners2 = marker1.getListeners(MarkerChangeListener.class);
    }

    /**
     * Records the last event.
     *
     * @param event  the event.
     */
    @Override
    public void markerChanged(MarkerChangeEvent event) {
        this.lastEvent = event;
    }
}
