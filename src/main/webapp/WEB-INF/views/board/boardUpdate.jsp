<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	
	$(".del").click(function(){
		var del=$(this);
		var fn=$(this).attr("title");
		var fname=$(this).attr("id");
		var check=confirm("주의: 삭제시 복구 불가능");
		if(check){
			$.ajax({
				url: "../file/fileDelete", 
				type: "GET",
				data: {
					/*파라미터명 */fn:fn, //변수명
					fname:fname
				},
				success: function(data){
					alert(data);
					if(data.trim()==1){
						$(del).prev().remove();
						$(del).remove();
						i--;
					}
				}
			});
		}
		
	});
	

	var i=${fn:length(view.files)};
	alert(i);
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
});
</script>
<style type="text/css">
#ex{
	display: none;
}
.x, .del{
	cursor: pointer;
}
</style>
</head>
<body>

<h1>${board}view</h1>
	<form action="${board}Update" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${view.num}">
		<P>writer: <input type="text" name="writer" value="${view.writer}" disabled="disabled"></P>
		<P>title: <input type="text" name="title" value="${view.title}"></P>
		<P>contents: <input type="text" name="contents" value="${view.contents}"></P>
		<%-- contents:<textarea rows="" cols="">${view.contents}</textarea> --%>

		<p><input type="button" id="btn" value="fileAdd"></p>
		<div id="result">
			<c:forEach items="${view.files}" var="file">
				<p><input type="text" value="${file.oname}" readonly="readonly"><span class="del" title="${file.fn}" id="${file.fname}">x</span></p>
			</c:forEach>
		</div>
		<input type="submit" value="update">
	</form>
		<div id="ex">
			<input type="file" name="f1"><span class="x">x</span>
		</div>
</body>
</html>