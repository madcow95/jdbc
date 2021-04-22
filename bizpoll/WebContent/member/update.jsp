<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>내 정보 수정</h1>
<form action="update_detail.jsp" method="post" name="frm">
	<label>Password</label>
	<input type="text" name="irum"><br>
	<label>Password</label>
	<input type="password" name="pwd"><br>
	<label>Retype Password</label>
	<input type="password" name="pwdCheck"><br>
	<input type="submit" value="정보수정" class="update">
</form>
</body>
</html>