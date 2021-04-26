<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<article>
	<h1>로그인</h1>
	<form action="login_detail.bizpoll" method="post" name="frm">
		<fieldset>
			<legend></legend>
			<label>User ID</label>
			<input type="text" name="id">
			<label>Password</label>
			<input type="password" name="pwd">
		</fieldset>
		<div id="buttons">
			<input type="submit" value="로그인" class="submit">
			<input type="button" value="회원가입" class="cancel" onclick="location='join.bizpoll'">
			<input type="button" value="아이디 / 비밀번호 찾기" class="submit" onclick="location='find_id_form.bizpoll'">
		</div>
	</form>
</article>
<%@ include file="../footer.jsp" %>
</body>
</html>