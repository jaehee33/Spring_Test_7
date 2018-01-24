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
<img src="../resources/upload/${member.fname}">
<p>name: ${member.name}</p>
<p>phone: ${member.phone}</p>
<p>email: ${member.email}</p>
<p>age: ${member.age}</p>
<p>job: ${member.job}</p>
<a href="./memberUpdate?id=${member.id}">update</a>
<a href="./memberDelete?id=${member.id}">member Delete</a>
<a href="../">HOME</a>

</body>
</html>