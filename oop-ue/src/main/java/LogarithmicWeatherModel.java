/**
 * Implementation of <code>IWeatherModel</code> that models temperature and
 * rainfall development based on a logarithmic function
 * 
 * Created by Christoph on 27.10.2015.
 */
public class LogarithmicWeatherModel implements IWeatherModel{
    private double aTemp,bTemp, aRain, bRain;

	/**
	 * Creates a new <code>LogarithmicWeatherModel</code>.
	 * 
	 * @param aTemp the first coefficient of the logarithmic temperature function
	 * @param bTemp the second coefficient of the logarithmic temperature function
	 * @param aRain the first coefficient of the logarithmic rainfall function
	 * @param bRain the second coefficient of the logarithmic rainfall function
	 */
    public LogarithmicWeatherModel(double aTemp, double bTemp, double aRain, double bRain){
        this.aRain = aRain;
        this.bRain = bRain;
        this.aTemp = aTemp;
        this.bTemp = bTemp;
    }

    /**
     * @see IWeatherModel#calcWeatherForYear(int)
     * 
     * Temperature and rainfall values are obtained based on logarithmic functions as follows:
	 * temp = aTemp * ln(simulationYear) + bTemp
	 * rain = aRain * ln(simulationYear) + bRain
	 * 
	 * @param simulationYear
	 * 		the simulation year for which to obtain weather conditions.
	 * 		Must be a positive value >= 1.
	 * 
     */
    @Override
    public WeatherConditions calcWeatherForYear(int simulationYear) {

        return new WeatherConditions((aTemp * Math.log(simulationYear) + bTemp),(aRain * Math.log(simulationYear) + bRain));
    }
}
