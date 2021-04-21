<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/shopping.css" rel="stylesheet">
<script type="text/javascript" src="js/member.js"></script>
<!-- <script type="text/javascript" src="js/member.js"></script> -->
<style type="text/css">
	#head a {
		text-decoration: none;
	}
</style>
</head>
<body>
	<div id="wrap">
		<header>
			<div id="logo">
				<a href="index.bizpoll"><img alt="logo" src="images/로고.png" width="100" height="80"></a>
			</div>
		</header>
		<nav id="catagory_menu">
			<ul>
				<c:choose>
					<c:when test="${empty sessionScope.userId}">
						<li><a href="login.bizpoll">LOGIN</a></li>
						<li>|</li>
						<li><a href="join.bizpoll">JOIN</a></li>
					</c:when>
					<c:otherwise>
						<li>
							${sessionScope.userId.name}({sessionScope.userId.id})
						</li>
						<li><a href="logout.bizpoll" onclick="location='index.bizpoll'">LOGOUT</a></li>
						<li>|</li>
						<li><a href="delete.bizpoll" onclick="location='index.bizpoll'">회원탈퇴</a></li>
					</c:otherwise>
				</c:choose>
				<li>|</li>
				<li><a>CART</a></li>
				<li>|</li>
				<li><a>MY PAGE</a></li>
				<li>|</li>
				<li><a>Q&amp;A (1 : 1)</a></li> <!-- &amp; : \ -->
				<li>|</li>
				<li><a>APP</a></li>
				<li>|</li>
				<li><a>board</a></li>
			</ul>
		</nav>
	</div>
</body>
</html>