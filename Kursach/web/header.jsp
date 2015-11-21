<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 12/13/2014
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>header</title>

    <link rel="stylesheet" href="content/css/style.css">
    <link rel="stylesheet" href="content/js/ddsmoothmenu.js">
    <link rel="stylesheet" href="content/css/style.css">
    <script type="text/javascript" src="content/js/jquery-1.5.min.js"></script>
    <script type="text/javascript" src="content/js/ddsmoothmenu.js"></script>
    <script type="text/javascript" src="content/js/scripts.js"></script>
    <script type="text/javascript" src="content/swfobject/swfobject.js"></script>
</head>
<body>

    <!-- Begin Header Wrapper -->
    <div id="page-top">
        <div id="header-wrapper">
            <!-- Begin Header -->
            <div id="header">

                <!-- Begin Menu -->
                <div id="menu-wrapper">
                    <div id="smoothmenu1" class="ddsmoothmenu">
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/" class="selected">Home</a></li>
                            <li><a href="${pageContext.request.contextPath}/showSheet.jsp">Progress</a></li>


                            <%--<li><a href="services.html">Services</a></li>--%>
                            <li><a>Tables</a>
                            <ul>
                            <li><a href="${pageContext.request.contextPath}/showStudent.jsp">Students</a></li>
                            <li><a href="${pageContext.request.contextPath}/showTeacher.jsp">Teachers</a></li>
                            <li><a href="${pageContext.request.contextPath}/showSheet.jsp">Sheet</a></li>
                            </ul>
                            </li>
                            <li><a>Change</a>
                                <ul>
                                    <li><a href="${pageContext.request.contextPath}/Search.jsp">searchStudents</a></li>
                                    <li><a href="${pageContext.request.contextPath}/searchTeacher.jsp">searchTeachers</a></li>
                                    <li><a href="${pageContext.request.contextPath}/searchSheetnew.jsp">searchSheet</a></li>
                                </ul>
                            </li>
                            <li><a href="${pageContext.request.contextPath}/addStudent.jsp">AddStudent</a></li>
                        </ul>
                    </div>
                </div>
                <!-- End Menu -->
            </div>
            <!-- End Header -->
        </div>

</div>
</body>
</html>
