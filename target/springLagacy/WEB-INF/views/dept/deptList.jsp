<%--
  Created by IntelliJ IDEA.
  User: evan
  Date: 11/15/24
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>부서리스트</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<style>
  table, th, td {
    border: 1px solid darkslategray;
    border-collapse: collapse;
  }
</style>
<script>
    let result = "${result}";
    if (result !== "") {
      alert(result);
    }
</script>
<body>
<div class="container">
    <a class="btn btn-primary" href="insert.do">부서입력</a>
<h2>어서와 버그개발자 집단은 처음이지?</h2>
<h3>부서목록</h3>
<table class="table table-striped color black">
    <tr>
        <td>부서번호</td>
        <td>부서이름</td>
        <td>매니저번호</td>
        <td>위치</td>
        <td></td>
    </tr>
    <%-- items====> List<DeptDTO> deptlist = getAttribute("deptDatas) --%>
    <%-- for (DeptDTO dept : deptlist) {} --%>
    <%-- DeptDTO dept = new DeptDTO() //javaBeans기술 -> 객체 생성시 기본 생성자로 생성됨 --%>
    <%-- dept.setDepartment_id(값) --%>
    <c:forEach items="${deptList}" var="dept">
        <tr>
            <td>
                <a href="detail.do?deptid=${dept.department_id}">${dept.department_id}</a>
            </td>
            <td>
                <a href="detail.do?deptid=${dept.department_id}">${dept.department_name}</a>
            </td>
            <td>${dept.manager_id}</td>
            <td>${dept.location_id}</td>
            <td><button class="btn btn-danger" onclick="location.href='delete.do?deptid=${dept.department_id}'">삭제</button></td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
