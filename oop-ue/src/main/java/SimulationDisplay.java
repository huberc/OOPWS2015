/**
 * Utility class to display simulation results
 * 
 * @author michael
 *
 */
public class SimulationDisplay {

	/**
	 * Creates an ASCII Table from a <code>SimulationResult</code>
	 * 
	 * @param res
	 * @return
	 */
	public static String formatAsTable(SimulationResult res){
		int yearSpace = 6;
		
        String output;

        output = "\n" + "--------------------------------------------------------------------------------------------------------------- \n";
        output += "| Jahr | lebendes Holz | verbleibendes Totholz |   geerntets Holz   |  verwertetes Holz  |   gebundenes CO2   | \n";
        String line;
        for(int i = 0; i < res.getYearsSimulated(); i++){
            line = "|" + i;
            for(int j = String.valueOf(i).length(); j < yearSpace; j++) {
                line += " ";
            }
            line += SimulationDisplay.formatAsTable(res.getRecordForYear(i));
            output += line;
        }
        output += "---------------------------------------------------------------------------------------------------------------";

        return output;
	}
	
	private static String formatAsTable(SimulationResult.SimulationRecord rec){
        int livingWoodspace = 15;
        int deadWoodspace = 23;
        int harvestedWoodspace = 20;
        int processedWoodspace = 20;
        int boundCO2space = 20;

        String line = "";
        
        line += "|" + rec.getTotalLivingWood();
        if(String.valueOf(rec.getTotalLivingWood()).length() < livingWoodspace) {
            for(int i = String.valueOf(rec.getTotalLivingWood()).length(); i < livingWoodspace; i++) {
                line += " ";
            }
        }

        line += "|" + rec.getTotalDeadWood();
        if(String.valueOf(rec.getTotalDeadWood()).length() < deadWoodspace) {
            for(int i = String.valueOf(rec.getTotalDeadWood()).length(); i < deadWoodspace; i++) {
                line += " ";
            }
        }

        line += "|" + rec.getTotalHarvestedWood();
        if(String.valueOf(rec.getTotalHarvestedWood()).length() < harvestedWoodspace) {
            for(int i = String.valueOf(rec.getTotalHarvestedWood()).length(); i < harvestedWoodspace; i++) {
                line += " ";
            }
        }

        line += "|" + rec.getTotalProcessedWood();
        if(String.valueOf(rec.getTotalProcessedWood()).length() < processedWoodspace) {
            for(int i = String.valueOf(rec.getTotalProcessedWood()).length(); i < processedWoodspace; i++) {
                line += " ";
            }
        }

        line += "|" + rec.getTotalBoundCO2();
        if(String.valueOf(rec.getTotalBoundCO2()).length() < boundCO2space) {
            for(int i = String.valueOf(rec.getTotalBoundCO2()).length(); i < boundCO2space; i++) {
                line += " ";
            }
        }

        return line + "| \n";
	}

	
}
