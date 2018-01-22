<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${board}view</h1>
<p>num: ${view.num}</p>
<P>title: ${view.title}</P>
<P>contents: ${view.contents}</P>

<%-- <!-- 첨부파일 a태그 사용 -->
<c:forEach items="${view.files}" var="file">
<p><a href="../resources/upload/${file.fname}">${file.oname}</a></p>
</c:forEach> --%>

<c:forEach items="${view.files}" var="file">
<p><a href="../file/fileDown?fname=${file.fname}&oname=${file.oname}">${file.oname}</a></p>
</c:forEach>

<a href="./${board}Update?num=${view.num}">Update</a>
<a href="./${board}Delete?num=${view.num}">Delete</a>

<p><a href="noticeList">List</a></p>
</body>
</html>