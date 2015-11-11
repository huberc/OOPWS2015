/**
 * @author Christoph Huber, e1427322@student.tuwien.ac.at
 */
public class Vollkantschnittholz extends Schnittholz {

    public Vollkantschnittholz(int laenge, int dicke, int breite) {
        super(laenge, dicke, breite);
    }

    @Override
    public String toString() {
        return "\tVollkantschnittholz{"+
                "\n\t\tLaenge:\t\t"+this.laenge()+
                "\n\t\tDicke:\t\t"+this.getDicke()+
                "\n\t\tBreite:\t\t"+this.getBreite()+"\n\t}";
    }
}
