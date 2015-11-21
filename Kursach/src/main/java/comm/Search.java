package comm;

import DB.Student;

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

public class Search extends HttpServlet {

    InitialContext ctx = null;
    DataSource ds = null;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;


    String addStudent = "INSERT INTO students (FIRST_NAME, LAST_NAME, EMAIL, SEX, GROUP_NUM, AGE, DEPARTMENT_NAME ) VALUES (?,?,?,?,?,?,?)";
    String selectStudent = "SELECT * FROM students where student_id =? or FIRST_NAME=? or  last_name=? or email=? or sex=? or group_num=? or age=? or department_name=?";
    String updateStudent = "UPDATE students set  FIRST_NAME=? , last_name=? , email=? , sex=? , group_num=? , age=? , department_name=? where student_id =? or FIRST_NAME=? or  last_name=? or email=? or sex=? or group_num=? or age=? or department_name=?";
    String deleteStudent = "Delete FROM students where  student_id =? or FIRST_NAME=? or  last_name=? or email=? or sex=? or group_num=? or age=? or department_name=?";
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
            String value;


            //
// //SELECT STUDENT
//
            ps = conn.prepareStatement(selectStudent);

//            value=request.getParameter("id");

            value = request.getParameter("id");
            ps.setString(1, value);
            value = request.getParameter("name");
            ps.setString(2, value);
            value=request.getParameter("surname");
            ps.setString(3, value);
            value = request.getParameter("email");
            ps.setString(4, value);
            value=request.getParameter("sex");
            ps.setString(5, value);
            value = request.getParameter("groupNumber");
            ps.setString(6, value);
            value=request.getParameter("age");
            ps.setString(7, value);
            value=request.getParameter("cafedra");
            ps.setString(8, value);


            rs = ps.executeQuery();
            List<Student> studentList = new ArrayList<Student>();
            while (rs.next()){


                Student student = new Student();
                student.setStudentId(rs.getInt(1));
                student.setFirstName(rs.getString(2));
                student.setLastName(rs.getString(3));
                student.setEmail(rs.getString(4));
                student.setSex(rs.getString(5));
                student.setGroupNumber(rs.getInt(6));
                student.setAge(rs.getInt(7));
                student.setDepartmentName(rs.getString(8));
                out.print(student);
                studentList.add(student);
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
                session.setAttribute("getStudent", studentList );
            }
//
// //UPDATE STUDENT
//
            PreparedStatement pss;
            ps = conn.prepareStatement(updateStudent);

            value = request.getParameter("id1");
            ps.setString(8, value);

            value = request.getParameter("name1");
            ps.setString(9, value);
            value=request.getParameter("surname1");
            ps.setString(10, value);
            value = request.getParameter("email1");
            ps.setString(11, value);
            value=request.getParameter("sex1");
            ps.setString(12, value);
            value = request.getParameter("groupNumber1");
            ps.setString(13, value);
            value=request.getParameter("age1");
            ps.setString(14, value);
            value=request.getParameter("cafedra1");
            ps.setString(15, value);

            value = request.getParameter("name2");
            ps.setString(1, value);
            value=request.getParameter("surname2");
            ps.setString(2, value);
            value = request.getParameter("email2");
            ps.setString(3, value);
            value=request.getParameter("sex2");
            ps.setString(4, value);
            value = request.getParameter("groupNumber2");
            ps.setInt(5, Integer.parseInt(value));
            value=request.getParameter("age2");
            ps.setInt(6, Integer.parseInt(value));
            value=request.getParameter("cafedra2");
            ps.setString(7, value);
            ps.executeUpdate();
//
// //DELETE STUDENT
//

            if((request.getParameter("id3")!=null)||(request.getParameter("name3")!=null)||(request.getParameter("surname3")!=null)||(request.getParameter("email3")!=null)||(request.getParameter("sex3")!=null)||(request.getParameter("groupNumber3")!=null)||(request.getParameter("age3")!=null)||(request.getParameter("cafedra3")!=null)) {
                ps = conn.prepareStatement(deleteStudent);

                value = request.getParameter("id3");
                ps.setString(1, value);
            value = request.getParameter("name3");
            ps.setString(2, value);
            value=request.getParameter("surname3");
            ps.setString(3, value);
            value = request.getParameter("email3");
            ps.setString(4, value);
            value=request.getParameter("sex3");
            ps.setString(5, value);
            value = request.getParameter("groupNumber3");
            ps.setString(6, value);
            value=request.getParameter("age3");
            ps.setString(7, value);
            value=request.getParameter("cafedra3");
            ps.setString(8, value);
                ps.executeUpdate();
            }





            out.println("</body> \n" +
                    "</html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("Search.jsp");

    }




}