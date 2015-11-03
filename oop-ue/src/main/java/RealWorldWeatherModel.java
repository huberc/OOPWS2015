import java.util.Random;

/**
 * A "real-world" climate model, trying to roughly model actual climatic
 * tendencies.
 * 
 * Calculation of temperature and rainfall values (which are to be understood as
 * averages for a simulation year) is done based on regression functions based
 * on the recorded yearly average temperature and rainfall values in Innsbruck
 * between 1906 and 2012. All calculations performed by a
 * <code>RealWorldWeatherModel</code> assume 2015 to be the year 0 of the
 * simulation.
 * 
 * Historical were values obtained from:
 * <link>https://www.innsbruck.gv.at/page.cfm
 * ?vpath=verwaltung/statistiken--zahlen/klima</link>
 * 
 * Depending on the used <code>ModelingApproach</code>, the used regression
 * function is either: Linear -> temp(year) = a * year + b Exponential ->
 * temp(year) = a * e^(b * temp) Logarithmic -> temp(year) = a * ln(year) + b
 * 
 * Optionally - depending on the <code>addSpreading</code> property, a random
 * component is added to the results returned by above described functions. The
 * random component is "normally" (i.e. gaussian) distributed.
 * 
 * @author michael
 *
 */
public class RealWorldWeatherModel implements IWeatherModel {

	/**
	 * Enum defining the apporach for approximative temperature and rainfall
	 * calculations done by a <code>RealWorldClimateModel</code>
	 * ModelingApproaches can be linear, logarithmic or epxonential
	 * 
	 * @author michael
	 *
	 */
	public enum ModelingApproach {

		LINEAR(new LinearWeatherModel(0.0176433708, 7.7536863967, 0.4208830502,
				926.8903015341)), EXPONENTIAL(new ExponentialWeatherModel(
				7.7826218563, 0.0019942751, 918.0082250306, -0.00045501)), LOGARITHMIC(
				new LogarithmicWeatherModel(0.4754550197, 6.9398418002,
						-12.371339315, 949.9769025133));

		private IWeatherModel internalModel;

		private ModelingApproach(IWeatherModel model) {
			this.internalModel = model;
		}

		public IWeatherModel getInternalModel() {
			return this.internalModel;
		}

	}

	/**
	 * The x-offset to use for input values of calculation functions. Assuming
	 * the start year of every simulation is 2015, the offset is 110 as the year
	 * 0 (i.e. year where backing data records start) is 1906.
	 */
	private static final int YEAR_OFFSET = 110;

	private static final double TEMP_STDDEV = 0.827957423;

	private static final double RAIN_STDDEV = 127.3405555;

	private ModelingApproach approach;

	private boolean addSpreading;

	private Random randomNumberGen = new Random(
			(long) (Math.random() * System.currentTimeMillis()));

	/**
	 * Creates a new <code>RealWorldWeatherModel</code>.
	 * 
	 * @param approach
	 *            the modeling approach (i.e. function type) to use
	 * @param doSpreading
	 *            if true, a random (gauss-distributed) value is added to
	 *            calculated temperature and rainfall values
	 */
	public RealWorldWeatherModel(ModelingApproach approach, boolean doSpreading) {
		this.approach = approach;
		this.addSpreading = doSpreading;
	}

	/**
	 * @see IWeatherModel#calcWeatherForYear(int)
	 */
	@Override
	public WeatherConditions calcWeatherForYear(int simulationYear) {
		WeatherConditions tmpConditions = this.approach.getInternalModel()
				.calcWeatherForYear(
						simulationYear + RealWorldWeatherModel.YEAR_OFFSET);
		double temp = tmpConditions.getAvgTemperature();
		double rainfall = tmpConditions.getRainfall();
		if (this.addSpreading) {
			temp += this.randomNumberGen.nextGaussian()
					* RealWorldWeatherModel.TEMP_STDDEV;
			rainfall += this.randomNumberGen.nextGaussian()
					* RealWorldWeatherModel.RAIN_STDDEV;
		}
		return new WeatherConditions(temp, rainfall);
	}

	public ModelingApproach getApproach() {
		return this.approach;
	}

	public boolean usesSpreading() {
		return this.addSpreading;
	}

}
