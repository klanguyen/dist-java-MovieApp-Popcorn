<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Movie Library - Add New Movie</title>
    <link rel="stylesheet" type="text/css" href="${cp}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="${cp}/resources/css/movie-form-style.css">
    <link rel="stylesheet" type="text/css" href="${cp}/resources/css/select-style.css">
</head>
<body>

<%@ include file="header.jsp" %>

<div id="container">
    <div id="content">
        <form:form action="${cp}/movie/save" modelAttribute="aMovie" enctype="multipart/form-data"
                   method="post">
            <form:hidden path="id" value="${aMovie.id}"/>

            <table>
                <tr>
                    <td><label>Name</label></td>
                    <td><form:input path="name"/>
                        <form:errors path="name" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Overview</label></td>
                    <td><form:input path="overview"/>
                        <form:errors path="overview" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Genre</label></td>
                    <td>
                        <form:select path="genres" items="${genres}" itemLabel="name" itemValue="id"
                                        cssClass="select-css">
                        </form:select>
                        <form:errors path="genres" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>
            </table>

        </form:form>

        <%@ include file="footer.jsp" %>
    </div>
</div>

</body>
</html>