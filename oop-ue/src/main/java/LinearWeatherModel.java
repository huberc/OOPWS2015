/**
 * Implementation of <code>IWeatherModel</code> that models temperature and
 * rainfall development based on a linear function
 * 
 * 
 * Created by Christoph on 27.10.2015.
 */
public class LinearWeatherModel implements IWeatherModel {

	private double aTemp, bTemp, aRain, bRain;

	/**
	 * Creates a new <code>LinearWeatherModel</code>.
	 * 
	 * @param aTemp the gradient of the linear temperature function
	 * @param bTemp the offset (from the x axis) of the linear temperature function
	 * @param aRain the gradient of the linear rainfall function
	 * @param bRain the offset (from the x axis) of the linear rainfall function
	 */
	public LinearWeatherModel(double aTemp, double bTemp, double aRain,
			double bRain) {
		this.aRain = aRain;
		this.bRain = bRain;
		this.aTemp = aTemp;
		this.bTemp = bTemp;
	}

	/**
	 * @see IWeatherModel#calcWeatherForYear(int)
	 * 
	 * Temperature and rainfall values are obtained based on linear functions as follows:
	 * temp = aTemp * simulationYear + bTemp
	 * rain = aRain * simulationYear + bRain
	 * 
	 */
	@Override
	public WeatherConditions calcWeatherForYear(int simulationYear) {

		return new WeatherConditions((aTemp * simulationYear + bTemp), (aRain
				* simulationYear + bRain));
	}
}
