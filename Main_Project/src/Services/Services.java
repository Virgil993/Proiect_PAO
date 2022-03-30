package Services;


import Classes.*;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Scanner;

public class Services {

    public static Scanner sc=new Scanner(System.in);
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public static void Adauga_User(List<User> lista_useri)
    {
        System.out.println("\nNumele userului = ");
        String nume = sc.nextLine();
        System.out.println("\nNmarul de telefon al userului = ");
        String numar_de_telefon = sc.nextLine();
        System.out.println("\nAdresa userului este = ");
        String adresa = sc.nextLine();

        User nou = new User(nume,adresa,numar_de_telefon);

        lista_useri.add(nou);

        System.out.println("\n"+lista_useri);
    }

    public static void Sterge_User(List<User> lista_useri)
    {
        System.out.println("\nAlege dupa indice din urmatorii useri pe care doresti sa il stergi:");
        for(int i=0;i<lista_useri.size();i++)
        {
            System.out.println("\n "+(i+1)+" = "+lista_useri.get(i));
        }
        System.out.println("\nIndexul ales = ");
        int i = sc.nextInt();
        i--;

        lista_useri.remove(i);

        System.out.println("\n"+lista_useri);
    }

    public static void Modifica_User(List<User> lista_useri)
    {
        System.out.println("\nAlege dupa indice din urmatorii useri pe care doresti sa il modifici:");
        for(int i=0;i<lista_useri.size();i++)
        {
            System.out.println("\n "+(i+1)+" = "+lista_useri.get(i));
        }
        System.out.println("\nIndexul ales = ");
        int indice1 = sc.nextInt();
        indice1--;

        System.out.println("\nAlege dupa indice ce doresti sa modifici la user:");
        System.out.println("\n1 = nume");
        System.out.println("\n2 = adresa");
        System.out.println("\n3 = numar de telefon");

        int indice2 = sc.nextInt();

        if(indice2 == 1)
        {
            System.out.println("\nIntroduceti numele nou");
            sc.nextLine();
            String nume = sc.nextLine();
            lista_useri.get(indice1).setNume(nume);
        }
        if(indice2 == 2)
        {
            System.out.println("\nIntroduceti adresa noua");
            sc.nextLine();
            String adresa = sc.nextLine();
            lista_useri.get(indice1).setAdresa(adresa);
        }
        if(indice2== 3)
        {
            System.out.println("\nIntroduceti numarul de telefon nou");
            sc.nextLine();
            String numar = sc.nextLine();
            lista_useri.get(indice1).setNumar_telefon(numar);
        }

        System.out.println(lista_useri);
    }

    public static void Adauga_Sofer(List<Sofer> lisa_soferi,List<User> lista_useri)
    {
        System.out.println("\nNumele soferului = ");
        String nume = sc.nextLine();
        System.out.println("\nNmarul de telefon al soferului = ");
        String numar_de_telefon = sc.nextLine();
        System.out.println("\nAdresa soferului este = ");
        String adresa = sc.nextLine();
        System.out.println("\nMasina soferului este = ");
        String masina = sc.nextLine();
        System.out.println("\nSalariul soferului este = ");
        Double salariu = sc.nextDouble();
        System.out.println("\nRatingul soferului este = ");
        Integer rating = sc.nextInt();

        Sofer nou = new Sofer(nume,adresa,numar_de_telefon,masina,salariu,rating);

        lisa_soferi.add(nou);
        lista_useri.add(nou);

    }

    public static void Sterge_Sofer(List<Sofer> lista_soferi,List<User> lista_useri){

        System.out.println("\nAlege dupa indice din urmatorii soferi pe care doresti sa il stergi:");
        for(int i=0;i<lista_soferi.size();i++)
        {
            System.out.println("\n "+(i+1)+" = "+lista_soferi.get(i));
        }
        System.out.println("\nIndexul ales = ");
        int i = sc.nextInt();
        i--;

        Sofer aux = lista_soferi.get(i);

        lista_soferi.remove(i);

        for(int j=0;j<lista_useri.size();j++)
            if(lista_useri.get(j).equals(aux))
            {
                lista_useri.remove(j);
                break;
            }

        System.out.println(lista_soferi+"\n\n\n");
        System.out.println(lista_useri);


    }

    public static void Modifica_Sofer(List<Sofer> lista_soferi,List<User> lista_useri)
    {
        System.out.println("\nAlege dupa indice din urmatorii useri pe care doresti sa il modifici:");
        for(int i=0;i<lista_soferi.size();i++)
        {
            System.out.println("\n "+(i+1)+" = "+lista_soferi.get(i));
        }
        System.out.println("\nIndexul ales = ");
        int indice1 = sc.nextInt();
        indice1--;

        System.out.println("\nAlege dupa indice ce doresti sa modifici la user:");
        System.out.println("\n1 = Masina");
        System.out.println("\n2 = Salariul");
        System.out.println("\n3 = Rating");

        int indice2 = sc.nextInt();

        if(indice2 == 1)
        {
            System.out.println("\nIntroduceti masina noua");
            sc.nextLine();
            String masina = sc.nextLine();
            lista_soferi.get(indice1).setMasina(masina);
        }
        if(indice2 == 2)
        {
            System.out.println("\nIntroduceti salariul nou");
            sc.nextLine();
            Double salariu= sc.nextDouble();
            lista_soferi.get(indice1).setSalariu(salariu);
        }
        if(indice2== 3)
        {
            System.out.println("\nIntroduceti ratingul nou");
            sc.nextLine();
            int rating = sc.nextInt();
            lista_soferi.get(indice1).setRating(rating);
        }

        System.out.println(lista_useri+"\n\n\n");
        System.out.println(lista_soferi);
    }

    public static void Adauga_Recenzie(List<User> lista_useri,List<Local> lista_localuri)
    {
        System.out.println("\nAlege dupa indice din urmatorii useri pe care doresti sa te identifici pentru a depune recenzia:");
        for(int i=0;i<lista_useri.size();i++)
        {
            System.out.println("\n "+(i+1)+" = "+lista_useri.get(i));
        }
        System.out.println("\nIndexul ales = ");
        int indice1 = sc.nextInt();
        indice1--;

        String nume = lista_useri.get(indice1).getNume();

        System.out.println("\nAlege dupa indice din urmatoarele localuri care va fi cel la care vei depune recenzia:");
        for(int i=0;i<lista_localuri.size();i++)
        {
            System.out.println("\n "+(i+1)+" = "+lista_localuri.get(i));
        }
        System.out.println("\nIndexul ales = ");
        int indice2 = sc.nextInt();
        indice2--;

        SortedSet<Recenzie> aux = new TreeSet<Recenzie>(Comparator.comparing(Recenzie::getNumber_of_stars));
        aux = lista_localuri.get(indice2).getLista_recenzii();

        System.out.println("\nNumarul de stele pentru calitatea acestui local = ");
        int numar_stele = sc.nextInt();
        System.out.println("\nComentarii aditionale = ");
        sc.nextLine();
        String comment = sc.nextLine();

        Recenzie nou = new Recenzie(lista_localuri.get(indice2).getNume(),numar_stele,comment,lista_useri.get(indice1).getNume());

        aux.add(nou);

        lista_localuri.get(indice2).setLista_recenzii(aux);

        System.out.println("\n\n\n"+lista_localuri);



    }

    public static void Afiseaza_Meniul_unui_local(List<Local> lista_localuri)
    {
        System.out.println("\nAlege dupa indice din urmatoarele localuri pentru a vedea meniul:");
        for(int i=0;i<lista_localuri.size();i++)
        {
            System.out.println("\n "+(i+1)+" = "+lista_localuri.get(i));
        }
        System.out.println("\nIndexul ales = ");
        int indice1 = sc.nextInt();
        indice1--;

        System.out.println(lista_localuri.get(indice1).getMeniu());

    }

    public static void Adauga_Comanda(List<User> lista_useri,List<Local> lista_localuri)
    {
        System.out.println("\nAlege dupa indice din urmatorii useri pe care doresti sa te identifici pentru a depune comanda:");
        for(int i=0;i<lista_useri.size();i++)
        {
            System.out.println("\n "+(i+1)+" = "+lista_useri.get(i));
        }
        System.out.println("\nIndexul ales = ");
        int indice1 = sc.nextInt();
        indice1--;

        System.out.println("\nAlege dupa indice din urmatoarele localuri de unde doriti sa comandati:");
        for(int i=0;i<lista_localuri.size();i++)
        {
            System.out.println("\n "+(i+1)+" = "+lista_localuri.get(i));
        }
        System.out.println("\nIndexul ales = ");
        int indice2 = sc.nextInt();
        indice2--;

        Double pret_total=0.0;

        System.out.println("\nApasati 1 pentru a alege preparatele");
        System.out.println("\nApasati 0 pentru a iesi din meniul de comanda");
        List<Preparat> lista_preparate=new ArrayList<>();
        int com = sc.nextInt();
        switch(com){
            case 1:
                int com2 = 1;
                while(com2==1)
                {
                    System.out.println("\n"+lista_localuri.get(indice2).getMeniu());
                    System.out.println("\nApasati 1 pentru a alege aperitive");
                    System.out.println("\nApasati 2 pentru a alege felul intai");
                    System.out.println("\nApasati 3 pentru a alege main_course");
                    System.out.println("\nApasati 4 pentru a alege desert");
                    System.out.println("\nApasati 5 pentru a finaliza comanda");
                    System.out.println("\nApasati 6 pentru a anula comanda");

                    int com3 = sc.nextInt();

                    switch(com3){
                        case 1:
                        {
                            System.out.println("\nAlegeti dupa indice aperitivul dorit");
                            for(int i=0;i<lista_localuri.get(indice2).getMeniu().getAperitive().size();i++)
                            {
                                System.out.println("\n "+(i+1)+" = "+lista_localuri.get(indice2).getMeniu().getAperitive().get(i));
                            }
                            System.out.println("\nIndexul ales = ");
                            int indice3 = sc.nextInt();
                            indice3--;

                            lista_preparate.add(lista_localuri.get(indice2).getMeniu().getAperitive().get(indice3));
                            break;
                        }
                        case 2:
                        {
                            System.out.println("\nAlegeti dupa indice felul dorit");
                            for(int i=0;i<lista_localuri.get(indice2).getMeniu().getFelul_intai().size();i++)
                            {
                                System.out.println("\n "+(i+1)+" = "+lista_localuri.get(indice2).getMeniu().getFelul_intai().get(i));
                            }
                            System.out.println("\nIndexul ales = ");
                            int indice3 = sc.nextInt();
                            indice3--;

                            lista_preparate.add(lista_localuri.get(indice2).getMeniu().getFelul_intai().get(indice3));
                            break;
                        }
                        case 3:
                        {
                            System.out.println("\nAlegeti dupa indice main course");
                            for(int i=0;i<lista_localuri.get(indice2).getMeniu().getMain_course().size();i++)
                            {
                                System.out.println("\n "+(i+1)+" = "+lista_localuri.get(indice2).getMeniu().getMain_course().get(i));
                            }
                            System.out.println("\nIndexul ales = ");
                            int indice3 = sc.nextInt();
                            indice3--;

                            lista_preparate.add(lista_localuri.get(indice2).getMeniu().getMain_course().get(indice3));
                            break;
                        }
                        case 4:
                        {
                            System.out.println("\nAlegeti dupa indice desertul dorit: ");
                            for(int i=0;i<lista_localuri.get(indice2).getMeniu().getDesert().size();i++)
                            {
                                System.out.println("\n "+(i+1)+" = "+lista_localuri.get(indice2).getMeniu().getDesert().get(i));
                            }
                            System.out.println("\nIndexul ales = ");
                            int indice3 = sc.nextInt();
                            indice3--;

                            lista_preparate.add(lista_localuri.get(indice2).getMeniu().getDesert().get(indice3));
                            break;
                        }
                        case 5:
                        {
                            com2 = 0;
                            System.out.println("\nApasati 1 pentru a alege comanda normala");
                            System.out.println("\nApasati 2 pentru a alege comanda premium");
                            int com4 = sc.nextInt();
                            if(com4 == 2)
                            {
                                LocalDateTime now = LocalDateTime.now();
                                Comanda nou = new Comanda(lista_localuri.get(indice2).getNume(),lista_preparate,now.toString());
                                List<Comanda> lista_com = lista_useri.get(indice1).getIstoric_comenzi().getComenzi_premium();
                                lista_com.add(nou);
                                lista_useri.get(indice1).getIstoric_comenzi().setComenzi_premium(lista_com);
                                System.out.println(lista_useri.get(indice1));
                            }
                            else
                            {
                                LocalDateTime now = LocalDateTime.now();
                                Comanda nou = new Comanda(lista_localuri.get(indice2).getNume(),lista_preparate,now.toString());
                                List<Comanda> lista_com = lista_useri.get(indice1).getIstoric_comenzi().getComenzi_normale();
                                lista_com.add(nou);
                                lista_useri.get(indice1).getIstoric_comenzi().setComenzi_normale(lista_com);
                                System.out.println(lista_useri.get(indice1));
                            }
                            break;
                        }
                        case 6:
                            return;
                        default:
                            break;


                    }


                }
                break;
            default:
                break;

        }




    }

    public static void Afiseaza_Istoricul_Comenzilor_unui_User(List<User> lista_useri)
    {
        System.out.println("\nAlege dupa indice din urmatorii useri pe care doresti sa te identifici pentru a afisa istoricul comenzii:");
        for(int i=0;i<lista_useri.size();i++)
        {
            System.out.println("\n "+(i+1)+" = "+lista_useri.get(i));
        }
        System.out.println("\nIndexul ales = ");
        int indice1 = sc.nextInt();
        indice1--;

        System.out.println("\n"+lista_useri.get(indice1).getIstoric_comenzi());
    }

}
