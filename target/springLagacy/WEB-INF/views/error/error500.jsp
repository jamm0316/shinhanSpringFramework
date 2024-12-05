<%--
  Created by IntelliJ IDEA.
  User: evan
  Date: 11/20/24
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" isELIgnored="false" %>
<html>
<head>
    <title>오류정보</title>
</head>
<body>
<h1>오류 정보</h1>
message : <%=exception.getMessage()%>
<p>message(from controller) : ${message}</p>
</body>
</html>
