/**
 * Created by ines on 26.10.2015.
 */
public class BlackAlder extends AbstractTree{
    public void grow(WeatherConditions weather, double spaceAvailable){
        ++age;

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
            deathwood = this.wood;
            return;
        }

        //height grow
        if(age <= 10){
            height += 1 * inf;
        }
        else {
            height += ((12-age/15)/age)*inf;
        }

        //diameter grow
        if (spaceAvailable > 0.1) {
            if (age <= 10) {
                diameter += age / 10 * inf;
            } else if ((age > 10) && (age <= 100)) {
                diameter += (5.98 * Math.pow(10, -4) * Math.pow(age, 2) - 0.13 * age + 7.29) * inf;
            } else {
                diameter += (0.2 / (age / 100)) * inf;
            }
        }

        //usable from the age of 4
        if (age < 4) {
            useablePercentage = 0;
        } else if (age == 4) {
            useablePercentage = 75;
        }

        //wood grow
        double useableWood = (Math.pow(diameter*100, 2)/1000)+(Math.pow(diameter*100, 2)/1000)*(height-27)*0.03;
        wood = useableWood *100/75;

        //change of used space
        double r = 0.1675 * Math.pow(diameter*100, 0.97);
        usedSpace = Math.pow(r, 2)*Math.PI;
    }


    public void rot() {
        wood = deathwood * Math.pow(Math.E, -0.1*age);
    }
}
