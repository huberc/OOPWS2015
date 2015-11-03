/**
 * Definition of a weather model for the wood simulation. A weather model
 * defines the weather conditions for a given simulation year. How these
 * conditions are calculated is implementation-specific
 * 
 * @author michael
 *
 */
public interface IWeatherModel {

	/**
	 * Calculates the <code>WeatherConditions</code> for a given year in a
	 * simulation.
	 * 
	 * @param simulationYear
	 *            the year for which to calculate the weather conditions
	 * @return a fully initialized instance of <code>WeatherConditions</code>
	 */
	WeatherConditions calcWeatherForYear(int simulationYear);

}
