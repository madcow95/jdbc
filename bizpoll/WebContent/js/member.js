/**
 * 
 */
function go_next() {
// script에서 radio의 입력된 값을 가져오는 배열사용
//	contract.jsp의 form 태그에서 okon1의 0번째 값(okon1[0])이 체크가 돼서 true이면 if문 실행
	if (document.frm.okon1[0].checked == true) {
		document.frm.action = "join_form.bizpoll";
		document.frm.submit();
	} else if (document.frm.okon1[1].checked == true){
		alert("동의해야 넘어갈수 있습니다.");
	}
}

function go_save() {
	if (document.frm.id.value == null) {
		alert("아이디를 입력하지 않았습니다.");
		document.frm.id.focus();
	} else if (document.frm.pwd.value == null) {
		alert("비밀번호를 입력하지 않았습니다.");
		document.frm.pwd.focus();
	} else if (document.frm.pwd.value != document.frm.pwdCheck.value) {
		alert("비밀번호가 일치하지 않습니다.");
		document.frm.pwdCheck.focus();
	}else if (document.frm.email.value == null) {
		alert("이메일을 입력해주세요.");
		document.frm.email.focus();
	} else {
		document.frm.action = "join.bizpoll";
		document.frm.submit();
	}
}

function idcheck() {
	if (document.frm.id.value == "") {
		alert("아이디를 입력해주세요");
		document.frm.id.focus();
		return;
	} 
	
	var url = "id_check_form.bizpoll?id=" + document.frm.id.value; // QueryString ?뒤에 입력받을 값 
	
	var w = 400;
	var h = 200;
	
	var leftPosition = (screen.width-w)/2; // screen : 지금 화면 .width의 넓이 (가로길이)
	var topPosition = (screen.height-h)/2;
	var rightPosition = (screen.width+w)/2;
	
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=" + w + ", height=" + h + ", top=" + topPosition + ", left=" + leftPosition); // window.open 자식창으로 띄워라 blank : 새로띄우는 창 이름
}

function post_zip() {
	var url = "find_zip_num.bizpoll";
	
	window.open(url, "_blank_1", "toolbar=no, menubar=no scrollbars=yes, resizable=no width=500, height=300, top=300, left=300");
}

/*function deletePost() {
	var id = document.frm.user.value();
	alert("id");
}*/