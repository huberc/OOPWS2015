/**
 * Definition of an economic model, i.e. an interface to the "wood market". The
 * economic model provides a wood price for a given simulation year.
 * 
 * @author michael
 *
 */
public interface IEconomicModel {

	/**
	 * Calculates the profit made by selling a one cubic meter wood in a given
	 * year of the simulation.
	 * 
	 * @param harvestedWood
	 *            the total amount of wood harvested in the current simulation
	 *            year
	 * @param pricePerMeter
	 *            the price per cubic meter of wood in euros
	 * @return the price for the total amount of the wood
	 */
	double calcProfitPerMeter(double harvetedWood, int pricePerMeter);

	/**
	 * Calculates the costs incurring within a simulation year in which a given
	 * amount of wood is harvested
	 *
	 * @param variableCosts
	 *            the cost for the harvest of a single cubic meter of wood
	 * @param harvestedWood
	 *            the total amount of wood harvested in the current simulation
	 *            year
	 * @param fixCosts
	 *            the fixed costs incurring per simulation year
	 * @return cots for the harvested wood
	 */
	double calcCosts(int variableCosts, double harvestedWood, int fixCosts);

	/**
	 * Calculates the total profit made from wood sales in one simulation year
	 *
	 * @param costs
	 *            costs (variable + fixed) that incurred in the current
	 *            simulation year
	 * @param profit
	 *            the turnover (without costs subtracted) made with wood sales
	 *            in the current year. BAD: Should be named differently since
	 *            this is actually the turnover, not profit - profit is
	 *            calculated by this method
	 * @return the total profit made from wood sales in the current year
	 */
	double calcProfit(double costs, double profit);

}
