package Services;

import Classes.Sofer;
import Classes.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class SingletonWriteSofer {

    private static SingletonWriteSofer sl;

    private SingletonWriteSofer()
    {

    }

    public static SingletonWriteSofer getInstance()
    {
        if(null == sl)
        {
            sl = new SingletonWriteSofer();
        }

        return sl;
    }

    public void writeSofer(List<Sofer> lista_soferi)
    {
        try(Writer w = new FileWriter("CSV_Files/Soferi.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(w)){

            for(int i=0;i<lista_soferi.size();i++)
            {
                Sofer sofer_curent = lista_soferi.get(i);
                bufferedWriter.write(sofer_curent.getNume()+","+sofer_curent.getAdresa()+","+sofer_curent.getNumar_telefon()+","+sofer_curent.getMasina()+","+sofer_curent.getSalariu()+","+sofer_curent.getRating()+"\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
