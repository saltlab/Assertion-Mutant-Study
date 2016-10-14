package org.jfree.chart;

import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Tests for a pie chart.
 *
 */
public class PieChartTest {

    /** A chart. */
    private JFreeChart pieChart;

    /**
     * Common test setup.
     */
    @Before
    public void setUp() {
        this.pieChart = createPieChart();
    }

    /**
     * Using a regular pie chart, we replace the dataset with null.  Expect to
     * receive notification of a chart change event, and (of course) the
     * dataset should be null.
     */
    public void testReplaceDatasetOnPieChart() {
        LocalListener l = new LocalListener();
        this.pieChart.addChangeListener(l);
        PiePlot plot = (PiePlot) this.pieChart.getPlot();
        plot.setDataset(null);
    }

    /**
     * Creates a pie chart.
     *
     * @return The pie chart.
     */
    private static JFreeChart createPieChart() {
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Java", new Double(43.2));
        data.setValue("Visual Basic", new Double(0.0));
        data.setValue("C/C++", new Double(17.5));
        return ChartFactory.createPieChart("Pie Chart", data);
    }

    /**
     * A chart change listener.
     *
     */
    static class LocalListener implements ChartChangeListener {

        /** A flag. */
        private boolean flag;

        /**
         * Event handler.
         *
         * @param event  the event.
         */
        @Override
        public void chartChanged(ChartChangeEvent event) {
            this.flag = true;
        }
    }
}
