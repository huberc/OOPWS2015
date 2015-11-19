
public class Radernter extends Holzvollernter {

    @Override
    public void addDistanceMoved(Number distanceMoved) {
        double dist = (double) this.distanceMoved;
        dist += (double) distanceMoved;
        this.distanceMoved = dist;
    }

}
