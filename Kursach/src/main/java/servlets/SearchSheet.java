package servlets;

import DB.Sheet;
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

/**
 * Created by Oleksandr on 12/16/2014.
 */
public class SearchSheet extends HttpServlet {


    InitialContext ctx = null;
    DataSource ds = null;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;


    String selectStudent = "SELECT Sheet_id,Student_id,Last_name,Subject_name,Mark, Department_name, group_num, Teacher_name FROM sheet where Sheet_id= ? or Student_id= ? or Last_name= ? or Subject_name=? or Mark=? or  Department_name=? or  group_num=? or  Teacher_name=?";

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



            String value;


            //
// //SELECT Sheet
//
            ps = conn.prepareStatement(selectStudent);

//            value=request.getParameter("id");

            value = request.getParameter("idtable");
            ps.setString(1, value);
            value = request.getParameter("idstudena");
            ps.setString(2, value);
            value=request.getParameter("surname");
            ps.setString(3, value);
            value = request.getParameter("subject");
            ps.setString(4, value);
            value=request.getParameter("mark");
            ps.setString(5, value);
            value = request.getParameter("cafedraName");
            ps.setString(6, value);
            value=request.getParameter("group");
            ps.setString(7, value);
            value=request.getParameter("teacherName");
            ps.setString(8, value);


            rs = ps.executeQuery();
            List<Sheet> sheetList = new ArrayList<Sheet>();
            while (rs.next()){


                Sheet sheet = new Sheet();
                sheet.setSheetId(rs.getInt(1));
                sheet.setStudentId(rs.getInt(2));
                sheet.setLastName(rs.getString(3));
                sheet.setSubjectName(rs.getString(4));
                sheet.setMark(rs.getInt(5));
                sheet.setDepartmentName(rs.getString(6));
                sheet.setGroupNum(rs.getInt(7));
                sheet.setTeacherName(rs.getString(8));
                out.print(sheet);
                sheetList.add(sheet);
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
                session.setAttribute("getSheet", sheetList );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("searchSheetnew.jsp");

    }


}
