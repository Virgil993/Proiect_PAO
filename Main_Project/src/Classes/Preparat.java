package Classes;

import java.util.Vector;

public class Preparat {
    private Integer id;
    private String nume;
    private Double pret;
    private Vector<String> ingrediente;
    private Integer local_id;
    private Integer tip_meniu;


    public Preparat(){}

    public Preparat(Integer id,String nume,Double Pret,Vector<String> ingrediente,Integer local_id,Integer tip_meniu)
    {
        this.tip_meniu=tip_meniu;
        this.id = id;
        this.nume=nume;
        this.pret=Pret;
        this.ingrediente = new Vector<String>(ingrediente);
        this.local_id=local_id;
    }

    public Preparat(String nume,Double Pret,Vector<String> ingrediente)
    {
        this.nume=nume;
        this.pret=Pret;
        this.ingrediente = new Vector<String>(ingrediente);
    }

    public Integer getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public Double getPret() {
        return pret;
    }

    public Vector<String> getIngrediente() {
        return ingrediente;
    }

    public Integer getLocal_id() {
        return local_id;
    }

    public Integer getTip_meniu() {
        return tip_meniu;
    }

    public void setIngrediente(Vector<String> ingrediente) {
        this.ingrediente = ingrediente;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public void setLocal_id(Integer local_id) {
        this.local_id = local_id;
    }

    @Override
    public String toString() {
        return "Preparat{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", pret=" + pret +
                ", ingrediente=" + ingrediente +
                ", local_id=" + local_id +
                '}';
    }
}
