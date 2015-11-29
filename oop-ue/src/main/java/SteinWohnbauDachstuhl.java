import java.util.ArrayList;
import java.util.List;

public class SteinWohnbauDachstuhl extends Dachstuhl{

    private List<KantholzGehobelt> kantholzGehobeltList = new ArrayList<>();

    @Override
    public Bauholz get(BauholzLager bauholzLager) {
        return bauholzLager.get(this);
    }

    public void add(KantholzGehobelt kantholzGehobelt){
        this.kantholzGehobeltList.add(kantholzGehobelt);
    }
}
