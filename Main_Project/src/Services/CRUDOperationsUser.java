package Services;

import Classes.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDOperationsUser {

    //read functionality
    public static List<User> LoadUsersFromDataBase(){
        List<User> lista_useri = new ArrayList<>();
        try{

            String url = "jdbc:mysql://localhost:3306/pao_project";
            String username = "root";
            String password = "1wD3Fsx&$*(fg";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "select * from user;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                User user = new User(resultSet.getInt("iduser"),
                        resultSet.getString("nume"),
                        resultSet.getString("adresa"),
                        resultSet.getString("nr_telefon"));
                lista_useri.add(user);
            }
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return lista_useri;

    }

    //create functionality
    public static List<User> CreateUser(String name,String adresa,String nr_telefon){
        try{
            String url = "jdbc:mysql://localhost:3306/pao_project";
            String username = "root";
            String password = "1wD3Fsx&$*(fg";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "insert into user (nume,adresa,nr_telefon) values ('"+name+"','"+adresa+"','"+nr_telefon+"');";
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return LoadUsersFromDataBase();
    }

    //update functionality
    public static List<User> UpdateUser(Integer id,Integer modification,String new_update){

        try{
            String url = "jdbc:mysql://localhost:3306/pao_project";
            String username = "root";
            String password = "1wD3Fsx&$*(fg";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query= "update user set nume = '"+new_update+"' where iduser = '"+id+"';";
            switch(modification){
                case 1:{
                    query = "update user set nume = '"+new_update+"' where iduser = '"+id+"';";
                    break;
                }
                case 2:{
                    query = "update user set adresa = '"+new_update+"' where iduser = '"+id+"';";
                    break;
                }
                case 3:{
                    query = "update user set nr_telefon = '"+new_update+"' where iduser = '"+id+"';";
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

        return LoadUsersFromDataBase();
    }

    //delete functionality
    public static List<User> DeleteUser(Integer id){
        try{
            String url = "jdbc:mysql://localhost:3306/pao_project";
            String username = "root";
            String password = "1wD3Fsx&$*(fg";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "delete from user where iduser = "+id+";";
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return LoadUsersFromDataBase();
    }

}
