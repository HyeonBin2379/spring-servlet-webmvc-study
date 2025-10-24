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
    <form action="modify" method="get">
        <div>
            <input type="text" name="tno" value="${dto.tno}" readonly><br/>
            <input type="text" name="title" value="${dto.title}" readonly disabled><br/>
            <input type="date" name="dueDate" value="${dto.dueDate}" readonly disabled><br/>
            <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""} readonly disabled><br/>
        </div>
        <div>
            <button type="submit">Modify/Remove</button>
        </div>
    </form>
</body>
</html>
