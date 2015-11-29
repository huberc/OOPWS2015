import java.util.ArrayList;
import java.util.List;

public class BauholzLager {

    private List<RundholzGehobelt> listRundholzGehobelt = new ArrayList<>();
    private List<RundholzSaegerauh> listRundholzSaegerauh = new ArrayList<>();
    private List<KantholzGehobelt> listKantholzGehobelt = new ArrayList<>();
    private List<KantholzSaegerauh> listKantholzSaegerauh = new ArrayList<>();

    public void add(Bauholz bauholz) {
        bauholz.add(this);
    }

    public void add(RundholzGehobelt rundholzGehobelt) {
        listRundholzGehobelt.add(rundholzGehobelt);
    }

    public void add(RundholzSaegerauh rundholzSaegerauh) {
        listRundholzSaegerauh.add(rundholzSaegerauh);
    }

    public void add(KantholzGehobelt kantholzGehobelt) {
        listKantholzGehobelt.add(kantholzGehobelt);
    }

    public void add(KantholzSaegerauh kantholzSaegerauh) {
        listKantholzSaegerauh.add(kantholzSaegerauh);
    }

    public Bauholz get(Dachstuhl dachstuhl) {

        return dachstuhl.get(this);
    }

    public KantholzGehobelt get(SteinWohnbauDachstuhl steinWohnbauDachstuhl) {

        KantholzGehobelt kantholzGehobelt=null;

        if(!(listKantholzGehobelt.isEmpty())) {
            kantholzGehobelt = listKantholzGehobelt.get(0);
            listKantholzGehobelt.remove(kantholzGehobelt);
            steinWohnbauDachstuhl.add(kantholzGehobelt);
        }
        return kantholzGehobelt;
    }

    public Kantholz get(SteinNutzbauDachstuhl steinNutzbauDachstuhl) {
        Kantholz kantholz =null;
        if(!(listKantholzSaegerauh.isEmpty())) {
            kantholz = listKantholzSaegerauh.get(0);
            listKantholzSaegerauh.remove(kantholz);
            steinNutzbauDachstuhl.add(kantholz);
        }else if(!(listKantholzGehobelt.isEmpty())){
            kantholz = listKantholzGehobelt.get(0);
            listKantholzGehobelt.remove(kantholz);
            steinNutzbauDachstuhl.add(kantholz);
        }
        return kantholz;
    }

    public RundholzGehobelt get(HolzWohnbauDachstuhl holzWohnbauDachstuhl) {
        RundholzGehobelt rundholzGehobelt =null;
        if(!(listRundholzGehobelt.isEmpty())) {
            rundholzGehobelt = listRundholzGehobelt.get(0);
            listRundholzGehobelt.remove(rundholzGehobelt);
            holzWohnbauDachstuhl.add(rundholzGehobelt);
        }
        return rundholzGehobelt;
    }

    //SIDE EFFECT
    public Rundholz get(HolzNutzbauDachstuhl holzNutzbauDachstuhl) {
        Rundholz rundholz = null;
        if(!(listRundholzSaegerauh.isEmpty())){
            rundholz = listRundholzSaegerauh.get(0);
            listRundholzSaegerauh.remove(rundholz);
            holzNutzbauDachstuhl.add(rundholz);
        }else if(!(listRundholzGehobelt.isEmpty())){
            rundholz = listRundholzGehobelt.get(0);
            listRundholzGehobelt.remove(rundholz);
            holzNutzbauDachstuhl.add(rundholz);
        }

        return rundholz;
    }

    public void list() {
        System.out.println("\tRundholzGehobelt:");
        for (RundholzGehobelt h : this.listRundholzGehobelt) {
            System.out.println("\t\t" + h.getLaenge());
        }
        System.out.println("\tRundholzSaegerauh:");
        for (RundholzSaegerauh h : this.listRundholzSaegerauh) {
            System.out.println("\t\t" + h.getLaenge());
        }
        System.out.println("\tKantholzGehobelt:");
        for (KantholzGehobelt h : this.listKantholzGehobelt) {
            System.out.println("\t\t" + h.getLaenge());
        }
        System.out.println("\tKantholzSaegerauh:");
        for (KantholzSaegerauh h : this.listKantholzSaegerauh) {
            System.out.println("\t\t" + h.getLaenge());
        }
    }

    public void list(Dachstuhl d) {
        System.out.println("\tFuer " + d.getClass().getSimpleName() + ":");

        for (Bauholz b : d.getHolz()) {
            System.out.println("\t\t" + b.getLaenge());
        }
    }

    public void price(Dachstuhl d) {
        int price = 0;
        for (Bauholz h : d.getHolz()) {
            price += h.getPreis();
        }
        System.out.println("\tDachstuhl " + d.getClass().getSimpleName() + " kostet: ");
    }

}
