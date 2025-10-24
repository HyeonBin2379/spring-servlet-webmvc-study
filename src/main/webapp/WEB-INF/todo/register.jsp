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
    <title>Todo Register Page</title>
</head>
<body>
    <h1>Todo Register Page</h1>
    <form action="/todo/register" method="post">
        <div>
            <input type="text" name="title" placeholder="INSERT TITLE" required><br/>
            <input type="date" name="dueDate" required>
        </div>
        <div>
            <button type="reset">RESET</button>
            <button type="submit">REGISTER</button>
        </div>
    </form>
</body>
</html>
