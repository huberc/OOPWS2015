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
	 * @param harvetedWood
	 *          the wood, which has been harvested
	 * @param pricePerMeter
	 * 			the price per meter
	 * @return the price for the total amout of the wood
	 */
	double calcProfitPerMeter(double harvetedWood, int pricePerMeter);

	/**
	 *
	 * @param variableCosts
	 * 			varibale costs
	 * @param harvestedWood
	 * 			the wood, which has been harvested
	 * @param fixCosts
	 * 			fix costs
	 * @return cots for the harvested wood
	 */
	double calcCosts(int variableCosts, double harvestedWood, int fixCosts);

	/**
	 *
	 * @param costs
	 * 			costs of the year
	 * @param profit
	 * 			profit of the year
	 * @return the total profit for the year
	 */
	double calcProfit(double costs, double profit);

}
