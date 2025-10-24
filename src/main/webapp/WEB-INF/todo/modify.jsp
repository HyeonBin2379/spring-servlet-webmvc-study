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
    <title>Todo Modify Page</title>
</head>
<body>
    <h1>Todo Modify Page</h1>
    <form method="post">
        <div>
            <input type="text" name="tno" value="${dto.tno}" readonly><br/>
            <input type="text" name="title" value="${dto.title}"><br/>
            <input type="date" name="dueDate" value="${dto.dueDate}"><br/>
            <input type="checkbox" name="finished" value="${dto.finished}"><br/>
        </div>
        <div>
            <button type="submit" formaction="modify">Modify</button>
            <button type="submit" formaction="remove">Remove</button>
        </div>
    </form>
</body>
</html>
