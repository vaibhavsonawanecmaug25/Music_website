<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Song List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-4">
    <h2 class="text-center mb-4">All Songs</h2>

    <div class="text-right mb-3">
        <a href="${pageContext.request.contextPath}/songs/add" class="btn btn-primary">
            + Add New Song
        </a>
    </div>

    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Duration (sec)</th>
            <th>Actions</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="song" items="${song_list}">
            <tr>
                <td>${song.songId}</td>
                <td>${song.title}</td>
                <td>${song.genre}</td>
                <td>${song.duration}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/songs/delete/${song.songId}"
                       class="btn btn-danger btn-sm"
                       onclick="return confirm('Are you sure you want to delete this song?');">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
