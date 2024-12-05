<%--
  Created by IntelliJ IDEA.
  User: evan
  Date: 11/20/24
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}"></c:set>
<meta name="viewprot" content="width=device-width, initiial-scale=1"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style>
  #loginInfo {
    display: flex;
    position: relative;
  }
</style>
<div id="loginInfo">
    <p>
        <c:if test="${loginMember.member_name == null}">
        손닙이시군요
        </c:if>
        <c:if test="${loginMember.member_name != null}">
        ${loginMember.member_name} 님이 접속중입니다.(session)
        </c:if>
    </p>
    <a href="${path}/auth/logout.do" class="btn btn-danger">로그아웃</a>
</div>

<%--같은 이름일 때 찾는 순서--%>
<%-- Request 영역 >> Session 영역 >> Application 영역--%>
<%--1. ${company}<br>
2. ${requestScope.company}<br>
3. ${sessionScope.company}<br>
4. ${applicationScope.company}<br>

&lt;%&ndash;jsp내장 객체 이용 Expression Language&ndash;%&gt;
2. <%=request.getAttribute("company")%><br>
3. <%=session.getAttribute("company")%><br>
4. <%=application.getAttribute("company")%>--%>

<%!
    //멤버변수(instance field), 멤버메서드(instance method) 만듦
//    String field1 = "instance field";
//    void method1(){
//
//    }
%>

<%
    //local 변수
//    String myName = "AA";
//
//    class Test{
//        String field1 = "instance field";
//        void service(){
//            String myName = "AA";
//        }
//        void method1(){
//
//        }
%>
