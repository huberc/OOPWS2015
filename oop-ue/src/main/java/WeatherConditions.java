/**
 * 
 * Wrapper class for conditions calculated by a <code>WeatherModel</code> for a
 * specific year.
 * 
 * @author michael
 *
 */
public class WeatherConditions {

	/**
	 * Yearly temperature average
	 */
	private double avgTemperature;

	/**
	 * Yearly average rainfall (in mm)
	 */
	private double rainfall;

	/**
	 * Creates a new <code>WeatherConditions</code>
	 * 
	 * @param temp
	 *            the yearly average temperature
	 * @param rain
	 *            the yearly average rainfall
	 */
	public WeatherConditions(double temp, double rain) {
		this.avgTemperature = temp;
		this.rainfall = rain;
	}

	public double getAvgTemperature() {
		return avgTemperature;
	}

	public double getRainfall() {
		return rainfall;
	}

}
