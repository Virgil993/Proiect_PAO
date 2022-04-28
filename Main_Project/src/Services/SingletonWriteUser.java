package Services;

import Classes.User;

import java.io.*;

import java.util.List;

public class SingletonWriteUser {

    private static SingletonWriteUser sl;

    private SingletonWriteUser()
    {

    }

    public static SingletonWriteUser getInstance()
    {
        if(null == sl)
        {
            sl = new SingletonWriteUser();
        }

        return sl;
    }

    public void writeUser(List<User> lista_useri)
    {
        try(Writer w = new FileWriter("CSV_Files/Useri.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(w)){

            for(int i=0;i<lista_useri.size();i++)
            {
                User user_curent = lista_useri.get(i);
                bufferedWriter.write(user_curent.getNume()+","+user_curent.getAdresa()+","+user_curent.getNumar_telefon()+"\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
