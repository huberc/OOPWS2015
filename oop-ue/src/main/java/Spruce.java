/**
 * Created by ines on 27.10.2015.
 */
public class Spruce extends AbstractTree{
    public void grow(WeatherConditions weather, double spaceAvailable) {
        //Influence weather conditions
        double temp = weather.getAvgTemperature();
        double rain = weather.getRainfall();
        int inf = 1;

        if (temp < -4) {
            double help = -4 - temp;
            inf -= help/10;
        }
        else if (temp > 9) {
            double help = temp - 9;
            inf -= help/10;
        }
        else if (rain < 400) {
            double help = 400 - rain;
            inf -= help/1000;
        }
        else if (rain > 800) {
            double help = rain - 800;
            inf -= help/1000;
        }

        if (inf < 0) {
            this.state = TreeState.DEAD;
        }

        //height grow
        height += 0.02 * age^2 * (Math.E)^(-0.1*age);
    }
    public void rot() {

    }
}
