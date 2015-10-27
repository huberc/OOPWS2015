/**
 * Created by Christoph on 27.10.2015.
 */
public class ExponentialWeatherModel implements IWeatherModel{

    private int aTemp,bTemp, aRain, bRain;

    public ExponentialWeatherModel(int aTemp, int bTemp, int aRain, int bRain){
        this.aRain = aRain;
        this.bRain = bRain;
        this.aTemp = aTemp;
        this.bTemp = bTemp;
    }

    @Override
    public WeatherConditions calcWeatherForYear(int simulationYear) {

        return new WeatherConditions((this.aTemp*Math.exp(this.bTemp * simulationYear)),(this.aRain*Math.exp(this.bRain * simulationYear)));
    }
}
