/**
 * dummy implementation
 * @author michael
 *
 */
public class DummyWeatherModel implements IWeatherModel{

	@Override
	public WeatherConditions calcWeatherForYear(int simulationYear) {
		return new WeatherConditions(20.0, 1000.0);
	}

}
