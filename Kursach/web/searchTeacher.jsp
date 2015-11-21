<%@ page import="connection.ConnectionPool" %>
<%@ page import="DB.Student" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DB.Teacher" %>

<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 12/14/2014
  Time: 6:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="content/css/style.css">
</head>
<body>
<jsp:include page="header.jsp"/>

<form method="post" action="addTeacher">

    <table class="table1" width="80%"style="table-layout:fixed;">

        <h1>Add Teacher</h1>
        <tr>
            <td ></td>
            <td><b>Ім'я</b></td>
            <td><b>Прізвище</b></td>
            <td><b>Назва предмету</b></td>
            <td><b>ступінь</b></td>

        </tr>
        <tr>
            <td ><b>Set Date</b></td>
            <td><input type="text" name="name4" maxlength="22" size="22"  placeholder="Ім'я"></td>
            <td><input type="text" name="surname4" maxlength="22" size="22"  placeholder="Прізвище"></td>
            <td> <input type="text" name="subject4" maxlength="22" size="22" placeholder="Subject"  ></td>
            <td> <input type="text" name="stupin4" maxlength="22" size="22" placeholder="Stupin"  ></td>
        </tr>

    </table>
    <input type="submit" value="OK">
    <input type="reset" value="Cansel">
</form>
<br>
<h1>Search Teacher</h1>
<form method="post" action="searchTeacher">

    <table class="table1" width="80%"style="table-layout:fixed;">

        <tr>
            <td ><b>ІД</b></td>
            <td><b>Ім'я</b></td>
            <td><b>Прізвище</b></td>
            <td><b>Назва предмету</b></td>
            <td><b>ступінь</b></td>

        </tr>
        <tr>
            <td ><b><input type='number' name='id' value=''placeholder="ІД"></b></td>
            <td><input type="text" name="name" maxlength="22" size="22"  placeholder="Ім'я"></td>
            <td><input type="text" name="surname" maxlength="22" size="22"  placeholder="Прізвище"></td>
            <td> <input type="text" name="subject" maxlength="22" size="22" placeholder="Subject"  ></td>
            <td> <input type="text" name="stupin" maxlength="22" size="22" placeholder="Stupin"  ></td>
          </tr>


        <% List<Teacher> teacherList;
            teacherList= (List<Teacher>) session.getAttribute("getTeacher");
            if (teacherList != null){
                for(Teacher teacher: teacherList) {
                    if (teacher != null) {
                        out.println("<TR><TD>" + teacher.getTeacherId());
                        out.println("<TD>" + teacher.getName());
                        out.println("<TD>" + teacher.getSurname());
                        out.println("<TD>" + teacher.getSubjectName());
                        out.println("<TD>" + teacher.getStupen());

                    }
                }
            }

        %>

    </table>
    <input type="submit" value="OK">
    <input type="reset" value="Cansel">
</form><br>
<h1>Update Teacher</h1>
<form method="post" action="searchTeacher">

    <table class="table1" width="80%"style="table-layout:fixed;">
        <tr>
            <td ><b>ІД</b></td>
            <td><b>Ім'я</b></td>
            <td><b>Прізвище</b></td>
            <td><b>Назва предмету</b></td>
            <td><b>ступінь</b></td>

        </tr>
        <tr>
            <td ><b><input type='number' name='id1' value=''placeholder="ІД"></b></td>
            <td><input type="text" name="name1" maxlength="22" size="22"  placeholder="Ім'я"></td>
            <td><input type="text" name="surname1" maxlength="22" size="22"  placeholder="Прізвище"></td>
            <td> <input type="text" name="subject1" maxlength="22" size="22" placeholder="Subject"  ></td>
            <td> <input type="text" name="stupin1" maxlength="22" size="22" placeholder="Stupin"  ></td>
        </tr>
        <tr>
            <td ><b>Set date:</b></td>
            <td><input type="text" name="name2" maxlength="22" size="22"  placeholder="setІм'я"></td>
            <td><input type="text" name="surname2" maxlength="22" size="22"  placeholder="setПрізвище"></td>
            <td> <input type="text" name="subject2" maxlength="22" size="22" placeholder="setSubject"  ></td>
            <td> <input type="text" name="stupin2" maxlength="22" size="22" placeholder="setStupin"  ></td>
        </tr>
    </table>
    <input type="submit" value="OK">
    <input type="reset" value="Cansel">
</form><br>
<h1>Delete Teacher</h1>
<form method="post" action="searchTeacher">

    <table class="table1" width="80%"style="table-layout:fixed;">

        <tr>
            <td ><b>ІД</b></td>
            <td><b>Ім'я</b></td>
            <td><b>Прізвище</b></td>
            <td><b>Назва предмету</b></td>
            <td><b>ступінь</b></td>

        </tr>
        <tr>
            <td ><b><input type='number' name='id3' value=''placeholder="ІД"></b></td>
            <td><input type="text" name="name3" maxlength="22" size="22"  placeholder="Ім'я"></td>
            <td><input type="text" name="surname3" maxlength="22" size="22"  placeholder="Прізвище"></td>
            <td> <input type="text" name="subject3" maxlength="22" size="22" placeholder="Subject"  ></td>
            <td> <input type="text" name="stupin3" maxlength="22" size="22" placeholder="Stupin"  ></td>
        </tr>

    </table>
    <input type="submit" value="OK">
    <input type="reset" value="Cansel">
</form>



</form>
</body>
</html>
