<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/include/header.jsp" />
<h3>회원정보</h3>
<table border="1">
<colgroup>
<col width="200px">
<col width="400px">
</colgroup>
<tr><th>아이디</th>
	<td>${dto.p_id }</td>
</tr>
<tr><th>이름</th>
	<td>${dto.c_name }</td>
</tr>
<tr><th>이메일</th>
	<td>${dto.c_email }</td>
</tr>
<tr><th>연락처</th>
	<td>${dto.c_tel }</td>
</tr>
</table>

<a href="list.l3">회원목록</a>
<a href="modify.l3?id=${dto.p_id}">정보수정</a>
<a href="javascript: fnDelete()">정보삭제</a>
<%-- <a href="javascript:if( confirm('회원 [${dto.c_name}] 정말 삭제?') ) location='delete.l3?id=${dto.p_id}'">정보삭제</a> --%>

<script>
function fnDelete(){
	if( confirm("회원 [ ${dto.c_name} ] 정말 삭제?") ){
		location="delete.l3?p_id=${dto.p_id}"
	}
}

</script>
</body>
</html>













