<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en-US">
<head>
    <link href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div>
    <canvas id="pieChart" width=700 height=700></canvas>

    <script src="//rawgit.com/FVANCOP/ChartNew.js/master/ChartNew.js" ></script>
    <script src="/webjars/drawChart.js"></script>
    <script>

        var newopts = {
            annotateDisplay : true,
            inGraphDataShow : true

        }
        var pieData = [
            <c:forEach items="${genresCount}" var="genreData" varStatus="loop">
            {
                value: ${genreData.count},
                title : "${genreData.name}",
                color: Colors.random()
            }<c:if test="${!loop.last}">,</c:if>
            </c:forEach>
        ];
        var pieCtx = document.getElementById('pieChart').getContext('2d');
        new Chart(pieCtx).Pie(pieData, newopts);
    </script>
</div>

</body>
</html>