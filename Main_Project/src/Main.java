import Services.*;
import Classes.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        List<Local> lista_localuri = new ArrayList<>();
        List<User> lista_useri =new ArrayList<>();
        List<Sofer> lista_soferi=new ArrayList<>();

        SingletonPreparateLocaluriLoad sl_local = SingletonPreparateLocaluriLoad.getInstance();
        SingletonUseriLoad sl_useri = SingletonUseriLoad.getInstance();
        SingletonSoferiLoad sl_soferi = SingletonSoferiLoad.getInstance(lista_useri);
        SingletonWriteAudit sl_audit = SingletonWriteAudit.getInstance();

        lista_localuri = sl_local.getLista_localuri();
        lista_useri = sl_useri.getLista_useri();
        lista_soferi = sl_soferi.getLista_soferi();


        int breaker = 1;
        while(breaker==1)
        {
            System.out.println("\nApasti 0 pentru a iesi din acest meniu");
            System.out.println("Apasti 1 pentru a adauga un user");
            System.out.println("Apasti 2 pentru a modifica un user");
            System.out.println("Apasti 3 pentru a sterge un user");
            System.out.println("Apasti 4 pentru a adauga un sofer");
            System.out.println("Apasti 5 pentru a modifica un sofer");
            System.out.println("Apasti 6 pentru a sterge un sofer");
            System.out.println("Apasti 7 pentru a adauga o recenzie");
            System.out.println("Apasti 8 pentru a afisa meniul unui local");
            System.out.println("Apasti 9 pentru a adauga o comanda");
            System.out.println("Apasti 10 pentru a afisa istoricul comenzilor unui user");

            int com = sc.nextInt();
            switch (com) {
                case 1: {
                    Services.Adauga_User(lista_useri);
                    sl_audit.WriteAudit("Adauga_User");
                    break;
                }
                case 2: {
                    Services.Modifica_User(lista_useri);
                    sl_audit.WriteAudit("Modifica_User");
                    break;
                }
                case 3: {
                    Services.Sterge_User(lista_useri);
                    sl_audit.WriteAudit("Sterge_User");
                    break;
                }
                case 4:
                {
                    Services.Adauga_Sofer(lista_soferi,lista_useri);
                    sl_audit.WriteAudit("Adauga_Sofer");
                    break;
                }
                case 5:
                {
                    Services.Modifica_Sofer(lista_soferi,lista_useri);
                    sl_audit.WriteAudit("Modifica_Sofer");
                    break;
                }
                case 6:
                {
                    Services.Sterge_Sofer(lista_soferi,lista_useri);
                    sl_audit.WriteAudit("Sterge_Sofer");
                    break;
                }
                case 7:
                {
                    Services.Adauga_Recenzie(lista_useri,lista_localuri);
                    sl_audit.WriteAudit("Adauga_Recenzie");
                    break;
                }
                case 8:
                {
                    Services.Afiseaza_Meniul_unui_local(lista_localuri);
                    sl_audit.WriteAudit("Afiseaza_Meniul_unui_local");
                    break;
                }
                case 9:
                {
                    Services.Adauga_Comanda(lista_useri,lista_localuri);
                    sl_audit.WriteAudit("Adauga_Comanda");
                    break;
                }
                case 10:
                {
                    Services.Afiseaza_Istoricul_Comenzilor_unui_User(lista_useri);
                    sl_audit.WriteAudit("Afiseaza_Istoricul_Comenzilor_unui_User");
                    break;
                }
                default:
                {
                    breaker = 0;
                    break;
                }

            }

        }

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
