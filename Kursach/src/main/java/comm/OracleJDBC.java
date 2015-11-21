package comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by Oleksandr on 11/13/2014.
 */
public class OracleJDBC {
    public static void main(String[] args) {



        System.out.println("Oracle JDBS Connection Testing");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Oracle JDBC Driver Registred!");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","nit","pass");

            java.sql.Statement statement = connection.createStatement();

            statement.executeUpdate("update table1 set name='225' where id='3'");
//            ResultSet str=statement.executeQuery("select ID from table1;");
//            statement.execute("INSERT INTO LOCATIONS ( COUNTRY, REGION, CITY, STREET, STREET_NUM, APARTMENT) VALUES ( 'sd', 'sd', 'sd', 'ad', 'asd', 'asd')");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
