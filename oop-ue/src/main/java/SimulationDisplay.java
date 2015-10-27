/**
 * Utility class to display simulation results
 *
 * @author michael
 */
public class SimulationDisplay {

    /**
     * Creates an ASCII Table from a <code>SimulationResult</code>
     *
     * @param res
     * @return
     */
    public static String formatAsTable(SimulationResult res) {
        int yearSpace = 6;

        String output, zusatzinfo = "";

        output = "\n"
                + "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ \n";
        output += "| Jahr |        lebendes Holz         |    verbleibendes Totholz     |        geerntets Holz        |       verwertetes Holz       |        gebundenes CO2        |      lebende Schwarzerle     |      tote Schwarzerle        |      lebende Fichte          |         tote Fichte          |            Profit            | \n";
        String line;
        for (int i = 0; i <= res.getYearsSimulated(); i++) {
            line = "|" + i;
            for (int j = String.valueOf(i).length(); j < yearSpace; j++) {
                line += " ";
            }
            SimulationResult.SimulationRecord rec1 = res.getRecordForYear(i);
            if (i == 0) {
                zusatzinfo = "\nDie Werte in der unten stehenden Tablle wurden unter folgenden Annahmen berechnet:\n";
                if (rec1.getWeather() != null) {
                    // no weather in year 0
                    zusatzinfo += "   Wetter:";
                    zusatzinfo += "\n\t\t- Regenfall:\t\t\t"
                            + rec1.getWeather().getRainfall();
                    zusatzinfo += "\n\t\t- Durchschnittstemperatur:\t"
                            + rec1.getWeather().getAvgTemperature() + "\n";
                    zusatzinfo += "   Durchgefuehrte Aktionen:\n";
                }
            }
            zusatzinfo += SimulationDisplay.actionsPerfomed(res.getRecordForYear(i), i);
            line += SimulationDisplay.formatAsTable(res.getRecordForYear(i));
            output += line;
        }
        output += "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";

        return zusatzinfo + output;
    }

    private static String formatAsTable(SimulationResult.SimulationRecord rec) {
        int livingWoodspace = 30;
        int deadWoodspace = 30;
        int harvestedWoodspace = 30;
        int processedWoodspace = 30;
        int boundCO2space = 30;
        int blackAlderspace = 30;
        int sprucespace = 30;
        int proftspace = 30;

        String line = "";

        line += "|" + rec.getTotalLivingWood();
        if (String.valueOf(rec.getTotalLivingWood()).length() < livingWoodspace) {
            for (int i = String.valueOf(rec.getTotalLivingWood()).length(); i < livingWoodspace; i++) {
                line += " ";
            }
        }

        line += "|" + rec.getTotalDeadWood();
        if (String.valueOf(rec.getTotalDeadWood()).length() < deadWoodspace) {
            for (int i = String.valueOf(rec.getTotalDeadWood()).length(); i < deadWoodspace; i++) {
                line += " ";
            }
        }

        line += "|" + rec.getTotalHarvestedWood();
        if (String.valueOf(rec.getTotalHarvestedWood()).length() < harvestedWoodspace) {
            for (int i = String.valueOf(rec.getTotalHarvestedWood()).length(); i < harvestedWoodspace; i++) {
                line += " ";
            }
        }

        line += "|" + rec.getTotalProcessedWood();
        if (String.valueOf(rec.getTotalProcessedWood()).length() < processedWoodspace) {
            for (int i = String.valueOf(rec.getTotalProcessedWood()).length(); i < processedWoodspace; i++) {
                line += " ";
            }
        }

        line += "|" + rec.getTotalBoundCO2();
        if (String.valueOf(rec.getTotalBoundCO2()).length() < boundCO2space) {
            for (int i = String.valueOf(rec.getTotalBoundCO2()).length(); i < boundCO2space; i++) {
                line += " ";
            }
        }

        line += "|" + rec.getLivingTreesByType().get(BlackAlder.class);
        if (String.valueOf(rec.getLivingTreesByType().get(BlackAlder.class)).length() < blackAlderspace) {
            for (int i = String.valueOf(
                    rec.getLivingTreesByType().get(BlackAlder.class)).length(); i < blackAlderspace; i++) {
                line += " ";
            }
        }

        line += "|" + rec.getDeadTreesByType().get(BlackAlder.class);
        if (String.valueOf(rec.getDeadTreesByType().get(BlackAlder.class)).length() < sprucespace) {
            for (int i = String.valueOf(rec.getDeadTreesByType().get(BlackAlder.class))
                    .length(); i < sprucespace; i++) {
                line += " ";
            }
        }

        line += "|" + rec.getLivingTreesByType().get(Spruce.class);
        if (String.valueOf(rec.getLivingTreesByType().get(Spruce.class)).length() < blackAlderspace) {
            for (int i = String.valueOf(
                    rec.getLivingTreesByType().get(Spruce.class)).length(); i < blackAlderspace; i++) {
                line += " ";
            }
        }

        line += "|" + rec.getDeadTreesByType().get(Spruce.class);
        if (String.valueOf(rec.getDeadTreesByType().get(Spruce.class)).length() < sprucespace) {
            for (int i = String.valueOf(rec.getDeadTreesByType().get(Spruce.class))
                    .length(); i < sprucespace; i++) {
                line += " ";
            }
        }

        line += "|" + rec.getProfitMade();
        if (String.valueOf(rec.getProfitMade()).length() < proftspace) {
            for (int i = String.valueOf(rec.getProfitMade()).length(); i < proftspace; i++) {
                line += " ";
            }
        }

        return line + "| \n";
    }

    private static String actionsPerfomed(SimulationResult.SimulationRecord rec, int year) {
        String output = "";

        if (rec.getWoodActions() != null) {
            output = "\t\t- Im Jahr " + year + " wurden:\n";
            for (WoodUsageAction action : rec.getWoodActions()) {
                output += "\t\t\t" + action.getNumTreesToActOn()
                        + " "
                        + action.getTreeTypeToActOn()
                        .toString() + " "
                        + action.getType().getHumanReadableName() + "\n";
            }
        } else {
            output = "\t\t- Im Jahr " + year + " wurden keine Aktionen durchgefuehrt\n";
        }
        return output;
    }

}
