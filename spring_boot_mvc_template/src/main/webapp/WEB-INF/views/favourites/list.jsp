<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User Favourites</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-4">

    <h2 class="text-center mb-4">Favourite Songs</h2>

    <div class="text-right mb-3">
        <a href="${pageContext.request.contextPath}/favourites/add?userId=${userId}"
           class="btn btn-primary">+ Add Favourite</a>
    </div>

    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>Song ID</th>
            <th>Song Title</th>
            <th>Genre</th>
            <th>Remove</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="fav" items="${fav_list}">
            <tr>
                <td>${fav.song.songId}</td>
                <td>${fav.song.title}</td>
                <td>${fav.song.genre}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/favourites/remove?userId=${userId}&songId=${fav.song.songId}"
                       class="btn btn-danger btn-sm"
                       onclick="return confirm('Remove this song from favourites?');">
                        Remove
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>

</body>
</html>
