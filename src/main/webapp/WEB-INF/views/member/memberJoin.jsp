<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){ //blur 포커스를 잃었을때, change 글자가 완전히 바꼈을때, keyup 한글자씩 바뀔때마다체크
		var check=true;
		$("#id").keyup(function(){
			var data = $("#id").val();
			$.post("memberIdCheck",{id:data},function(result){
				if(result.trim()==0){
					$("#result").html("이미 있는 아이디 입니다.");
				}else{
					$("#result").html("사용 가능 한 id 입니다.");
				}
			});
		});
	});
	
</script>
</head>
<body>
	<h1>Member Join</h1>
	<form action="memberJoin" method="POST" enctype="multipart/form-data">
		<p>id:<input type="text" name="id" id="id"></p><div id="result"></div>
		<p>pw:<input type="password" name="pw"></p>
		<p>name:<input type="text" name="name"></p>
		<p>email:<input type="text" name="email"></p>
		<p>phone:<input type="text" name="phone"></p>
		<p>age: <input type="number" name="age"></p>
		<p>job: S<input type="radio" name="job" value="S" checked="checked">
				T<input type="radio" name="job" value="T"></p>
		<p>photo: <input type="file" name="f1"></p>
		<button>Join</button>
	</form>
</body>
</html>