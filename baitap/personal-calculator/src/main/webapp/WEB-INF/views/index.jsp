<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="home" method="post">
  <h2>Calculator</h2>
  <input type="text" name="numStr1" value="0">
  <input type="text" name="numStr2" value="0">
  <div style="margin-top: 10px">
    <button name="operation" value="add">Addition(+)</button>
    <button name="operation" value="subtract">Subtraction(-)</button>
    <button name="operation" value="multiply">Multiplication(X)</button>
    <button name="operation" value="divide">Division(/)</button>
  </div>
</form>
<h2>Kết quả : ${result}</h2>
<c:if test="${not empty error}">
  <h2>Lỗi : ${error}</h2>
</c:if>
</body>
</html>