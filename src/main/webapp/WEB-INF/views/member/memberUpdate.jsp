<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Member Update</h1>
<form action="memberUpdate" method="POST" enctype="multipart/form-data">
<input type="hidden" name="id" value="${member.id}">
<p>pw:<input type="password" name="pw" value="${member.pw}"></p>
<p>name:<input type="text" name="name" value="${member.name}"></p>
<p>email:<input type="text" name="email" value="${member.email}"></p>
<p>phone:<input type="text" name="phone" value="${member.phone}"></p>
<p>age:<input type="number" name="age" value="${member.age}"></p>
<p>photo: <span>${member.oname} x</span></p>
<button>Update</button>
</form>
</body>
</html>