<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="js/member.js">
	
</script>
<article>
	<h2>JOIN US</h2>
	<form id="join" action="join_form.bizpoll" method="post" name="frm">
		좋은 샵입니다.
		<br><br>
		<textarea rows="15" cols="80">
			제 1장 총칙
			제 1조 (목적)
			....
			많이 이용해주세요
		</textarea>
		<br><br>
		<div style="text-align: center;">
			<input type="radio" name="okon1" checked="checked"> 동의함&nbsp;&nbsp;&nbsp;
			<input type="radio" name="okon1"> 동의하지 않음
		</div>
		<input type="button" value="next" class="submit" onclick="go_next();" style="float: right;">
	</form>
</article>
<%@ include file="../footer.jsp" %>