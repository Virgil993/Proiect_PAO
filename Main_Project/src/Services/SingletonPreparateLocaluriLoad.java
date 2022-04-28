package Services;
import Classes.Local;
import Classes.Meniu;
import Classes.Preparat;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import  java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class SingletonPreparateLocaluriLoad {

        private static SingletonPreparateLocaluriLoad sl;
        private List<Local> lista_localuri;

        private SingletonPreparateLocaluriLoad()
        {
            lista_localuri=new ArrayList<>();
            List<Preparat> lista_prep_totala = new ArrayList<>();
            try (var in = new BufferedReader(new FileReader("CSV_Files/Preparate.csv"))){
                String linie = "";
                while((linie=in.readLine())!=null)
                {
                    String [] fields = linie.split(",");
                    Vector<String> ingrediente = new Vector<String>(Arrays.asList(((fields[2].split(" ")))));
                    Preparat prep_nou = new Preparat(fields[0],Double.parseDouble(fields[1]),ingrediente);
                    lista_prep_totala.add(prep_nou);
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
            Integer idx = 0;
            try (var in = new BufferedReader(new FileReader("CSV_Files/Localuri.csv"))){
                String linie = "";
                Integer idx2;
                while((linie=in.readLine())!=null){
                    String [] fields = linie.split(",");
                    List<Preparat> aperitive = new ArrayList<>();
                    List<Preparat> felul_1 = new ArrayList<>();
                    List<Preparat> felul_2 = new ArrayList<>();
                    List<Preparat> desert = new ArrayList<>();
                    for(idx2 = idx;idx2<=idx+7;idx2++)
                    {
                        if(idx2%8 == 0 || idx2%8==1)
                            aperitive.add(lista_prep_totala.get(idx2));
                        if(idx2%8 == 2 || idx2%8==3)
                            felul_1.add(lista_prep_totala.get(idx2));
                        if(idx2%8 == 4|| idx2%8==5)
                            felul_2.add(lista_prep_totala.get(idx2));
                        if(idx2%8 == 6 || idx2%8 == 7)
                            desert.add(lista_prep_totala.get(idx2));
                    }
                    Meniu meniu_nou = new Meniu(aperitive,felul_1,felul_2,desert);
                    Local local_nou = new Local(fields[0],meniu_nou,fields[1],fields[2]);
                    lista_localuri.add(local_nou);
                    idx=idx2;
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }

        }

        public static SingletonPreparateLocaluriLoad getInstance()
        {
            if(null == sl)
            {
                sl = new SingletonPreparateLocaluriLoad();
            }

            return sl;
        }

    public List<Local> getLista_localuri() {
        return lista_localuri;
    }
}
