<%@ page import="connection.ConnectionPool" %>
<%@ page import="DB.Student" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

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
<h1>Add Student</h1>
<form method="post" action="addStudent">

    <table class="table1" width="80%"style="table-layout:fixed;">

        <tr>
            <td ></td>
            <td><b>Ім'я</b></td>
            <td><b>Прізвище</b></td>
            <td><b>Email</b></td>
            <td><b>Стать</b></td>
            <td><b>Номер групи</b></td>
            <td><b>Вік</b></td>
            <td><b>Кафедра</b></td>
        </tr>
        <tr>
            <td ><b>Add date:</b></td>
            <td><input type="text" name="name4" maxlength="22" size="22"  placeholder="Ім'я"></td>
            <td><input type="text" name="surname4" maxlength="22" size="22"  placeholder="Прізвище"></td>
            <td> <input type="email" name="email4" maxlength="22" size="22" placeholder="Email"  ></td>
            <td> <input type="text" name="sex4" maxlength="22" size="22" placeholder="Стать"  ></td>
            <td> <input type="number" name="groupNumber4" maxlength="15" size="22" placeholder="Номер групи"  ></td>
            <td> <input type='number' name='age4' value=''placeholder="Вік"/></td>
            <td><input type="text" name="cafedra4" maxlength="22" size="22"  placeholder="Кафедра" ></td>
        </tr>

    </table>
    <input type="submit" value="OK">
    <input type="reset" value="Cansel">
</form>
<br>
<h1>Search Student</h1>
<form method="post" action="search">

        <table class="table1" width="80%"style="table-layout:fixed;">

            <tr>
                <td ><b>ІД</b></td>
                <td><b>Ім'я</b></td>
                <td><b>Прізвище</b></td>
                <td><b>Email</b></td>
                <td><b>Стать</b></td>
                <td><b>Номер групи</b></td>
                <td><b>Вік</b></td>
                <td><b>Кафедра</b></td>
            </tr>
            <tr>
                <td ><b><input type='number' name='id' value=''placeholder="ІД"></b></td>
                <td><input type="text" name="name" maxlength="22" size="22"  placeholder="Ім'я"></td>
                <td><input type="text" name="surname" maxlength="22" size="22"  placeholder="Прізвище"></td>
                <td> <input type="email" name="email" maxlength="22" size="22" placeholder="Email"  ></td>
                <td> <input type="text" name="sex" maxlength="22" size="22" placeholder="Стать"  ></td>
                <td> <input type="number" name="groupNumber" maxlength="15" size="22" placeholder="Номер групи"  ></td>
                <td> <input type='number' name='age' value=''placeholder="Вік"/></td>
                <td><input type="text" name="cafedra" maxlength="22" size="22"  placeholder="Кафедра" ></td>
            </tr>


            <% List<Student> studentList;
                studentList= (List<Student>) session.getAttribute("getStudent");
                if (studentList != null){
                for(Student student1 : studentList) {
                    if (student1 != null) {
                        out.println("<TR><TD>" + student1.getStudentId());
                        out.println("<TD>" + student1.getFirstName());
                        out.println("<TD>" + student1.getLastName());
                        out.println("<TD>" + student1.getEmail());
                        out.println("<TD>" + student1.getSex());
                        out.println("<TD>" + student1.getGroupNumber());
                        out.println("<TD>" + student1.getAge());
                        out.println("<TD>" + student1.getDepartmentName());
                    }
                }
                }

            %>

        </table>
    <input type="submit" value="OK">
    <input type="reset" value="Cansel">
    </form>
<br>
    <h1>Update Student</h1>
    <form method="post" action="search">

        <table class="table1" width="80%"style="table-layout:fixed;">

            <tr>
                <td ><b>ІД</b></td>
                <td><b>Ім'я</b></td>
                <td><b>Прізвище</b></td>
                <td><b>Email</b></td>
                <td><b>Стать</b></td>
                <td><b>Номер групи</b></td>
                <td><b>Вік</b></td>
                <td><b>Кафедра</b></td>
            </tr>
            <tr>
                <td ><b><input type='number' name='id1' value=''placeholder="ІД"></b></td>
                <td><input type="text" name="name1" maxlength="22" size="22"  placeholder="Ім'я"></td>
                <td><input type="text" name="surname1" maxlength="22" size="22"  placeholder="Прізвище"></td>
                <td> <input type="email" name="email1" maxlength="22" size="22" placeholder="Email"  ></td>
                <td> <input type="text" name="sex1" maxlength="22" size="22" placeholder="Стать"  ></td>
                <td> <input type="number" name="groupNumber1" maxlength="15" size="22" placeholder="Номер групи"  ></td>
                <td> <input type='number' name='age1' value=''placeholder="Вік"/></td>
                <td><input type="text" name="cafedra1" maxlength="22" size="22"  placeholder="Кафедра" ></td>
            </tr>
            <tr>
                <td ><b>Set date</b></td>
                <td><input type="text" name="name2" maxlength="22" size="22"  placeholder="setІм'я"></td>
                <td><input type="text" name="surname2" maxlength="22" size="22"  placeholder="setПрізвище"></td>
                <td> <input type="email" name="email2" maxlength="22" size="22" placeholder="setEmail"  ></td>
                <td> <input type="text" name="sex2" maxlength="22" size="22" placeholder="setСтать"  ></td>
                <td> <input type="number" name="groupNumber2" maxlength="15" size="22" placeholder="setНомер групи"  ></td>
                <td> <input type='number' name='age2' value=''placeholder="Вік"/></td>
                <td><input type="text" name="cafedra2" maxlength="22" size="22"  placeholder="setКафедра" ></td>
            </tr>





        </table>
        <input type="submit" value="OK">
        <input type="reset" value="Cansel">
        </form>
<br>
<h1>Delete Student</h1>
<form method="post" action="search">

    <table class="table1" width="80%"style="table-layout:fixed;">

        <tr>
            <td ><b>ІД</b></td>
            <td><b>Ім'я</b></td>
            <td><b>Прізвище</b></td>
            <td><b>Email</b></td>
            <td><b>Стать</b></td>
            <td><b>Номер групи</b></td>
            <td><b>Вік</b></td>
            <td><b>Кафедра</b></td>
        </tr>
        <tr>
            <td ><b><input type='number' name='id3' value=''placeholder="ІД"></b></td>
            <td><input type="text" name="name3" maxlength="22" size="22"  placeholder="Ім'я"></td>
            <td><input type="text" name="surname3" maxlength="22" size="22"  placeholder="Прізвище"></td>
            <td> <input type="email" name="email3" maxlength="22" size="22" placeholder="Email"  ></td>
            <td> <input type="text" name="sex3" maxlength="22" size="22" placeholder="Стать"  ></td>
            <td> <input type="number" name="groupNumber3" maxlength="15" size="22" placeholder="Номер групи"  ></td>
            <td> <input type='number' name='age3' value=''placeholder="Вік"/></td>
            <td><input type="text" name="cafedra3" maxlength="22" size="22"  placeholder="Кафедра" ></td>
        </tr>

    </table>
    <input type="submit" value="OK">
    <input type="reset" value="Cansel">
</form>




</body>
</html>
