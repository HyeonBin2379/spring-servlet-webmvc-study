<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2025-10-23
  Time: 오후 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Read Page</title>
</head>
<body>
    <h1>Read Page</h1>
    <form method="post">
        <div>
            <input type="text" name="tno" value="${dto.tno}" readonly><br/>
            <input type="text" name="title" value="${dto.title}" readonly><br/>
            <input type="date" name="dueDate" value="${dto.dueDate}" readonly><br/>
            <input type="checkbox" name="finished" checked="${dto.finished}" disabled><br/>
        </div>
        <div>
            <button type="submit" formaction="modify">Modify</button>
            <button type="submit" formaction="remove">Remove</button>
        </div>
    </form>
</body>
</html>
