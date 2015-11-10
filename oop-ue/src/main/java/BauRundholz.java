

public class BauRundholz extends Saegerundholz implements Bauholz {

    public BauRundholz(int laenge, int staerke) {
        super(laenge, staerke);

        this.setEtikettierbar(false);

        if (staerke < 20)
            throw new IllegalArgumentException("Ein Holz mit der Staerke " + staerke + " cm kann kein Bau-Rundholz sein\n");
        if (laenge < 50)
            throw new IllegalArgumentException("Ein Holz der laenge " + laenge + " cm ist zu kurz um als Bau-Rundholz verwendet werden zu koennen\n");

    }


}
