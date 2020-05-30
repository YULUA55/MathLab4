package com.company.Chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Chart {

    public JPanel createChart(final String title, ArrayList<Double> X, ArrayList<Double> Y) {

        XYDataset dataset = createDataset(X, Y);
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

    private JFreeChart createChart(XYDataset dataset) {
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "",
                "x",
                "y",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false
        );

        chart.setBackgroundPaint(new Color(54, 54, 54));
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(new Color(122, 197, 205));
        plot.setDomainGridlinePaint(Color.gray);
        plot.setRangeGridlinePaint(Color.gray);
        plot.setAxisOffset(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
        ValueAxis axis = plot.getDomainAxis();
        ValueAxis rangeAxis2 = plot.getRangeAxis();
        rangeAxis2.setTickLabelPaint(Color.white);
        axis.setTickLabelPaint(Color.white);
        axis.setAxisLineVisible(false);
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        plot.setRenderer(renderer);
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setAxisLineVisible(false);
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return chart;
    }

    public XYDataset createDataset(ArrayList<Double> X, ArrayList<Double> Y) {

        XYSeries line = new XYSeries("График");
        for (int k = 0; k < X.size(); k++)
            line.add(X.get(k), Y.get(k));
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(line);
        return dataset;
    }


}
