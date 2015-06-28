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

    <script src=//rawgit.com/FVANCOP/ChartNew.js/master/ChartNew.js ></script>
    <script>
        Colors = {};
        Colors.names = {
            aqua: "#00ffff",
            azure: "#f0ffff",
            beige: "#f5f5dc",
            black: "#000000",
            blue: "#0000ff",
            brown: "#a52a2a",
            cyan: "#00ffff",
            darkblue: "#00008b",
            darkcyan: "#008b8b",
            darkgrey: "#a9a9a9",
            darkgreen: "#006400",
            darkkhaki: "#bdb76b",
            darkmagenta: "#8b008b",
            darkolivegreen: "#556b2f",
            darkorange: "#ff8c00",
            darkorchid: "#9932cc",
            darkred: "#8b0000",
            darksalmon: "#e9967a",
            darkviolet: "#9400d3",
            fuchsia: "#ff00ff",
            gold: "#ffd700",
            green: "#008000",
            indigo: "#4b0082",
            khaki: "#f0e68c",
            lightblue: "#add8e6",
            lightcyan: "#e0ffff",
            lightgreen: "#90ee90",
            lightgrey: "#d3d3d3",
            lightpink: "#ffb6c1",
            lightyellow: "#ffffe0",
            lime: "#00ff00",
            magenta: "#ff00ff",
            maroon: "#800000",
            navy: "#000080",
            olive: "#808000",
            orange: "#ffa500",
            pink: "#ffc0cb",
            purple: "#800080",
            violet: "#800080",
            red: "#ff0000",
            silver: "#c0c0c0",
            yellow: "#ffff00"
        };
        Colors.random = function() {
            var result;
            var count = 0;
            for (var prop in this.names)
                if (Math.random() < 1/++count)
                    result = prop;
            return result;
        };
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