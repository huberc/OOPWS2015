/**
 * dummy implementation
 * @author michael
 *
 */
public class DummyWeatherModel implements IWeatherModel{

	@Override
	public WeatherConditions calcWeatherForYear(int simulationYear) {
		return new WeatherConditions(8.0, 1000.0);
	}

}
