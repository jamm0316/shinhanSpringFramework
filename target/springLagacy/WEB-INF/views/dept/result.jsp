<%--
  Created by IntelliJ IDEA.
  User: evan
  Date: 11/15/24
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<meta http-equiv="refresh" content="1;url=list.do"/>
<html>
<head>
    <title>WelcomePage</title>
  <style>
    .orange
      background-color: lightcoral {
      color: darkblue;
      border: deeppink
    };
  </style>
</head>
<body>
<%--${} => getAttribute--%>
  <h1 class="orange">수정정보: ${dept}</h1>
</body>
</html>
