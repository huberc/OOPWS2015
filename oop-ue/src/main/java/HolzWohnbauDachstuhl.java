import java.util.ArrayList;
import java.util.List;

public class HolzWohnbauDachstuhl extends Dachstuhl{

    private List<RundholzGehobelt> gehobeltList = new ArrayList<>();

    @Override
    public Bauholz get(BauholzLager bauholzLager) {
        return bauholzLager.get(this);
    }

    @Override
    public List getList() {
        return gehobeltList;
    }

    public void add(RundholzGehobelt rundholzGehobelt){
        gehobeltList.add(rundholzGehobelt);
    }
}
