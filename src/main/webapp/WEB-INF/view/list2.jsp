<%--
  Created by IntelliJ IDEA.
  User: NguyenNguyen
  Date: 2/7/2020
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Movies</title>
    <link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<body>
<jsp:include page="header.jsp"/>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Overview</th>
        <th>Year</th>
    </tr>
    <c:forEach var="movie" items="${movies}">
        <tr>
            <td>${movie.movieId}</td>
            <td>${movie.name}</td>
            <td>${movie.overview}</td>
            <td>${movie.year}</td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="footer.jsp"/>
</body>
</html>
