/**
 * Created by ines on 26.10.2015.
 */
public class blackAlder extends AbstractTree{
    public void grow(WeatherConditions weather, double spaceAvailable){
    //Influence weather conditions
        double temp = weather.getAvgTemperature();
        double rain = weather.getRainfall();
        int inf = 1;

        if (temp < 3) {
            double help = -4 - temp;
            inf -= help/10;
        }
        else if (temp > 14) {
            double help = temp - 9;
            inf -= help/10;
        }
        else if (rain < 450) {
            double help = 400 - rain;
            inf -= help/1000;
        }
        else if (rain > 1300) {
            double help = rain - 800;
            inf -= help/1000;
        }

        if (inf < 0) {
            this.state = TreeState.DEAD;
        }

    //height grow
        if(age <= 10){
            height += 1 * inf;
        }
        else {
            height += ((12-age/15)/age)*inf;
        }

    //diameter grow
        diameter = 1/(1+(Math.E)^(-0.05*(age-60)));
    }

    public void rot() {

    }
}
