/**
 * Klasse zur Verwaltung rechteckiger Schachteln
 */

package oop.schachteln;

import oop.core.DevelopedBy;
import oop.core.Geschenk;
import oop.core.Schachtel;
import oop.forms.Rechteck;
import oop.forms.Sechseck;

@DevelopedBy("Christoph Huber")
public class RechteckigeSchachtel extends Rechteck implements Schachtel {

    private Geschenk inhalt;

    /**
     * VB: hoehe, name, breite und laenge sind nicht null und hoehe und breite >0 NB: eine
     * RechteckigeSchachtel mit den uebergebenen Parametern wurde erzeugt
     * 
     * @param hoehe
     *            Hoehe der zu erzeugenden Schachtel
     * @param name
     *            Name der zu erzeugenden Schachtel
     * @param breite
     *            Breite der zu erzeugenden Schachtel
     * @param laenge
     *            Laenge der zu erzeugenden Schachtel
     */
    @DevelopedBy("Christoph Huber")
    public RechteckigeSchachtel(int hoehe, String name, int breite, int laenge) {
        super(hoehe, name, breite, laenge);
    }

    /**
     * VB: g ist nicht null NB: der Inhalt dieser Schachtel wurde auf g gesetzt
     * 
     * @param g
     *            Geschenk, das in dieser Schachtel eingepackt werden soll
     */
    @Override
    @DevelopedBy("Christoph Huber")
    public void einpacken(Geschenk g) {
        inhalt = g;
    }

    /**
     * VB: g ist nicht null NB: ein boolean wurde zurueckgegeben ob das uebergebene Geschenk in diese
     * Schachtel passt und ob es auch nicht zu viel Platz hat (damit es nicht verrutscht)
     * 
     * @param g
     *            Geschenk, dessen Parameter ueberprueft werden ob es in dieser Schachtel Platz finden wuerde
     *            und ob es auch nicht zu viel Platz hat
     * @return boolean ob das uebergebene Geschenk in diese Schachtel passt und ob es nicht zu viel Platz hat
     */
    @Override
    @DevelopedBy("Christoph Huber")
    public boolean passtHinein(Geschenk g) {
        if (this.getHoehe() < g.getHoehe() + 1 || (this.getHoehe() > g.getHoehe() + 3)) {
            return false;
        } else if (g instanceof Rechteck) {
            Rechteck r = (Rechteck) g;
            if (this.getBreite() > r.getBreite() + 1 && this.getLaenge() > r.getLaenge() + 1
                && this.getBreite() <= r.getBreite() + 3 && this.getLaenge() <= r.getLaenge() + 3) {
                return true;
            } else {
                return false;
            }
        } else if (g instanceof Sechseck) {
            Sechseck s = (Sechseck) g;
            if (this.getBreite() > s.getUmkreisDurchmesser() + 1
                && this.getBreite() <= s.getUmkreisDurchmesser() + 3
                && this.getLaenge() > s.getUmkreisDurchmesser() + 1
                && this.getLaenge() <= s.getUmkreisDurchmesser() + 3) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @DevelopedBy("Christoph Huber")
    public Geschenk getInhalt() {
        return inhalt;
    }

}
