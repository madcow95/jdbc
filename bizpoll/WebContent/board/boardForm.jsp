<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 등록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$("#preview").attr("src", e.target.result);	/* id가 preview인 속성을바꾸는 함수 attr */
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	
	function backToList(obj) {
		obj.action="board_list.bizpoll";
		obj.submit();
	}
	
	function logintest() {
		var idval = document.articleForm.id.value;
		if (idval == "") {
			alert("로그인을 해야합니다");
			location.href = "login.bizpoll";
		}
		else {
			document.articleForm.submit();
		}
	}
</script> 
</head>
<body>
<%@ include file="../header.jsp" %>
<h1 style="text-align: center;">새글 쓰기</h1>
<form action="boardAdd.bizpoll" name="articleForm" method="post" enctype="multipart/form-data"> <!-- enctype이 안들어가면 첨부파일을 인식못한다. -->
	<!-- 화면에서 보이진 않지만 서버에서 동작하게 값을 넘겨주는 타입 : hidden -->
	<input type="hidden" name="id" value="${sessionScope.userId.id}">
	<table border="0" align="center">
		<tr>
			<td align="right">글 제목 : </td>
			<td colspan="2"><input type="text" size="67" maxlength="500" name="subject"></td>
		</tr>
		<tr>
			<td>글내용 : </td>
			<td colspan="2"><textarea rows="10" cols="65" maxlength="4000" name="content"></textarea></td>
		</tr>
		<tr>
			<td align="right">이미지 파일 첨부 : </td>
			<td>
				<input type="file" name="filename" onchange="readURL(this);">
			</td>
			<td><img id="preview" alt="preview" src="#" width="200" height="200"></td>
		</tr>
		<tr>
			<td align="right"></td>
			<td colspan="2">
				<input type="button" value="글쓰기" onclick="logintest();">
				<input type="button" value="글목록" onclick="backToList(this.form);">
			</td>
		</tr>
	</table>
</form>

<%@ include file="../footer.jsp" %>
</body>
</html>