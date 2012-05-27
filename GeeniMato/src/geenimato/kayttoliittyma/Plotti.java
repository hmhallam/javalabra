/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato.kayttoliittyma;

import geenimato.luokat.Aine;
import java.util.HashMap;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author henriikka
 */
public class Plotti extends ApplicationFrame {
    
    private Datankasittelija kasittelija;
    
    public Plotti(String title, Datankasittelija kasittelija) {
        super(title);
        this.kasittelija = kasittelija;
        XYDataset data = kasittelija.getKonsentraatiot();
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Konsentraatioiden plottaus",
            "Aika", 
            "Konsentraatio", 
            data,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }
    
    
    
}
