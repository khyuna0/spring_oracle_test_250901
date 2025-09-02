<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 목록</title>
</head>
<body>
	<h2>게시판 글 목록</h2>
	<hr>
	<table border="1" cellspacing="0" cellpadding="0">
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>아이디</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>등록일</th>
			<th>삭제</th>
		</tr>
	<c:forEach items="${boardDtos }" var="board" varStatus="status">
		<tr>
			<td>${count-status.index}</td>
			<td><a href="boardView?bnum=${board.bnum}">${board.btitle}</a></td>
			<td>${board.bwriter}</td>
			<td>${board.memberDto.membername}</td>
			<td>${board.bhit}</td>
			<td>${board.bdate}</td>
			<td>
				<input type="button" value="삭제" onclick="javascript:window.location.href='boardDelete?bnum=${board.bnum}'">
			</td>
		</tr>	
	</c:forEach>
	</table>
	<hr>
	총 게시글 수 : ${count } 건<br><br>
	<input type="button" value="글쓰기" onclick="javascript:window.location.href='bwrite'">
			
	
</body>
</html>