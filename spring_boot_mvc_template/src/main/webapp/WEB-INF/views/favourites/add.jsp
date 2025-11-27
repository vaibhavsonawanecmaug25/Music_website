<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Add Favourite Song</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>

<body>

<div class="container mt-4">

    <h2 class="text-center mb-4">Add Favourite Song</h2>

    <form action="${pageContext.request.contextPath}/favourites/add"
          method="post" class="shadow p-4">

        <input type="hidden" name="userId" value="${userId}"/>

        <div class="form-group">
            <label>Select Song:</label>
            <select name="songId" class="form-control" required>
                <c:forEach var="s" items="${songs}">
                    <option value="${s.songId}">
                        ${s.title} (${s.genre})
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group text-center">
            <button class="btn btn-success">Add to Favourites</button>
            <a href="${pageContext.request.contextPath}/favourites/list?userId=${userId}"
               class="btn btn-secondary">Cancel</a>
        </div>

    </form>

</div>

</body>
</html>
