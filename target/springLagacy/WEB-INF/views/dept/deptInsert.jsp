<%--
  Created by IntelliJ IDEA.
  User: evan
  Date: 11/15/24
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<style>
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
<%@include file="../jsp/header.jsp" %>
<!-- Example Code -->


<div class="input-group mb-3">
    <form class="insertCard" action="insert.do" method="post">
        <h2>부서등록</h2>
        <div class="input-group mb-3">
            <span class="input-group-text">부서번호</span>
            <input type="number" required="required" class="form-control" placeholder="숫자입력" name="department_id"
                   aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">부서이름</span>
            <input type="text" required="required" class="form-control" placeholder="부서입력" name="department_name"
                   aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">부서장</span>
            <input type="number" required="required" class="form-control" value="101" placeholder="101"
                   name="manager_id"
                   aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">지역번호</span>
            <input type="number" required="required" class="form-control" value="1700" placeholder="1700"
                   name="location_id"
                   aria-describedby="basic-addon1">
        </div>
        <input type="hidden" name="phone" value="010-1234-5678"/>
        <button type="submit" class="btn btn-primary">신규부서 등록</button>
        <button id="btn_ajax" type="button" class="btn btn-warning">신규부서 등록(Ajax)</button>
    </form>
</div>
<script>
  $("#btn_ajax").on("click", f_jsonInsert)

  function f_jsonInsert() {
    let obj = {
      "deptid": $('[name="department_id"]').val(),
      "deptname": $('[name="department_name"]').val(),
      "mid": $('[name="manager_id"]').val(),
      "locid": $('[name="location_id"]').val()
    };
    let jsonStr = JSON.stringify(obj);
    console.log(obj);
    console.log(jsonStr)
    $.ajax({
      url: "${path}/json.do",
      type: "get",
      data: {"jsonInfo": jsonStr},
      success: function (responseData) {
        alert(responseData);
      },
      error: function (err) {
        alert(err);
      },
      complete: function () {
        alert("완료!");
      }

    });
  }
</script>
</body>
</html>