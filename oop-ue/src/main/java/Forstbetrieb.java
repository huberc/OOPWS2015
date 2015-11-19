/**
 * @author Christoph Huber
 */
public class Forstbetrieb implements Listable {

    private CustomList customListHolzvollernert = new CustomList();
    private UniqueNameProvider uniqueNameProvider = new UniqueNameProvider();
    private String name;

    public Forstbetrieb(String name) {
        if(!(uniqueNameProvider.checkName(name))){
            this.name = name;
        }
    }

    public void addHolzvollernter(Holzvollernter holzvollernter) {
        customListHolzvollernert.insert(holzvollernter);
    }

    /**
     *
     * NB: Holzvollernter ist aus der Liste entfernt
     * @param holzvollernter
     */
    public void deleteHolzvollernter(Holzvollernter holzvollernter) {
        customListHolzvollernert.removeByName(holzvollernter.getName());
    }

    /**
     *
     * @param id die Id des zu bearbeitenden Holzvollernters
     * @param betriebsstunden die neuen Betriebsstunden
     * @param distanceMoved die neu zurueckgelegte Distanz
     * @param arbeitskopf der neue Arbeitskopf
     */
    public void changeInformationOfHolzvollernter(int id, int betriebsstunden, Number distanceMoved, AbstractArbeitskopf arbeitskopf) {
        Holzvollernter  tmp = (Holzvollernter) customListHolzvollernert.getElement(""+id);
        tmp.setBetriebsstunden(betriebsstunden);
        tmp.addDistanceMoved(distanceMoved);
        tmp.setArbeitskopf(arbeitskopf);
    }

    //TODO zu ueberlegen, was ich da zurueckgebe, weil eine Aufschluesselung, nach bestimmten Kriterien
    //TODO gefordert ist. Mein Vorschlag: eine Map als key die entsprechende Aufschluesselung
    //NOTE: jz erstmals als String definiert.
    public CustomList getAvgWorkingHoursOfAll() {

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
