<%@ page import="DB.Sheet" %>
<%@ page import="java.util.List" %>
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

<h1>Search Sheet</h1>
<form method="post" action="searchSheetnew">

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
            <td><input type="text" name="idstudenta" maxlength="22" size="22"  placeholder="ID_student"></td>
            <td><input type="text" name="surname" maxlength="22" size="22"  placeholder="Surname"></td>
            <td> <input type="email" name="subject" maxlength="22" size="22" placeholder="Subject"  ></td>
            <td> <input type="text" name="mark" maxlength="22" size="22" placeholder="Mark"  ></td>
            <td> <input type="number" name="cafedraName" maxlength="15" size="22" placeholder="Cafedra"  ></td>
            <td> <input type='number' name='group' value=''placeholder="group"/></td>
            <td><input type="text" name="teacherName" maxlength="22" size="22"  placeholder="teacher" ></td>
        </tr>


        <%

            List<Sheet> sheetList;
            sheetList= (List<Sheet>) session.getAttribute("getSheet");
            if (sheetList != null){
                for(Sheet sheet : sheetList) {
                    if (sheet != null) {
                        out.println("<TR><TD>" + sheet.getSheetId());
                        out.println("<TD>" + sheet.getStudentId());
                        out.println("<TD>" + sheet.getLastName());
                        out.println("<TD>" + sheet.getSubjectName());
                        out.println("<TD>" + sheet.getMark());
                        out.println("<TD>" + sheet.getDepartmentName());
                        out.println("<TD>" + sheet.getGroupNum());
                        out.println("<TD>" + sheet.getTeacherName());
                    }
                }
            }

        %>

    </table>
    <input type="submit" value="OK">
    <input type="reset" value="Cansel">
</form>

</body>
</html>
