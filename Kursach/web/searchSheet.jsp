<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 12/16/2014
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="header.jsp"/>

<h1>Search Student</h1>
<form method="post" action="search">

    <table class="table1" width="80%"style="table-layout:fixed;">

        <tr>
            <td ><b>ІД табл</b></td>
            <td ><b>ІД студента</b></td>
            <td><b>Прізвище</b></td>
            <td><b>Предмет</b></td>
            <td><b>Оцінка</b></td>
            <td><b>Кафедра</b></td>
            <td><b>Група</b></td>
            <td><b>Викладач</b></td>
        </tr>
        <tr>
            <td ><b><input type='number' name='idtable' value=''placeholder="ІД"></b></td>
            <td><input type="text" name="idstudena" maxlength="22" size="22"  placeholder="ID_student"></td>
            <td><input type="text" name="surname" maxlength="22" size="22"  placeholder="Surname"></td>
            <td> <input type="email" name="subject" maxlength="22" size="22" placeholder="Subject"  ></td>
            <td> <input type="text" name="mark" maxlength="22" size="22" placeholder="Mark"  ></td>
            <td> <input type="number" name="cafedraName" maxlength="15" size="22" placeholder="Cafedra"  ></td>
            <td> <input type='number' name='group' value=''placeholder="Вік"/></td>
            <td><input type="text" name="teacherName" maxlength="22" size="22"  placeholder="teacher" ></td>
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
<h1>Reset Student</h1>
<form method="post" action="search">

    <table class="table1" width="80%"style="table-layout:fixed;">


        <tr>
            <td ><b>ІД табл</b></td>
            <td ><b>ІД студента</b></td>
            <td><b>Прізвище</b></td>
            <td><b>Предмет</b></td>
            <td><b>Оцінка</b></td>
            <td><b>Кафедра</b></td>
            <td><b>Група</b></td>
            <td><b>Викладач</b></td>
        </tr>
        <tr>
            <td ><b><input type='number' name='idtable1' value=''placeholder="ІД"></b></td>
            <td><input type="text" name="idstudena1" maxlength="22" size="22"  placeholder="ID_student"></td>
            <td><input type="text" name="surname1" maxlength="22" size="22"  placeholder="Surname"></td>
            <td> <input type="email" name="subject1" maxlength="22" size="22" placeholder="Subject"  ></td>
            <td> <input type="text" name="mark1" maxlength="22" size="22" placeholder="Mark"  ></td>
            <td> <input type="number" name="cafedraName1" maxlength="15" size="22" placeholder="Cafedra"  ></td>
            <td> <input type='number' name='group1' value=''placeholder="Вік"/></td>
            <td><input type="text" name="teacherName1" maxlength="22" size="22"  placeholder="teacher" ></td>
        </tr>
        <tr>
            <td ><b>Set date</b></td>
            <td><input type="text" name="idstudena2" maxlength="22" size="22"  placeholder="ID_student"></td>
            <td><input type="text" name="surname2" maxlength="22" size="22"  placeholder="Surname"></td>
            <td> <input type="email" name="subject2" maxlength="22" size="22" placeholder="Subject"  ></td>
            <td> <input type="text" name="mark2" maxlength="22" size="22" placeholder="Mark"  ></td>
            <td> <input type="number" name="cafedraName2" maxlength="15" size="22" placeholder="Cafedra"  ></td>
            <td> <input type='number' name='group2' value=''placeholder="Вік"/></td>
            <td><input type="text" name="teacherName2" maxlength="22" size="22"  placeholder="teacher" ></td>
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
            <td ><b>ІД табл</b></td>
            <td ><b>ІД студента</b></td>
            <td><b>Прізвище</b></td>
            <td><b>Предмет</b></td>
            <td><b>Оцінка</b></td>
            <td><b>Кафедра</b></td>
            <td><b>Група</b></td>
            <td><b>Викладач</b></td>
        </tr>
        <tr>
            <td ><b><input type='number' name='idtable3' value=''placeholder="ІД"></b></td>
            <td><input type="text" name="idstudena3" maxlength="22" size="22"  placeholder="ID_student"></td>
            <td><input type="text" name="surname3" maxlength="22" size="22"  placeholder="Surname"></td>
            <td> <input type="email" name="subject3" maxlength="22" size="22" placeholder="Subject"  ></td>
            <td> <input type="text" name="mark3" maxlength="22" size="22" placeholder="Mark"  ></td>
            <td> <input type="number" name="cafedraName3" maxlength="15" size="22" placeholder="Cafedra"  ></td>
            <td> <input type='number' name='group3' value=''placeholder="Вік"/></td>
            <td><input type="text" name="teacherName3" maxlength="22" size="22"  placeholder="teacher" ></td>
        </tr>

    </table>
    <input type="submit" value="OK">
    <input type="reset" value="Cansel">
</form>
</body>
</html>
