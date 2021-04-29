<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	function delPost() {
		var articleno = document.frm.artino.value;
		var sePwd = document.frm.sePwd.value;
		var inPwd = document.frm.delPwd.value;
		if(sePwd == inPwd){
			document.frm.action = "delete_post.bizpoll";
			document.frm.submit();
		} else if(inPwd == ""){
			alert("비밀번호를 입력해주세요");
		} else {
			alert("비밀번호가 다릅니다.");
		}
	}
</script>
</head>
<body>
<%@ include file="../header.jsp" %>
	<form action="#" name="frm" method="post">
	<br>
		<input type="hidden" value="${delPost.articleno}" name="artino"><br>
		<input type="hidden" value="${sessionScope.userId.pwd}" name="sePwd"><br>
		ID : <input type="text" value="${sessionScope.userId.id}" name="seId" disabled="disabled"><br>
		PW : <input type="text" name="delPwd"><br>
		<input type="button" value="삭제하기" name="delbtn" onclick="delPost();">  
	</form>
<%@ include file="../footer.jsp" %>
</body>
</html>