/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato.kayttoliittyma;

import geenimato.luokat.Aine;
import geenimato.luokat.Solu;
import java.util.HashMap;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author henriikka
 */
public class Datankasittelija {
    
    private XYSeriesCollection konsentraatiot;
    private HashMap<Aine, XYSeries> map;
    private Solu solu;
    
    public Datankasittelija(Solu solu){
        this.solu = solu;
        this.map = new HashMap<Aine, XYSeries>();
        this.konsentraatiot = luoXYSeries();
    }
    
    private XYSeriesCollection luoXYSeries(){
        XYSeriesCollection data = new XYSeriesCollection();
        for (Aine a : solu.getAineet()){
            XYSeries series = new XYSeries(a.getNimi());
            map.put(a, series);
            series.add(solu.getAika(), a.getKonsentraatio());
            data.addSeries(series);
        }
        return data;
    }
    
    public void paivita(){
        for (Aine a : solu.getAineet()){
            XYSeries series = map.get(a);
            series.add(solu.getAika(), a.getKonsentraatio());
        }
    }
    
    public XYSeriesCollection getKonsentraatiot(){
        return this.konsentraatiot;
    }
    
}
