<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/12/2024
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Chuyển đổi tiền tệ</h2>
<form action="/currency/convert" method="post">
    <label for="usd">Số tiền USD:</label>
    <input type="text" id="usd" name="usd"><br><br>
    <input type="submit" value="Đổi">
</form>
</body>
</html>
