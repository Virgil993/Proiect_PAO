package Classes;

import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private String nume_local;
    private Double pret_total;
    private List<Preparat> preparate;
    private String data;

    public Comanda(){
        this.preparate=new ArrayList<>();
    }

    public Comanda(String nume_local,List<Preparat> preparate,String data)
    {
        this.data=data;
        this.nume_local=nume_local;
        this.preparate=preparate;
        this.pret_total=0.0;
        for(Preparat p:preparate)
            this.pret_total=this.pret_total+p.getPret();
    }

    public String getNume_local() {
        return nume_local;
    }

    public Double getPret_total() {
        return pret_total;
    }

    public List<Preparat> getPreparate() {
        return preparate;
    }

    public String getData() {
        return data;
    }

    public void setNume_local(String nume_local) {
        this.nume_local = nume_local;
    }

    public void setPret_total(Double pret_total) {
        this.pret_total = pret_total;
    }

    public void setPreparate(List<Preparat> preparate) {
        this.preparate = preparate;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "\nComanda{" +
                "nume_local='" + nume_local + '\'' +
                ", pret_total=" + pret_total +
                ", preparate=" + preparate +
                ", data='" + data + '\'' +
                '}';
    }
}
