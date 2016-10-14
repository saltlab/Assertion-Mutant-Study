package org.jfree.chart.annotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import org.jfree.chart.event.AnnotationChangeEvent;
import org.jfree.chart.event.AnnotationChangeListener;
import org.jfree.ui.TextAnchor;
import org.junit.Test;

/**
 * Tests for the {@link TextAnnotation} class.
 */
public class TextAnnotationTest implements AnnotationChangeListener {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        TextAnnotation a1 = new CategoryTextAnnotation("Test", "Category", 1.0);
        TextAnnotation a2 = new CategoryTextAnnotation("Test", "Category", 1.0);
        a1.setText("Text");
        a2.setText("Text");
        a1.setFont(new Font("Serif", Font.BOLD, 18));
        a2.setFont(new Font("Serif", Font.BOLD, 18));
        a1.setPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.pink));
        a2.setPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.pink));
        a1.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        a2.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        a1.setRotationAnchor(TextAnchor.BOTTOM_LEFT);
        a2.setRotationAnchor(TextAnchor.BOTTOM_LEFT);
        a1.setRotationAngle(Math.PI);
        a2.setRotationAngle(Math.PI);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashCode() {
        TextAnnotation a1 = new CategoryTextAnnotation("Test", "Category", 1.0);
        TextAnnotation a2 = new CategoryTextAnnotation("Test", "Category", 1.0);
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
    }

    /**
     * Test null-argument (Bug #3428870).
     */
    public void testSetRotationAnchor() {
        TextAnnotation a = new CategoryTextAnnotation("Test", "Category", 1.0);
        try {
            a.setRotationAnchor(null);
            fail("Should have thrown Exception.");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Some tests to ensure that change events are generated as expected.
     */
    public void testChangeEvents() {
        TextAnnotation a = new CategoryTextAnnotation("Test", "A", 1.0);
        a.addChangeListener(this);
        this.lastEvent = null;
        a.setText("B");
        this.lastEvent = null;
        a.setText("B");
        this.lastEvent = null;
        a.setFont(new Font("SansSerif", Font.PLAIN, 12));
        this.lastEvent = null;
        a.setPaint(Color.BLUE);
        this.lastEvent = null;
        a.setTextAnchor(TextAnchor.CENTER_LEFT);
        this.lastEvent = null;
        a.setRotationAnchor(TextAnchor.CENTER_LEFT);
        this.lastEvent = null;
        a.setRotationAngle(123.4);
    }

    private AnnotationChangeEvent lastEvent;

    /**
     * Receives notification of a change to an annotation.
     * 
     * @param event  the event. 
     */
    @Override
    public void annotationChanged(AnnotationChangeEvent event) {
        this.lastEvent = event;
    }
}
