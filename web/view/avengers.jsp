<%--
  Created by IntelliJ IDEA.
  User: NguyenNguyen
  Date: 12/10/2019
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- font awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <title>Popcorn - Avengers</title>
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
        <div class="poster">
            <img src="/resources/img/avengers-poster.jpg">
        </div>
        <div class="header_poster_wrapper">
            <section class="header poster">
                <div class="title" dir="auto">
                    <span><h2>Avengers: Endgame (2019)</h2></span>
                </div>
                <div class="header_info">
                    <h3 dir="auto">Overview</h3>
                    <div class="overview" dir="auto"></div>
                    <h3 class="featured" dir="auto">Featured Crew</h3>
                    <ol class="people no_image">
                        <li class="profile">
                            <p>Joe Russo</p>
                            <p class="character">Director</p>
                        </li>
                        <li class="profile">
                            <p>Anthony Russo</p>
                            <p class="character">Director</p>
                        </li>
                        <li class="profile">
                            <p>Stephen McFeely</p>
                            <p class="character">Screenplay</p>
                        </li>
                        <li class="profile">
                            <p>Christopher Markus</p>
                            <p class="character">Screenplay</p>
                        </li>
                    </ol>
                    <h3 class="genre" dir="auto">Genres</h3>
                    <ol class="genre_list">
                        <li>Action</li>
                        <li>Sci-Fi</li>
                    </ol>
                </div>
            </section>
        </div>
    </div>

</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
