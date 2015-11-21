package servlets;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Oleksandr on 12/16/2014.
 */
public class addSheet extends HttpServlet{



    InitialContext ctx = null;
    DataSource ds = null;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;


    String addStudent = "INSERT INTO students (STUDENT_ID, LAST_NAME, SUBJECT_NAME, MARK, SUBJECT_ID, DEPARTMENT_ID, DEPARTMENT_NAME, GROUP_ID, GROUP_NUM, TEACHER_ID, TEACHER_NAME) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    public void init() throws ServletException {
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("jdbc/NitConnectionPool");
            conn = ds.getConnection();
            ps = conn.prepareStatement(addStudent);
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
        try {

            String value;


//
            ps = conn.prepareStatement(addStudent);

            value=request.getParameter("name4");
            ps.setString(1, value);
            value=request.getParameter("surname4");
            ps.setString(2, value);
            value=request.getParameter("email4");
            ps.setString(3, value);
            value=request.getParameter("sex4");
            ps.setString(4, value);
            value=request.getParameter("groupNumber4");
            ps.setInt(5, Integer.parseInt(value));
            value=request.getParameter("age4");
            ps.setInt(6, Integer.parseInt(value));
            value=request.getParameter("cafedra4");
            ps.setString(7, value);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("Search.jsp");

    }





}
