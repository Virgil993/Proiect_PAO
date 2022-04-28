package Classes;

import java.util.*;

public class Local {
    private String nume;
    private Meniu meniu;
    private SortedSet<Recenzie> lista_recenzii;
    private String adresa;
    private String numar_telefon;

    public Local(){}

    public Local(String nume,Meniu meniu,String adresa,String numar_telefon){
        this.nume=nume;
        this.meniu=meniu;
        this.adresa=adresa;
        this.numar_telefon=numar_telefon;
        this.lista_recenzii = new TreeSet<Recenzie>(Comparator.comparing(Recenzie::getNumber_of_stars));
    }

    public String getNume() {
        return nume;
    }

    public Meniu getMeniu() {
        return meniu;
    }

    public SortedSet<Recenzie> getLista_recenzii() {
        return lista_recenzii;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getNumar_telefon() {
        return numar_telefon;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setLista_recenzii(SortedSet<Recenzie> lista_recenzii) {
        this.lista_recenzii = lista_recenzii;
    }

    public void setMeniu(Meniu meniu) {
        this.meniu = meniu;
    }

    public void setNumar_telefon(String numar_telefon) {
        this.numar_telefon = numar_telefon;
    }

    @Override
    public String toString() {
        return "Local{" +
                "nume='" + nume + '\'' +
                ", meniu=" + meniu +
                ", \nlista_recenzii=" + lista_recenzii +
                ", adresa='" + adresa + '\'' +
                ", numar_telefon='" + numar_telefon + '\'' +
                '}';
    }
}
