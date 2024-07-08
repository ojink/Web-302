<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>제조사 변경</h2>
<form method="post" action="update.l5">
<table border="1">
<colgroup>
	<col width="200px">
	<col width="400px">
</colgroup>
<tr><th colspan="2">제조사 변경</th></tr>
<tr><th>제품코드</th>
	<td><input type="text" value="${dto.code }" name="code" readonly style="border:none"></td>
</tr>
<tr><th>제조사명</th>
	<td><input type="text" name="maker" value="${dto.maker }"></td>
</tr>
<tr><th colspan="2"><button>저장</button>	</th>
</tr>
</table>
</form>


</body>
</html>