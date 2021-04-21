<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<form action="join_detail.bizpoll" method="post" name="frm"><br>
	아이디 : <input type="text" name="id"><br>
	비밀번호 : <input type="text" name="pwd"><br>
	이름 : <input type="text" name="name"><br>
	이메일 : <input type="text" name="email"><br>
	주소 : <input type="text" name="address"><br>
	전화번호 : <input type="text" name="phone"><br>
	우편번호 : <input type="text" name="zip_num"><br>
	<input type="submit" value="제출">
<%@ include file="../footer.jsp" %>
</form>
</body>
</html>