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
    <title>Gia vị đã chọn</title>
</head>
<body>
<h2>Bạn đã chọn các loại gia vị sau cho bánh sandwich của mình:</h2>
<ul>
    <c:forEach var="condiment" items="${selectedCondiments}">
        <li>${condiment}</li>
    </c:forEach>
</ul>
</body>
</html>