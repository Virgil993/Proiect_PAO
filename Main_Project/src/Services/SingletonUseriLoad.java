package Services;
import Classes.User;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import  java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class SingletonUseriLoad {

    private static SingletonUseriLoad sl;
    private List<User> lista_useri;

    private SingletonUseriLoad()
    {
        lista_useri = new ArrayList<>();
        try (var in = new BufferedReader(new FileReader("CSV_Files/Useri.csv")))
        {
            String linie = "";
            while((linie=in.readLine())!=null)
            {
                String [] fields = linie.split(",");
                User user_nou = new User(fields[0],fields[1],fields[2]);
                lista_useri.add(user_nou);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static SingletonUseriLoad getInstance()
    {
        if(null == sl)
        {
            sl = new SingletonUseriLoad();
        }
        return sl;
    }

    public List<User> getLista_useri() {
        return lista_useri;
    }
}
