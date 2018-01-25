<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">

	$(function() {
		$('#del').click(function() {
			var id = $(this).attr("title");
			$("#" + id).html('photo: <input type="file" name="file" id="f">');
		});
		$('#btn').click(function() {
			var f = $('#f').val();
			alert(f == '');//true로 나오면 if문 써서 저장이 안되도록 한다.
			if (f != '') {
				alert("ok");
				$('#frm').submit();
			}
		});

	});
</script>
</head>
<body>
<h1>Member Update</h1>
<form id="frm" action="memberUpdate" method="POST" enctype="multipart/form-data">
<input type="hidden" name="id" value="${member.id}">
<p>pw:<input type="password" name="pw" value="${member.pw}"></p>
<p>name:<input type="text" name="name" value="${member.name}"></p>
<p>email:<input type="text" name="email" value="${member.email}"></p>
<p>phone:<input type="text" name="phone" value="${member.phone}"></p>
<p>age:<input type="number" name="age" value="${member.age}"></p>
<p id="photo">photo: <span id="del" title="photo">${member.oname} x</span></p>
<input type="button" value="update" id="btn">
</form>

</body>
</html>