package org.example;
import java.sql.*;
public class EmployeeDAO {
    public Connection getConnection() throws SQLException {
            String url = "jdbc:mysql://localhost:3306/employeesdb";
            String username = "root";
            String password = "123qwe459a";
            return DriverManager.getConnection(url, username, password);

    }

    public void createEmployee(String nume , String departament , double salariu){
        try{
            Connection connection= getConnection();
            String sql = "INSERT INTO employees(nume,departament,salariu) values('" + nume+"','"+departament+"','"+salariu+"')";
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            System.out.println("Au fost adaugate " + rows + "randuri");
            connection.close();
        }
        catch(SQLException ex){
            System.out.println("Nu am putut face insert-ul : " + ex.getMessage());
        }
    }

    public void getEmployeeById(int id)
    {
        try{
            Connection connection = getConnection();
            String sql = "SELECT nume,departament,salariu FROM employees WHERE id = "+id;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
                String nume = resultSet.getString("nume");
                String departament = resultSet.getString("departament");
                double salariu = resultSet.getDouble("salariu");
                System.out.println("Nume = " + nume + "\n Departament = " + departament + "\n Salariu = "+salariu);
        }
        catch(SQLException ex){
            System.out.println("Nu am putu gasi angajatul cu acest id");
        }
    }
    public void updateEmployee(int id,String nume , String departament , double salariu){
        try{
            Connection connection= getConnection();
            String sql = "UPDATE employees SET nume=? , departament=? , salariu=? WHERE id= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,nume);
            statement.setString(2,departament);
            statement.setDouble(3,salariu);
            statement.setInt(4,id);
            statement.executeUpdate();
            System.out.println("Update-ul a fost realizat cu succes");
            connection.close();
        }
        catch(SQLException ex){
            System.out.println("Nu am putut face update-ul : " + ex.getMessage());
        }
    }

    public void deleteEmployee(int id){
        try{
            Connection connection= getConnection();
            String sql = "DELETE FROM employees WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
            System.out.println("Delete-ul a fost realizat cu succes");
            connection.close();

        }
        catch(SQLException ex){
            System.out.println("Nu am putut face delete-ul : " + ex.getMessage());
        }
    }
}
