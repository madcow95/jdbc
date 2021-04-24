<%@page import="com.bizpoll.dao.MemberDAO"%>
<%@page import="com.bizpoll.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<%@ include file="../header.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>내 정보 수정</h1>
	<% String id = session.getAttribute("userId").toString(); 
	   MemberDAO mDao = MemberDAO.getInstance();
	   MemberDTO mDto = mDao.getMember(id);
	   
	   String userID = mDto.getId();
	   String userName = mDto.getName();
	%>
	
	<form action="update_detail.bizpoll" method="post" name="frm">
		<label>ID</label>
		<input type="text" name="id" value="<%=userID%>" readonly="readonly"><br>
		<label>Name</label>
		<input type="text" name="id" value="<%=userName%>" readonly="readonly"><br>
		<label>Password</label>
		<input type="password" name="pwd"><br>
		<label>Retype Password</label>
		<input type="password" name="changepwd"><br>
		<input type="submit" value="정보수정" class="update">
	</form>
</body>
</html>
<%@ include file="../footer.jsp"%>