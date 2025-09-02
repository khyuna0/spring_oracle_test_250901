<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글보기</title>
</head>
<body>

	<h2>글 내용</h2>
	<hr>
	글 제목 : ${boardDto.btitle } <br><br>
	글 내용 : ${boardDto.bcontent } <br><br>
	글 작성자 아이디 : ${boardDto.bwriter } <br><br>
	글 등록일 : ${boardDto.bdate } <br><br>
	<hr>
	
	<input type="button" value="목록" onclick="javascript:window.location.href='blist'">
	<input type="button" value="삭제" onclick="javascript:window.location.href='boardDelete?bnum=${boardDto.bnum}'">
</body>
</html>