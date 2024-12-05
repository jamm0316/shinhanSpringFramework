<%--
  Created by IntelliJ IDEA.
  User: evan
  Date: 11/29/24
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>업무선택</h1>
<ul>
  <li><a href="${path}/auth/login.do">로그인</a></li>
  <li><a href="${path}/emp/list.do">직원조회</a></li>
  <li><a href="${path}/emp/insert.do">직원입력</a></li>
  <li><a href="${path}/dept/list.do">부서조회</a></li>
  <li><a href="${path}/dept/insert.do">부서입력</a></li>
  <li><a href="${path}/board/insert.do">board입력</a></li>
  <li><a href="${path}/board/list.do">board조회</a></li>
</ul>
</body>
</html>
