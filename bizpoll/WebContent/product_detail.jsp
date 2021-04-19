<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Detail</title>
</head>
<body>
<div id="product_detail">
		<div id="item_detail">
			<h3>${productDetail.p_code}</h3>
			<h3>${productDetail.p_name}</h3>
			<h3>${productDetail.p_kind}</h3>
			<h3>${productDetail.p_price1}</h3>
			<h3>${productDetail.p_price2}</h3>
			<h3>${productDetail.p_price3}</h3>
			<h3>${productDetail.p_content}</h3>
			<img src="images/product_img/${productDetail.p_img}">
			<h3>${productDetail.p_useyn}</h3>
			<h3>${productDetail.p_bestyn}</h3>
			<h3>${productDetail.p_indate}</h3>
		</div>
</div>
</body>
</html>