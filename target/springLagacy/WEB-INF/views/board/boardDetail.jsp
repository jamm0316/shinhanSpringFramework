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
    <form class="insertCard" action="update.do" method="post">
        <h2>게시글 등록</h2>
        <div class="input-group mb-3">
            <span class="input-group-text">넘버</span>
            <input type="text" required="required" class="form-control" placeholder="넘버" name="board_no"
                   aria-describedby="basic-addon1" value="${boardDTO.board_no}" readonly="readonly">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">제목</span>
            <input type="text" required="required" class="form-control" placeholder="제목" name="title"
                   aria-describedby="basic-addon1" value="${boardDTO.title}">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">내용</span>
            <input type="text" required="required" class="form-control" placeholder="내용" name="content"
                   aria-describedby="basic-addon1" value="${boardDTO.content}">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">작성자</span>
            <input type="text" required="required" class="form-control" placeholder="작성자" name="writer"
                   aria-describedby="basic-addon1" value="${boardDTO.writer}" readonly="readonly">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">작성일</span>
            <input type="text" required="required" class="form-control" placeholder="등록일" name="regdate"
                   aria-describedby="basic-addon1" value="${boardDTO.regdate}" readonly="readonly">
        </div>
        <div class="input-group mb-3">
            <input hidden="hidden" type="text" required="required" class="form-control" placeholder="등록일" name="pic"
                   aria-describedby="basic-addon1" value="${boardDTO.pic}" readonly="readonly">
            <img src="${path}/resources/upload/${boardDTO.pic}" alt="${boardDTO.title}이미지" style="max-width: 300px;"/>
        </div>
        <c:if test="${loginMember.member_id == boardDTO.writer}">
        <div class="input-group mb-3">
            <input type="submit" class="btn btn-primary" value="수정">
        </div>
        </c:if>
    </form>
</body>
</html>
