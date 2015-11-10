
public class Industrieholz extends Rundholz {

    public Industrieholz(int laenge, int staerke) {
        super(laenge, staerke);
    }

    public void mahlen() {
        this.setEtiketierbar(false);
    }

    public void fasen() {
        this.setEtiketierbar(false);
    }
}
