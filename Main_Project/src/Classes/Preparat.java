package Classes;

import java.util.Vector;

public class Preparat {
    private String nume;
    private Double pret;
    private Vector<String> ingrediente;

    public Preparat(){}

    public Preparat(String nume,Double Pret,Vector<String> ingrediente)
    {
        this.nume=nume;
        this.pret=Pret;
        this.ingrediente = new Vector<String>(ingrediente);
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

    public void setIngrediente(Vector<String> ingrediente) {
        this.ingrediente = ingrediente;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Preparat {" +
                "nume='" + nume + '\'' +
                ", pret=" + pret +
                ", ingrediente=" + ingrediente +
                '}';
    }
}
