package org.jfree.chart.demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

class CombinedXYPlotDemo1 extends ApplicationFrame {
    public static void main(String[] var0) {
        CombinedXYPlotDemo1 var1 = new CombinedXYPlotDemo1("Sound Velocity vs Depth");
        var1.pack();
        RefineryUtilities.centerFrameOnScreen(var1);
        var1.setVisible(true);
    }

    public CombinedXYPlotDemo1(String var1) {
        super(var1);
        JPanel var2 = createDemoPanel();
        var2.setPreferredSize(new Dimension(1000, 1000));
        this.setContentPane(var2);
    }

    private static JFreeChart createCombinedChart() {
        IntervalXYDataset var0 = createDataset1();
        XYLineAndShapeRenderer var1 = new XYLineAndShapeRenderer(true, false);
        DateAxis var2 = new DateAxis("Speed (m/s)");

        var2.setLowerMargin(0.0D);//dont know what this does yet
        var2.setUpperMargin(0.02D);//dont know what this does yet

        NumberAxis var3 = new NumberAxis("Depth (meters)");
        XYPlot var4 = new XYPlot(var0, (ValueAxis)null, var3, var1);

        //var4.setBackgroundPaint(Color.red);//useful
        //var4.setDomainGridlinePaint(Color.red);
        //var4.setRangeGridlinePaint(Color.white);


        CombinedDomainXYPlot var8 = new CombinedDomainXYPlot(var2);
        var8.add(var4, 3);
        var8.setGap(2.0D);
        var8.setDomainGridlinePaint(Color.white);
        var8.setDomainGridlinesVisible(true);
        var8.setDomainPannable(true);
        JFreeChart var9 = new JFreeChart("Sound Velocity vs Depth", JFreeChart.DEFAULT_TITLE_FONT, var8, false);
        TextTitle var10 = new TextTitle("Source: http://www.publicdebt.treas.gov/opd/opdhisms.htm", new Font("Dialog", 0, 10));
        var10.setPosition(RectangleEdge.BOTTOM);
        var10.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        var9.addSubtitle(var10);
        LegendTitle var11 = new LegendTitle(var8);
        var9.addSubtitle(var11);
        ChartUtilities.applyCurrentTheme(var9);

        return var9;
    }


    private static IntervalXYDataset createDataset1() {
        TimeSeries var0 = new TimeSeries("Public Debt Outstanding");
        var0.add(new Month(1, 1990), 2974.584D);
        var0.add(new Month(2, 1990), 2994.354D);
        var0.add(new Month(3, 1990), 3051.956D);
        var0.add(new Month(4, 1990), 3061.013D);
        var0.add(new Month(5, 1990), 3095.172D);
        var0.add(new Month(6, 1990), 3143.754D);
        var0.add(new Month(7, 1990), 3168.772D);
        var0.add(new Month(8, 1990), 3211.691D);
        var0.add(new Month(9, 1990), 3233.313D);
        var0.add(new Month(10, 1990), 3274.95D);
        var0.add(new Month(11, 1990), 3330.685D);
        var0.add(new Month(12, 1990), 3364.82D);
        var0.add(new Month(1, 1991), 3411.409D);
        var0.add(new Month(2, 1991), 3458.637D);
        var0.add(new Month(3, 1991), 3441.367D);
        var0.add(new Month(4, 1991), 3445.059D);
        var0.add(new Month(5, 1991), 3497.232D);
        var0.add(new Month(6, 1991), 3537.988D);
        var0.add(new Month(7, 1991), 3576.827D);
        var0.add(new Month(8, 1991), 3614.399D);
        var0.add(new Month(9, 1991), 3665.303D);
        var0.add(new Month(10, 1991), 3717.106D);
        var0.add(new Month(11, 1991), 3747.363D);

        return new TimeSeriesCollection(var0);
    }


    public static JPanel createDemoPanel() {
        JFreeChart var0 = createCombinedChart();
        return new ChartPanel(var0);
    }


}
