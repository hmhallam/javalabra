/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato.luokat;

/**
 *
 * @author henriikka
 */
public enum Interaktio { //kaikki geenit voivat vaikuttaa toisiinsa, nyt päälle/pois.
    INHIBITIO, //geenin tuote tarpeeksi suuressa konsentraatiossa sammuttaa toisen geenin
    AKTIVAATIO, //geenin tuote tarpeeksi suuressa konsentraatiossa pistää päälle toisen geenin
    EI //ei interaktiota
}
