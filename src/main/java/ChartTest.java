import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.io.File;
import java.io.IOException;
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
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;


/**
 * Created by Maximilian Chircop.
 * Date: mm/dd/yyyy
 * Brief:
 */

public class ChartTest extends ApplicationFrame {
    public ChartTest(String title) {
        super(title);
    }
    public static void main(String[]args) {

        //xy chart
        XYSeries xySeries = new XYSeries("Sound Velocity vs Depth");
        xySeries.add(1445,0);
        xySeries.add(1480,250);
        xySeries.add(1499,500);
        xySeries.add(1505,1000);
        xySeries.add(1555,1250);
        xySeries.add(1590,1500);
        xySeries.add(1660,1750);
        xySeries.add(1700,2000);


        //ad xy chart data to dataset
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(xySeries);

        //make the graph visible
        JFreeChart chart = ChartFactory.createXYLineChart("Sound Velocity vs Depth","Speed","Depth",dataset, PlotOrientation.VERTICAL,true,true,false);



        try{
            File desktop = new File(System.getProperty("user.home"), "Desktop");
            String saveDirectory = String.valueOf(desktop)+"/graph.jpeg";
            ChartUtilities.saveChartAsJPEG(new File(saveDirectory), chart,1000,1000);
        }
        catch(IOException e){
            System.out.println("Error somewhere");
        }


    }
}
