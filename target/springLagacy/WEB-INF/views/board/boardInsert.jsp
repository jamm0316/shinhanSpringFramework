<%--
  Created by IntelliJ IDEA.
  User: evan
  Date: 12/4/24
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="input-group mb-3">
    <%--include 디렉티브 태그는 jsp를 합쳐서 컴파일 한다.--%>
    <%@include file="../jsp/header.jsp" %>
    <form class="insertCard" action="insert.do" method="post" enctype="multipart/form-data">

        <h2>게시글 등록</h2>
        <div class="input-group mb-3">
            <span class="input-group-text">제목</span>
            <input type="text" required="required" class="form-control" placeholder="제목" name="title"
                   aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">내용</span>
            <input type="text" required="required" class="form-control" placeholder="내용" name="content"
                   aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">이미지선택</span>
            <input type="file" class="form-control" placeholder="이미지선택" name="pic"
                   aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <input type="submit" class="btn btn-primary" value="입력">
        </div>
    </form>
</body>
</html>
