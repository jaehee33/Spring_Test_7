<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
<script type="text/javascript">
 var message='${message}';
 if(message !=''){
 alert(message);
 }
</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<a href="./notice/noticeList">Notice</a>
<a href="./qna/qnaList">QNA</a>
<c:if test="${empty member }">
<a href="./member/memberJoin">Join</a>
<a href="./member/memberLogin">Login</a>
</c:if>
<c:if test="${not empty member }">
<a href="./member/memberView">View</a>
<a href="./member/memberLogout">Logout</a>
</c:if>
</body>
</html>
