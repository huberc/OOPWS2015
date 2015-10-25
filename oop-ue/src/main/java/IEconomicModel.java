/**
 * Definition of an economic model, i.e. an interface to the "wood market". The
 * economic model provides a wood price for a given simulation year.
 * 
 * @author michael
 *
 */
public interface IEconomicModel {

	/**
	 * Calculates a price for one cubic meter of wood in a given year of the
	 * simulation.
	 * 
	 * @param simulationYear
	 *            the year for which to calculate a price
	 * @return the price for one cubic meter wood
	 */
	double calcPricePerMeter(int simulationYear);

	double calcGuV(int variableCosts, double harvestedWood, int fixCosts);

}
