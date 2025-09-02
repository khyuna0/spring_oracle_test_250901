<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글보기</title>
</head>
<body>

	<h2>글 내용 보기 & 수정</h2>
	<hr>
	<form action="boardModify">
	<input type="hidden" name="bnum" value="${boardDto.bnum}">
	글 제목 : <input type="text" name ="btitle" value="${boardDto.btitle }"> <br><br>
	글 내용 : <textarea rows="10" cols="45" name ="bcontent">${boardDto.bcontent }</textarea> <br><br>
	글 작성자 아이디 : ${boardDto.bwriter } <br><br>
	글 작성자 이름 : ${boardDto.memberDto.membername } <br><br>
	글 조회수 : ${boardDto.bhit }<br><br>
	글 등록일 : ${boardDto.bdate } <br><br>
	<input type="submit" value="수정">
	</form>
	<hr>
	
	<input type="button" value="목록" onclick="javascript:window.location.href='blist'">
	<input type="button" value="삭제" onclick="javascript:window.location.href='boardDelete?bnum=${boardDto.bnum}'">
</body>
</html>