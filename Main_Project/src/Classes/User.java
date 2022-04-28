package Classes;

import java.util.Objects;

public class User {
    private String nume;
    private String adresa;
    private String numar_telefon;
    private IstoricComenzi istoric_comenzi;

    public User(){}

    public User(String nume,String adresa,String numar_telefon)
    {
        this.nume=nume;
        this.adresa=adresa;
        this.numar_telefon=numar_telefon;
        this.istoric_comenzi=new IstoricComenzi();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getNume().equals(user.getNume()) && getAdresa().equals(user.getAdresa()) && getNumar_telefon().equals(user.getNumar_telefon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNume(), getAdresa(), getNumar_telefon(), getIstoric_comenzi());
    }

    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getNumar_telefon() {
        return numar_telefon;
    }

    public IstoricComenzi getIstoric_comenzi() {
        return istoric_comenzi;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setNumar_telefon(String numar_telefon) {
        this.numar_telefon = numar_telefon;
    }

    public void setIstoric_comenzi(IstoricComenzi istoric_comenzi) {
        this.istoric_comenzi = istoric_comenzi;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", numar_telefon='" + numar_telefon + '\'' +
                ", istoric_comenzi=" + istoric_comenzi +
                '}';
    }
}
