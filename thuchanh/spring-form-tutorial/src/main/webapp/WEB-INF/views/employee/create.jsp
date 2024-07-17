<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/15/2024
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Tạo một nhân viên mới</title>
</head>
<body>
<h3>Chào mừng, nhập thông tin nhân viên</h3>
<%--@elvariable id="employee" type=""--%>
<form:form method="POST" action="addEmployee" modelAttribute="employee">
    <table>
        <tr>
            <td><form:label path="id">ID nhân viên: </form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Tên nhân viên: </form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="contactNumber">Số đt liên lạc: </form:label></td>
            <td><form:input path="contactNumber"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Lưu"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
