import java.util.ArrayList;
import java.util.List;

public class SteinNutzbauDachstuhl extends Dachstuhl{

    private List<Kantholz> kantholz = new ArrayList<>();

    @Override
    public Bauholz get(BauholzLager bauholzLager) {
        return bauholzLager.get(this);
    }

    public void add(Kantholz kantholz){
        this.kantholz.add(kantholz);
    }
}
