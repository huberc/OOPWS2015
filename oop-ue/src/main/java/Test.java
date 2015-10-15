import oop.SimulationRequest;
import oop.SimulationResult;
import oop.SimulationResult.SimulationRecord;
import oop.Simulator;

/**
 * Test class for the environment simulation.
 * 
 * TODO Who did what? Why did we do it?
 * 
 * @author Michael Langowski, e1426581@student.tuwien.ac.at
 *
 */
public class Test {

	private Simulator sim = new Simulator();
	
	public static void main(String[] args){
		System.out.println("Test of initial state: "  + new Test().testInitialState());
		System.out.println("Test of state after 1 year: "  + new Test().testOneYear());
		
	}
	
	public boolean testInitialState(){
		SimulationRequest req = new SimulationRequest();
		req.setStartDeadWood(10);
		req.setStartLivingWood(10);
		req.setAvgWoodGrowth(10);
		req.setAvgProcessedWoodYearly(0.5);
		req.setAvgHarvestYearly(10);
		req.setAvgDecompWoodYearly(0.2);
		req.setAvgDeadWoodYearly(2);
		SimulationResult actual = this.sim.simulate(req, 0);
		
		// reference result
		SimulationResult expected = new SimulationResult(0);
		SimulationRecord rec = expected.new SimulationRecord();
		rec.setTotalBoundCO2(20);
		rec.setTotalDeadWood(10);
		rec.setTotalHarvestedWood(0);
		rec.setTotalLivingWood(10);
		rec.setTotalProcessedWood(0);
		expected.addSimulationRecordForYear(rec, 0);
		return Test.compareResults(actual, expected);
	}
	
	public boolean testOneYear(){
		SimulationRequest req = new SimulationRequest();
		req.setStartDeadWood(10);
		req.setStartLivingWood(10);
		req.setAvgWoodGrowth(10);
		req.setAvgProcessedWoodYearly(0.5);
		req.setAvgHarvestYearly(10);
		req.setAvgDecompWoodYearly(0.2);
		req.setAvgDeadWoodYearly(2);
		SimulationResult actual = this.sim.simulate(req, 1);
		
		// reference result
		SimulationResult expected = new SimulationResult(1);
		
		SimulationRecord rec = expected.new SimulationRecord();
		rec.setTotalBoundCO2(20);
		rec.setTotalDeadWood(10);
		rec.setTotalHarvestedWood(0);
		rec.setTotalLivingWood(10);
		rec.setTotalProcessedWood(0);
		expected.addSimulationRecordForYear(rec, 0);
		
		SimulationRecord rec1 = expected.new SimulationRecord();
		rec1.setTotalDeadWood(12.0 - 0.2 * 12);
		rec1.setTotalHarvestedWood(10 - 0.5 * 10);
		rec1.setTotalLivingWood(10);
		rec1.setTotalProcessedWood(5);
		rec1.setTotalBoundCO2(10 + rec1.getTotalDeadWood() + rec1.getTotalHarvestedWood());
		expected.addSimulationRecordForYear(rec1, 1);
		
		return Test.compareResults(actual, expected);
	}
	
	private static boolean compareResults(SimulationResult actual, SimulationResult expected){
		System.out.println("Actual = " + actual);
		System.out.println("Expected = " + expected);
		if(actual.getYearsSimulated() != expected.getYearsSimulated()){
			return false;
		}
		for(int i = 0; i <= expected.getYearsSimulated(); i++){
			if(!Test.compareRecords(actual.getRecordForYear(i), expected.getRecordForYear(i))){
				return false;
			}
		}
		return true;
	}
	
	// OK to compare doubles using identity here as values
	// aren´t divided and this is not a proper equals implementation
	private static boolean compareRecords(SimulationRecord actual, SimulationRecord expected){
		if(actual.getTotalBoundCO2() != expected.getTotalBoundCO2()){
			return false;
		}
		if(actual.getTotalDeadWood() != expected.getTotalDeadWood()){
			return false;
		}
		if(actual.getTotalHarvestedWood() != expected.getTotalHarvestedWood()){
			return false;
		}
		if(actual.getTotalLivingWood() != expected.getTotalLivingWood()){
			return false;
		}
		if(actual.getTotalProcessedWood() != expected.getTotalProcessedWood()){
			return false;
		}
		return true;
	}
}
