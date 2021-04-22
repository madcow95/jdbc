<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<script type="text/javascript" src="js/member.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#idChk").blur(function(){ /* blur 텍스트박스에서 포커스를 잃었을때 function작동 */
			var id = $("#idChk").val(); /* idChk에 입력된 값을 id변수에 저장 */
		
			if (id == "") {
				$("#idChk").val("필수 입력항목입니다.").css("background-color","red"); /* id가 null이면 idchk칸에 va에 입력된 값을 출력해라 */
			} else{
				$("#idChk").css("background-color","white");
				$.ajax({
					type : "post",
					url : "id_check_form.bizpoll",
					dataType : "json",
					data : "id=" + id,
					success : function(data) { /* 요청했을때 받아오는 함수 callback */
						if (data.message == "1") {
							$("#message").html("사용 불가능 아이디입니다.").css("color","red");
							$("#reid").val("-1");
						} else {
							$("#message").html("사용 가능 아이디입니다.").css("color","blue");
							$("#reid").val("1");
						}
					},
					fail : function() {
						alert("시스템 에러");
					}
				});
			}
		});
	});
</script>
<article>
	<h2>JOIN US</h2>
	<form action="join.bizpoll" id="join" method="post" name="frm">
		<!-- 사각형 -->
		<fieldset>
			<legend>Basic Info</legend>
			<label>UserID</label>
			<!-- <input type="text" name="id" size="12"> -->
			<input type="text" name="id" id="idChk">&nbsp;<span id="message"></span> <!-- span : 입력된 값만큼만 영역을 잡는다? -->
			<!-- 화면에는 안보이지만 데이터는 존재하는 타입 : hidden -->
			<input type="hidden" name="reid" id="reid"><br>
			<!-- <input type="button" value="중복체크" class="dup" onclick="idcheck();"><br> -->
			<label>Password</label>
			<input type="password" name="pwd"><br>
			<label>Retype Password</label>
			<input type="password" name="pwdCheck"><br> <!-- 비밀번호 위에 입력한 값과 같은지 체크 -->
			<label>Name</label>
			<input type="text" name="irum"><br>
			<label>Email</label>
			<input type="text" name="email"><br>
		</fieldset>
		<fieldset>
			<legend>Optional</legend>
			<label>Zip Code</label>
			<input type="text" name="zipNum" size="10">
			<input type="button" value="주소찾기" class="dup" onclick="post_zip();"><br>
			<label>Address</label>
			<input type="text" name="addr1" size="50"><br> <!-- 주소찾기에서 선택한 값 -->
			<input type="text" name="addr2" size="25"><br> <!-- 상세주소 -->
			<label>Phone Number</label>
			<input type="text" name="phone"><br>
		</fieldset>
		<div id="buttons">
			<input type="button" value="회원가입" class="submit" onclick="go_save();">
			<input type="reset" value="취소" class="cancel"> 
		</div> 
	</form>
</article>
<%@ include file="../footer.jsp" %>