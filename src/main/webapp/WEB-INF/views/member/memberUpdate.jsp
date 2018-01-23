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
<form action="memberUpdate" method="POST">
<input type="hidden" name="id" value="${m2.id}">
name:<input type="text" name="name" value="${m2.name}">
email:<input type="text" name="email" value="${m2.email}">
phone:<input type="text" name="phone" value="${m2.phone}">
age:<input type="number" name="age" value="${m2.age}">
<button>Update</button>
</form>
</body>
</html>