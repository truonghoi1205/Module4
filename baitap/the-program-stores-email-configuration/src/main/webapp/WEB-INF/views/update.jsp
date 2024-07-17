<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/16/2024
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Mail Box Settings</title>
</head>
<body>
<h2>Update Mailbox Settings</h2>

<form:form method="post" modelAttribute="email" action="/email-config/update">
    <label for="language">Language:</label>
    <form:select path="language">
        <form:options items="${languages}" />
    </form:select>
    <br>

    <label for="pageSize">Page size:</label>
    <form:select path="pageSize">
        <form:options items="${sizes}" />
    </form:select>
    <br>

    <label for="spam">Spam filter:</label>
    <form:checkbox path="spam" />
    <br>

    <label for="signature">Signature:</label>
    <form:textarea path="signature" />
    <br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>