<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>

<html>
<head>
 <style>
   .no-underline{
      text-decoration:none;
   }
 </style>
  <meta charset="UTF-8">
  <title>사이드 메뉴</title>
</head>
<body>
	<h1>사이드 메뉴</h1>
	<h1> 
		<a href="${contextPath}/member/listMembers.do"  class="no-underline">급여관리</a><br>
	    <a href="#"  class="no-underline">근태결과입력</a><br>
	    <a href="#"  class="no-underline">급여입력및계산</a><br>
	    <a href="#"  class="no-underline">급여이체현황</a><br>
    </h1>
</body>
</html>