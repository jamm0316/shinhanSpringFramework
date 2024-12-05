<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" %>

<html>
<head>
    <meta charset="UTF-8">
    <style>
        #hi {
          border-radius: 10px;
        }
    </style>
</head>
<body>
<h2>Hello World!</h2>
<p>${myName}</p>
<p>${serverTime}</p>
</body>
</html>
