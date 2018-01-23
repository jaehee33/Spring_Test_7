<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Member View(My Page)</h1>
<p>id: ${member.id}</p>
<p>name: ${member.name}</p>
<p>phone: ${member.phone}</p>
<a href="./memberUpdate?id=${m2.id}">update</a>
<a href="./memberDelete?id=${m2.id}">member Delete</a>

</body>
</html>