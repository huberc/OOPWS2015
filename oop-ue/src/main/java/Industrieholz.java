/**
 * @author Ines Rieder, e1425000@student.tuwien.ac.at
 */
public class Industrieholz extends Rundholz {

    public Industrieholz(int laenge, int staerke) {
        super(laenge, staerke);
    }

    public void mahlen() {
        this.setEtikettierbar(false);
        System.out.println("\tDas Industrieholz wurde durch mahlen in ein Endprodukt umgewandelt");
    }

    public void fasen() {
        this.setEtikettierbar(false);
        System.out.println("\tDas Industrieholz wurde durch fasen in ein Endprodukt umgewandelt");
    }

    public String toString() {
        return "\tIndustrieholz{"+
                "\n\t\tLaenge:\t\t"+this.laenge()+
                "\n\t\tStaerke:\t"+this.getStaerke()+"\n\t}";
    }
}
