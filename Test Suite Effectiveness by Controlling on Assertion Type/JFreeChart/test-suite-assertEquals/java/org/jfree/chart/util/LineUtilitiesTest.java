package org.jfree.chart.util;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Tests for the {@link LineUtilities} class.
 */
public class LineUtilitiesTest {

    private boolean lineEquals(Line2D line, double x1, double y1, double x2, double y2) {
        boolean result = true;
        double epsilon = 0.0000000001;
        if (Math.abs(line.getX1() - x1) > epsilon) {
            result = false;
        }
        if (Math.abs(line.getY1() - y1) > epsilon) {
            result = false;
        }
        if (Math.abs(line.getX2() - x2) > epsilon) {
            result = false;
        }
        if (Math.abs(line.getY2() - y2) > epsilon) {
            result = false;
        }
        return result;
    }

    public void testClipLine() {
        Rectangle2D rect = new Rectangle2D.Double(1.0, 1.0, 1.0, 1.0);
        Line2D line = new Line2D.Double();
        line.setLine(0.5, 0.5, 0.6, 0.6);
        line.setLine(0.5, 0.5, 1.6, 0.6);
        line.setLine(0.5, 0.5, 2.6, 0.6);
        line.setLine(0.5, 0.5, 0.6, 1.6);
        line.setLine(0.5, 0.5, 1.6, 1.6);
        line.setLine(0.5, 0.5, 2.6, 1.6);
        line.setLine(0.5, 0.5, 0.5, 2.6);
        line.setLine(0.5, 0.5, 1.5, 2.6);
        line.setLine(0.5, 0.5, 2.5, 2.6);
        line.setLine(0.5, 0.5, 1.5, 1.5);
        line.setLine(2.5, 1.0, 1.5, 1.5);
        line.setLine(1.5, 1.5, 2.5, 1.0);
    }
}
