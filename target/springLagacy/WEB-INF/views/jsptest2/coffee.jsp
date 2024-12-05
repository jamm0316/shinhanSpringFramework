<%--
  Created by IntelliJ IDEA.
  User: evan
  Date: 11/28/24
  Time: 14:07
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
<h1>coffee.jsp 파일 열기</h1>
<form action="${path}/jsptest2/coffee2.do">
    <input name="department_id" type="number" value="100"/>
    <input name="department_name" type="text" value="개발부"/>
    <input name="manager_id" type="number" value="120"/>
    <input name="location_id" type="number" value="1700"/>
    <input type="submit" value="서버로 전송"/>
</form>
</body>
</html>
