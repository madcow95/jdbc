<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트용 페이지</title>
</head>
<body>
<!-- 재미있어요 html -->
<!-- 네이버 사이트로 이동 -->
<a href = "https://www.naver.com"> NAVER사이트로 이동</a><br>
<!-- <input type = "text" size = "12"/> -->
<b>볼드체로 만들었다.</b><br>
<i>이탤릭체로 만든다.</i><br>
<strong>텍스트를 강하게 표시한다.</strong><br>
<em>텍스트 강조</em><br>
<code>텍스트가 코드임을 표시</code><br>
2<sup>10</sup><br>
<!-- %rbsp; non-breaking space의 약자로 공백문자 한개 -->
<!-- &lt = < -->
<!-- &gt = > -->
<!-- 리스트 / 순서가 있는 리스트 : <ol> , 순서가 없는 리스트 : <ul> -->
<ul>
	<li>에스프레소</li>
	<li>아메리카노</li>
</ul>
	<a href = "http://localhost:9090/html5css3/mydoc.jsp">내정보</a>
<dl>
	<dt>에스프레소</dt>
	<dd> -- 에스프레소라는 커피</dd>
</dl>	
<a href = "http://localhost:9090/html5css3/mydoc.jsp"> 어디</a>
<hr />
<a id = "section">참고사항</a>
<hr />
<a href = "http://localhost:9090/html5css3/mydoc.jsp"><img src = "photos/photo.jpg" width = "300" height = "300"></a>
<a href = "https://www.naver.com"><img src = "photos/naver.jpg" width = "300" height = "300"></a> <br>
<input type = "button" value = "눌러보소" name = "button1"><br>
<input type = "text" value = "입력" name = "name"><br>
<input type = "password" value = "비번" name = "pw"><br>
<input type = "radio" value = "라디오" name = "radio"><br>
<input type = "checkbox" value = "체크박스" name = "check"><br>
<form>
	이름 : <input type = "text" name = "name"> <br>
	학번 : <input type = "text" name = "stunum"> <br>
	비번 : <input type = "password" name = "stpw"> <br>
	성별 : <input type = "radio" name = "gender" value = "male">남성
		   <input type = "radio" name = "gender" value = "female">여성<br>
	과일선택 : <input type = "checkbox" name = "fruit">
</form>
<form name = "input" action = "getid.jsp" method = "get">
	물품가격 : <input type = "text" name = "user"> <br>
	수량 : <input type = "text" name = "user"> <br>
	<input type = "button" value = "계산" onclick = "alert('10000원입니다,')"><br>
</form>
<form action = "">
	<select name = "cars">
		<option value = "선택"> 선택</option>
		<option value = "----------------"> --------------</option>
		<option value = "bmw"> BMW</option>
		<option value = "audie"> 아우디</option>
		<option value = "benz"> 벤츠</option>
		<option value = "hyundai"> 현대</option>
	</select>
	<!-- label for = "male -->
</form>
<form enctype = "multipart/form-data">
	<input type = "file" accept = "image/jpg, image/gif">
</form>
<form enctype = "multipart/form-data">
	생일<input type = "date" name = "birthday">
</form>

</body>
</html>