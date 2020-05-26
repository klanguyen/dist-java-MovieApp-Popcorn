<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Movie List</title>
    <link rel="stylesheet" type="text/css" href="${cp}/resources/css/style.css">
</head>
<body>

<%@ include file="header.jsp" %>

<div id="container">
    <div id="content">
        <!-- Only show add movie button if user is logged in -->
        <security:authorize access="hasRole('USER')">
            <button class="add-button"
                    onclick="window.location.href='${cp}/movie/user/showAddMovieForm'; return false;">
                Add Movie
            </button>
        </security:authorize>

        <!--Search form-->
        <form:form method="GET" action="search">
            Search movies <input type="search" name="searchTerm">
            <input type="submit" value="Search" class="add-button">
        </form:form>

        <!--Movie list table-->
        <table>
            <tr>
                <th>Genre</th>
                <th>Name</th>
                <th>Overview</th>
                <!-- Only show table header if user is logged in -->
                <security:authorize access="hasAnyRole('USER,ADMIN')">
                    <th>Action</th>
                </security:authorize>
            </tr>

            <c:forEach var="tempMovie" items="${movies}">
                <!--construct an update link with movie id-->
                <!--c:url is same as JSP's response.encodeURL()-->
                <c:url var="updateLink" value="/movie/user/showUpdateMovieForm">
                    <c:param name="movieId" value="${tempMovie.id}"/>
                </c:url>

                <!--construct a delete link with movie id-->
                <c:url var="deleteLink" value="/movie/admin/delete">
                    <c:param name="movieId" value="${tempMovie.id}"/>
                </c:url>

                <tr>
                    <td>
                        <c:forEach var="tempGenre" items="${tempMovie.genres}">
                            ${tempGenre.description}&nbsp;
                        </c:forEach>
                    </td>
                    <td>${tempMovie.name}</td>
                    <td>${tempMovie.overview}</td>
                    <!-- Only show this last cell if the user is logged in -->
                    <security:authorize access="hasAnyRole('USER,ADMIN')">
                        <td>
                            <!-- Display the update link -->
                            <a href="${updateLink}">Update</a>
                            <!-- Only display the delete link if user is admin -->
                            <security:authorize access="hasRole('ADMIN')">
                                &nbsp;|&nbsp;
                                <a href="${deleteLink}"
                                   onclick="if(!confirm('Are you sure?')) return false">Delete</a>
                            </security:authorize>
                        </td>
                    </security:authorize>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>

</html>