<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Join</h1>
	<form action="memberJoin" method="POST" enctype="multipart/form-data">
		<p>id:<input type="text" name="id"></p>
		<p>pw:<input type="password" name="pw"></p>
		<p>name:<input type="text" name="name"></p>
		<p>email:<input type="text" name="email"></p>
		<p>phone:<input type="text" name="phone"></p>
		<p>age: <input type="number" name="age"></p>
		<p>job: S<input type="radio" name="job" value="S" checked="checked">
				T<input type="radio" name="job" value="T"></p>

		<div id="ex">
			<input type="file" name="f1">
		</div>
	
	<button>Join</button>
	</form>
</body>
</html>