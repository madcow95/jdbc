<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	/* $(document).ready(function() {
		$("#idphone").hide();
	}); */
	
	function idfind() {
		alert("hello");
	}
	
	$(function () {
		$("#idFindEmail").click(function () {
			$("#idemail").show();
			$("#idphone").hide();
		});
	
		$("#phoneFindPhone").click(function () {
			$("#idemail").hide();
			$("#idphone").show();
		});
	})
</script>
<body>
<%@ include file="../header.jsp" %>
<form action="idFind.bizpoll" method="post" name="frm">
	<h1>아이디찾기</h1>
	<br>
		<label id="irum"><span>이름</span><input type="text" name="irum"></label><br><br><br><br>
		<label id="idemail"><span>이메일</span><input type="text" name="idemail"></label><br><br><br><br>
		<label id="idphone"><span>전화번호</span><input type="text" name="idphone"></label><br><br><br><br>
		<input type="radio" id="idFindEmail">이메일로찾기
		<input type="radio" id="phoneFindPhone">전화번호로찾기<br>
		<input type="button" value="아이디찾기" onclick="idfind();">
	<h1>비밀번호찾기</h1> 
		<label>아이디</label>
		<input type="text" name="id"><br>
		<label>이메일</label>
		<input type="text" name="pwdemail"><br>
		<input type="submit" value="비밀번호찾기">
</form>
<%@ include file="../footer.jsp" %>
</body>
</html>