/**
 * Created by Christoph on 27.10.2015.
 */
public class LinearWeatherModel implements IWeatherModel{

    private double aTemp,bTemp, aRain, bRain;

    public LinearWeatherModel(double aTemp, double bTemp, double aRain, double bRain){
        this.aRain = aRain;
        this.bRain = bRain;
        this.aTemp = aTemp;
        this.bTemp = bTemp;
    }

    @Override
    public WeatherConditions calcWeatherForYear(int simulationYear) {

        return new WeatherConditions((aTemp * simulationYear + bTemp),(aRain * simulationYear + bRain));
    }
}
