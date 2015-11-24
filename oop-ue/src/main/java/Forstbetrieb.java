/**
 * @author Christoph Huber
 */
public class Forstbetrieb implements Listable {

    private static final UniqueNameProvider NAME_PROVIDER            = new UniqueNameProvider();

    private CustomList                      customListHolzvollernert = new CustomList();
    private String                          name;

    /**
     * Erzeugt einen neuen <code>Forstbetrieb</code>. Dabei wird sichergestellt, dass der benutzte Name
     * eindeutig ist, bzw. falls das nicht der Fall sein sollte eine Exception geworfen wird.
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

    /**
     *
     * VB:  der Holzvollernter darf nicht null sein
     * NB:  es ist sichergestellt, dass der uebergebene Holzvollernter in der Liste enthalten ist.
     *      er wird entweder hinzugefuegt oder ist bereits bestandteil der Liste
     *
     * @param holzvollernter der einzufuegende Holzvollernter
     */
    public void addHolzvollernter(Holzvollernter holzvollernter) {
        customListHolzvollernert.insert(holzvollernter);
    }

    /**
     * VB: der uebergebene Holzvollernter darf nicht null sein
     * NB: Holzvollernter ist aus der Liste entfernt
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
     * VB: die uebgergebene ID muss bereits vergeben sein
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

    /**
     * VB: der Forstbetrien enthaelt Holzvollernter
     * NB: es wird eine CustomList mit zwei Elementen zurueckgegeben, wobei die CustomList hier wie eine Map funktioniert.
     *  Die Elemente haben als key "HackschnitzelArbeitskopf" bzw. "Schneidearbeitskopf" und als value die durchschnittlichen
     *  Betriebsstunden.
     *
     * @return Eine "Map" mit zwei Elementen mit geforderter Aufschliesselung nach Arbeitskopf die die Arbeitsstunden enthalten.
     */
    public CustomList getAvgWorkingHoursOfAll() {
        CustomList customListWorkingHoursAll = new CustomList();
        if (!(customListHolzvollernert.isEmpty())) {
            CustomList.CustomListNode customListNode = customListHolzvollernert.getHead();
            int hackschnitzelarbeitskopf = 0;
            int schneidearbeitskopf = 0;
            int cnthackschnitzel = 0;
            int cntschneide = 0;



            while (customListNode != null) {
                Holzvollernter tmp = (Holzvollernter) customListHolzvollernert.getElement(customListNode
                        .getValue().getName());

                if (tmp.getArbeitskopf() instanceof HackschnitzelArbeitskopf) {
                    hackschnitzelarbeitskopf += tmp.getBetriebsstunden();
                    cnthackschnitzel++;
                } else if(tmp.getArbeitskopf() instanceof  Schneidearbeitskopf){
                    schneidearbeitskopf += tmp.getBetriebsstunden();
                    cntschneide++;
                }
                customListNode = customListNode.getNext();
            }

            if(cnthackschnitzel == 0) {
                cnthackschnitzel =1;
            }
            KeyValueListable  keyValueListableHackschnitzelArbeitskopf = new KeyValueListable(HackschnitzelArbeitskopf.class.getName(),(double)(hackschnitzelarbeitskopf/cnthackschnitzel));

            if(cntschneide == 0 )
                cntschneide =1;

            KeyValueListable keyValueListableSchneideArbeitskopf = new KeyValueListable(Schneidearbeitskopf.class.getName(), (double) (schneidearbeitskopf/cntschneide));

            customListWorkingHoursAll.insert(keyValueListableHackschnitzelArbeitskopf);
            customListWorkingHoursAll.insert(keyValueListableSchneideArbeitskopf);
        }
        return customListWorkingHoursAll;
    }

    /**
     * VB: der uebergebene Holzvollernter darf nicht null sein
     * NB: es wird eine CustomList mit zwei Elementen zurueckgegeben, wobei die CustomList hier wie eine Map funktioniert.
     *  Die Elemente haben als key "Schreiter" bzw. "Radernter" und als value die durchschnittlichen
     *  Betriebsstunden.
     *
     * @return eine "Map" mit zwei Element die die geforderte Aufschluesselung nach Art des Holzvollernters zurueckgegeben
     */
    public CustomList getAvgWorkingHoursOfSpecific() {
        CustomList customListWorkingHoursSpecific = new CustomList();

        if (!(customListHolzvollernert.isEmpty())) {

            CustomList.CustomListNode customListNode = customListHolzvollernert.getHead();
            int radernterhours = 0;
            int schreiterhours = 0;
            int cntradernter = 0;
            int cntschreiter =0;

            while (customListNode != null) {
                Holzvollernter tmp = (Holzvollernter) customListHolzvollernert.getElement(customListNode
                        .getValue().getName());

                if (tmp instanceof Radernter ) {
                    radernterhours += tmp.getBetriebsstunden();
                    cntradernter++;
                }else if(tmp instanceof Schreiter){
                    schreiterhours += tmp.getBetriebsstunden();
                    cntschreiter++;
                }
                customListNode = customListNode.getNext();

            }

            if(cntradernter == 0)
                cntradernter=1;
            if(cntschreiter == 0)
                cntschreiter=1;

            KeyValueListable keyValueListableradernter = new KeyValueListable(Radernter.class.getName(),(double) (radernterhours/cntradernter));
            KeyValueListable keyValueListableschreiter = new KeyValueListable(Schreiter.class.getName(), (double)(schreiterhours/cntschreiter));

            customListWorkingHoursSpecific.insert(keyValueListableradernter);
            customListWorkingHoursSpecific.insert(keyValueListableschreiter);

        }
        return customListWorkingHoursSpecific;
    }

    /**
     * VB: Forstbetrieb enthaelt Holzvollernter
     * NB: es wird eine CustomList mit zwei Elementen zurueckgegeben, wobei die CustomList hier wie eine Map funktioniert.
     *  Die Elemente haben als key "HackschnitzelArbeitskopf" bzw. "Schneidearbeitskopf" und als value die durchschnittlich
     *  zurueckgelegte Wegstrecke.
     *
     * @return eine "Map" mit zwei Element, die die geforderte Aufschluesselung der durchschnittlich zurueckgelegten Wegstrecke
     * nach Arbeitskoepfen beinhaltet
     */
    public CustomList getAvgDistance() {
        CustomList customListAvgDistance = new CustomList();
        if (!(customListHolzvollernert.isEmpty())) {

            CustomList.CustomListNode customListNode = customListHolzvollernert.getHead();
            double distancehack = 0;
            double distanceschneide = 0;
            int cnthack = 0;
            int cntschneide = 0;

            while (customListNode != null) {
                Holzvollernter tmp = (Holzvollernter) customListHolzvollernert.getElement(customListNode
                        .getValue().getName());

                if (tmp instanceof Radernter) {
                    if (tmp.getArbeitskopf() instanceof HackschnitzelArbeitskopf) {
                        distancehack += (double) tmp.getDistanceMoved();
                        cnthack++;
                    } else if(tmp.getArbeitskopf() instanceof  Schneidearbeitskopf) {
                        distanceschneide += (double) tmp.getDistanceMoved();
                        cntschneide++;
                    }

                }

                customListNode = customListNode.getNext();

            }

            if(cnthack == 0)
                cnthack =1;
            if(cntschneide == 0)
                cntschneide=1;

            KeyValueListable keyValueListableHackschnitzelArbeitskopf = new KeyValueListable(HackschnitzelArbeitskopf.class.getName(), (distancehack/cnthack));
            KeyValueListable keyValueListableSchneideArbeitskopf = new KeyValueListable(Schneidearbeitskopf.class.getName(), (distanceschneide/cntschneide));

            customListAvgDistance.insert(keyValueListableHackschnitzelArbeitskopf);
            customListAvgDistance.insert(keyValueListableSchneideArbeitskopf);

        }
        return customListAvgDistance;
    }

    /**
     * VB: der Forstbetrieb enthaelt Holzvollernter des Typs "Schreiter"
     * NB: es wird eine CustomList mit zwei Elementen zurueckgegeben, wobei die CustomList hier wie eine Map funktioniert.
     *  Die Elemente haben als key "HackschnitzelArbeitskopf" bzw. "Schneidearbeitskopf" und als value die durchschnittliche
     *  Anzahl an zurueckgelegten Schritten.
     *
     * @return Eine "Map" mit zwei Elementen die entsprechend nach Arbeitskopf aufgeschluesselt wurden und die die
     *         durchschnittlichen Schritte enthalten.
     */
    public CustomList getAvgSteps() {
        CustomList customListAvgSteps = new CustomList();
        if (!(customListHolzvollernert.isEmpty())) {

            CustomList.CustomListNode customListNode = customListHolzvollernert.getHead();
            double distancehack = 0;
            double distanceschneide = 0;
            int cnthack = 0;
            int cntschneide = 0;

            while (customListNode != null) {
                Holzvollernter tmp = (Holzvollernter) customListHolzvollernert.getElement(customListNode
                        .getValue().getName());

                if (tmp instanceof Schreiter) {
                    if (tmp.getArbeitskopf() instanceof HackschnitzelArbeitskopf) {
                        distancehack += tmp.getDistanceMoved().doubleValue();
                        cnthack++;
                    } else if(tmp.getArbeitskopf() instanceof  Schneidearbeitskopf) {
                        distanceschneide += tmp.getDistanceMoved().doubleValue();
                        cntschneide++;
                    }

                }
                customListNode = customListNode.getNext();
            }

            if(cnthack == 0)
                cnthack=1;
            if(cntschneide == 0)
                cntschneide=1;

            KeyValueListable keyValueListableHackschnitzelArbeitskopf = new KeyValueListable(HackschnitzelArbeitskopf.class.getName(), (distancehack/cnthack));
            KeyValueListable keyValueListableSchneideArbeitskopf = new KeyValueListable(Schneidearbeitskopf.class.getName(), (distanceschneide/cntschneide));

            customListAvgSteps.insert(keyValueListableHackschnitzelArbeitskopf);
            customListAvgSteps.insert(keyValueListableSchneideArbeitskopf);

        }
        return customListAvgSteps;
    }

    /**
     * VB: der Forstbetrien enthaelt min. einen Holzvollernter mit einem Schneidearbeitskopf
     * NB: es wird eine CustomList mit vier Elementen zurueckgegeben, wobei die CustomList hier wie eine Map funktioniert.
     *  Die Elemente haben als key "Schreiter Minimum", "Schreiter Maximum", "Radernter Maximum" bzw. "Radernter Minimum"
     *  und als Value die entsprechende minimale/ maximale Stücklänge aller Holzvollernter.
     *
     * @return Eine "Map" mit vier Elementen die die entsprechende minimale/ maximale Stücklänge aller Holzvollernter
     *      aufgeschluesselt zurueck gibt.
     */
    public CustomList getMaxAndMinPieceLength() {
        double minrad = 0, minschreit = 0, maxrad = 0, maxschreit = 0;
        CustomList customListMinMax = new CustomList();
        if (!(customListHolzvollernert.isEmpty())) {
            CustomList.CustomListNode customListNode = customListHolzvollernert.getHead();

            while (customListNode != null) {
                Holzvollernter tmp = (Holzvollernter) customListHolzvollernert.getElement(customListNode
                        .getValue().getName());

                if (tmp.getArbeitskopf() instanceof Schneidearbeitskopf) {
                    if (tmp instanceof Radernter) {
                        if (minrad == 0.0 && maxrad == 0.0) {
                            minrad = tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue();
                            maxrad = tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue();
                        } else {
                            if (tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue() > maxrad) {
                                maxrad = tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue();
                            } else if (tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue() < minrad) {
                                minrad = tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue();
                            }
                        }
                    } else if (tmp instanceof Schreiter) {
                        if (minschreit == 0.0 && maxschreit == 0.0) {
                            minschreit = tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue();
                            maxschreit = tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue();
                        } else {
                            if (tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue() > maxschreit) {
                                maxschreit = tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue();
                            } else if (tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue() < minschreit) {
                                minschreit = tmp.getArbeitskopf().getConstraint().constraintValue.doubleValue();
                            }
                        }
                    }

                }

                customListNode = customListNode.getNext();
            }

            KeyValueListable keyValueListableRadernterMin = new KeyValueListable(Radernter.class.getName()+" Minimum", minrad);
            KeyValueListable keyValueListableRadernterMax = new KeyValueListable(Radernter.class.getName()+" Maximum", maxrad);
            KeyValueListable keyValueListableSchreiterMin = new KeyValueListable(Schreiter.class.getName()+" Minimum", minschreit);
            KeyValueListable keyValueListableSchreiterMax = new KeyValueListable(Schreiter.class.getName()+" Maximum", maxschreit);

            customListMinMax.insert(keyValueListableRadernterMin);
            customListMinMax.insert(keyValueListableRadernterMax);
            customListMinMax.insert(keyValueListableSchreiterMin);
            customListMinMax.insert(keyValueListableSchreiterMax);

        }

        return customListMinMax;
    }

    /**
     * VB: der Forstbetrieb enthaelt min. einen Holzvollernter mit einem Hackschnitzelkopf
     * NB: es wird eine CustomList mit zwei Elementen zurueckgegeben, wobei die CustomList hier wie eine Map funktioniert.
     *  Die Elemente haben als key "Schreiter" bzw. "Radernter" und als Value die durhschnittliche Baumdicke aller Holzvollernter.
     *
     * @return Eine "Map" mit zwei Elementen, die entsprechend nach Art des Holzvollernters aufgeschluesselt wurden und
     *      die durchschnittliche Baumdicke enthaelt.
     */
    public CustomList getAvgTreeThickness() {

        int thicknessrad = 0, thicknessschreit = 0;
        CustomList customListAvgThickness = new CustomList();
        int cntradernter = 0;
        int cntschreiter = 0;

        if (!(customListHolzvollernert.isEmpty())) {
            CustomList.CustomListNode customListNode = customListHolzvollernert.getHead();

            while (customListNode != null) {
                Holzvollernter tmp = (Holzvollernter) customListHolzvollernert.getElement(customListNode
                        .getValue().getName());

                if (tmp.getArbeitskopf() instanceof HackschnitzelArbeitskopf) {
                    if (tmp instanceof Radernter) {
                        thicknessrad += tmp.getArbeitskopf().getConstraint().constraintValue.intValue();
                        cntradernter++;
                    } else if (tmp instanceof Schreiter) {
                        thicknessschreit += tmp.getArbeitskopf().getConstraint().constraintValue.intValue();
                        cntschreiter++;
                    }

                }

                customListNode = customListNode.getNext();
            }

            if(cntradernter == 0)
                cntradernter=1;
            if(cntschreiter == 0)
                cntschreiter=1;

            KeyValueListable keyValueListableRadernter = new KeyValueListable(Radernter.class.getName(), (double) (thicknessrad/cntradernter));
            KeyValueListable keyValueListableSchreiter = new KeyValueListable(Schreiter.class.getName(), (double) (thicknessschreit/cntschreiter));

            customListAvgThickness.insert(keyValueListableRadernter);
            customListAvgThickness.insert(keyValueListableSchreiter);

        }

        return customListAvgThickness;
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean containsHolzvollernter(Holzvollernter holzvollernter) {
        return customListHolzvollernert.contains(holzvollernter);
    }

    public boolean equals(Object e){

        if(!(e instanceof Forstbetrieb)){
            return false;
        }else if(this.name.equals(((Forstbetrieb) e).getName())){
            return true;
        }
        else
            return false;
    }
    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

}
