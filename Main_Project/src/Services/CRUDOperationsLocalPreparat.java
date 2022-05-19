package Services;

import Classes.Local;
import Classes.Meniu;
import Classes.Preparat;
import Classes.User;

import java.sql.*;
import java.util.*;

public class CRUDOperationsLocalPreparat {

    //read functionality
    public static Meniu LoadPreparateFromDataBase(Integer local_id)
    {
        List<Preparat> lista_aperitive = new ArrayList<>();
        List<Preparat> lista_felul_1 = new ArrayList<>();
        List<Preparat> lista_felul_2 = new ArrayList<>();
        List<Preparat> lista_desert = new ArrayList<>();
        try{

            String url = "jdbc:mysql://localhost:3306/pao_project";
            String username = "root";
            String password = "1wD3Fsx&$*(fg";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "select * from preparat where id_local = "+local_id+";";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Vector<String> lista_ingrediente = new Vector<>();
                Collections.addAll(lista_ingrediente,resultSet.getString("ingrediente").split(" "));
                Preparat preparat = new Preparat(resultSet.getInt("idpreparat"),
                        resultSet.getString("nume"),
                        resultSet.getDouble("pret"),
                        lista_ingrediente,
                        resultSet.getInt("id_local"),
                        resultSet.getInt("tip_meniu"));
                if(preparat.getTip_meniu()==1)
                    lista_aperitive.add(preparat);
                if(preparat.getTip_meniu()==2)
                    lista_felul_1.add(preparat);
                if(preparat.getTip_meniu()==3)
                    lista_felul_2.add(preparat);
                if(preparat.getTip_meniu()==4)
                    lista_desert.add(preparat);
            }
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        Meniu meniu=new Meniu(lista_aperitive,lista_felul_1,lista_felul_2,lista_desert);
        return meniu;
    }

    public static List<Local> LoadLocalsFromDataBase(){
        List<Local> lista_localuri = new ArrayList<>();
        try{

            String url = "jdbc:mysql://localhost:3306/pao_project";
            String username = "root";
            String password = "1wD3Fsx&$*(fg";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "select * from local;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Integer id = resultSet.getInt("idlocal");
                Meniu meniu = LoadPreparateFromDataBase(id);
                Local local = new Local(id,
                        resultSet.getString("nume"),
                        meniu,
                        resultSet.getString("adresa"),
                        resultSet.getString("nr_telefon"));
                lista_localuri.add(local);
            }
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return lista_localuri;
    }

    //create functionality
    public static List<Local> CreatePreparat(String nume,Double pret,String ingrediente,Integer tip_meniu,Integer id_local){
        try{
            String url = "jdbc:mysql://localhost:3306/pao_project";
            String username = "root";
            String password = "1wD3Fsx&$*(fg";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "insert into preparat (nume,pret,ingrediente,tip_meniu,id_local) values ('"+nume+"',"+pret+",'"+ingrediente+"',"+tip_meniu+","+id_local+");";
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return LoadLocalsFromDataBase();
    }

    public static List<Local> CreateLocal(String nume,String adresa,String nr_telefon){
        try{
            String url = "jdbc:mysql://localhost:3306/pao_project";
            String username = "root";
            String password = "1wD3Fsx&$*(fg";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "insert into local (nume,adresa,nr_telefon) values ('"+nume+"','"+adresa+"','"+nr_telefon+"');";
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return LoadLocalsFromDataBase();
    }

    //update functionality
    public static List<Local> UpdatePreparatPret(Integer id,Double pret_nou){
        try{
            String url = "jdbc:mysql://localhost:3306/pao_project";
            String username = "root";
            String password = "1wD3Fsx&$*(fg";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "update preparat set pret = "+pret_nou+" where idpreparat = "+id+";";
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return LoadLocalsFromDataBase();
    }

    public static List<Local> UpdateLocal(Integer id,Integer modifcation,String new_update){
        try{
            String url = "jdbc:mysql://localhost:3306/pao_project";
            String username = "root";
            String password = "1wD3Fsx&$*(fg";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "update local set adresa = '"+new_update+"' where idlocal = "+id+";";
            switch (modifcation){
                case 1:
                {
                    query = "update local set nume = '"+new_update+"' where idlocal = "+id+";";
                    break;
                }
                case 2:
                {
                    query = "update local set adresa = '"+new_update+"' where idlocal = "+id+";";
                    break;
                }
                case 3:
                {
                    query = "update local set nr_telefon = '"+new_update+"' where idlocal = "+id+";";
                    break;
                }
                default:{
                    break;
                }
            }

            statement.executeUpdate(query);
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return LoadLocalsFromDataBase();
    }

    //delete functionality
    public static List<Local> DeletePreparat(Integer id){
        try{
            String url = "jdbc:mysql://localhost:3306/pao_project";
            String username = "root";
            String password = "1wD3Fsx&$*(fg";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "delete from preparat where idpreparat = "+id+";";
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return LoadLocalsFromDataBase();
    }

    public static List<Local> DeleteLocal(Integer id){
        try{
            String url = "jdbc:mysql://localhost:3306/pao_project";
            String username = "root";
            String password = "1wD3Fsx&$*(fg";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "delete from local where idlocal = "+id+";";
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return LoadLocalsFromDataBase();
    }
}
