import Services.Services;
import Classes.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);


        //useri
        User u1=new User("Manolache Mihai","Strada Cirstea Mateescu 70","0745777345");
        User u2= new User("Ionita Robert","Strada Teiul Doamnei 45","0798345876");
        User u3= new User("Stefanescu Bogdan","Strada Grigore Ionescu 25","0783879123");

        //soferi
        Sofer s1 = new Sofer("Theodora Thomescu","Strada Masina de Paine 56","0345679230","Skoda Octavia 2007",2100.0,5);
        Sofer s2 = new Sofer("Radu Popescu","Strada Berindei 54","0327651239","Dacia Logan 2012",2100.0,4);
        Sofer s3 = new Sofer("Octavian Ilie","Strada Florilor 32","0956784358","BMW Seria S 2017",2100.0,4);

       //meniu  local
        List<Preparat> d11=new ArrayList<>();
        List<Preparat> d12=new ArrayList<>();
        List<Preparat> d13=new ArrayList<>();
        List<Preparat> d14=new ArrayList<>();

        //d11 preparate

        String[] d111ia = {"bocconcini","rosii","ulei de masline","oregano","busuioc"};
        Vector<String> d111i = new Vector<>(Arrays.asList(d111ia));
        Preparat d111=new Preparat("Caprese",23.0,d111i);

        String[] d112ia = {"bagheta prajita","mozzarela","usturoi","oregano","ulei de masline"};
        Vector<String> d112i = new Vector<>(Arrays.asList(d112ia));
        Preparat d112 =  new Preparat("Crostini",17.0,d112i);

        String[] d121ia = {"salata verde","rosii","castraveti","ardei grasi","ceapa"};
        Vector<String> d121i=new Vector<>(Arrays.asList(d121ia));
        Preparat d121 = new Preparat("Salata asortata",15.0,d121i);

        String[] d122ia = {"rucola","rosii cherry","bocconcini","ulei de masline","busuioc proaspat"};
        Vector<String> d122i =  new Vector<>(Arrays.asList(d122ia));
        Preparat d122 = new Preparat("Salata rucola",30.0,d122i);

        String[] d131ia = {"tortellini","suna","sos roze","ciuperci","usturoi","mozzarella","parmezan","parmezan","gratinate"};
        Vector<String> d131i = new Vector<>(Arrays.asList(d131ia));
        Preparat d131 = new Preparat("Tortellini al Forno",36.0,d131i);

        String[] d132ia = {"sos de rosii","mozzarella","sunca","masline","ciuperci"};
        Vector<String> d132i = new Vector<>(Arrays.asList(d132ia));
        Preparat d132 = new Preparat("Pizza Capriciosa",38.0,d132i);

        String[] d141ia = {"blat crocant","crema de vanilie","mere coapte si caramelizate","scortisoara"};
        Vector<String> d141i = new Vector<>(Arrays.asList(d141ia));
        Preparat d141 = new Preparat("Tarta cu mere",23.0,d141i);

        String[] d142ia = {"blat de ciocolata","crema mascarpone","ganache de ciocolata"};
        Vector<String> d142i = new Vector<>(Arrays.asList(d142ia));
        Preparat d142 = new Preparat("Tort de ciocolata",23.0,d142i);

        d11.add(d111);
        d11.add(d112);
        d12.add(d121);
        d12.add(d122);
        d13.add(d131);
        d13.add(d132);
        d14.add(d141);
        d14.add(d142);

        Meniu d1=new Meniu(d11,d12,d13,d14);

        Local l1 = new Local("Sabatini",d1,"Strada Teiul Doamnei 15,Bucuresti","0770 227 880");

        List<Local> lista_localuri = new ArrayList<>();
        List<User> lista_useri =new ArrayList<>();
        List<Sofer> lista_soferi=new ArrayList<>();

        lista_localuri.add(l1);

        lista_useri.add(u1);
        lista_useri.add(u2);
        lista_useri.add(u3);
        lista_useri.add(s1);
        lista_useri.add(s2);
        lista_useri.add(s3);

        lista_soferi.add(s1);
        lista_soferi.add(s2);
        lista_soferi.add(s3);

        //Services.Adauga_User(lista_useri);
        //Services.Modifica_User(lista_useri);
        //Services.Sterge_User(lista_useri);
        //Services.Adauga_Sofer(lista_soferi,lista_useri);
        //Services.Sterge_Sofer(lista_soferi,lista_useri);
        // Services.Modifica_Sofer(lista_soferi,lista_useri);
        //Services.Adauga_Recenzie(lista_useri,lista_localuri);
        //Services.Afiseaza_Meniul_unui_local(lista_localuri);
        //Services.Adauga_Comanda(lista_useri,lista_localuri);
        //Services.Afiseaza_Istoricul_Comenzilor_unui_User(lista_useri);


    }
}
