
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Mail box</title>
</head>
<body>
<h3>Language: ${email.language}</h3>
<h3>Page size: ${email.pageSize}</h3>
<h3>Spam filter: ${email.spam}</h3>
<h3>Signature: ${email.signature}</h3>
<button type="submit" onclick="window.location.href='email-config/update'">Edit</button>
</body>
</html>