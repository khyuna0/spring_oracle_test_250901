<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 로그인하지 않은 경우 로그인 페이지로 강제이동함 -->
<c:if test="${empty sessionScope.sessionId }">
	<c:redirect url="login"/>
</c:if>	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
</head>
<body>

	<h2>게시판 글쓰기</h2>
	<hr>
	<form action="bwriteOk">
	글 제목 : <input type="text" name="btitle" size="50"> <br> <br>
	글 내용 : <textarea rows="10" cols="45" name="bcontent"></textarea> <br> <br>
	글쓴이 : <input type="text" value="${sessionScope.sessionId }" name = "bwriter" readonly="readonly"> <br><br>
	<input type="submit" value="글쓰기">
	</form>
</body>
</html>