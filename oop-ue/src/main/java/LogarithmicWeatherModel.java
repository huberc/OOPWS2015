/**
 * Created by Christoph on 27.10.2015.
 */
public class LogarithmicWeatherModel implements IWeatherModel{
    private int aTemp,bTemp, aRain, bRain;

    public LogarithmicWeatherModel(int aTemp, int bTemp, int aRain, int bRain){
        this.aRain = aRain;
        this.bRain = bRain;
        this.aTemp = aTemp;
        this.bTemp = bTemp;
    }

    @Override
    public WeatherConditions calcWeatherForYear(int simulationYear) {

        return new WeatherConditions((aTemp * Math.log(simulationYear) + bTemp),(aRain * Math.log(simulationYear) + bRain));
    }
}
