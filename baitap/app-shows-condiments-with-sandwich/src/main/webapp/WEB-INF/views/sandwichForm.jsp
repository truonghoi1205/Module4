<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/14/2024
  Time: 12:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gia vị Sandwich</title>
</head>
<body>
<form action="save" method="post">
    <h2>Chọn gia vị cho Sandwich:</h2>
    <c:forEach var="condiment" items="${condiments}">
        <input type="checkbox" name="condiments" value="${condiment}"/> ${condiment}
    </c:forEach>
    <c:if test="${message != null}">
        <h2>${message}</h2>
    </c:if>
    <input type="submit" value="Chọn"/>
</form>

</body>
</html>
