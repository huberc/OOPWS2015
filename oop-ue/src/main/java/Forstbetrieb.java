/**
 * @author Christoph Huber
 */
public class Forstbetrieb {

    private static String name="";

    protected static final String fetchName() {
        String retVal;
        synchronized (Forstbetrieb.name) {
            retVal = Holzvollernter.idSequence++;
        }
        return retVal;
    }



    public Forstbetrieb() {

    }


    public void addHolzvollernter(Holzvollernter holzvollernter) {

    }

    public void deleteHolzvollernter(Holzvollernter holzvollernter) {

    }

    public boolean changeInformationOfHolzvollernter(Holzvollernter holzvollernter) {

        return false;
    }

    //TODO zu überlegen, was ich da zurückgebe, weil eine Aufschlüsselung, nach bestimmten Kriterien
    //TODO gefordert ist. Mein Vorschlag: eine Map als key die entsprechende Aufschlüsselung
    //NOTE: jz erstmals als String definiert.
    public String getAvgWorkingHoursOfAll() {

        return null;
    }

    public String getAvgWorkingHoursOfSpecific(Holzvollernter holzvollernter) {

        return null;
    }

    public String getAvgDistance() {

        return null;
    }

    public String getAvgSteps() {

        return null;
    }

    public String getMaxAndMinPieceLength() {
        return null;
    }

    public String getAvgTreeThickness() {

        return null;
    }
}