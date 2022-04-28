package Services;

import Classes.Sofer;
import Classes.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import  java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
public class SingletonSoferiLoad {

    private static SingletonSoferiLoad sl;
    private List<Sofer> lista_soferi;

    private SingletonSoferiLoad(List<User> lista_useri)
    {
        lista_soferi=new ArrayList<>();
        try(var in = new BufferedReader(new FileReader("CSV_Files/Soferi.csv"))){
            String linie  = "";
            while ((linie = in.readLine())!=null)
            {
                String [] fields = linie.split(",");
                Sofer sofer_nou = new Sofer(fields[0],fields[1],fields[2],fields[3],Double.parseDouble(fields[4]),Integer.parseInt(fields[5]));
                lista_useri.add(sofer_nou);
                lista_soferi.add(sofer_nou);
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public static SingletonSoferiLoad getInstance(List<User> lista_useri)
    {
        if(null==sl)
        {
            sl = new SingletonSoferiLoad(lista_useri);
        }
        return sl;
    }

    public List<Sofer> getLista_soferi() {
        return lista_soferi;
    }
}
