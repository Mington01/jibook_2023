<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>방명록 목록</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        html, body {
            height: 70%;
            margin: 0;
            display: flex;
            justify-content: center;
            text-align: center;
            align-items: center;
            flex-direction: column;
        }

        form, table, button {
            margin: 5px;
        }

        .container {
            width: 500px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="text-primary"><b>방명록 목록</b></h1>
        <form action="/jwbook_2023/guestBookControl?action=list" method="get">
	        <br>
	        <div class="list">
	            <table class="table table-hover table-bordered">
	                <tr class="text-center">
	                    <th>번호</th>
	                    <th>작성자</th>
	                    <th>이메일</th>
	                    <th>작성일</th>
	                    <th>제목</th>
	                </tr>
	                <c:forEach items="${guestbooks}" var="guestbook">
	                    <tr>
	                        <td>${guestbook.id}</td>
	                        <td>${guestbook.author}</td>
	                        <td>${guestbook.email}</td>
	                        <td>${guestbook.createdAt}</td>
	                        <td><a href="/jwbook_2023/guestBookControl?action=revise&id=${guestbook.id}">${guestbook.title}</a></td>
	                    </tr>
	                </c:forEach>
	            </table>
	        </div>
	    </form>
        <button type="button" class="btn btn-primary" onclick="location.href='GuestBook/guestInput.jsp'">등록</button>
    </div>
</body>
</html>