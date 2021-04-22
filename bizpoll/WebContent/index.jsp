<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- jsp의 기능을 사용하겠다고 선언 core기능과 fmt? -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Bizpoll Shop</title>

</head>
<body>
<%@ include file="../header.jsp" %>
<div id="main_img">
	<img alt="main_img" src="images/포스터12.jpg" width="200" height="200">
</div>
<div id="front">
	<h2>New Item</h2>
	<div id="newProduct">
		<!-- forEach : 반복문 items는 IndexAction class의 setAttribute의 ""이름-->
		<c:forEach items="${newProductList}" var="newProductDto">
			<div id="item">
				<a href="product_detail.bizpoll?p_code=${newProductDto.p_code}"> <!-- newProducList를 newProducDto라고 새로 정의하고, 달러중괄호에서 p_code를 호출 전체적인 방법은 DAO에서 DTO가져오는 방법과 비슷하지만 .get을 붙이지 않고 사용한다.-->
					<img alt="" src="images/product_img/${newProductDto.p_img} "> <!-- 주석처리에서도 달러중괄호는 하지말자 ㅅ -->
					${newProductDto.p_name}
					<fmt:formatNumber value="${newProductDto.p_price2}" type="currency"/>
				</a>
			</div>
		</c:forEach>
	</div>
	<h2>Best Item</h2>
	<div id="bestProduct">
		<c:forEach items="${bestProductList}" var="bestProductDto">
			<div id="item2">
				<a href="product_detail.bizpoll?p_code=${bestProductDto.p_code}"> 
					<img alt="" src="images/product_img/${bestProductDto.p_img}"> 
					${bestProductDto.p_name}
					<fmt:formatNumber value="${bestProductDto.p_price2}" type="currency"/>
				</a>
			</div>
		</c:forEach>
	</div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>