package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.TestUtilities;
import org.junit.Test;

/**
 * Tests for the {@link DefaultDrawingSupplier} class.
 */
public class DefaultDrawingSupplierTest {

    /**
     * Check that the equals() method can distinguish all required fields.
     */
    public void testEquals() {
        DefaultDrawingSupplier r1 = new DefaultDrawingSupplier();
        DefaultDrawingSupplier r2 = new DefaultDrawingSupplier();
        Paint[] ps1A = new Paint[] { Color.red, Color.blue };
        Paint[] ps2A = new Paint[] { Color.green, Color.yellow, Color.white };
        Paint[] ops1A = new Paint[] { Color.lightGray, Color.blue };
        Paint[] ops2A = new Paint[] { Color.black, Color.yellow, Color.cyan };
        Stroke[] ss1A = new Stroke[] { new BasicStroke(1.1f) };
        Stroke[] ss2A = new Stroke[] { new BasicStroke(2.2f), new BasicStroke(3.3f) };
        Stroke[] oss1A = new Stroke[] { new BasicStroke(4.4f) };
        Stroke[] oss2A = new Stroke[] { new BasicStroke(5.5f), new BasicStroke(6.6f) };
        Shape[] shapes1A = new Shape[] { new Rectangle2D.Double(1.0, 1.0, 1.0, 1.0) };
        Shape[] shapes2A = new Shape[] { new Rectangle2D.Double(2.0, 2.0, 2.0, 2.0), new Rectangle2D.Double(2.0, 2.0, 2.0, 2.0) };
        Paint[] ps1B = new Paint[] { Color.red, Color.blue };
        Paint[] ps2B = new Paint[] { Color.green, Color.yellow, Color.white };
        Paint[] ops1B = new Paint[] { Color.lightGray, Color.blue };
        Paint[] ops2B = new Paint[] { Color.black, Color.yellow, Color.cyan };
        Stroke[] ss1B = new Stroke[] { new BasicStroke(1.1f) };
        Stroke[] ss2B = new Stroke[] { new BasicStroke(2.2f), new BasicStroke(3.3f) };
        Stroke[] oss1B = new Stroke[] { new BasicStroke(4.4f) };
        Stroke[] oss2B = new Stroke[] { new BasicStroke(5.5f), new BasicStroke(6.6f) };
        Shape[] shapes1B = new Shape[] { new Rectangle2D.Double(1.0, 1.0, 1.0, 1.0) };
        Shape[] shapes2B = new Shape[] { new Rectangle2D.Double(2.0, 2.0, 2.0, 2.0), new Rectangle2D.Double(2.0, 2.0, 2.0, 2.0) };
        r1 = new DefaultDrawingSupplier(ps1A, ops1A, ss1A, oss1A, shapes1A);
        r2 = new DefaultDrawingSupplier(ps1B, ops1B, ss1B, oss1B, shapes1B);
        r1 = new DefaultDrawingSupplier(ps2A, ops1A, ss1A, oss1A, shapes1A);
        r2 = new DefaultDrawingSupplier(ps2B, ops1B, ss1B, oss1B, shapes1B);
        r1 = new DefaultDrawingSupplier(ps2A, ops2A, ss1A, oss1A, shapes1A);
        r2 = new DefaultDrawingSupplier(ps2B, ops2B, ss1B, oss1B, shapes1B);
        r1 = new DefaultDrawingSupplier(ps2A, ops2A, ss2A, oss1A, shapes1A);
        r2 = new DefaultDrawingSupplier(ps2B, ops2B, ss2B, oss1B, shapes1B);
        r1 = new DefaultDrawingSupplier(ps2A, ops2A, ss2A, oss2A, shapes1A);
        r2 = new DefaultDrawingSupplier(ps2B, ops2B, ss2B, oss2B, shapes1B);
        r1 = new DefaultDrawingSupplier(ps2A, ops2A, ss2A, oss2A, shapes2A);
        r2 = new DefaultDrawingSupplier(ps2B, ops2B, ss2B, oss2B, shapes2B);
        r1.getNextPaint();
        r2.getNextPaint();
        r1.getNextOutlinePaint();
        r2.getNextOutlinePaint();
        r1.getNextStroke();
        r2.getNextStroke();
        r1.getNextOutlineStroke();
        r2.getNextOutlineStroke();
        r1.getNextShape();
        r2.getNextShape();
    }

    /**
     * Some basic checks for the clone() method.
     */
    public void testCloning() throws CloneNotSupportedException {
        DefaultDrawingSupplier r1 = new DefaultDrawingSupplier();
        DefaultDrawingSupplier r2 = (DefaultDrawingSupplier) r1.clone();
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        DefaultDrawingSupplier r1 = new DefaultDrawingSupplier();
        DefaultDrawingSupplier r2 = (DefaultDrawingSupplier) TestUtilities.serialised(r1);
    }
}
