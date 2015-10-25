import java.util.Random;
import java.util.function.Function;

/**
 * A "real-world" climate model, roughly modeling actual climatic tendencies.
 * Historical data URL:
 * <link>https://www.innsbruck.gv.at/page.cfm?vpath=verwaltung
 * /statistiken--zahlen/klima</link>
 * 
 * @author michael
 *
 */
public class RealWorldWeatherModel implements IWeatherModel {

	/**
	 * Enum defining the apporach for approximative temperature and rainfall
	 * calculations done by a <code>RealWorldClimateModel</code>
	 * 
	 * @author michael
	 *
	 */
	public enum ModelingApproach {

		LINEAR(RealWorldWeatherModel.TEMP_LINEAR,
				RealWorldWeatherModel.RAIN_LINEAR), EXPONENTIAL(
				RealWorldWeatherModel.TEMP_EXPONENTIAL,
				RealWorldWeatherModel.RAIN_EXPONENTIAL), LOGARITHMIC(
				RealWorldWeatherModel.TEMP_LOGARITHMIC,
				RealWorldWeatherModel.RAIN_LOGARITHMIC);

		private Function<Integer, Double> temperatureFunction;
		private Function<Integer, Double> rainfallFunction;

		private ModelingApproach(Function<Integer, Double> tempFunc,
				Function<Integer, Double> rainFunc) {
			this.temperatureFunction = tempFunc;
			this.rainfallFunction = rainFunc;
		}

		public Function<Integer, Double> getTemperatureFunction() {
			return this.temperatureFunction;
		}

		public Function<Integer, Double> getRainfallFunction() {
			return this.rainfallFunction;
		}

	}
	
	private ModelingApproach approach;
	
	private boolean addSpreading;
	
	private Random randomNumberGen = new Random((long) (Math.random() * System.currentTimeMillis()));

	/**
	 * The x-offset to use for input values of calculation functions. Assuming
	 * the start year of every simulation is 2015, the offset is 110 as the year
	 * 0 (i.e. year where backing data records start) is 1906.
	 */
	private static final int YEAR_OFFSET = 110;

	private static final double TEMP_STDDEV = 0.827957423;

	private static final double RAIN_STDDEV = 127.3405555;

	private static final Function<Integer, Double> TEMP_LINEAR = (year) -> {
		return 0.0176433708 * (year) + 7.7536863967;
	};

	private static final Function<Integer, Double> TEMP_EXPONENTIAL = (year) -> {
		return 7.7826218563 * Math.exp(0.0019942751 * year);
	};

	private static final Function<Integer, Double> TEMP_LOGARITHMIC = (year) -> {
		return 0.4754550197 * Math.log(year) + 6.9398418002;
	};

	private static final Function<Integer, Double> RAIN_LINEAR = (year) -> {
		return 0.4208830502 * year + 926.8903015341;
	};

	private static final Function<Integer, Double> RAIN_EXPONENTIAL = (year) -> {
		return 918.0082250306 * Math.exp(-0.00045501 * year);
	};

	private static final Function<Integer, Double> RAIN_LOGARITHMIC = (year) -> {
		return -12.371339315 * Math.log(year) + 949.9769025133;
	};
	
	@Override
	public WeatherConditions calcWeatherForYear(int simulationYear) {
		double temp = 
				this.approach.temperatureFunction.apply(RealWorldWeatherModel.YEAR_OFFSET + simulationYear);
		double rain = 
				this.approach.rainfallFunction.apply(RealWorldWeatherModel.YEAR_OFFSET + simulationYear);
		if(this.addSpreading){
			temp += this.randomNumberGen.nextGaussian() * RealWorldWeatherModel.TEMP_STDDEV;
			rain += this.randomNumberGen.nextGaussian() * RealWorldWeatherModel.RAIN_STDDEV;
		}
		return new WeatherConditions(temp, rain);
	}
	
	public ModelingApproach getApproach() {
		return this.approach;
	}

	public boolean usesSpreading() {
		return this.addSpreading;
	}
	
}
