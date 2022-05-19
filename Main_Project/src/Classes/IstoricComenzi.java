package Classes;

import java.util.*;

public class IstoricComenzi {
    private List<Comanda> comenzi_premium;
    private  List<Comanda> comenzi_normale;

    public IstoricComenzi()
    {
        this.comenzi_normale=new ArrayList<>();
        this.comenzi_premium=new ArrayList<>();
    }

    public IstoricComenzi(List<Comanda> comenzi_premium, List<Comanda> comenzi_normale)
    {
        this.comenzi_normale=comenzi_normale;
        this.comenzi_premium=comenzi_premium;
    }

    public List<Comanda> getComenzi_normale() {
        return comenzi_normale;
    }

    public List<Comanda> getComenzi_premium() {
        return comenzi_premium;
    }

    public void setComenzi_normale(List<Comanda> comenzi_normale) {
        this.comenzi_normale = comenzi_normale;
    }

    public void setComenzi_premium(List<Comanda> comenzi_premium) {
        this.comenzi_premium = comenzi_premium;
    }

    @Override
    public String toString() {
        return "Istoric_Comenzi{" +
                "\ncomenzi_premium=" + comenzi_premium +
                ", \ncomenzi_normale=" + comenzi_normale +
                '}';
    }
}
