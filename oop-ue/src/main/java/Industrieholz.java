
public class Industrieholz extends Rundholz {

    public Industrieholz(int laenge, int staerke) {
        super(laenge, staerke);
    }

    public void mahlen() {
        this.setEtikettierbar(false);
    }

    public void fasen() {
        this.setEtikettierbar(false);
    }
}
