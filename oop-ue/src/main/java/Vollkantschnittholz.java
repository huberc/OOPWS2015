
public class Vollkantschnittholz extends Schnittholz {

    public Vollkantschnittholz(int laenge, int dicke, int breite) {
        super(laenge, dicke, breite);
    }

    @Override
    public String toString() {
        return "Vollkantschnittholz{\n"+
                "\n\tlaenge:\t\t"+this.laenge()+
                "\n\tdicke:\t\t"+this.getDicke()+
                "\n\tbreite:\t\t"+this.getBreite()+"\n}";
    }
}
