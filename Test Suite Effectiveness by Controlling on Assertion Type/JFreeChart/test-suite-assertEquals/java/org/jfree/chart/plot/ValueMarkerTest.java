package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Stroke;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.event.MarkerChangeEvent;
import org.jfree.chart.event.MarkerChangeListener;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.junit.Test;

/**
 * Tests for the {@link ValueMarker} class.
 */
public class ValueMarkerTest implements MarkerChangeListener {

    MarkerChangeEvent lastEvent;

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        Marker m1 = new ValueMarker(45.0);
        Marker m2 = new ValueMarker(45.0);
        m1.setPaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.red));
        m2.setPaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.red));
        BasicStroke stroke = new BasicStroke(2.2f);
        m1.setStroke(stroke);
        m2.setStroke(stroke);
        m1.setOutlinePaint(new GradientPaint(4.0f, 3.0f, Color.yellow, 2.0f, 1.0f, Color.white));
        m2.setOutlinePaint(new GradientPaint(4.0f, 3.0f, Color.yellow, 2.0f, 1.0f, Color.white));
        m1.setOutlineStroke(stroke);
        m2.setOutlineStroke(stroke);
        m1.setAlpha(0.1f);
        m2.setAlpha(0.1f);
        m1.setLabel("New Label");
        m2.setLabel("New Label");
        m1.setLabelFont(new Font("SansSerif", Font.PLAIN, 10));
        m2.setLabelFont(new Font("SansSerif", Font.PLAIN, 10));
        m1.setLabelPaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.yellow));
        m2.setLabelPaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.yellow));
        m1.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
        m2.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
        m1.setLabelTextAnchor(TextAnchor.BASELINE_RIGHT);
        m2.setLabelTextAnchor(TextAnchor.BASELINE_RIGHT);
        m1.setLabelOffset(new RectangleInsets(10.0, 10.0, 10.0, 10.0));
        m2.setLabelOffset(new RectangleInsets(10.0, 10.0, 10.0, 10.0));
        m1.setLabelOffsetType(LengthAdjustmentType.EXPAND);
        m2.setLabelOffsetType(LengthAdjustmentType.EXPAND);
        m1 = new ValueMarker(12.3);
        m2 = new ValueMarker(45.6);
        m2 = new ValueMarker(12.3);
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        ValueMarker m1 = new ValueMarker(25.0);
        ValueMarker m2 = (ValueMarker) m1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        ValueMarker m1 = new ValueMarker(25.0);
        ValueMarker m2 = (ValueMarker) TestUtilities.serialised(m1);
    }

    private static final double EPSILON = 0.000000001;

    /**
     * Some checks for the getValue() and setValue() methods.
     */
    public void testGetSetValue() {
        ValueMarker m = new ValueMarker(1.1);
        m.addChangeListener(this);
        this.lastEvent = null;
        m.setValue(33.3);
    }

    /**
     * Records the last event.
     *
     * @param event  the last event.
     */
    @Override
    public void markerChanged(MarkerChangeEvent event) {
        this.lastEvent = event;
    }

    /**
     * A test for bug 1802195.
     */
    public void test1802195() {
        ValueMarker m1 = new ValueMarker(25.0);
        ValueMarker m2 = (ValueMarker) TestUtilities.serialised(m1);
        try {
            m2.setValue(-10.0);
        } catch (NullPointerException e) {
            fail("No exception should be thrown.");
        }
    }

    /**
     * A test for bug report 1808376.
     */
    public void test1808376() {
        Stroke stroke = new BasicStroke(1.0f);
        Stroke outlineStroke = new BasicStroke(2.0f);
        ValueMarker m = new ValueMarker(1.0, Color.red, stroke, Color.blue, outlineStroke, 0.5f);
    }
}
