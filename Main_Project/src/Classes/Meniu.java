package Classes;

import java.util.List;

public class Meniu {
    private List<Preparat> aperitive;
    private List<Preparat> felul_intai;
    private List<Preparat> main_course;
    private List<Preparat> desert;

    public Meniu(){}

    public Meniu(List<Preparat> aperitive,List<Preparat> felul_intai,List<Preparat> main_course,List<Preparat> desert)
    {
        this.aperitive=aperitive;
        this.desert=desert;
        this.felul_intai=felul_intai;
        this.main_course=main_course;
    }

    public List<Preparat> getAperitive() {
        return aperitive;
    }

    public List<Preparat> getFelul_intai() {
        return felul_intai;
    }

    public List<Preparat> getMain_course() {
        return main_course;
    }

    public List<Preparat> getDesert() {
        return desert;
    }

    public void setAperitive(List<Preparat> aperitive) {
        this.aperitive = aperitive;
    }

    public void setFelul_intai(List<Preparat> felul_intai) {
        this.felul_intai = felul_intai;
    }

    public void setMain_course(List<Preparat> main_course) {
        this.main_course = main_course;
    }

    public void setDesert(List<Preparat> desert) {
        this.desert = desert;
    }

    @Override
    public String toString() {
        return "Meniu{\n" +
                "aperitive=" + aperitive +
                ", \nfelul_intai=" + felul_intai +
                ", \nmain_course=" + main_course +
                ", \ndesert=" + desert +
                '}';
    }
}
