/**
 * dummy implementation - 5 bucks per meter wood
 * 
 * @author michael
 *
 */
public class DummyEconomicModel implements IEconomicModel {

	@Override
	public double calcPricePerMeter(int simulationYear) {
		return 5.0;
	}

	@Override
	public double calcGuV(int variableCosts, double harvestedWood, int fixCosts){
		return (double) fixCosts +(harvestedWood*variableCosts);
	}

}
