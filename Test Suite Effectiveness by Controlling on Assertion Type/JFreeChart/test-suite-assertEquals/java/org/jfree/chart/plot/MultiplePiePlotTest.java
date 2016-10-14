package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.TestUtilities;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.event.PlotChangeListener;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.util.TableOrder;
import org.junit.Test;

/**
 * Some tests for the {@link MultiplePiePlot} class.
 */
public class MultiplePiePlotTest implements PlotChangeListener {

    /** The last event received. */
    PlotChangeEvent lastEvent;

    /**
     * Receives a plot change event and records it.  Some tests will use this
     * to check that events have been generated (or not) when required.
     *
     * @param event  the event.
     */
    @Override
    public void plotChanged(PlotChangeEvent event) {
        this.lastEvent = event;
    }

    /**
     * Some checks for the constructors.
     */
    public void testConstructor() {
        MultiplePiePlot plot = new MultiplePiePlot();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        plot = new MultiplePiePlot(dataset);
    }

    /**
     * Check that the equals() method distinguishes the required fields.
     */
    public void testEquals() {
        MultiplePiePlot p1 = new MultiplePiePlot();
        MultiplePiePlot p2 = new MultiplePiePlot();
        p1.setDataExtractOrder(TableOrder.BY_ROW);
        p2.setDataExtractOrder(TableOrder.BY_ROW);
        p1.setLimit(1.23);
        p2.setLimit(1.23);
        p1.setAggregatedItemsKey("Aggregated Items");
        p2.setAggregatedItemsKey("Aggregated Items");
        p1.setAggregatedItemsPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        p2.setAggregatedItemsPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow));
        p1.setPieChart(ChartFactory.createPieChart("Title", null, true, true, true));
        p2.setPieChart(ChartFactory.createPieChart("Title", null, true, true, true));
        p1.setLegendItemShape(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        p2.setLegendItemShape(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
    }

    /**
     * Some basic checks for the clone() method.
     */
    public void testCloning() throws CloneNotSupportedException {
        MultiplePiePlot p1 = new MultiplePiePlot();
        Rectangle2D rect = new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0);
        p1.setLegendItemShape(rect);
        MultiplePiePlot p2 = (MultiplePiePlot) p1.clone();
        rect.setRect(2.0, 3.0, 4.0, 5.0);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    public void testSerialization() {
        MultiplePiePlot p1 = new MultiplePiePlot(null);
        p1.setAggregatedItemsPaint(new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.red));
        MultiplePiePlot p2 = (MultiplePiePlot) TestUtilities.serialised(p1);
    }

    /**
     * Fetches the legend items and checks the values.
     */
    public void testGetLegendItems() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(35.0, "S1", "C1");
        dataset.addValue(45.0, "S1", "C2");
        dataset.addValue(55.0, "S2", "C1");
        dataset.addValue(15.0, "S2", "C2");
        MultiplePiePlot plot = new MultiplePiePlot(dataset);
        JFreeChart chart = new JFreeChart(plot);
        LegendItemCollection legendItems = plot.getLegendItems();
        LegendItem item1 = legendItems.get(0);
        LegendItem item2 = legendItems.get(1);
    }
}
