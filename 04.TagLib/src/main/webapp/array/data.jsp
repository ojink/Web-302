<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href="../">홈으로</a></div>
<hr>

<h2>배열출력</h2>
<%
ArrayList<String> list = new ArrayList<String>();
list.add("자바");
list.add("View");
list.add("Oracle");
request.setAttribute("subjects", list);

HashMap<String, String> map = new HashMap<String, String>();
map.put("홍길동", "062-9874-5632");
map.put("심청", "02-8521-3214");
map.put("박문수", "010-6541-2580");
session.setAttribute("phones", map);
%>
<div>${subjects[0]}</div>
<div>${subjects[1]}</div>
<div>${subjects[2]}</div>
<div>${subjects[3]}</div>


</body>
</html>