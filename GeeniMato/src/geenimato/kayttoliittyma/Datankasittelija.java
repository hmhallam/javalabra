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
    
    /** pitää sisällään konsentraatiodataa
     * 
     * @param solu tämän sisältämistä aineista jokaisesta tehdään oma dataset
     */
    public Datankasittelija(Solu solu){
        this.solu = solu;
        this.map = new HashMap<Aine, XYSeries>();
        this.konsentraatiot = luoXYSeries();
    }
    
    /**datasäiliöiden luomismetodi
     * 
     * @return XYSeriesCollection
     */
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
    
    /** lisää joka aineelle datapisteen, jossa aika ja aineen konsentraatio
     * 
     */
    public void paivita(){
        for (Aine a : solu.getAineet()){
            XYSeries series = map.get(a);
            series.add(solu.getAika(), a.getKonsentraatio());
        }
    }
    
    /**Palauttaa kaikki datasetit kokoelmassa
     * 
     * @return XYSeriesCollection
     */
    public XYSeriesCollection getKonsentraatiot(){
        return this.konsentraatiot;
    }
    
}
