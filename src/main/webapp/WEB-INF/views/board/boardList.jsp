<%--
  Created by IntelliJ IDEA.
  User: evan
  Date: 12/4/24
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../jsp/header.jsp"/>
<c:set var="path" value="${pageContext.servletContext.contextPath}"/>
<h1>게시목록</h1>
<img alt="아이유" src="${path}/resources/image/upload/image.png" width="200"/>
<div class="input-group mb-3">
    <a class="btn btn-primary" href="${path}/board/insert.do">게시글 입력</a>
    <table class="table table-striped color black">
        <tr>
            <td>순서</td>
            <td>게시번호</td>
            <td>제목</td>
            <td>내용</td>
            <td>작성자</td>
            <td>작성일</td>
            <td>이미지</td>
            <td>삭제하기</td>
        </tr>
        <c:forEach var="board" items="${boardList}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td><a href="${path}/board/detail.do?bno=${board.board_no}">${board.board_no}</a></td>
                <td>${board.title}</td>
                <td>${board.content}</td>
                <td>${board.writer}</td>
                <td>${board.regdate}</td>
                <td>${board.pic}</td>
                <c:if test="${loginMember.member_id == board.writer}">
                    <td>
                        <button class="btn btn-danger"
                                onclick="location.href='${path}/board/delete.do?bno=${board.board_no}'">삭제
                        </button>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
