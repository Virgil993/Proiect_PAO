package Classes;

public class Sofer extends User{

    private String masina;
    private Double salariu;
    private Integer rating;

    public Sofer(){}

    public Sofer(String nume,String adresa,String numar_telefon,String masina,Double salariu,Integer rating)
    {
        super(nume,adresa,numar_telefon);
        this.masina=masina;
        this.salariu=salariu;
        this.rating=rating;
    }

    public String getMasina() {
        return masina;
    }

    public Double getSalariu() {
        return salariu;
    }

    public Integer getRating() {
        return rating;
    }

    public void setMasina(String masina) {
        this.masina = masina;
    }

    public void setSalariu(Double salariu) {
        this.salariu = salariu;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "\nSofer{" + "nume='" + this.getNume() + '\'' +
                ", adresa='" + this.getAdresa() + '\'' +
                ", numar_telefon='" + this.getAdresa() + '\'' +
                ", istoric_comenzi=" + this.getIstoric_comenzi() +", "+
                "masina='" + masina + '\'' +
                ", salariu=" + salariu +
                ", rating=" + rating +
                '}';
    }
}
