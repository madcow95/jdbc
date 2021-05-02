<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="js/member.js"></script>
<script type="text/javascript">
	
	function deletePost() {
		var user = document.frm.user.value;
		var postUser = document.frm.postUser.value;
		if (user == postUser){
			document.frm.action = "delete.bizpoll";
			document.frm.submit();
		} else{
			alert("글을 작성한 회원이 아닙니다.");
		}
	}
</script>
<h1>게시판 글</h1>
<form action="index.bizpoll" name="frm" method="post">
	<input type="hidden" value="${sessionScope.userId.id}" name="user">
	<input type="hidden" value="${artNo.id }" name="postUser">
	${artNo.articleno}<br>
	${artNo.subject}<br>
	${artNo.content}<br>
	<img alt="인식" src="images/board/${artNo.articleno}/${artNo.filename}" width="150" height="150"> <br>
	<input type="button" value="목록" onclick="location='board_list.bizpoll'">
	<input type="button" value="삭제" onclick="deletePost();" name="delbutton"> 
</form>
</body>
</html>