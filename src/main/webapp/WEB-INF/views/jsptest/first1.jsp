<%--
  Created by IntelliJ IDEA.
  User: evan
  Date: 11/28/24
  Time: 11:39
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
<h1>first1.jsp열기</h1>
<form action="${path}/second3.do" method="post">
    id: <input type="text" name="userid" value="jamm"/><br>
    pw: <input type="text" name="userpw" value="1234"/><br>
    <input type="submit" value="서버전송(post)"/>
</form>

<h1>요청 parameter check</h1>
<form action="${path}/second4.do" method="get">
    id: <input type="text" name="userid" value="jamm"/><br>
    pw: <input type="text" name="userpw" value="1234"/><br>
    <input type="submit" value="서버전송(post)"/>
</form>
</body>
</html>
