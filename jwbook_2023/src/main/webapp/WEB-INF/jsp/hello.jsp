<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World</title>
</head>
<body>
	<h2>Hello World!</h2>
	<hr>
	<div>
		현재 시간과 날짜는
	<%=java.time.LocalDateTime.now() %>
	입니다.
	</div>
</body>
</html>