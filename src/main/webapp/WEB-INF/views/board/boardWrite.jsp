<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	var i=0;
	$("#btn").click(function(){
		/* alert($(".x").size()); */
		if(i<5){
		var ex = $("#ex").html();
		$("#result").append(ex);
		i++;
		}
	});
	
	$("#result").on("click", ".x", function(){
		$(this).prev().remove();
		$(this).remove();
		i--;
	});
	
	
/* 	var i=0;
	$("#btn").click(function(){
	if(i<5){
		$("#result").append('<input type="file" name="f1"><span class="x">xxxxxxx</span>');
		i++;
	}else{
		alert("최대 5개 까지 가능 합니다");
	}
	}); */
});
</script>
<style type="text/css">
#ex{
	display: none;
}
.x{
	cursor: pointer;
}
</style>
</head>
<body>
	<h1>${board}Write</h1>
	<form action="./${board}Write" method="POST" enctype="multipart/form-data">
		title: <input type="text" name="title"> 
		writer: <input type="text" name="writer">
		contents: <input type="text" name="contents">
		<div id="result">
			<div id="ex">
				<input type="file" name="file"><span class="x">xxxxxxx</span>
			</div>
		</div>
		<p><input type="button" id="btn" value="fileAdd"></p>
		<button>save</button>
	</form>
</body>
</html>