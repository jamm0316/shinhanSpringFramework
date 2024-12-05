<%--
  Created by IntelliJ IDEA.
  User: evan
  Date: 11/20/24
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="../jsp/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:setLocale value="en_US"/>
<table class="table table-striped color black">
    <tr>
        <td>순서</td>
        <td>직원번호</td>
        <td>fname</td>
        <td>lname</td>
        <td>email</td>
        <td>phone_number</td>
        <td>job_id</td>
        <td>hire_date</td>
        <td>commission</td>
        <td>salary</td>
        <td>manager</td>
        <td>department</td>
        <td>get요청</td>
        <td>post요청</td>
    </tr>
    <c:forEach items="${emplist}" var="emp" varStatus="status">
        <tr>
            <td>
                    ${status.count}
                <c:if test="${status.first}">
                    첫번째
                </c:if>
                <c:if test="${status.last}">
                    마지막
                </c:if>
                <c:if test="${status.count mod 2 == 0}">
                    / 짝수
                </c:if>
            </td>
            <td>
                <a href='detail.do?empid=${emp.employee_id}'>${emp.employee_id}</a>
            </td>
            <td>
                <a href='detail.do?empid=${emp.employee_id}'>${emp.first_name}</a>
            </td>
            <td>${emp.last_name}</td>
            <td>${fn:toLowerCase(emp.email)}</td>
            <td>${fn:replace(emp.phone_number, ".","-")}</td>
            <td>${emp.job_id}</td>
<%--            <fmt:formatNumber value=" " type="currency"/>--%>
            <td>
                <fmt:formatDate type="date" value="${emp.hire_date}" dateStyle="full"/>
            </td>
            <td>${emp.commission_pct}</td>
            <td>${emp.salary}</td>
            <td>${emp.manager_id}</td>
            <td>${emp.department_id}</td>
            <td>
                <form action="delete.do" method="post">
                    <input type="hidden" name="empid" value="${emp.employee_id}">
                    <button class="btn btn-danger">삭제</button>
                </form>
            </td>
            <td>
                <button class="btn btn-success"
                        onclick="location.href='${path}/emp/detail.do?empid=${emp.employee_id}'">수정
                </button>
            </td>
        </tr>
    </c:forEach>
</table>