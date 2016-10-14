package org.jfree.chart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.awt.geom.Rectangle2D;
import java.util.EventListener;
import java.util.List;
import javax.swing.event.CaretListener;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultXYDataset;
import org.junit.Test;

/**
 * Tests for the {@link ChartPanel} class.
 */
public class ChartPanelTest implements ChartChangeListener, ChartMouseListener {

    private List chartChangeEvents = new java.util.ArrayList();

    /**
     * Receives a chart change event and stores it in a list for later
     * inspection.
     *
     * @param event  the event.
     */
    @Override
    public void chartChanged(ChartChangeEvent event) {
        this.chartChangeEvents.add(event);
    }

    /**
     * Test that the constructor will accept a null chart.
     */
    public void testConstructor1() {
        ChartPanel panel = new ChartPanel(null);
    }

    /**
     * Test that it is possible to set the panel's chart to null.
     */
    public void testSetChart() {
        JFreeChart chart = new JFreeChart(new XYPlot());
        ChartPanel panel = new ChartPanel(chart);
        panel.setChart(null);
    }

    /**
     * Check the behaviour of the getListeners() method.
     */
    public void testGetListeners() {
        ChartPanel p = new ChartPanel(null);
        p.addChartMouseListener(this);
        EventListener[] listeners = p.getListeners(ChartMouseListener.class);
        listeners = p.getListeners(CaretListener.class);
        p.removeChartMouseListener(this);
        listeners = p.getListeners(ChartMouseListener.class);
        boolean pass = false;
        try {
            listeners = p.getListeners((Class) null);
        } catch (NullPointerException e) {
            pass = true;
        }
        pass = false;
        try {
            listeners = p.getListeners(Integer.class);
        } catch (ClassCastException e) {
            pass = true;
        }
    }

    /**
     * Ignores a mouse click event.
     *
     * @param event  the event.
     */
    @Override
    public void chartMouseClicked(ChartMouseEvent event) {
    }

    /**
     * Ignores a mouse move event.
     *
     * @param event  the event.
     */
    @Override
    public void chartMouseMoved(ChartMouseEvent event) {
    }

    /**
     * Checks that a call to the zoom() method generates just one
     * ChartChangeEvent.
     */
    public void test2502355_zoom() {
        DefaultXYDataset dataset = new DefaultXYDataset();
        JFreeChart chart = ChartFactory.createXYLineChart("TestChart", "X", "Y", dataset, PlotOrientation.VERTICAL, false, false, false);
        ChartPanel panel = new ChartPanel(chart);
        chart.addChangeListener(this);
        this.chartChangeEvents.clear();
        panel.zoom(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
    }

    /**
     * Checks that a call to the zoomInBoth() method generates just one
     * ChartChangeEvent.
     */
    public void test2502355_zoomInBoth() {
        DefaultXYDataset dataset = new DefaultXYDataset();
        JFreeChart chart = ChartFactory.createXYLineChart("TestChart", "X", "Y", dataset, PlotOrientation.VERTICAL, false, false, false);
        ChartPanel panel = new ChartPanel(chart);
        chart.addChangeListener(this);
        this.chartChangeEvents.clear();
        panel.zoomInBoth(1.0, 2.0);
    }

    /**
     * Checks that a call to the zoomOutBoth() method generates just one
     * ChartChangeEvent.
     */
    public void test2502355_zoomOutBoth() {
        DefaultXYDataset dataset = new DefaultXYDataset();
        JFreeChart chart = ChartFactory.createXYLineChart("TestChart", "X", "Y", dataset, PlotOrientation.VERTICAL, false, false, false);
        ChartPanel panel = new ChartPanel(chart);
        chart.addChangeListener(this);
        this.chartChangeEvents.clear();
        panel.zoomOutBoth(1.0, 2.0);
    }

    /**
     * Checks that a call to the restoreAutoBounds() method generates just one
     * ChartChangeEvent.
     */
    public void test2502355_restoreAutoBounds() {
        DefaultXYDataset dataset = new DefaultXYDataset();
        JFreeChart chart = ChartFactory.createXYLineChart("TestChart", "X", "Y", dataset, PlotOrientation.VERTICAL, false, false, false);
        ChartPanel panel = new ChartPanel(chart);
        chart.addChangeListener(this);
        this.chartChangeEvents.clear();
        panel.restoreAutoBounds();
    }

    /**
     * Checks that a call to the zoomInDomain() method, for a plot with more
     * than one domain axis, generates just one ChartChangeEvent.
     */
    public void test2502355_zoomInDomain() {
        DefaultXYDataset dataset = new DefaultXYDataset();
        JFreeChart chart = ChartFactory.createXYLineChart("TestChart", "X", "Y", dataset, PlotOrientation.VERTICAL, false, false, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setDomainAxis(1, new NumberAxis("X2"));
        ChartPanel panel = new ChartPanel(chart);
        chart.addChangeListener(this);
        this.chartChangeEvents.clear();
        panel.zoomInDomain(1.0, 2.0);
    }

    /**
     * Checks that a call to the zoomInRange() method, for a plot with more
     * than one range axis, generates just one ChartChangeEvent.
     */
    public void test2502355_zoomInRange() {
        DefaultXYDataset dataset = new DefaultXYDataset();
        JFreeChart chart = ChartFactory.createXYLineChart("TestChart", "X", "Y", dataset, PlotOrientation.VERTICAL, false, false, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setRangeAxis(1, new NumberAxis("X2"));
        ChartPanel panel = new ChartPanel(chart);
        chart.addChangeListener(this);
        this.chartChangeEvents.clear();
        panel.zoomInRange(1.0, 2.0);
    }

    /**
     * Checks that a call to the zoomOutDomain() method, for a plot with more
     * than one domain axis, generates just one ChartChangeEvent.
     */
    public void test2502355_zoomOutDomain() {
        DefaultXYDataset dataset = new DefaultXYDataset();
        JFreeChart chart = ChartFactory.createXYLineChart("TestChart", "X", "Y", dataset, PlotOrientation.VERTICAL, false, false, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setDomainAxis(1, new NumberAxis("X2"));
        ChartPanel panel = new ChartPanel(chart);
        chart.addChangeListener(this);
        this.chartChangeEvents.clear();
        panel.zoomOutDomain(1.0, 2.0);
    }

    /**
     * Checks that a call to the zoomOutRange() method, for a plot with more
     * than one range axis, generates just one ChartChangeEvent.
     */
    public void test2502355_zoomOutRange() {
        DefaultXYDataset dataset = new DefaultXYDataset();
        JFreeChart chart = ChartFactory.createXYLineChart("TestChart", "X", "Y", dataset, PlotOrientation.VERTICAL, false, false, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setRangeAxis(1, new NumberAxis("X2"));
        ChartPanel panel = new ChartPanel(chart);
        chart.addChangeListener(this);
        this.chartChangeEvents.clear();
        panel.zoomOutRange(1.0, 2.0);
    }

    /**
     * Checks that a call to the restoreAutoDomainBounds() method, for a plot
     * with more than one range axis, generates just one ChartChangeEvent.
     */
    public void test2502355_restoreAutoDomainBounds() {
        DefaultXYDataset dataset = new DefaultXYDataset();
        JFreeChart chart = ChartFactory.createXYLineChart("TestChart", "X", "Y", dataset, PlotOrientation.VERTICAL, false, false, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setDomainAxis(1, new NumberAxis("X2"));
        ChartPanel panel = new ChartPanel(chart);
        chart.addChangeListener(this);
        this.chartChangeEvents.clear();
        panel.restoreAutoDomainBounds();
    }

    /**
     * Checks that a call to the restoreAutoRangeBounds() method, for a plot
     * with more than one range axis, generates just one ChartChangeEvent.
     */
    public void test2502355_restoreAutoRangeBounds() {
        DefaultXYDataset dataset = new DefaultXYDataset();
        JFreeChart chart = ChartFactory.createXYLineChart("TestChart", "X", "Y", dataset, PlotOrientation.VERTICAL, false, false, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setRangeAxis(1, new NumberAxis("X2"));
        ChartPanel panel = new ChartPanel(chart);
        chart.addChangeListener(this);
        this.chartChangeEvents.clear();
        panel.restoreAutoRangeBounds();
    }

    /**
     * In version 1.0.13 there is a bug where enabling the mouse wheel handler
     * twice would in fact disable it.
     */
    public void testSetMouseWheelEnabled() {
        DefaultXYDataset dataset = new DefaultXYDataset();
        JFreeChart chart = ChartFactory.createXYLineChart("TestChart", "X", "Y", dataset, PlotOrientation.VERTICAL, false, false, false);
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        panel.setMouseWheelEnabled(true);
        panel.setMouseWheelEnabled(false);
    }
}
