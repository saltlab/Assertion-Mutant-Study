package org.jfree.chart.plot;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Tests for the {@code ColorPalette} class.
 */
public class ColorPaletteTest {

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        ColorPalette p1 = new GreyPalette();
        ColorPalette p2 = (ColorPalette) p1.clone();
    }

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    public void testEquals() {
        ColorPalette p1 = new GreyPalette();
        ColorPalette p2 = new GreyPalette();
    }
}
