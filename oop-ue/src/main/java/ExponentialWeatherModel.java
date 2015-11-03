/**
 * Implementation of <code>IWeatherModel</code> that models temperature and
 * rainfall development based on an exponential function
 * 
 * Created by Christoph on 27.10.2015.
 */
public class ExponentialWeatherModel implements IWeatherModel{

    private double aTemp,bTemp, aRain, bRain;

	/**
	 * Creates a new <code>ExponentialWeatherModel</code>.
	 * 
	 * @param aTemp the first coefficient of the exponential temperature function
	 * @param bTemp the second coefficient of the exponential temperature function
	 * @param aRain the first coefficient of the exponential rainfall function
	 * @param bRain the second coefficient of the exponential rainfall function
	 */
    public ExponentialWeatherModel(double aTemp, double bTemp, double aRain, double bRain){
        this.aRain = aRain;
        this.bRain = bRain;
        this.aTemp = aTemp;
        this.bTemp = bTemp;
    }

    /**
     * @see IWeatherModel#calcWeatherForYear(int)
     * 
     * Temperature and rainfall values are obtained based on exponential functions as follows:
	 * temp = aTemp * e^(simulationYear * bTemp)
	 * rain = aRain * e^(simulationYear * bRain)
	 * 
     */
    @Override
    public WeatherConditions calcWeatherForYear(int simulationYear) {

        return new WeatherConditions((this.aTemp*Math.exp(this.bTemp * simulationYear)),(this.aRain*Math.exp(this.bRain * simulationYear)));
    }
}
