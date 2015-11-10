

public class Brett extends Vollkantschnittholz implements Bauholz{

    public Brett(int laenge, int dicke, int breite) {
        super(laenge, dicke, breite);

        this.setEtikettierbar(false);

        if(dicke > 4 || dicke < 1)
            throw new IllegalArgumentException("Ein Brett muss mindestens 1 cm und darf maximal 4 cm dick sein\n");

        if(breite < 8)
            throw new IllegalArgumentException("Ein Brett darf nicht die Breite von 8 cm unterschreiten\n");
    }

}
