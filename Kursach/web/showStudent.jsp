
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="connection.ConnectionPool" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 12/11/2014
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="content/css/style.css">
</head>
<body>

<jsp:include page="header.jsp"/>
<h1>Students:</h1>
<table class="table1" width="80%">


    <tr>
        <td align="center"><b>ІД</b></td>
        <td><b>Ім'я</b></td>
        <td><b>Прізвище</b></td>
        <td><b>Email</b></td>
        <td><b>Стать</b></td>
        <td><b>Номер групи</b></td>
        <td><b>Вік</b></td>
        <td><b>Кафедра</b></td>
    </tr>
    <%



        try {
            String query="select * from students";


            Statement statement= ConnectionPool.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){

                out.println("<TR><TD>" + resultSet.getInt(1));
                out.println("<TD>" + resultSet.getString(2));
                out.println("<TD>" + resultSet.getString(3));
                out.println("<TD>" + resultSet.getString(4));
                out.println("<TD>" + resultSet.getString(5));
                out.println("<TD>" + resultSet.getInt(6));
                out.println("<TD>" + resultSet.getInt(7));
                out.println("<TD>" + resultSet.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    %>
</TABLE>
</body>
</html>
