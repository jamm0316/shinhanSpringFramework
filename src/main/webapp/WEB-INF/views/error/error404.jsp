<%--
  Created by IntelliJ IDEA.
  User: evan
  Date: 11/20/24
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error발생</title>
</head>
<body>
<h1>주소가 존재하지 않습니다.</h1>
<p>${pageContext.request.requstURI}</p>
<p><%=request.getRequestURI()%>></p>
<p id="here"></p>
<script>
  document.querySelector("#here").innerHTML = location.href
</script>
</body>
</html>
