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

<h3>L3- 회원정보수정</h3>
<form method="post" action="update.l3">
<input type="hidden" name="p_id" value="${dto.p_id }">
<table border="1">
<colgroup>
	<col width="200px">
	<col width="400px">
</colgroup>
<tr><th>아이디</th>
	<td>${dto.p_id }</td>
<%-- 	<td><input type="text" name="p_id" style="border:none" value="${dto.p_id }" readonly></td> --%>
</tr>
<tr><th>비밀번호</th>
	<td><input type="password" name="p_pw" value="${dto.p_pw }"></td>
</tr>
<tr><th>이름</th>
	<td><input type="text" name="c_name" value="${dto.c_name }"></td>
</tr>
<tr><th>이메일</th>
	<td><input type="text" name="c_email" value="${dto.c_email }"></td>
</tr>
<tr><th>전화번호</th>
	<td><input type="text" name="c_tel" value="${dto.c_tel }"></td>
</tr>
</table>

<button>저장하기</button>
<button type="button" 
	onclick="location='info.l3?id=${dto.p_id}'">취소하기</button>

</form>

</body>
</html>