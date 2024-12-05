<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}"/>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1>Sign in</h1>
<form action="${path}/auth/login.do" method="post">
    <label>사용자번호</label>
    <input type="text" name="uesrid" value="jamm"/>
    <label>사용자비밀번호</label>
    <input type="password" name="userpass" value="1234"/>
    <input type="submit" value="로그인">
    <hr>
</form>
</body>
</html>
