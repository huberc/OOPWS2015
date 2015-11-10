

public class Brett extends Vollkantschnittholz implements Bauholz{

    public Brett(int laenge, int dicke, int breite) {
        super(laenge, dicke, breite);

        if(dicke > 4 || dicke < 1)
            throw new IllegalArgumentException("Ein Brett muss mindestens 1 cm und darf maximal 4 cm dick sein\n");

        if(breite < 8)
            throw new IllegalArgumentException("Ein Brett darf nicht die Breite von 8 cm unterschreiten\n");
    }

    @Override
    public String toString() {
        return "\tBrett{\n" +
                "\t\tLaenge:\t\t"+this.laenge()+
                "\n\t\tDicke:\t\t"+this.getDicke()+
                "\n\t\tBreite:\t\t"+this.getBreite()+"\n}";
    }
}
