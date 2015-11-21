package comm;

import DB.Student;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Oleksandr on 11/18/2014.
 */
public class Main {


    public static void main(String[] args) throws NamingException {
          DBWorker worker=new DBWorker();
        String query="select * from userr";
        try {

         Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("jdbc/LabPool");
            Connection conn = ds.getConnection();
            Statement  statement=conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                System.out.println(user);


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
