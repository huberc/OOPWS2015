

public class Kantholz extends Vollkantschnittholz implements Bauholz {

    public Kantholz(int laenge, int dicke, int breite) {
        super(laenge, dicke, breite);

        this.setEtiketierbar(false);

        if (dicke < 4)
            throw new IllegalArgumentException("Ein Kantholz muss mindestens eine dicke von 4 cm aufweisen");
        if ((breite > (dicke * 3)) || breite < 1)
            throw new IllegalArgumentException("Ein Kantholz darf nicht breiter als maximal die dreifache Dicke sein und auch nicht schmaeler als 1 cm");
    }


}
