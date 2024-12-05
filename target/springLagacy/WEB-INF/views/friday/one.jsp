<%--
  Created by IntelliJ IDEA.
  User: evan
  Date: 11/29/24
  Time: 09:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> One RequestParameter연습</h1>
<form action="one.do">
    <input name="userid"/>
    <input name="username" value="홍길동"/>
    <input name="useremail" value="aa@naver.com"/>
    <input name="userphone" value="010-1234-5677"/>
    <input type="submit" value="서버전송"/>
</form>
</body>
</html>
