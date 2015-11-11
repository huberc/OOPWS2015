/**
 * @author Christoph Huber, e1427322@student.tuwien.ac.at
 */

public class BauRundholz extends Saegerundholz implements Bauholz {

    public BauRundholz(int laenge, int staerke) {
        super(laenge, staerke);

        if (staerke < 20)
            throw new IllegalArgumentException("\tEin Holz mit der Staerke " + staerke + " cm kann kein Bau-Rundholz sein\n");
    }

    public String toString() {
        return "\tBaurundholz{\n"+
                "\n\t\tLaenge:\t\t"+this.laenge()+
                "\n\t\tStaerke:\t\t"+this.getStaerke()+"\n\t}";
    }

}
