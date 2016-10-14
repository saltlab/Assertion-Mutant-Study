package org.jfree.chart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.RenderingHints;
import java.util.List;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.Align;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

/**
 * Tests for the {@link JFreeChart} class.
 */
public class JFreeChartTest implements ChartChangeListener {

    /** A pie chart. */
    private JFreeChart pieChart;

    /**
     * Common test setup.
     */
    @Before
    public void setUp() {
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Java", new Double(43.2));
        data.setValue("Visual Basic", new Double(0.0));
        data.setValue("C/C++", new Double(17.5));
        this.pieChart = ChartFactory.createPieChart("Pie Chart", data);
    }

    /**
     * Check that the equals() method can distinguish all fields.
     */
    public void testEquals() {
        JFreeChart chart1 = new JFreeChart("Title", new Font("SansSerif", Font.PLAIN, 12), new PiePlot(), true);
        JFreeChart chart2 = new JFreeChart("Title", new Font("SansSerif", Font.PLAIN, 12), new PiePlot(), true);
        chart1.setRenderingHints(new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        chart2.setRenderingHints(new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        chart1.setBorderVisible(true);
        chart2.setBorderVisible(true);
        BasicStroke s = new BasicStroke(2.0f);
        chart1.setBorderStroke(s);
        chart2.setBorderStroke(s);
        chart1.setBorderPaint(Color.red);
        chart2.setBorderPaint(Color.red);
        chart1.setPadding(new RectangleInsets(1, 2, 3, 4));
        chart2.setPadding(new RectangleInsets(1, 2, 3, 4));
        chart1.setTitle("XYZ");
        chart2.setTitle("XYZ");
        chart1.addSubtitle(new TextTitle("Subtitle"));
        chart2.addSubtitle(new TextTitle("Subtitle"));
        chart1 = new JFreeChart("Title", new Font("SansSerif", Font.PLAIN, 12), new RingPlot(), false);
        chart2 = new JFreeChart("Title", new Font("SansSerif", Font.PLAIN, 12), new PiePlot(), false);
        chart2 = new JFreeChart("Title", new Font("SansSerif", Font.PLAIN, 12), new RingPlot(), false);
        chart1.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        chart2.setBackgroundPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        chart1.setBackgroundImage(JFreeChart.INFO.getLogo());
        chart2.setBackgroundImage(JFreeChart.INFO.getLogo());
        chart1.setBackgroundImageAlignment(Align.BOTTOM_LEFT);
        chart2.setBackgroundImageAlignment(Align.BOTTOM_LEFT);
        chart1.setBackgroundImageAlpha(0.1f);
        chart2.setBackgroundImageAlpha(0.1f);
    }

    /**
     * A test to make sure that the legend is being picked up in the
     * equals() testing.
     */
    public void testEquals2() {
        JFreeChart chart1 = new JFreeChart("Title", new Font("SansSerif", Font.PLAIN, 12), new PiePlot(), true);
        JFreeChart chart2 = new JFreeChart("Title", new Font("SansSerif", Font.PLAIN, 12), new PiePlot(), false);
    }

    /**
     * Checks the subtitle count - should be 1 (the legend).
     */
    public void testSubtitleCount() {
        int count = this.pieChart.getSubtitleCount();
    }

    /**
     * Some checks for the getSubtitle() method.
     */
    public void testGetSubtitle() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        JFreeChart chart = ChartFactory.createPieChart("title", dataset);
        Title t = chart.getSubtitle(0);
        try {
            chart.getSubtitle(-1);
            fail("Should have thrown an IllegalArgumentException on negative number");
        } catch (IllegalArgumentException e) {
            assertEquals("Index out of range.", e.getMessage());
        }
        try {
            chart.getSubtitle(1);
            fail("Should have thrown an IllegalArgumentException on excesive number");
        } catch (IllegalArgumentException e) {
            assertEquals("Index out of range.", e.getMessage());
        }
        try {
            chart.getSubtitle(2);
            fail("Should have thrown an IllegalArgumentException on number being out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Index out of range.", e.getMessage());
        }
    }

    /**
     * Serialize a pie chart, restore it, and check for equality.
     */
    public void testSerialization1() {
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Type 1", 54.5);
        data.setValue("Type 2", 23.9);
        data.setValue("Type 3", 45.8);
        JFreeChart c1 = ChartFactory.createPieChart("Test", data);
        JFreeChart c2 = (JFreeChart) TestUtilities.serialised(c1);
        LegendTitle lt2 = c2.getLegend();
    }

    /**
     * Serialize a 3D pie chart, restore it, and check for equality.
     */
    public void testSerialization2() {
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Type 1", 54.5);
        data.setValue("Type 2", 23.9);
        data.setValue("Type 3", 45.8);
        JFreeChart c1 = ChartFactory.createPieChart3D("Test", data);
        JFreeChart c2 = (JFreeChart) TestUtilities.serialised(c1);
    }

    /**
     * Serialize a bar chart, restore it, and check for equality.
     */
    public void testSerialization3() {
        String series1 = "First";
        String series2 = "Second";
        String series3 = "Third";
        String category1 = "Category 1";
        String category2 = "Category 2";
        String category3 = "Category 3";
        String category4 = "Category 4";
        String category5 = "Category 5";
        String category6 = "Category 6";
        String category7 = "Category 7";
        String category8 = "Category 8";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, series1, category1);
        dataset.addValue(4.0, series1, category2);
        dataset.addValue(3.0, series1, category3);
        dataset.addValue(5.0, series1, category4);
        dataset.addValue(5.0, series1, category5);
        dataset.addValue(7.0, series1, category6);
        dataset.addValue(7.0, series1, category7);
        dataset.addValue(8.0, series1, category8);
        dataset.addValue(5.0, series2, category1);
        dataset.addValue(7.0, series2, category2);
        dataset.addValue(6.0, series2, category3);
        dataset.addValue(8.0, series2, category4);
        dataset.addValue(4.0, series2, category5);
        dataset.addValue(4.0, series2, category6);
        dataset.addValue(2.0, series2, category7);
        dataset.addValue(1.0, series2, category8);
        dataset.addValue(4.0, series3, category1);
        dataset.addValue(3.0, series3, category2);
        dataset.addValue(2.0, series3, category3);
        dataset.addValue(3.0, series3, category4);
        dataset.addValue(6.0, series3, category5);
        dataset.addValue(3.0, series3, category6);
        dataset.addValue(4.0, series3, category7);
        dataset.addValue(3.0, series3, category8);
        JFreeChart c1 = ChartFactory.createBarChart("Vertical Bar Chart", "Category", "Value", dataset);
        JFreeChart c2 = (JFreeChart) TestUtilities.serialised(c1);
    }

    /**
     * Serialize a time seroes chart, restore it, and check for equality.
     */
    public void testSerialization4() {
        RegularTimePeriod t = new Day();
        TimeSeries series = new TimeSeries("Series 1");
        series.add(t, 36.4);
        t = t.next();
        series.add(t, 63.5);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);
        JFreeChart c1 = ChartFactory.createTimeSeriesChart("Test", "Date", "Value", dataset);
        JFreeChart c2 = (JFreeChart) TestUtilities.serialised(c1);
    }

    /**
     * Some checks for the addSubtitle() methods.
     */
    public void testAddSubtitle() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        JFreeChart chart = ChartFactory.createPieChart("title", dataset);
        TextTitle t0 = new TextTitle("T0");
        chart.addSubtitle(0, t0);
        TextTitle t1 = new TextTitle("T1");
        chart.addSubtitle(t1);
        try {
            chart.addSubtitle(null);
            fail("Should have thrown an IllegalArgumentException on index out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Null 'subtitle' argument.", e.getMessage());
        }
        try {
            chart.addSubtitle(-1, t0);
            fail("Should have thrown an IllegalArgumentException on index out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("The 'index' argument is out of range.", e.getMessage());
        }
        try {
            chart.addSubtitle(4, t0);
            fail("Should have thrown an IllegalArgumentException on index out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("The 'index' argument is out of range.", e.getMessage());
        }
    }

    /**
     * Some checks for the getSubtitles() method.
     */
    public void testGetSubtitles() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        JFreeChart chart = ChartFactory.createPieChart("title", dataset);
        List subtitles = chart.getSubtitles();
        subtitles.add(new TextTitle("T"));
    }

    /**
     * Some checks for the default legend firing change events.
     */
    public void testLegendEvents() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        JFreeChart chart = ChartFactory.createPieChart("title", dataset);
        chart.addChangeListener(this);
        this.lastChartChangeEvent = null;
        LegendTitle legend = chart.getLegend();
        legend.setPosition(RectangleEdge.TOP);
    }

    /**
     * Some checks for title changes and event notification.
     */
    public void testTitleChangeEvent() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        JFreeChart chart = ChartFactory.createPieChart("title", dataset);
        chart.addChangeListener(this);
        this.lastChartChangeEvent = null;
        TextTitle t = chart.getTitle();
        t.setFont(new Font("Dialog", Font.BOLD, 9));
        this.lastChartChangeEvent = null;
        TextTitle t2 = new TextTitle("T2");
        chart.setTitle(t2);
        this.lastChartChangeEvent = null;
        t2.setFont(new Font("Dialog", Font.BOLD, 9));
        this.lastChartChangeEvent = null;
        t.setFont(new Font("Dialog", Font.BOLD, 9));
        this.lastChartChangeEvent = null;
    }

    public void testBug942() throws Exception {
        final String title = "Pie Chart Demo 1\n\n\ntestnew line";
    }

    /** The last ChartChangeEvent received. */
    private ChartChangeEvent lastChartChangeEvent;

    /**
     * Records the last chart change event.
     *
     * @param event  the event.
     */
    @Override
    public void chartChanged(ChartChangeEvent event) {
        this.lastChartChangeEvent = event;
    }
}
