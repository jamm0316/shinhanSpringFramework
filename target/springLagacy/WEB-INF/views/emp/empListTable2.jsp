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
        <td>salary</td>
        <td>department_name</td>
        <td>city</td>
        <td>country_name</td>
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
                <a href='detail.do?empid=${emp["EMPLOYEE_ID"]}'>${emp["EMPLOYEE_ID"]}</a>
            </td>
            <td>
                <a href='detail.do?empid=${emp["EMPLOYEE_ID"]}'>${emp["FIRST_NAME"]}</a>
            </td>

            <td>${emp["SALARY"]}</td>
            <td>${emp["DEPARTMENT_NAME"]}</td>
<%--            <fmt:formatNumber value=" " type="currency"/>--%>
            <td>${emp["CITY"]}</td>
            <td>${emp["COUNTRY_NAME"]}</td>
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