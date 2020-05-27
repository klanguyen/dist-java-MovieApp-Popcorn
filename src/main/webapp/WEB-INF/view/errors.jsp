<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Oops! An Error Occurred</title>
    <link rel="stylesheet" type="text/css" href="${cp}/resources/css/style.css">
</head>
<body>

<%@ include file="header.jsp" %>

<div id="container">
    <div id="content">
        <p>${errorMessage}</p>
    </div>
</div>

<security:authorize access="hasRole('ADMIN')">
    <c:forEach items="${exception.stackTrace}" var="element">
        <c:out value="${element}"/>
    </c:forEach>
</security:authorize>

<%@ include file="footer.jsp" %>
</body>
</html>