<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NguyenNguyen
  Date: 12/10/2019
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- font awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <!--css-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <title>Popcorn - Action</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col align-self-center">
            <h1 class="display-4"><i class="fas fa-couch"></i> POPCORN</h1>
        </div>
    </div>
    <!--nav bar-->
    <ul class="nav nav-pills nav-fill justify-content-center">
        <li class="nav-item">
            <a class="nav-link" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="genre-list.jsp">Genres</a>
        </li>
        <li class="nav-item">
            <a class="nav-link active" href="action.jsp">Recommendations</a>
        </li>
    </ul>
    <!--content-->
    <div class="jumbotron my-2 border border-secondary">
        <h1 class="display-4"><i class="fas fa-list-ul"></i> Action Movies</h1>
    </div>
    <div class="container">
        <!--actions-->
        <ul class="nav nav-pills nav-fill justify-content-center">
            <li class="nav-item">
                <a class="nav-link" href="add-form.jsp">Add new movie</a>
            </li>
        </ul>
        <ul class="list-group movie-list">
            <li class="list-group-item">
                <div class="image-content">
                    <a href="avengers.jsp" title="Avengers: Endgame">
                        <img src="<c:url value="/resources/img/avengers.jpg"/>" alt="Avengers: Endgame" sizes="185px"/>
                    </a>
                </div>
                <div class="info">
                    <div class="wrapper">
                        <a class="title-list" href="avengers.jsp" title="Avengers: Endgame">Avengers: Endgame</a>
                    </div>
                    <p class="overview">
                        After the devastating events of Avengers: Infinity War,
                        the universe is in ruins due to the efforts of the Mad Titan, Thanos.
                        With the help of remaining allies, the Avengers must assemble once more in order to undo…
                    </p>
                    <p class="view-more">
                        <a class="title-list" href="avengers.jsp" title="Avengers: Endgame">More Info</a>
                        <a class="title-list" href="#">Edit</a>
                    </p>
                </div>
            </li>
            <li class="list-group-item">
                <div class="image-content">
                    <a href="hobbsandshaw.jsp" title="Fast & Furious Presents: Hobbs & Shaw">
                        <img src="<c:url value="/resources/img/hobbsandshaw.jpg"/>" alt="Fast & Furious Presents: Hobbs & Shaw" sizes="185px"/>
                    </a>
                </div>
                <div class="info">
                    <div class="wrapper">
                        <a class="title-list" href="hobbsandshaw.jsp" title="Fast & Furious Presents: Hobbs & Shaw">Fast & Furious Presents: Hobbs & Shaw</a>
                    </div>
                    <p class="overview">
                        A spinoff of The Fate of the Furious, focusing on
                        Johnson's US Diplomatic Security Agent Luke Hobbs
                        forming an unlikely alliance with Statham's Deckard Shaw.
                    </p>
                    <p class="view-more">
                        <a class="title-list" href="hobbsandshaw.jsp" title="Fast & Furious Presents: Hobbs & Shaw">More Info</a>
                    </p>
                </div>
            </li>
            <li class="list-group-item">
                <div class="image-content">
                    <a href="godzilla.jsp" title="Godzilla: King of the Monsters">
                        <img src="<c:url value="/resources/img/godzilla.jpg"/>" alt="Godzilla: King of the Monsters" sizes="185px"/>
                    </a>
                </div>
                <div class="info">
                    <div class="wrapper">
                        <a class="title-list" href="godzilla.jsp" title="Godzilla: King of the Monsters">Godzilla: King of the Monsters</a>
                    </div>
                    <p class="overview">
                        Follows the heroic efforts of the crypto-zoological
                        agency Monarch as its members face off against a battery
                        of god-sized monsters, including the mighty Godzilla,
                        who collides with Mothra, Rodan, and his ultimate…
                    </p>
                    <p class="view-more">
                        <a class="title-list" href="godzilla.jsp" title="Godzilla: King of the Monsters">More Info</a>
                    </p>
                </div>
            </li>
            <li class="list-group-item">
                <div class="image-content">
                    <a href="johnwick3.jsp" title="John Wick: Chapter 3 – Parabellum">
                        <img src="<c:url value="/resources/img/johnwick3.jpg"/>" alt="John Wick: Chapter 3 – Parabellum" sizes="185px"/>
                    </a>
                </div>
                <div class="info">
                    <div class="wrapper">
                        <a class="title-list" href="johnwick3.jsp" title="John Wick: Chapter 3 – Parabellum">John Wick: Chapter 3 – Parabellum</a>
                    </div>
                    <p class="overview">
                        Super-assassin John Wick returns with a $14 million
                        price tag on his head and an army of bounty-hunting
                        killers on his trail. After killing a member of the
                        shadowy international assassin’s guild, the High Table…
                    </p>
                    <p class="view-more">
                        <a class="title-list" href="johnwick3.jsp" title="John Wick: Chapter 3 – Parabellum">More Info</a>
                    </p>
                </div>
            </li>
        </ul>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
