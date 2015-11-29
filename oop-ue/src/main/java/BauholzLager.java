import java.util.ArrayList;
import java.util.List;

public class BauholzLager {

    private List<RundholzGehobelt>  listRundholzGehobelt  = new ArrayList<>();
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
        KantholzGehobelt kantholzGehobelt = listKantholzGehobelt.get(0);
        if (kantholzGehobelt != null) {
            listKantholzGehobelt.remove(kantholzGehobelt);
        }

        steinWohnbauDachstuhl.add(kantholzGehobelt);
        return kantholzGehobelt;
    }

    public Kantholz get(SteinNutzbauDachstuhl steinNutzbauDachstuhl) {
        Kantholz kantholz = listKantholzSaegerauh.get(0);
        if (kantholz == null) {
            kantholz = listKantholzGehobelt.get(0);
            if (kantholz != null) {
                listKantholzGehobelt.remove(kantholz);
            }
        } else {
            listKantholzSaegerauh.remove(0);
        }
        steinNutzbauDachstuhl.add(kantholz);
        return kantholz;
    }

    public RundholzGehobelt get(HolzWohnbauDachstuhl holzWohnbauDachstuhl) {
        RundholzGehobelt rundholzGehobelt = listRundholzGehobelt.get(0);
        if (rundholzGehobelt != null) {
            listRundholzGehobelt.remove(rundholzGehobelt);
        }
        holzWohnbauDachstuhl.add(rundholzGehobelt);
        return rundholzGehobelt;
    }

    public Rundholz get(HolzNutzbauDachstuhl holzNutzbauDachstuhl) {
        Rundholz rundholz = listRundholzSaegerauh.get(0);
        if (rundholz == null) {
            rundholz = listRundholzGehobelt.get(0);
            if (rundholz != null) {
                listRundholzGehobelt.remove(rundholz);
            }
        } else {
            listRundholzSaegerauh.remove(rundholz);
        }

        holzNutzbauDachstuhl.add(rundholz);
        return rundholz;
    }

    public void list() {
        System.out.println("RundholzGehobelt:");
        for (RundholzGehobelt h : this.listRundholzGehobelt) {
            System.out.println("\t" + h.getLaenge());
        }
        System.out.println("RundholzSaegerauh:");
        for (RundholzSaegerauh h : this.listRundholzSaegerauh) {
            System.out.println("\t" + h.getLaenge());
        }
        System.out.println("KantholzGehobelt:");
        for (KantholzGehobelt h : this.listKantholzGehobelt) {
            System.out.println("\t" + h.getLaenge());
        }
        System.out.println("KantholzSaegerauh:");
        for (KantholzSaegerauh h : this.listKantholzSaegerauh) {
            System.out.println("\t" + h.getLaenge());
        }
    }
    
    public void list(Dachstuhl d){
        System.out.println("Fuer "+d.getClass().getSimpleName()+":");
        List<? extends Bauholz> list = d.getHolz();

        for(Bauholz b : list){
            System.out.println("\t"+b.getLaenge());
        }
    }

    public void price(Dachstuhl d) {
        int price = 0;
        for (Bauholz h : d.getHolz()) {
            price += h.getPreis();
        }
        System.out.println("Dachstuhl " + d.getClass().getSimpleName() + " kostet: ");
    }

}
