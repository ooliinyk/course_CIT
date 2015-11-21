package comm;

import connection.ConnectionPool;
import javafx.scene.input.DataFormat;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Filler extends HttpServlet {


    InitialContext ctx = null;
    DataSource ds = null;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Statement stmt = null;


    String sql = "INSERT INTO students (FIRST_NAME, LAST_NAME, EMAIL, SEX, GROUP_NUM, AGE, DEPARTMENT_NAME ) VALUES (?,?,?,?,?,?,?)";



    public void init() throws ServletException {
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("jdbc/NitConnectionPool");
            conn = ds.getConnection();
            ps = conn.prepareStatement(sql);
        } catch (SQLException se) {
            System.out.println("SQLException: " + se.getMessage());
        } catch (NamingException ne) {
            System.out.println("NamingException: " + ne.getMessage());
        }
    }



    public void destroy() {
        try {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
            if (ctx != null)
                ctx.close();
        } catch (SQLException se) {
            System.out.println("SQLException: " + se.getMessage());
        } catch (NamingException ne) {
            System.out.println("NamingException: " + ne.getMessage());
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

//       PrintWriter out = response.getWriter();
//
//        out.println(
//                "<!doctype html> \n" +
//                        "<html lang=\"ru\"> \n" +
//                        "<head> \n" +
//                        "<meta charset=\"UTF-8\">\n" +
//                        "<title> Answer  </title> \n" +
//                        "</head> \n" +
//                        "<body> \n");
        try {

///*
           String value=request.getParameter("name");
            ps.setString(1, value);

            value=request.getParameter("surname");
            ps.setString(2, value);
            value=request.getParameter("email");

            ps.setString(3, value);
            value=request.getParameter("sex");
            ps.setString(4, value);
            value=request.getParameter("groupNumber");
            ps.setInt(5, Integer.parseInt(value));
            value=request.getParameter("birthday");
//            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
//            java.util.Date date = formatter.parse(value);
//            DateFormat dateFormat= DateFormat.getDateInstance();
//            java.util.Date date=dateFormat.parse(value);
            ps.setInt(6, Integer.parseInt(value));
            value=request.getParameter("info");
            ps.setString(7, value);

//*/
/*
            String value=request.getParameter("name");
            ps.setString(1, value);

            value=request.getParameter("surname");
            ps.setString(2, value);
            value=request.getParameter("sex");
            ps.setString(3, value);
            value=request.getParameter("email");
            ps.setString(4, value);
            value=request.getParameter("groupNumber");
            ps.setInt(5, Integer.parseInt(value));

            value=request.getParameter("city");
            ps.setInt(6, Integer.parseInt(value));

  */
                    ps.executeUpdate();



//            out.println("</body> \n" +
//                    "</html>");


        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("index.jsp");

    }
}
