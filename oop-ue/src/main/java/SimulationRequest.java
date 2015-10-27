/**
 * @author Christoph
 */

public class SimulationRequest {

    /**
     * Average yearly percentage of wood that is processed. Measured against the
     * total amount of living wood.
     */
    private double avgProcessedWoodYearly;

    /**
     * Weathermodel for the simulation
     */
    private IWeatherModel weatherModel;

    /**
     * Woadusagemodel for the simulation
     */
    private IWoodUsageModel woodUsageModel;

    /**
     * Ecconomicmodel for the simulation
     */
    private IEconomicModel economicModel;

    /**
     * The forest, which should be simulated.
     */
    private Forest forest;

    /**
     * variable costs for GuV calculation
     */
    private int variableCosts;
    /**
     * fix costs for GuV calculation
     */
    private int fixCosts;

    /**
     * price per meter wood
     */
    private int pricePerMeter;

    public double getAvgProcessedWoodYearly() {
        return avgProcessedWoodYearly;
    }

    public void setAvgProcessedWoodYearly(double avgProcessedWoodYearly) {
        this.avgProcessedWoodYearly = avgProcessedWoodYearly;
    }
    public IWeatherModel getWeatherModel() {
        return this.weatherModel;
    }

    public void setWeatherModel(IWeatherModel weatherModel) {
        this.weatherModel = weatherModel;
    }

    public IWoodUsageModel getWoodUsageModel() {
        return woodUsageModel;
    }

    public void setWoodUsageModel(IWoodUsageModel woodUsageModel) {
        this.woodUsageModel = woodUsageModel;
    }

    public IEconomicModel getEconomicModel() {
        return economicModel;
    }

    public void setEconomicModel(IEconomicModel economicModel) {
        this.economicModel = economicModel;
    }

    public Forest getForest() {
        return forest;
    }

    public void setForest(Forest forest) {
        this.forest = forest;
    }

    public int getVariableCosts() {
        return variableCosts;
    }

    public void setVariableCosts(int variableCosts) {
        this.variableCosts = variableCosts;
    }

    public int getFixCosts() {
        return fixCosts;
    }

    public void setFixCosts(int fixCosts) {
        this.fixCosts = fixCosts;
    }

    public int getPricePerMeter() {
        return pricePerMeter;
    }

    public void setPricePerMeter(int pricePerMeter) {
        this.pricePerMeter = pricePerMeter;
    }
}
