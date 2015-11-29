import java.util.ArrayList;
import java.util.List;

public class HolzNutzbauDachstuhl extends Dachstuhl{

    private List<Rundholz> saegerauhList = new ArrayList<>();

    @Override
    public Bauholz get(BauholzLager bauholzLager) {
        return bauholzLager.get(this);
    }

    public void add(Rundholz rundholz){
        saegerauhList.add(rundholz);
    }
}
