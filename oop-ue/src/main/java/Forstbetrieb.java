/**
 * @author Christoph Huber
 */
public class Forstbetrieb implements Listable {

    private static final UniqueNameProvider NAME_PROVIDER            = new UniqueNameProvider();

    private CustomList                      customListHolzvollernert = new CustomList();
    private String                          name;

    /**
     * Erzeugt einen neuen <code>Forstbetrieb</code>. Dabei wird sichergestellt, dass der benutzte Name
     * eindeutig ist, bzw. falls das nicht der Falls sein sollte eine Exception geworfen
     * 
     * @param name
     *            der name dieses <code>Forstbetrieb</code>es
     * @throws IllegalArgumentException
     *             falls der angegebene Name bereits fuer einen anderen <code>Forstbetrieb</code> benutzt
     *             wurde
     */
    public Forstbetrieb(String name) throws IllegalArgumentException {
        if (Forstbetrieb.NAME_PROVIDER.nameUsed(name)) {
            throw new IllegalArgumentException("Name " + name + " ist bereits in Verwendung!");
        }
        this.name = name;
        Forstbetrieb.NAME_PROVIDER.registerName(name);
    }

    public void addHolzvollernter(Holzvollernter holzvollernter) {
        customListHolzvollernert.insert(holzvollernter);
    }

    /**
     * VB: der uebergebene Holzvollernter darf nicht null sein NB: Holzvollernter ist aus der Liste entfernt
     *
     * @param id
     *            Die eindeutige Id des zu loeschenden Holzvollernters
     */
    public void deleteHolzvollernter(int id) {
        if (!(customListHolzvollernert.isEmpty())) {
            customListHolzvollernert.removeByName(Integer.toString(id));
        }
    }

    /**
     *
     * NB: die uebergebenen Informationen des durch die ID eindeutigen Holzvollernters wurden geaendert
     *
     * @param id
     *            die Id des zu bearbeitenden Holzvollernters
     * @param betriebsstunden
     *            die neuen Betriebsstunden
     * @param distanceMoved
     *            die neu zurueckgelegte Distanz
     * @param arbeitskopf
     *            der neue Arbeitskopf
     */
    public void changeInformationOfHolzvollernter(int id, int betriebsstunden, Number distanceMoved,
            AbstractArbeitskopf arbeitskopf) {
        Holzvollernter tmp = (Holzvollernter) customListHolzvollernert.getElement(Integer.toString(id));
        tmp.setBetriebsstunden(betriebsstunden);
        tmp.addDistanceMoved(distanceMoved);
        tmp.setArbeitskopf(arbeitskopf);
    }

    //TODO zu ueberlegen, was ich da zurueckgebe, weil eine Aufschluesselung, nach bestimmten Kriterien
    //TODO gefordert ist. Mein Vorschlag: eine Map als key die entsprechende Aufschluesselung

    /**
     * NB: es wird eine CustomList mit zwei Elementen zurueckgegeben, wo sichergestellt ist, dass das erste
     * Element die durschnittlichen Arbeitsstunden der Einsatzart "in Stuecke schneiden" und das zweite
     * Element die durschnittlichen Arbeitsstunden der Einsatzart "Hackschnizel erzeugen" representiert.
     *
     * @return Eine Liste mit zwei Elementen die die Arbeitsstunden enthalten.
     */
    public CustomList getAvgWorkingHoursOfAll() {
        CustomList customListWorkingHoursAll = new CustomList();
        if (!(customListHolzvollernert.isEmpty())) {
            CustomList.CustomListNode customListNode = customListHolzvollernert.getHead();
            int hackschnitzelarbeitskopf = 0;
            int saegearbeitskopf = 0;
            int cnt = 0;

            while (customListNode.getNext() != null) {
                Holzvollernter tmp = (Holzvollernter) customListHolzvollernert.getElement(customListNode
                        .getValue().getName());

                //TODO: Wie ueberpruefen, welchen Arbeitskopf der aktuelle Holzvollernter hat?
                // TODO: derzeitige Anweisung nur als Placeholder is nicht ernst gemeint :D
                // TODO: gilt bei fast allen anderen methoden auch
                if (tmp.getArbeitskopf().equals(HackschnitzelArbeitskopf.class)) {
                    hackschnitzelarbeitskopf += tmp.getBetriebsstunden();
                } else {
                    saegearbeitskopf += tmp.getBetriebsstunden();
                }
                customListNode = customListNode.getNext();
                cnt++;
            }

            ListableNumber listableNumberhack = new ListableNumber((double) (hackschnitzelarbeitskopf / cnt));
            ListableNumber listableNumbersaeg = new ListableNumber((double) (saegearbeitskopf / cnt));

            customListWorkingHoursAll.insert(listableNumberhack);
            customListWorkingHoursAll.insert(listableNumbersaeg);
        }
        return customListWorkingHoursAll;
    }

    /**
     * VB: der uebergebene Holzvollernter darf nicht null sein
     *
     * NB: es wird eine CustomList mit zwei Elementen zurueckgegeben, wo sichergestellt ist, dass das erste
     * Element die durschnittlichen Arbeitsstunden der Einsatzart "in Stuecke schneiden" und das zweite
     * Element die durschnittlichen Arbeitsstunden der Einsatzart "Hackschnizel erzeugen" representiert.
     *
     * @param holzvollernter
     *            der spezielle Holzvollernter von dem die
     * @return eine Liste mit zwei Element die die geforderte Aufschluesselung nach Arbeitskoepfen beinhaltet
     */
    public CustomList getAvgWorkingHoursOfSpecific(Holzvollernter holzvollernter) {
        CustomList customListWorkingHoursSpecific = new CustomList();
        if (!(customListHolzvollernert.isEmpty())) {

            CustomList.CustomListNode customListNode = customListHolzvollernert.getHead();
            int saegehours = 0;
            int hackhours = 0;
            int cnt = 0;

            while (customListNode.getNext() != null) {
                Holzvollernter tmp = (Holzvollernter) customListHolzvollernert.getElement(customListNode
                        .getValue().getName());

                if (tmp.equals(holzvollernter)) {
                    if (tmp.getArbeitskopf().equals(HackschnitzelArbeitskopf.class)) {
                        hackhours += tmp.getBetriebsstunden();
                    } else {
                        saegehours += tmp.getBetriebsstunden();
                    }
                }
                customListNode = customListNode.getNext();
                cnt++;
            }

            ListableNumber listableNumberhackhours = new ListableNumber((double) (hackhours / cnt));
            ListableNumber listableNumbersaegehours = new ListableNumber((double) (saegehours / cnt));

            customListWorkingHoursSpecific.insert(listableNumberhackhours);
            customListWorkingHoursSpecific.insert(listableNumbersaegehours);
        }
        return customListWorkingHoursSpecific;
    }

    public CustomList getAvgDistance() {
        CustomList customListAvgDistance = new CustomList();
        if (!(customListHolzvollernert.isEmpty())) {

            CustomList.CustomListNode customListNode = customListHolzvollernert.getHead();
            double distancehack = 0;
            double distancestueck = 0;
            int cnt = 0;

            while (customListNode.getNext() != null) {
                Holzvollernter tmp = (Holzvollernter) customListHolzvollernert.getElement(customListNode
                        .getValue().getName());

                if (tmp instanceof Schreiter) {
                    if (tmp.getArbeitskopf().equals(HackschnitzelArbeitskopf.class)) {
                        distancehack += (double) tmp.getDistanceMoved();
                    } else {
                        distancestueck += (double) tmp.getDistanceMoved();
                    }

                }

                customListNode = customListNode.getNext();
                cnt++;
            }

            ListableNumber listableNumberhack = new ListableNumber(distancehack / cnt);
            ListableNumber listableNumbersaeg = new ListableNumber(distancestueck / cnt);

            customListAvgDistance.insert(listableNumberhack);
            customListAvgDistance.insert(listableNumbersaeg);

        }
        return customListAvgDistance;
    }

    /**
     * NB: es wird eine CustomList mit zwei Elementen zurueckgegeben, wo sichergestellt ist, dass das erste
     * Element die durschnittlichen Arbeitsstunden der Einsatzart "in Stuecke schneiden" und das zweite
     * Element die durschnittlichen Arbeitsstunden der Einsatzart "Hackschnizel erzeugen" representiert.
     *
     * @return Eine Liste mit zwei Elementen die entsprechend aufgeschluesselt wurden und die die
     *         durchschnittlichen Schritte enthalten.
     */
    public CustomList getAvgSteps() {
        CustomList customListAvgSteps = new CustomList();
        if (!(customListHolzvollernert.isEmpty())) {

            CustomList.CustomListNode customListNode = customListHolzvollernert.getHead();
            double distancehack = 0;
            double distancestueck = 0;
            int cnt = 0;

            while (customListNode.getNext() != null) {
                Holzvollernter tmp = (Holzvollernter) customListHolzvollernert.getElement(customListNode
                        .getValue().getName());

                if (tmp instanceof Radernter) {
                    if (tmp.getArbeitskopf().equals(HackschnitzelArbeitskopf.class)) {
                        distancehack += (double) tmp.getDistanceMoved();
                    } else {
                        distancestueck += (double) tmp.getDistanceMoved();
                    }

                }

                customListNode = customListNode.getNext();
                cnt++;
            }

            ListableNumber listableNumberhack = new ListableNumber(distancehack / cnt);
            ListableNumber listableNumbersaeg = new ListableNumber(distancestueck / cnt);

            customListAvgSteps.insert(listableNumberhack);
            customListAvgSteps.insert(listableNumbersaeg);

        }
        return customListAvgSteps;
    }

    /**
     * NB: der erste wert in der Liste ist min der Radernter, der zweite max der Radernter. 3 und 4 min, max
     * fuer Schreiter
     *
     * @return
     */
    public CustomList getMaxAndMinPieceLength() {
        double minrad = 0, minschreit = 0, maxrad = 0, maxschreit = 0;
        CustomList customListMinMax = new CustomList();
        if (!(customListHolzvollernert.isEmpty())) {
            CustomList.CustomListNode customListNode = customListHolzvollernert.getHead();
            double distancehack = 0;
            double distancestueck = 0;

            while (customListNode.getNext() != null) {
                Holzvollernter tmp = (Holzvollernter) customListHolzvollernert.getElement(customListNode
                        .getValue().getName());

                if (tmp.getArbeitskopf().equals(Schneidearbeitskopf.class)) {
                    if (tmp instanceof Radernter) {
                        if (minrad == 0 && maxrad == 0) {
                            minrad = tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue();
                            maxrad = tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue();
                        } else {
                            if (tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue() > maxrad) {
                                minrad = tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue();
                            } else if (tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue() < minrad) {
                                maxrad = tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue();
                            }
                        }
                    } else if (tmp instanceof Schreiter) {
                        if (minschreit == 0 && maxschreit == 0) {
                            minschreit = tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue();
                            maxschreit = tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue();
                        } else {
                            if (tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue() > maxschreit) {
                                minrad = tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue();
                            } else if (tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue() < minschreit) {
                                maxrad = tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue();
                            }
                        }
                    }

                }

                customListNode = customListNode.getNext();
            }

            ListableNumber listableNumberMinRad = new ListableNumber(minrad);
            ListableNumber listableNumberMaxRad = new ListableNumber(maxrad);
            ListableNumber listableNumberMinSchreit = new ListableNumber(minschreit);
            ListableNumber listableNumberMaxSchreit = new ListableNumber(maxschreit);

            customListMinMax.insert(listableNumberMinRad);
            customListMinMax.insert(listableNumberMaxRad);
            customListMinMax.insert(listableNumberMinSchreit);
            customListMinMax.insert(listableNumberMaxSchreit);

        }

        return customListMinMax;
    }

    public CustomList getAvgTreeThickness() {

        int thicknessrad = 0, thicknessschreit = 0;
        CustomList customListAvgThickness = new CustomList();
        int cnt = 0;

        if (!(customListHolzvollernert.isEmpty())) {
            CustomList.CustomListNode customListNode = customListHolzvollernert.getHead();

            while (customListNode.getNext() != null) {
                Holzvollernter tmp = (Holzvollernter) customListHolzvollernert.getElement(customListNode
                        .getValue().getName());

                if (tmp.getArbeitskopf().equals(HackschnitzelArbeitskopf.class)) {
                    if (tmp instanceof Radernter) {
                        thicknessrad += tmp.getArbeitskopf().getConstraint().constraintValue.intValue();
                    } else if (tmp instanceof Schreiter) {
                        thicknessschreit += tmp.getArbeitskopf().getConstraint().constraintValue.intValue();
                    }

                }

                customListNode = customListNode.getNext();
            }

            ListableNumber listableNumberThicknessRad = new ListableNumber(thicknessrad);
            ListableNumber listableNumberThicknessSchreit = new ListableNumber(thicknessschreit);

            customListAvgThickness.insert(listableNumberThicknessRad);
            customListAvgThickness.insert(listableNumberThicknessSchreit);

        }

        return customListAvgThickness;
    }

    @Override
    public String getName() {
        return name;
    }

}
