package Services;

import Classes.Sofer;
import Classes.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDOperatiosSofer {

    //read functionality
    public static List<Sofer> LoadSoferFromDataBase(){
        List<Sofer> lista_soferi = new ArrayList<>();
        try{

            String url = "jdbc:mysql://localhost:3306/pao_project";
            String username = "root";
            String password = "1wD3Fsx&$*(fg";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "select * from sofer;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Sofer sofer = new Sofer(resultSet.getInt("idsofer"),
                        resultSet.getString("nume"),
                        resultSet.getString("adresa"),
                        resultSet.getString("nr_telefon"),
                        resultSet.getString("masina"),
                        resultSet.getDouble("salariu"),
                        resultSet.getInt("rating"));
                lista_soferi.add(sofer);
            }
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return lista_soferi;
    }

    //create functionality
    public static List<Sofer> CreateSofer(String name,String adresa, String nr_telefon,String masina,Double salariu,Integer rating){
        try{
            String url = "jdbc:mysql://localhost:3306/pao_project";
            String username = "root";
            String password = "1wD3Fsx&$*(fg";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "insert into sofer (nume,adresa,nr_telefon,masina,salariu,rating) values ('"+name+"','"+adresa+"','"+nr_telefon+"',+'"+masina+"',"+salariu+",+"+rating+");";
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return LoadSoferFromDataBase();
    }

    //update functionality
    public static List<Sofer> UpdateSoferForString(Integer id,Integer modification,String new_update)
    {
        try{
            String url = "jdbc:mysql://localhost:3306/pao_project";
            String username = "root";
            String password = "1wD3Fsx&$*(fg";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query= "update sofer set nume = '"+new_update+"' where idsofer = '"+id+"';";
            switch(modification){
                case 1:{
                    query = "update sofer set nume = '"+new_update+"' where idsofer = '"+id+"';";
                    break;
                }
                case 2:{
                    query = "update sofer set adresa = '"+new_update+"' where idsofer = '"+id+"';";
                    break;
                }
                case 3:{
                    query = "update sofer set nr_telefon = '"+new_update+"' where idsofer = '"+id+"';";
                    break;
                }
                case 4:{
                    query = "update sofer set masina = '"+new_update+"' where idsofer = '"+id+"';";
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

        return LoadSoferFromDataBase();
    }

    public static List<Sofer> UpdateSoferForDouble(Integer id,Double new_update){
        try{
            String url = "jdbc:mysql://localhost:3306/pao_project";
            String username = "root";
            String password = "1wD3Fsx&$*(fg";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query= "update sofer set salariu = '"+new_update+"' where idsofer = '"+id+"';";
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return LoadSoferFromDataBase();
    }

    public static List<Sofer> UpdateSoferForInteger(Integer id,Integer new_update){
        try{
            String url = "jdbc:mysql://localhost:3306/pao_project";
            String username = "root";
            String password = "1wD3Fsx&$*(fg";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query= "update sofer set rating = '"+new_update+"' where idsofer = '"+id+"';";
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return LoadSoferFromDataBase();
    }

    //delete functionality
    public static List<Sofer> DeleteSofer(Integer id){
        try{
            String url = "jdbc:mysql://localhost:3306/pao_project";
            String username = "root";
            String password = "1wD3Fsx&$*(fg";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "delete from sofer where idsofer = "+id+";";
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return LoadSoferFromDataBase();
    }
}


