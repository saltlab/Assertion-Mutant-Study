package org.jfree.chart.labels;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.TestUtilities;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.PublicCloneable;
import org.junit.Test;

/**
 * Tests for the {@link StandardXYSeriesLabelGenerator} class.
 */
public class StandardXYSeriesLabelGeneratorTest {

    /**
     * Some checks for the generalLabel() method.
     */
    public void testGenerateLabel() {
        StandardXYSeriesLabelGenerator g = new StandardXYSeriesLabelGenerator("Series {0}");
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(new XYSeries("1"));
        dataset.addSeries(new XYSeries("2"));
    }

    /**
     * Some checks for the equals() method.
     */
    public void testEquals() {
        StandardXYSeriesLabelGenerator g1 = new StandardXYSeriesLabelGenerator("Series {0}");
        StandardXYSeriesLabelGenerator g2 = new StandardXYSeriesLabelGenerator("Series {0}");
        g1 = new StandardXYSeriesLabelGenerator("{1}");
        g2 = new StandardXYSeriesLabelGenerator("{1}");
    }

    /**
     * Simple check that hashCode is implemented.
     */
    public void testHashCode() {
        StandardXYSeriesLabelGenerator g1 = new StandardXYSeriesLabelGenerator();
        StandardXYSeriesLabelGenerator g2 = new StandardXYSeriesLabelGenerator();
    }

    /**
     * Confirm that cloning works.
     */
    public void testCloning() throws CloneNotSupportedException {
        StandardXYSeriesLabelGenerator g1 = new StandardXYSeriesLabelGenerator("Series {0}");
        StandardXYSeriesLabelGenerator g2 = (StandardXYSeriesLabelGenerator) g1.clone();
    }

    /**
     * Check to ensure that this class implements PublicCloneable.
     */
    public void testPublicCloneable() {
        StandardXYSeriesLabelGenerator g1 = new StandardXYSeriesLabelGenerator("Series {0}");
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        StandardXYSeriesLabelGenerator g1 = new StandardXYSeriesLabelGenerator("Series {0}");
        StandardXYSeriesLabelGenerator g2 = (StandardXYSeriesLabelGenerator) TestUtilities.serialised(g1);
    }
}
