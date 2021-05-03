<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글보기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<script type="text/javascript">

	$(document).ready(function(){
		if(document.frm.user.value != document.frm.postUser.value){
			$("#modifybtn").hide();
			$("#deletebtn").hide();
		}
		/* var count = document.frm.readcount.value;
		parseInt(count) += 1; */
	});

	function deletePost(url, articleno) {
		var user = document.frm.user.value;
		var postUser = document.frm.postUser.value;
		
		if (user == postUser){
			document.frm.action = url;
			document.frm.submit();
		} else{
			alert("글을 작성한 회원이 아닙니다.");
		}
	}
	
	function fn_enable(obj) {
		var fileName = document.frm.originalFileName.value;
		document.getElementById("i_subject").disabled = false;
		document.getElementById("i_content").disabled = false;
		
		if(fileName != ""){
			document.getElementById("i_fileName").disabled = false;
		}
		
		document.getElementById("tr_btn_modify").style.display = "block";
		document.getElementById("tr_btn").style.display = "none";
	}
	
	function backToList() {
		document.frm.action="count.bizpoll?readcount="+document.frm.readcount.value+"&articleno="+document.frm.articleno.value;
		document.frm.submit();
	}
	
	function fn_modify_article(obj) {
		obj.action = "boardModify.bizpoll";
		obj.submit();
	}
	// 숙제
	function fn_remove_article(url, articleno) {
		
		var user = document.frm.user.value;
		var postUser = document.frm.postUser.value;
		
		
		var form = document.createElement("form");
		var parentNoInput = document.createElement("input");
		form.setAttribute("method", "post");
		form.setAttribute("action", url);
		
		parentNoInput = document.createElement("input");
		parentNoInput.setAttribute("type", "hidden");
		parentNoInput.setAttribute("name", "articleno");
		parentNoInput.setAttribute("value", articleno);
		form.appendChild(parentNoInput);
		document.body.appendChild(form);
		
		if (user != postUser){
			alert("글을 작성한 회원이 아닙니다.");
		}
		form.submit();
	}
	
	function fn_reply_form(url, articleno, ref, re_step, re_level) {
		var form = document.createElement("form");
		var parentNoInput = document.createElement("input");
		
		form.setAttribute("method", "post");
		form.setAttribute("action", url);
		
		parentNoInput = document.createElement("input");
		parentNoInput.setAttribute("type", "hidden");
		parentNoInput.setAttribute("name", "articleno");
		parentNoInput.setAttribute("value", articleno);
		form.appendChild(parentNoInput);
		
		parentNoInput = document.createElement("input");
		parentNoInput.setAttribute("type", "hidden");
		parentNoInput.setAttribute("name", "ref");
		parentNoInput.setAttribute("value", ref);
		form.appendChild(parentNoInput);
		
		parentNoInput = document.createElement("input");
		parentNoInput.setAttribute("type", "hidden");
		parentNoInput.setAttribute("name", "re_step");
		parentNoInput.setAttribute("value", re_step);
		form.appendChild(parentNoInput);
		
		parentNoInput = document.createElement("input");
		parentNoInput.setAttribute("type", "hidden");
		parentNoInput.setAttribute("name", "re_level");
		parentNoInput.setAttribute("value", re_level);
		form.appendChild(parentNoInput);
		
		document.body.appendChild(form);
		
		form.submit();
	}
	
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function (e) {
				$("#preview").attr("src", e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
<body>
<%@ include file="../header.jsp" %>

	<form action="#" name="frm" method="post" enctype="multipart/form-data">
		<input type="hidden" value="${sessionScope.userId.id}" name="user">
		<input type="hidden" value="${selBoardView.id }" name="postUser">
			<table border="0" align="center">
				<tr>
					<td width="150" align="center" bgcolor="#ff9933">글번호</td>
					<td><input type="text" value="${selBoardView.articleno}" disabled="disabled"></td>
					<td><input type="hidden" value="${selBoardView.articleno}" name="articleno"></td>
				</tr>
				<tr>
					<td width="150" align="center" bgcolor="#ff9933">작성자아이디</td>
					<td><input type="text" value="${selBoardView.id}" disabled="disabled"></td>
				</tr>
				<tr>
					<td width="150" align="center" bgcolor="#ff9933">글제목</td>
					<td><textarea rows="20" cols="60" disabled="disabled" id="i_subject" name="subject">${selBoardView.subject}</textarea></td>
				</tr>
				<tr>
					<td width="150" align="center" bgcolor="#ff9933">글내용</td>
					<td>
						<textarea rows="20" cols="60" disabled="disabled" id="i_content" name="content">${selBoardView.content}</textarea>
					</td>
				</tr>
				<c:if test="${not empty selBoardView.filename && selBoardView.filename != 'null'}">
					<tr>
						<td width="150" align="center" bgcolor="#ff9933" rowspan="2">이미지</td>
						<td>
							<input type="hidden" name="originalFileName" value="${selBoardView.filename}">
							<img alt="image_preview" src="imagePreView.bizpoll?articleno=${selBoardView.articleno}&filename=${selBoardView.filename}" id="preview" style="width: 150px; height: 150px;">
						</td>
					</tr>
					<tr>
						<td>
							<input type="file" name="filename" id="i_fileName" disabled="disabled" onchange="readURL(this);">
						</td>
					</tr>
				</c:if>
				<tr>
					<td width="150" align="center" bgcolor="#ff9933" rowspan="2">등록일자</td>
					<td>
						<input type="text" value='<fmt:formatDate value="${selBoardView.reg_date}" pattern="yyyy-MM-dd HH:mm:ss"/>' disabled="disabled">
					</td>
				</tr>
				<tr id="tr_btn_modify">
					<td colspan="2" align="center">
						<input type="button" value="수정반영하기" onclick="fn_modify_article(frm)">
						<input type="button" value="취소" onclick="backToList(frm)"> <!-- frm 하면 form의 name이지? 그 정보를 넘긴다 -->
					</td>
				</tr>
				<tr id="tr_btn">
					<td colspan="2" align="center"> 
						<input type="hidden"  name="readcount" value="${selBoardView.readcount}">
						<input type="button" value="수정하기" onclick="fn_enable(this.form);" id="modifybtn">
						<input type="button" value="삭제하기" onclick="fn_remove_article('delete.bizpoll',${selBoardView.articleno});" id="deletebtn">
						<input type="button" value="목록보기" onclick="backToList();">
						<input type="button" value="댓글쓰기" onclick="fn_reply_form('boardReplyForm.bizpoll', ${selBoardView.articleno}, ${selBoardView.ref}, ${selBoardView.re_step}, ${selBoardView.re_level});">
					</td>
				</tr>
			</table>
		<!-- <input type="button" value="삭제" onclick="deletePost();"> -->
	</form>
<%@ include file="../footer.jsp" %>
</body>
</html>