/**
 * dummy implementation - 5 bucks per meter wood
 * 
 * @author michael
 *
 */
public class DummyEconomicModel implements IEconomicModel {

	@Override
	public double calcProfitPerMeter(double harvetedWood, int pricePerMeter) {
		return harvetedWood*pricePerMeter;
	}

	@Override
	public double calcCosts(int variableCosts, double harvestedWood, int fixCosts){
		return fixCosts +(harvestedWood*variableCosts);
	}
	@Override
	public double calcProfit(double costs, double profit){
		return profit - costs;
	}

}
