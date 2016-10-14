package org.jfree.chart.renderer.category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import java.util.Arrays;
import java.util.List;
import org.jfree.chart.TestUtilities;
import org.jfree.data.Range;
import org.jfree.data.statistics.DefaultMultiValueCategoryDataset;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link ScatterRenderer} class.
 */
public class ScatterRendererTest {

    /**
     * Test that the equals() method distinguishes all fields.
     */
    public void testEquals() {
        ScatterRenderer r1 = new ScatterRenderer();
        ScatterRenderer r2 = new ScatterRenderer();
        r1.setSeriesShapesFilled(1, true);
        r2.setSeriesShapesFilled(1, true);
        r1.setBaseShapesFilled(false);
        r2.setBaseShapesFilled(false);
        r1.setUseFillPaint(true);
        r2.setUseFillPaint(true);
        r1.setDrawOutlines(true);
        r2.setDrawOutlines(true);
        r1.setUseOutlinePaint(true);
        r2.setUseOutlinePaint(true);
        r1.setUseSeriesOffset(false);
        r2.setUseSeriesOffset(false);
    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    public void testHashcode() {
        ScatterRenderer r1 = new ScatterRenderer();
        ScatterRenderer r2 = new ScatterRenderer();
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        ScatterRenderer r1 = new ScatterRenderer();
        ScatterRenderer r2 = (ScatterRenderer) r1.clone();
    }

    /**
     * Check that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        ScatterRenderer r1 = new ScatterRenderer();
    }

    /**
     * Checks that the two renderers are equal but independent of one another.
     *
     * @param r1  renderer 1.
     * @param r2  renderer 2.
     *
     * @return A boolean.
     */
    private boolean checkIndependence(ScatterRenderer r1, ScatterRenderer r2) {
        if (!r1.equals(r2)) {
            return false;
        }
        r1.setSeriesShapesFilled(1, true);
        if (r1.equals(r2)) {
            return false;
        }
        r2.setSeriesShapesFilled(1, true);
        if (!r1.equals(r2)) {
            return false;
        }
        r1.setBaseShapesFilled(false);
        r2.setBaseShapesFilled(true);
        if (r1.equals(r2)) {
            return false;
        }
        r2.setBaseShapesFilled(false);
        if (!r1.equals(r2)) {
            return false;
        }
        return true;
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        ScatterRenderer r1 = new ScatterRenderer();
        ScatterRenderer r2 = (ScatterRenderer) TestUtilities.serialised(r1);
    }

    /**
     * Some checks for the findRangeBounds() method.
     */
    public void testFindRangeBounds() {
        ScatterRenderer r = new ScatterRenderer();
        DefaultMultiValueCategoryDataset dataset = new DefaultMultiValueCategoryDataset();
        List values = Arrays.asList(new Double[] { new Double(1.0) });
        dataset.add(values, "R1", "C1");
        values = Arrays.asList(new Double[] { new Double(2.0), new Double(2.2) });
        dataset.add(values, "R1", "C2");
        values = Arrays.asList(new Double[] { new Double(-3.0), new Double(-3.2) });
        dataset.add(values, "R1", "C3");
        values = Arrays.asList(new Double[] { new Double(6.0) });
        dataset.add(values, "R2", "C1");
        r.setSeriesVisible(1, Boolean.FALSE);
    }
}
