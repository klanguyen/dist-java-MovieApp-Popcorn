<%--
  Created by IntelliJ IDEA.
  User: NguyenNguyen
  Date: 1/31/2020
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Popcorn - Search</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form method="get" action="search2">
    <input type="text" placeholder="Enter a movie name" name="searchTerm"><br/><br/>
    <input type="submit" value="Search">
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>