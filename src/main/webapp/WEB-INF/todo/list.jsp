<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2025-10-23
  Time: 오후 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 현재 페이지에서 JSTL 라이브러리를 사용--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Todo List Page</title>
</head>
<body>
<%--${list}--%>
<%--<h3>${1+2+3}</h3>--%>
<%--<h3>${"AAA" += "BBB"}</h3>--%>
<%--<h3>${"AAA".equals("AAA")}</h3>--%>
<%--<h4>${list[0].tno}</h4>--%>
<%--<h4>${list[0].title}</h4>--%>
<%--<h4>${list[0].dueDate}</h4>--%>
    <h1>List Page</h1>
    <ul>
        <c:forEach var="dto" items="${list}">
          <li>${dto}</li>
        </c:forEach>
    </ul>

    <c:if test="${list.size() % 2 == 0}">
        짝수
    </c:if>
    <c:if test="${list.size() % 2 != 0}">
        홀수
    </c:if>

    <c:choose>
        <c:when test="${list.size() % 2 == 0}">
            짝수
        </c:when>
        <c:otherwise>
            홀수
        </c:otherwise>
    </c:choose>

    <c:set var="target" value="5"></c:set>
    <ul>
        <c:forEach var="num" begin="1" end="10">
            <li>${num}</li>
        </c:forEach>
    </ul>
</body>
</html>
