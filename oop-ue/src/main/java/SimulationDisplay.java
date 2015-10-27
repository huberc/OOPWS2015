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
		
        String output, zusatzinfo="";


        output = "\n" + "--------------------------------------------------------------------------------------------------------------- \n";
        output += "| Jahr | lebendes Holz | verbleibendes Totholz |   geerntets Holz   |  verwertetes Holz  |   gebundenes CO2   |    Schwarzerle     |       Fichte       |       Profit       | \n";
        String line;
        for(int i = 0; i < res.getYearsSimulated(); i++){
            line = "|" + i;
            for(int j = String.valueOf(i).length(); j < yearSpace; j++) {
                line += " ";
            }
            SimulationResult.SimulationRecord rec1 = res.getRecordForYear(i);
            zusatzinfo = "Die Werte in der unten stehenden Tablle wurden unter folgenden Annahmen berechnet:\n";
            zusatzinfo += "   Wetter:";
            zusatzinfo += "      - Regenfall:\t"+rec1.getWeather().getRainfall();
            zusatzinfo += "      - Durchschnittstemperatur:\n"+rec1.getWeather().getAvgTemperature();
            zusatzinfo += "   Durchgeführte Aktionen:";

            for (int k=0;k<rec1.getWoodActions().size();k++){
                zusatzinfo += "      -"+rec1.getWoodActions().get(k).getNumTreesToActOn()+" "+rec1.getWoodActions().get(k).getTreeTypeToActOn().getName()+"wurden "+rec1.getWoodActions().get(k).getType().toString();
            }

            line += SimulationDisplay.formatAsTable(res.getRecordForYear(i));
            output += line;
        }
        output += "---------------------------------------------------------------------------------------------------------------";


        return zusatzinfo + output;
	}
	
	private static String formatAsTable(SimulationResult.SimulationRecord rec){
        int livingWoodspace = 15;
        int deadWoodspace = 23;
        int harvestedWoodspace = 20;
        int processedWoodspace = 20;
        int boundCO2space= 20;
        int blackAlderspace = 20;
        int sprucespace = 20;
        int proftspace = 20;

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

        line += "|" + rec.getTreesByType().get(BlackAlder.class);
        if(String.valueOf(rec.getTotalBoundCO2()).length() < blackAlderspace) {
            for(int i = String.valueOf(rec.getTotalBoundCO2()).length(); i < blackAlderspace; i++) {
                line += " ";
            }
        }

        line += "|" + rec.getTreesByType().get(Spruce.class);
        if(String.valueOf(rec.getTotalBoundCO2()).length() < sprucespace) {
            for(int i = String.valueOf(rec.getTotalBoundCO2()).length(); i < sprucespace; i++) {
                line += " ";
            }
        }

        line += "|" + rec.getProfitMade();
        if(String.valueOf(rec.getTotalBoundCO2()).length() < proftspace) {
            for(int i = String.valueOf(rec.getTotalBoundCO2()).length(); i < proftspace; i++) {
                line += " ";
            }
        }

        return line + "| \n";
	}

	
}
