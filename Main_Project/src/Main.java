import Services.*;
import Classes.*;

import java.net.ConnectException;
import java.util.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        List<Local> lista_localuri = new ArrayList<>();
        List<User> lista_useri =new ArrayList<>();
        List<Sofer> lista_soferi=new ArrayList<>();

        lista_useri = CRUDOperationsUser.LoadUsersFromDataBase();
        lista_soferi = CRUDOperatiosSofer.LoadSoferFromDataBase();
        lista_localuri=CRUDOperationsLocalPreparat.LoadLocalsFromDataBase();


        SingletonWriteAudit sl_audit = SingletonWriteAudit.getInstance();


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
            System.out.println("Apasti 7 pentru a adauga un preparat");
            System.out.println("Apasti 8 pentru a modifica pretul unui preparat");
            System.out.println("Apasti 9 pentru a sterge un preparat");
            System.out.println("Apasti 10 pentru a adauga un local");
            System.out.println("Apasti 11 pentru a modifica un local");
            System.out.println("Apasti 12 pentru a sterge un local");
            System.out.println("Apasti 13 pentru a adauga o recenzie");
            System.out.println("Apasti 14 pentru a afisa meniul unui local");
            System.out.println("Apasti 15 pentru a adauga o comanda");
            System.out.println("Apasti 16 pentru a afisa istoricul comenzilor unui user");

            int com = sc.nextInt();
            switch (com) {
                case 1: {
                    lista_useri=Services.Adauga_User();
                    System.out.println(lista_useri);
                    sl_audit.WriteAudit("Adauga_User");
                    break;
                }
                case 2: {
                    lista_useri=Services.Modifica_User(lista_useri);
                    System.out.println(lista_useri);
                    sl_audit.WriteAudit("Modifica_User");
                    break;
                }
                case 3: {
                    lista_useri=Services.Sterge_User(lista_useri);
                    System.out.println(lista_useri);
                    sl_audit.WriteAudit("Sterge_User");
                    break;
                }
                case 4:
                {
                    lista_soferi=Services.Adauga_Sofer();
                    System.out.println(lista_soferi);
                    sl_audit.WriteAudit("Adauga_Sofer");
                    break;
                }
                case 5:
                {
                    lista_soferi=Services.Modifica_Sofer(lista_soferi);
                    System.out.println(lista_soferi);
                    sl_audit.WriteAudit("Modifica_Sofer");
                    break;
                }
                case 6:
                {
                    lista_soferi=Services.Sterge_Sofer(lista_soferi);
                    System.out.println(lista_soferi);
                    sl_audit.WriteAudit("Sterge_Sofer");
                    break;
                }
                case 7:
                {
                    lista_localuri=Services.AdaugaPreparat(lista_localuri);
                    System.out.println(lista_localuri);
                    sl_audit.WriteAudit("Adauga_Preparat");
                    break;
                }
                case 8:
                {
                    lista_localuri=Services.ModificaPretulUnuiPreparat(lista_localuri);
                    System.out.println(lista_localuri);
                    sl_audit.WriteAudit("Modifica_Pretul_Unui_Preparat");
                    break;
                }
                case 9:
                {
                    lista_localuri=Services.StergePreparat(lista_localuri);
                    System.out.println(lista_localuri);
                    sl_audit.WriteAudit("Sterge_Preparat");
                    break;
                }
                case 10:
                {
                    lista_localuri=Services.AdaugaLocal();
                    System.out.println(lista_localuri);
                    sl_audit.WriteAudit("Adauga_Local");
                    break;
                }
                case 11:
                {
                    lista_localuri=Services.ModificaLocal(lista_localuri);
                    System.out.println(lista_localuri);
                    sl_audit.WriteAudit("Modifica_Local");
                    break;
                }
                case 12:
                {
                    lista_localuri=Services.StergeLocal(lista_localuri);
                    System.out.println(lista_localuri);
                    sl_audit.WriteAudit("Sterge_Local");
                    break;
                }
                case 13:
                {
                    Services.Adauga_Recenzie(lista_useri,lista_localuri);
                    System.out.println(lista_localuri);
                    sl_audit.WriteAudit("Adauga_Recenzie");
                    break;
                }
                case 14:
                {
                    Services.Afiseaza_Meniul_unui_local(lista_localuri);
                    sl_audit.WriteAudit("Afiseaza_Meniul_unui_local");
                    break;
                }
                case 15:
                {
                    Services.Adauga_Comanda(lista_useri,lista_localuri);
                    System.out.println(lista_useri);
                    sl_audit.WriteAudit("Adauga_Comanda");
                    break;
                }
                case 16:
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
