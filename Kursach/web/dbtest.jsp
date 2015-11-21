<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
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
    <title></title>
</head>
<body>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%


        try {
            String query="select * from userr";

            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("jdbc/NitConnectionPool");
            Connection conn = ds.getConnection();
            Statement statement= ConnectionPool.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){

               out.println("id: " + resultSet.getInt(1));
                out.println("; name: " + resultSet.getString("username"));
                System.out.println("; pass: " + resultSet.getString("password"));
                System.out.println("<br>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


%>
</body>
</html>
