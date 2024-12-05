<%--
  Created by IntelliJ IDEA.
  User: evan
  Date: 11/15/24
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
</head>
<style>
  [readonly] {
    background-color: lightgray;
  }
  /*body {*/
  /*  display: grid;*/
  /*}*/

  /*.input-group {*/
  /*  display: grid;*/
  /*  place-items: center;*/
  /*}*/
  /*.input-group-text {*/
  /*  display: inline-block;*/
  /*  width: 80px;*/
  /*}*/
</style>
<body class="p-3 m-0 border-0 bd-example m-0 border-0">
<%--include 디렉티브 태그는 jsp를 합쳐서 컴파일 한다.--%>
<%@include file="../jsp/header.jsp"%>
<div class="input-group mb-3">
  <form class="insertCard" action="detail.do" method="post">
    <h2>부서등록</h2>
    <div class="input-group mb-3">
      <span class="input-group-text" readonly="readonly">부서번호</span>
      <input type="number" required="required" class="form-control" placeholder="숫자입력" name="department_id"
             value="${deptDTO.department_id}" aria-describedby="basic-addon1">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">부서이름</span>
      <input type="text" required="required" class="form-control" placeholder="부서입력" name="department_name"
             value="${deptDTO.department_name}" aria-describedby="basic-addon1">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">부서장</span>
      <input type="number" required="required" class="form-control" value="${deptDTO.manager_id}" name="manager_id" aria-describedby="basic-addon1">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">지역번호</span>
      <input type="number" required="required" class="form-control" value="${deptDTO.location_id}"
             name="location_id"
             aria-describedby="basic-addon1">
    </div>
    <input type="hidden" name="phone" value="010-1234-5678"/>
    <button type="submit" class="btn btn-primary">신규부서 등록</button>
  </form>
</div>
</body>
</html>