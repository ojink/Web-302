<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/include/header.jsp" />


<c:forEach items="${books }" var="dto">
<div><span>${dto.isbn }</span>
	<span>${dto.title }</span>
	<span>${dto.price }</span>
</div>
</c:forEach>


<hr>
<h3>Level3 SW개발 공개문제 - 회원목록</h3>

<a href="register.l3">신규등록</a>
<table border="1">
<colgroup>
	<col width="200px">
	<col width="200px">
	<col width="300px">
	<col width="200px">
</colgroup>
<tr><th>아이디</th><th>이름</th><th>이메일</th><th>연락처</th>
</tr>

<c:if test="${empty list }">
<tr><td colspan="4">회원정보가 없습니다</td></tr>
</c:if>

<c:forEach items="${list }" var="dto">
<tr><td>${dto.p_id }</td>
	<td>${dto.c_name }</td>
	<td>${dto.c_email }</td>
	<td>${dto.c_tel }</td>
</tr>
</c:forEach>

</table>

</body>
</html>