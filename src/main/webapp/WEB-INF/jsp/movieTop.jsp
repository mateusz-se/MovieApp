<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8">
    <title>Spring MVC and Hibernate Template</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">

    <!--
      IMPORTANT:
      This is Heroku specific styling. Remove to customize.
    -->
    <link href="http://heroku.github.com/template-app-bootstrap/heroku.css" rel="stylesheet">
    <!-- /// -->

</head>

<body>
<div class="container">
    <div class="row">
        <div class="span8 offset2">
            <div class="page-header">
                <h1>Top 20 Movies</h1>
            </div>
            <p><a href="search/">Search</a></p>
            <p><a href="topGenres/">Genre popularity chart</a></p>
            <c:if  test="${!empty movies}">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>Title</th>
                        <th>Average Votes</th>
                        <th>Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${movies}" var="movie">
                        <tr>
                            <td>${movie.title}</td>
                            <td>${movie.voteAverage}</td>
                            <td><a href="movie/${movie.id}/">Details</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>
<script>angular.module('hello', [])
        .controller('home', function($scope) {
            $scope.greeting = {id: 'xxx', content: 'Hello World!'}
        })</script>
</body>
</html>
