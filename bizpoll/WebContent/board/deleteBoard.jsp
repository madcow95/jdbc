<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<script type="text/javascript">
	function delPost() {
		var pwd = document.frm.userPwd.value;
		var id = document.frm.userId.value;
		if(document.frm.delPwds.value == ""){
			alert("비밀번호를 입력하세요");
		}
		else if(document.frm.delId.value == id && document.frm.delPwds.value == pwd){
			document.frm.action = "delete_post.bizpoll";
			document.frm.submit();
		} else {
			alert("게시글을 작성한 회원이 아닙니다.")
		}
	}
</script>
<form action="" name="frm" method="post">
	<input type="hidden" value="${sessionScope.artNo.articleno}" name="artino">
	<input type="hidden" value="${sessionScope.userId.id }" name="userId"><br>
	<input type="hidden" value="${sessionScope.userId.pwd }" name="userPwd"><br>
	아이디 : <input type="text" name="delId" value="${sessionScope.userId.id }" readonly="readonly"><br>
	비밀번호 : <input type="password" name="delPwds"><br>
	<input type="button" value="게시글삭제" onclick="delPost();">
</form>
</body>
</html>