

public class SimulationRequest {

	/**
	 * The amount of living wood at the start of a simulation.
	 */
	private double startLivingWood;

	/**
	 * The amount of daedwood at the start of a simulation.
	 */
	private double startDeadWood;

	/**
	 * Average wood growth per year
	 */
	private double avgWoodGrowth;

	/**
	 * Average amount of wood harvested per year.
	 */
	private double avgHarvestYearly;

	/**
	 * Average amount of dead wood which remains in the wood per year.
	 */
	private double avgDeadWoodYearly;

	/**
	 * Average yearly percentage of wood that is processed. Measured against the
	 * total amount of living wood.
	 */
	private double avgProcessedWoodYearly;

	/**
	 * Average yearly amount of decompositioned wood. Measured against the total
	 * amount of dead wood.
	 */
	private double avgDecompWoodYearly;

	public double getStartLivingWood() {
		return startLivingWood;
	}

	public void setStartLivingWood(double startLivingWood) {
		this.startLivingWood = startLivingWood;
	}

	public double getStartDeadWood() {
		return startDeadWood;
	}

	public void setStartDeadWood(double startDeadWood) {
		this.startDeadWood = startDeadWood;
	}

	public double getAvgWoodGrowth() {
		return avgWoodGrowth;
	}

	public void setAvgWoodGrowth(double avgWoodGrowth) {
		this.avgWoodGrowth = avgWoodGrowth;
	}

	public double getAvgHarvestYearly() {
		return avgHarvestYearly;
	}

	public void setAvgHarvestYearly(double avgHarvestYearly) {
		this.avgHarvestYearly = avgHarvestYearly;
	}

	public double getAvgDeadWoodYearly() {
		return avgDeadWoodYearly;
	}

	public void setAvgDeadWoodYearly(double avgDeadWoodYearly) {
		this.avgDeadWoodYearly = avgDeadWoodYearly;
	}

	public double getAvgProcessedWoodYearly() {
		return avgProcessedWoodYearly;
	}

	public void setAvgProcessedWoodYearly(double avgProcessedWoodYearly) {
		this.avgProcessedWoodYearly = avgProcessedWoodYearly;
	}

	public double getAvgDecompWoodYearly() {
		return avgDecompWoodYearly;
	}

	public void setAvgDecompWoodYearly(double avgDecompWoodYearly) {
		this.avgDecompWoodYearly = avgDecompWoodYearly;
	}
}
