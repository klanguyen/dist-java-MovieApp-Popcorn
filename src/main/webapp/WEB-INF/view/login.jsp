<%--
  Created by IntelliJ IDEA.
  User: NguyenNguyen
  Date: 1/28/2020
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Popcorn - Login </title>
    <link type="text/css" rel="stylesheet" href="${cp}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${cp}/resources/css/movie-form-style.css">
    <link type="text/css" rel="stylesheet" href="${cp}/resources/css/select-style.css">
</head>
<body>
<%@ include file="/WEB-INF/view/header.jsp"%>

<div class="container">
    <div id="content">
        <h3>Login</h3>
        <form:form action="${cp}/authenticate" method="POST">
            <table>
                <!-- Only show this message if the user has been logged out -->
                <c:if test="${param.logout != null}">
                    <tr>
                        <td></td>
                        <td>You have been logged out</td>
                    </tr>
                </c:if>
                <tr>
                    <td><label>Username</label></td>
                    <!-- Spring expect this to have name="username" -->
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td><label>Password</label></td>
                    <!-- Spring expect this to have name="password" -->
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login"></td>
                </tr>
                <!-- Only show this row if there was a login error -->
                <c:if test="${param.error != null}">
                    <tr>
                        <td></td>
                        <td class="error">Invalid login</td>
                    </tr>
                </c:if>
            </table>
        </form:form>
    </div>

    <%@ include file="/WEB-INF/view/footer.jsp"%>
</div>

</body>
</html>
