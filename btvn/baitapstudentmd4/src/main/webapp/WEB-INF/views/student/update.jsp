<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Cập nhật học sinh</title>
    <meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Trang chủ</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="/student">Học sinh</a>
                <a class="nav-link" href="/teacher">Giáo viên</a>
                <a class="nav-link" href="/class">Lớp học</a>
            </div>
        </div>
    </div>
</nav>
<div class="container">
    <form:form method="post" modelAttribute="student" action="/student/update">
        <div class="mb-3">
            <form:input type="hidden" class="form-control" id="id" path="id"/>
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Họ và tên</label>
            <form:input type="text" class="form-control" id="name" path="name"/>
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Địa chỉ</label>
            <form:input type="text" class="form-control" id="address" path="address"/>
        </div>
        <div class="mb-3">
            <label class="form-label" for="score">Điểm</label>
            <form:input type="text" class="form-control" id="score" path="score"/>
        </div>
        <button class="btn btn-primary">Submit</button>
    </form:form>
    <p>${error}</p>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>