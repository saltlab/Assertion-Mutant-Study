package org.jfree.chart.renderer;

import static org.junit.Assert.assertEquals;
import org.jfree.data.DomainOrder;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.junit.Test;

/**
 * Some checks for the {@link RendererUtilities} class.
 */
public class RendererUtilitiesTest {

    /**
     * Some checks for the findLiveItemsLowerBound() method when the dataset is
     * unordered.
     */
    public void testFindLiveItemsLowerBound_Unordered() {
        DefaultXYDataset d = new DefaultXYDataset();
        d.addSeries("S1", new double[][] { {}, {} });
        d.addSeries("S2", new double[][] { { 0.0 }, { 9.9 } });
        d.addSeries("S3", new double[][] { { 0.0, 1.0 }, { 9.9, 9.9 } });
        d.addSeries("S4", new double[][] { { 1.0, 2.0, 1.5 }, { 9.9, 9.9, 9.9 } });
        d.addSeries("S5", new double[][] { { 1.0, 2.0, 1.5, 1.8 }, { 9.9, 9.9, 9.9, 9.9 } });
    }

    /**
     * Some checks for the findLiveItemsLowerBound() method when the dataset is
     * ASCENDING.
     */
    @Test
    public void testFindLiveItemsLowerBound_Ascending() {
        DefaultXYDataset d = new DefaultXYDataset() {

            @Override
            public DomainOrder getDomainOrder() {
                return DomainOrder.ASCENDING;
            }
        };
        d.addSeries("S1", new double[][] { {}, {} });
        d.addSeries("S2", new double[][] { { 1.0 }, { 9.9 } });
        d.addSeries("S3", new double[][] { { 1.0, 2.0 }, { 9.9, 9.9 } });
        assertEquals(1, RendererUtilities.findLiveItemsLowerBound(d, 2, 2.0, 3.3));
        d.addSeries("S4", new double[][] { { 1.0, 2.0, 3.0 }, { 9.9, 9.9, 9.9 } });
        d.addSeries("S5", new double[][] { { 1.0, 2.0, 3.0, 4.0 }, { 9.9, 9.9, 9.9, 9.9 } });
        d.addSeries("S5", new double[][] { { 1.0, 2.0, 2.0, 2.0, 3.0 }, { 9.9, 9.9, 9.9, 9.9, 9.9 } });
    }

    /**
     * Some checks for the findLiveItemsLowerBound() method when the dataset is
     * DESCENDING.
     */
    public void testFindLiveItemsLowerBound_Descending() {
        DefaultXYDataset d = new DefaultXYDataset() {

            @Override
            public DomainOrder getDomainOrder() {
                return DomainOrder.DESCENDING;
            }
        };
        d.addSeries("S1", new double[][] { {}, {} });
        d.addSeries("S2", new double[][] { { 1.0 }, { 9.9 } });
        d.addSeries("S3", new double[][] { { 2.0, 1.0 }, { 9.9, 9.9 } });
        d.addSeries("S4", new double[][] { { 3.0, 2.0, 1.0 }, { 9.9, 9.9, 9.9 } });
        d.addSeries("S5", new double[][] { { 4.0, 3.0, 2.0, 1.0 }, { 9.9, 9.9, 9.9, 9.9 } });
        d.addSeries("S6", new double[][] { { 3.0, 2.0, 2.0, 2.0, 1.0 }, { 9.9, 9.9, 9.9, 9.9, 9.9 } });
    }

    /**
     * Some checks for the findLiveItemsUpperBound() method when the dataset is
     * unordered.
     */
    public void testFindLiveItemsUpperBound_Unordered() {
        DefaultXYDataset d = new DefaultXYDataset();
        d.addSeries("S1", new double[][] { {}, {} });
        d.addSeries("S2", new double[][] { { 1.0 }, { 9.9 } });
        d.addSeries("S3", new double[][] { { 1.0, 2.0 }, { 9.9, 9.9 } });
        d.addSeries("S4", new double[][] { { 1.0, 2.0, 1.5 }, { 9.9, 9.9, 9.9 } });
        d.addSeries("S5", new double[][] { { 1.0, 2.0, 1.5, 1.8 }, { 9.9, 9.9, 9.9, 9.9 } });
    }

    /**
     * Some checks for the findLiveItemsUpperBound() method when the dataset is
     * ASCENDING.
     */
    public void testFindLiveItemsUpperBound_Ascending() {
        DefaultXYDataset d = new DefaultXYDataset() {

            @Override
            public DomainOrder getDomainOrder() {
                return DomainOrder.ASCENDING;
            }
        };
        d.addSeries("S1", new double[][] { {}, {} });
        d.addSeries("S2", new double[][] { { 1.0 }, { 9.9 } });
        d.addSeries("S3", new double[][] { { 1.0, 2.0 }, { 9.9, 9.9 } });
        d.addSeries("S4", new double[][] { { 1.0, 2.0, 3.0 }, { 9.9, 9.9, 9.9 } });
        d.addSeries("S5", new double[][] { { 1.0, 2.0, 3.0, 4.0 }, { 9.9, 9.9, 9.9, 9.9 } });
        d.addSeries("S5", new double[][] { { 1.0, 2.0, 2.0, 2.0, 3.0 }, { 9.9, 9.9, 9.9, 9.9, 9.9 } });
    }

    /**
     * Some checks for the findLiveItemsUpperBound() method when the dataset is
     * DESCENDING.
     */
    @Test
    public void testFindLiveItemsUpperBound_Descending() {
        DefaultXYDataset d = new DefaultXYDataset() {

            @Override
            public DomainOrder getDomainOrder() {
                return DomainOrder.DESCENDING;
            }
        };
        d.addSeries("S1", new double[][] { {}, {} });
        d.addSeries("S2", new double[][] { { 1.0 }, { 9.9 } });
        d.addSeries("S3", new double[][] { { 2.0, 1.0 }, { 9.9, 9.9 } });
        d.addSeries("S4", new double[][] { { 3.0, 2.0, 1.0 }, { 9.9, 9.9, 9.9 } });
        d.addSeries("S5", new double[][] { { 4.0, 3.0, 2.0, 1.0 }, { 9.9, 9.9, 9.9, 9.9 } });
        d.addSeries("S6", new double[][] { { 3.0, 2.0, 2.0, 2.0, 1.0 }, { 9.9, 9.9, 9.9, 9.9, 9.9 } });
        assertEquals(4, RendererUtilities.findLiveItemsUpperBound(d, 5, 0.0, 5.0));
    }

    /**
     * Checks the bounds calculation for a series where the x-ordering is not
     * known.  See bug 3561093.
     */
    public void test3561093() {
        XYSeries s = new XYSeries("S1", false);
        s.add(0.0, 0.0);
        s.add(21.0, 0.0);
        s.add(2.0, 0.0);
        s.add(23.0, 0.0);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s);
        int[] bounds = RendererUtilities.findLiveItems(dataset, 0, 10.0, 20.0);
    }
}
