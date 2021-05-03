<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <c:set var="selAllBoardList" value="${selAllBoardList}"/> <!-- c tag에 변수값 세팅가능? -->
<c:set var="boardList" value="${boardList }"/>
<c:set var="section" value="${section }"/>
<c:set var="pageNum" value="${pageNum }"/> --%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css">
	.cls1 {
		text-decoration: none;
		color: black;
	}
	
	.cls2 {
		text-align: center;
		font-size: 30px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	
	function logintest() {
		var idval = document.frm.id.value;
		if (idval == "") {
			alert("로그인을 해야합니다");
			location.href = "login.bizpoll";
		}
		else {
			document.frm.submit();
		}
	}
	
	function count() {
		
	}	
</script>
</head>
<body>
	<h1 class="cls2">게시판</h1>
	<table align="center" border="1" style="border-collapse: collapse;" width="80%">
		<thead>
			<tr height="10" align="center" bgcolor="lightgray">
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty boardInfo.boardList}">
					<tr height="10">
						<th colspan="5">
							<p align="center">
								<b><span style="font-size: 20px;">등록된 글이 없습니다.</span></b>
							</p>
						</th>
					</tr>
				</c:when>
				<c:when test="${!empty boardInfo.boardList}">
					<c:forEach items="${boardInfo.boardList}" var="selAllBoardListDto" varStatus="status">
						<tr>
							<td width="5%">${selAllBoardListDto.articleno}</td>
							<td width="20%">${selAllBoardListDto.id}</td>
							<td width="45%" style="text-align: left;"><%-- ${selAllBoardListDto.content} --%>
								<span style="padding-left: 10px;"></span>
								<c:choose>
									<c:when test="${selAllBoardListDto.re_level > 1}">
										<c:forEach begin="2" end="${selAllBoardListDto.re_level }" step="1">
											<input type="hidden" value="${selAllBoardListDto.re_level }" name="reLevel">
											<span style="padding-left: 20px;"></span>
										</c:forEach>
										<span style="font-size: 12px;">[답변]</span>
										<a class="cls1" href="boardView.bizpoll?articleno=${selAllBoardListDto.articleno }" onclick="count();">${selAllBoardListDto.subject }</a>
									</c:when>
									<c:otherwise>
										<a class="cls1" href="boardView.bizpoll?articleno=${selAllBoardListDto.articleno}" onclick="count();">${selAllBoardListDto.subject }</a>
									</c:otherwise>
								</c:choose>
							</td>
							<td width="20%"><fmt:formatDate value="${selAllBoardListDto.reg_date }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td width="10%">${selAllBoardListDto.readcount}</td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5" align="center"> 
					<div class="cls2">
						<c:if test="${!empty boardInfo.selAllBoardList }">
							<c:choose>
								<c:when test="${boardInfo.selAllBoardList > 100}">
									<c:forEach var="page" begin="1" end="10" step="1">
										<c:if test="${boardInfo.section > 1 && page == 1}">
											<a class="no-uline" href="board_list.bizpoll?section=${boardInfo.section-1}&pageNum=10">pre</a>
										</c:if>
									</c:forEach>
									<c:forEach var="page" begin="1" end="${(boardInfo.selAllBoardList)}" step="1"> 
										<a class="no-uline" href="board_list.bizpoll?section=${boardInfo.section}&pageNum=${page}">${(boardInfo.section-1)*10 + page}</a>
									</c:forEach>
										<c:if test="${ boardInfo.section < (boardInfo.selAllBoardList/100) && page == 10}">
											<a class="no-uline" href="board_list.bizpoll?section=${boardInfo.section+1}&pageNum=1">next</a>
										</c:if>
								</c:when>
								<c:when test="${boardInfo.selAllBoardList == 100}">
									<c:forEach var="page" begin="1" end="10" step="1">
										<a class="no-uline" href="#">${boardInfo.pageNum}</a>
									</c:forEach>
								</c:when>
								<c:when test="${boardInfo.selAllBoardList < 100}">
									<c:forEach var="page" begin="1" end="${boardInfo.selAllBoardList/10+1}" step="1">
										<c:choose>
											<c:when test="${page == boardInfo.pageNum }">
												<a class="sel-page" href="board_list.bizpoll?section=${boardInfo.section }&pageNum=${page}">${page}</a>
											</c:when>
											<c:otherwise>
												<a class="no-uline" href="board_list.bizpoll?section=${boardInfo.section}&pageNum=${page}">${page}</a>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:when>
							</c:choose>
						</c:if>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="5" align="center">
					<form action="board_list.bizpoll" method="get">
						<select name="searchType" id="searchType">
							<option value="t"<c:out value="${boardInfo.searchType == 't' ? 'selected' : ''}"/>>제목</option>
							<option value="c"<c:out value="${boardInfo.searchType == 'c' ? 'selected' : ''}"/>>내용</option>
							<option value="w"<c:out value="${boardInfo.searchType == 'w' ? 'selected' : ''}"/>>작성자</option>
							<option value="tc"<c:out value="${boardInfo.searchType == 'tc' ? 'selected' : ''}"/>>제목 + 내용</option>
							<option value="cw"<c:out value="${boardInfo.searchType == 'cw' ? 'selected' : ''}"/>>내용 + 작성자</option>
							<option value="tcw"<c:out value="${boardInfo.searchType == 'tcw' ? 'selected' : ''}"/>>제목 + 내용 + 작성자</option>
						</select>
						<input type="text" name="searchKeyword" id="searchKeyword" value="${boardInfo.searchKeyword}">
						<input type="submit" value="검색">
					</form> 
				</td>
			</tr>
		</tfoot>
	</table>
	<form action="#" name="frm" method="post" class="cls1">
		<!-- <input type="button" value="글쓰기" onclick="logintest();"> -->
		<input type="hidden" value="${sessionScope.userId.id}" name="id">
		<a class="cls1" href="boardForm.bizpoll" onclick="logintest();">
			<p class="cls2">글쓰기</p>
		</a>
	</form>
<%@ include file="../footer.jsp" %>
</body>
</html>