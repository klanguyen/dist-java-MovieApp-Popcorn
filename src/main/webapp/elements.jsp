<%--
  Created by IntelliJ IDEA.
  User: NguyenNguyen
  Date: 2/7/2020
  Time: 6:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body {
            background-color: floralwhite;
            font-family: sans-serif;
            font-size: larger;
        }
        table {
            border: 2px dashed saddlebrown;
        }
        td {
            border: 1px solid sandybrown;
            padding: 5px;
            text-align: center;
        }
    </style>
    <!--include the current date and time in the page title-->
    <title>JSP Elements: <%= new java.util.Date() %></title>
</head>
<body>
<!--include a file-->
<%@include file="header.jsp"%>

<!--Create the method-->
<%!
    public String createTableDetail(int num) {
    return "<td>" + num + "</td>";
    }
%>

<table>
    <!--use the method to ouput a multiplication table-->
    <%
        for (int row = 1; row < 5; row++) {
            out.write("<tr>");
            for (int col = 1; col < 5; col++) {
                out.write(createTableDetail(row*col));
            }
            out.write("</tr>");
        }
    %>
</table>

<%@include file="footer.jsp"%>
</body>
</html>
