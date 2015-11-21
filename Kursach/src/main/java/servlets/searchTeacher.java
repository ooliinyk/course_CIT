package servlets;

import DB.Student;
import DB.Teacher;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksandr on 12/15/2014.
 */
public class searchTeacher extends HttpServlet {


    InitialContext ctx = null;
    DataSource ds = null;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;



    String selectStudent= "SELECT * FROM teachers where teacher_id =? or  name=? or  surname=? or subject_name=? or stupen=?";
    String updateTeacher = "UPDATE teachers set     name=? ,  surname=? , subject_name=? , stupen=?  where teacher_id =? or name=? or  surname=? or subject_name=? or stupen=?";
    String deleteStudent = "Delete FROM teachers  where teacher_id =? or name=? or  surname=? or subject_name=? or stupen=? ";
    public void init() throws ServletException {
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("jdbc/NitConnectionPool");
            conn = ds.getConnection();
            ps = conn.prepareStatement(selectStudent);
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
            response.setStatus(200);

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();


            out.println(
                    "<!doctype html> \n" +
                            "<html lang=\"ru\"> \n" +
                            "<head> \n" +
                            "<meta charset=\"UTF-8\">\n" +
                            "<title> Answer  </title> \n" +
                            "</head> \n" +
                            "<body> <jsp:include page=\"header.jsp\"/>\n");
            //
// //SELECT STUDENT
//
            ps = conn.prepareStatement(selectStudent);
            String value;
//            value=request.getParameter("id");

            value = request.getParameter("id");
            ps.setString(1, value);
            value = request.getParameter("name");
            ps.setString(2, value);
            value=request.getParameter("surname");
            ps.setString(3, value);
            value = request.getParameter("subject");
            ps.setString(4, value);
            value=request.getParameter("stupin");
            ps.setString(5, value);



            rs = ps.executeQuery();
            List<Teacher> teacherList = new ArrayList<Teacher>();
            while (rs.next()){


               Teacher teacher= new Teacher();

                teacher.setTeacherId(rs.getInt(1));
                teacher.setName(rs.getString(2));
                teacher.setSurname(rs.getString(3));
                teacher.setSubjectName(rs.getString(4));
                teacher.setStupen(rs.getString(5));

                out.print(teacher);
                teacherList.add(teacher);
            /*
                out.println("<TR><TD>" + rs.getInt(1));
                out.println("<TD>" + rs.getString(2));
                out.println("<TD>" + rs.getString(3));
                out.println("<TD>" + rs.getString(4));
                out.println("<TD>" + rs.getString(5));
                out.println("<TD>" + rs.getInt(6));
                out.println("<TD>" + rs.getInt(7));
                out.println("<TD>" + rs.getString(8));
                */
                HttpSession session = request.getSession();
                session.setAttribute("getTeacher", teacherList );
            }
//
// //UPDATE STUDENT
//
            ps = conn.prepareStatement(updateTeacher);
            value = request.getParameter("id1");
            ps.setString(5, value);
            value = request.getParameter("name1");
            ps.setString(6, value);
            value=request.getParameter("surname1");
            ps.setString(7, value);
            value = request.getParameter("subject1");
            ps.setString(8, value);
            value=request.getParameter("stupin1");
            ps.setString(9, value);

            value = request.getParameter("name2");
            ps.setString(1, value);
            value=request.getParameter("surname2");
            ps.setString(2, value);
            value = request.getParameter("subject2");
            ps.setString(3, value);
            value=request.getParameter("stupin2");
            ps.setString(4, value);
           ps.executeUpdate();
//
// //DELETE STUDENT
//
            ps = conn.prepareStatement(deleteStudent);

            value = request.getParameter("id3");
            ps.setString(1, value);
//            value = request.getParameter("name3");
//            ps.setString(2, value);
//            value=request.getParameter("surname3");
//            ps.setString(3, value);
//            value = request.getParameter("email3");
//            ps.setString(4, value);
//            value=request.getParameter("sex3");
//            ps.setString(5, value);
//            value = request.getParameter("groupNumber3");
//            ps.setString(6, value);
//            value=request.getParameter("age3");
//            ps.setString(7, value);
//            value=request.getParameter("cafedra3");
//            ps.setString(8, value);
            ps.executeUpdate();

//
// //DELETE STUDENT
//

            out.println("</body> \n" +
                    "</html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("searchTeacher.jsp");

    }



}
