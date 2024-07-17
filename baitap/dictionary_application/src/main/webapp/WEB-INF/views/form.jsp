<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/12/2024
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictionary/a" method="post">
    <input type="text" placeholder="Tiếng anh" name="keyword">
    <button type="submit">Dịch</button>
    result : ${result}
</form>
${message}
</body>
</html>
