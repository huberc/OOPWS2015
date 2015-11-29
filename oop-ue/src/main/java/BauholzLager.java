import java.util.ArrayList;
import java.util.List;

public class BauholzLager {

    private List list = new ArrayList<>();

    public void add(RundholzGehobelt rundholzGehobelt){
        list.add(rundholzGehobelt);
    }

    public void add(RundholzSaegerauh rundholzSaegerauh){
        list.add(rundholzSaegerauh);
    }

    public void add(KantholzGehobelt kantholzGehobelt){
        list.add(kantholzGehobelt);
    }

    public void add(KantholzSaegerauh kantholzSaegerauh){
        list.add(kantholzSaegerauh);
    }

    public Bauholz get(){
        return null;
    }
    
    public void list(){
        
    }
    
    public void list(Dachstuhl d){
        
    }
    
    public void price(Dachstuhl d){
        
    }
    
}
