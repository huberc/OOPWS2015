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
            deathwood = wood;
            this.state = TreeState.DEAD;
            return;
        }

        //height grow
        height += 0.02 * Math.pow(age, 2) * Math.pow(Math.E, (-0.1*age)) * inf;

        //diameter grow
        if (spaceAvailable > 0.1) {
            diameter = 1/(1+Math.pow(Math.E, (-0.05*(age-60))));
        }

        //usable from the age of 9
        if (age < 9) {
            useablePercentage = 0;
        } else if (age == 9) {
            useablePercentage = 84;
        }

        //wood grow
        double useableWood = (Math.pow(diameter*100, 2)/1000)+(Math.pow(diameter*100, 2)/1000)*(height-(19+diameter*2)*10)*0.04;
        wood = useableWood *100/75;

        //change of used space
        double r = 0.0466 * Math.pow(diameter*100, 1.1778);
        usedSpace = Math.pow(r, 2)*Math.PI;
    }
    public void rot() {
        wood = deathwood * Math.pow(Math.E, -0.1*age);
    }
}
