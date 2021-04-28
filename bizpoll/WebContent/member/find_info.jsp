<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">

</script>
<body>
<%@ include file="../header.jsp" %>
<form action="idFind.bizpoll" method="post" name="frm">
	<h1>아이디찾기</h1>
		<label>이름</label>
		<input type="text" name="irum"><br>
		<label>이메일</label>
		<input type="text" name="idemail"><br>
		<input type="submit" value="아이디찾기">
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