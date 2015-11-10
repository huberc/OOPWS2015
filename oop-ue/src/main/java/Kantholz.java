

public class Kantholz extends Vollkantschnittholz implements Bauholz {

    public Kantholz(int laenge, int dicke, int breite) {
        super(laenge, dicke, breite);


        if (dicke < 4)
            throw new IllegalArgumentException("Ein Kantholz muss mindestens eine dicke von 4 cm aufweisen\n");
        if ((breite > (dicke * 3)) || breite < 1)
            throw new IllegalArgumentException("Ein Kantholz darf nicht breiter als maximal die dreifache Dicke sein und auch nicht schmaeler als 1 cm\n");
    }

    @Override
    public String toString() {
        return "Kantholz{"+
                "\n\tlaenge:\t\t"+this.laenge()+
                "\n\tdicke:\t\t"+this.getDicke()+
                "\n\tbreite:\t\t"+this.getBreite()+"\n)";
    }
}
