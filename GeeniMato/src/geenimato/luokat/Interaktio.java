/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato.luokat;

/**Interaktioiden laadut
 * 
 * EI on mukana, jotta kaikilla aineilla olisi toistensa kanssa interaktio, eikä null-arvoja
 *
 * @author henriikka
 */


public enum Interaktio { //kaikki geenit voivat vaikuttaa toisiinsa, nyt päälle/pois.
    INHIBITIO {public String toString(){return "X";}}, //geenin tuote tarpeeksi suuressa konsentraatiossa sammuttaa toisen geenin
    AKTIVAATIO {public String toString(){return "A";}}, //geenin tuote tarpeeksi suuressa konsentraatiossa pistää päälle toisen geenin
    EI{public String toString(){return " ";}} //ei interaktiota
}
