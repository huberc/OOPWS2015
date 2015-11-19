/**
 * @author Christoph Huber
 */
public class Forstbetrieb implements Listable {

    public Forstbetrieb(String name) {

    }

    public void addHolzvollernter(Holzvollernter holzvollernter) {

    }

    public void deleteHolzvollernter(Holzvollernter holzvollernter) {

    }

    public boolean changeInformationOfHolzvollernter(Holzvollernter holzvollernter) {

        return false;
    }

    //TODO zu ueberlegen, was ich da zurueckgebe, weil eine Aufschluesselung, nach bestimmten Kriterien
    //TODO gefordert ist. Mein Vorschlag: eine Map als key die entsprechende Aufschluesselung
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

    @Override
    public String getName() {
        return name;
    }
}
