<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

"<html>

<head>
    <meta charset="utf-8">
    <title>Spring MVC and Hibernate Template</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>

    <!-- /// -->

</head>

<body>

<a href="../">Search</a>
<div class="container">
    <div class="row">
        <div class="span8 offset2">
            <div class="page-header">
                <h1>${movie.title}</h1>
            </div>

                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${movie.title}</td>
                            <td>${movie.voteAverage}</td>
                            <td>| <c:forEach items="${genres}" var="genre">
                            ${genre.name} |
                        </c:forEach> </td>
                         </tr>

                    </tbody>
                </table>

                    <div ng-app="getPlot" ng-controller="plotController">
                        <p>{{ plot }}</p>
                    </div>

            <script>
                var app = angular.module('getPlot', []);
                app.controller('plotController', function($scope, $http) {
                    $http.get("//www.omdbapi.com/?t=${movie.title.replace(":", "%3A")}&y=&plot=full&r=json")
                            .success(function(response) {$scope.plot = response.Plot;});
                });
            </script>
        </div>
    </div>
</div>

</body>

</html>
