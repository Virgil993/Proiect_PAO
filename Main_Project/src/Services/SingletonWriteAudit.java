package Services;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.List;


public class SingletonWriteAudit {

    private static SingletonWriteAudit sl;

    private SingletonWriteAudit()
    {

    }

    public static SingletonWriteAudit getInstance()
    {
        if(null==sl)
        {
            sl=new SingletonWriteAudit();
        }
        return sl;
    }

    public void WriteAudit(String nume_actiune)
    {
        try(FileInputStream in = new FileInputStream("CSV_Files/Audit.csv");
            FileOutputStream out = new FileOutputStream("CSV_Files/Audit.csv")) {

            int c;
            while( (c = in.read()) != -1) {
                out.write(c);
            }
            try(Writer w =  new FileWriter("CSV_Files/Audit.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(w)){
                LocalDateTime now = LocalDateTime.now();
                bufferedWriter.write(nume_actiune+","+now.toString()+"\n");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
