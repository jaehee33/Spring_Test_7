<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	/*$("#btn").clic(function(){
		document.frm.submit();
	}); */
	var message='${message}';
	if(message != ''){
		alert(message);
	}
	
	$(".page").click(function(){
		var cur=$(this).attr("title");
		document.frm.curPage.value=cur;
		document.frm.search.value='${page.search}';
		document.frm.kind.value='${page.kind}';
		document.frm.submit();
	});
});
</script>
<style type="text/css">
.page{
	cursor: pointer;
}
</style>
</head>
<body>
	<h1>${board}List</h1>
	<div>
	<form name="frm" action="${board}List" >
		<input type="hidden" name="curPage" value="1">
		<select name="kind">
			<option value="title">title</option>
			<option value="writer">writer</option>
			<option value="contents">contents</option>
		</select>
		<input type="text" name="search">
		<input id="btn" type="submit" value="search"> 
	</form>
	</div>
	<table>
		<tr>
			<td>num</td>
			<td>title</td>
			<td>writer</td>
			<td>date</td>
			<td>hit</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.num}</td>
			<td><a href="${board}View?num=${dto.num}">
			<c:catch> <!-- 예외처리할때 catch 쓴다 -->
				<c:forEach begin="1" end="${dto.depth}">>></c:forEach>
			</c:catch>
			${dto.title}</a></td>
			<td>${dto.writer}</td>
			<td>${dto.reg_date}</td>
			<td>${dto.hit}</td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<c:if test="${page.curBlock > 1}">
			<span class="page" title="${page.startNum-1}">[이전]</span>
		</c:if>
		<c:forEach begin="${page.startNum}" end="${page.lastNum}" var="i">
			<span class="page" title="${i}">${i}</span>
		</c:forEach>
		<c:if test="${page.curBlock < page.totalBlock}">
			<span class="page" title="${page.lastNum+1}">[다음]</span>
		</c:if>
		
	</div>
	
	<div>
	<form action="./${board}Write" method="get">
		<a href="./${board}Write">write</a>
	</form>
	</div>
</body>
</html>