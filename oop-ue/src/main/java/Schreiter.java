

public class Schreiter extends Holzvollernter{

    @Override
    public void addDistanceMoved(Number distanceMoved) {
        int dist = (int) this.distanceMoved;
        dist += (int) distanceMoved;
        this.distanceMoved = dist;
    }

}
