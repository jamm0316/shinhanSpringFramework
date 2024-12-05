<%--
  Created by IntelliJ IDEA.
  User: evan
  Date: 11/18/24
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>empUpdate</title>
</head>
<style>
  [required] {
    background-color: lightcyan;
  }
</style>
<script>
  window.onload = () => {
    var d = new Date().toISOString().split("T")[0];
    document.querySelector("input[name='hire_date']").value = d;
  };
</script>
<body>
<div class="input-group mb-3">
    <%--include 디렉티브 태그는 jsp를 합쳐서 컴파일 한다.--%>
    <%@include file="../jsp/header.jsp" %>
    <form class="insertCard" action="detail.do" method="post">

        <h2>직원수정</h2>
        <div class="input-group mb-3">
            <span class="input-group-text">직원 아이디</span>
            <input type="number" required="required" class="form-control" placeholder="직원 아이디" name="employee_id"
                   value="${empDTO.employee_id}" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">firstName</span>
            <input type="text" class="form-control" placeholder="firstName" name="first_name"
                   value="${empDTO.first_name}" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">lastName</span>
            <input type="text" required="required" class="form-control" placeholder="lastName" name="last_name"
                   value="${empDTO.last_name}" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">이메일</span>
            <input type="email" required="required" class="form-control" placeholder="이메일"
                   name="email"
                   value="${empDTO.email}" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">핸드폰번호</span>
            <input type="text" required="required" class="form-control" placeholder="010-1234-5678"
                   name="phone_number"
                   value="${empDTO.phone_number}" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">입사일</span>
            <input type="date" required="required" class="form-control"
                   name="hire_date" pattern="yyyy-MM-dd"
                   value="${empDTO.hire_date}" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">jobId</span>
            <select required="required" class="form-control" name="job_id"
                    aria-describedby="basic-addon1">
                <c:forEach items="${joblist}" var="job">
                    <option ${job.job_id == empDTO.job_id  ? 'selected' : ''} value="${job.job_id}">
                            ${job.job_id} / ${job.job_title}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">급여</span>
            <input type="number" class="form-control" value="${empDTO.salary}"
                   name="salary"
                   aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">커미션비율</span>
            <input type="number" class="form-control" value="${empDTO.commission_pct}" pattern="[0]\.[0-9]{1, 2}"
                   name="commission_pct"
                   aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">매니저 아이디</span>
            <select required="required" class="form-control" name="manager_id">
                <option value="-1">
                    매니저 없음
                </option>
                <c:forEach items="${managerlist}" var="manager">
                    <option ${manager.employee_id == empDTO.manager_id ? 'selected' : ''}
                            value="${manager.employee_id}">
                            ${manager.employee_id} / ${manager.last_name}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">부서 아이디</span>
            <select class="form-control" name="department_id" value="${empDTO.department_id}">
                <option value="-1">
                    부서없음
                </option>
                <c:forEach items="${deptlist}" var="dept">
                    <option ${dept.department_id == empDTO.department_id ? 'selected' : ''}
                            value="${dept.department_id}">
                            ${dept.department_id} / ${dept.department_name}
                    </option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">직원정보 수정</button>
    </form>
</div>
</body>
</html>
