<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>방명록 입력</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        function validateForm() {
        	var author = document.getElementById("author").value;
        	var email = document.getElementById("email").value;
            var title = document.getElementById("title").value;
            var password = document.getElementById("gPassword").value;
            var content = document.getElementById("content").value;
            
            if (author === "") {
                alert("작성자를 입력해주세요.");
                return false;
            }
            if (email === "") {
                alert("이메일을 입력해주세요.");
                return false;
            }
            if (title === "") {
                alert("제목을 입력해주세요.");
                return false;
            }
            if (password === "") {
                alert("비밀번호를 입력해주세요.");
                return false;
            }
            if (content === "") {
                alert("내용을 입력해주세요.");
                return false;
            }
        }
        
        function clearForm() {
        	document.getElementById("author").value = "";
        	document.getElementById("email").value = "";
            document.getElementById("title").value = "";
            document.getElementById("gPassword").value = "";
            document.getElementById("content").value = "";
        }
    </script>
    <style>
	    body {
	        display: flex;
	        justify-content: center;
	        align-items: center;
	        height: 100vh;
	    }
	    
	    .inputbox {
	        text-align: center;
	        max-width: 500px;
	        padding: 20px;
	        border: 1px solid #ccc;
	        border-radius: 10px;
	        box-shadow: 10px 5px 5px gray;
	    }
	
	    .inputbox h1 {
	    	margin-top: 30px;
	        margin-bottom: 50px;
	    }
	
	    .inputbox table {
	        margin-bottom: 30px;
	    }
	    
	    .inputbox input:focus {
	        outline: none;
	    }
	
	    .inputbox textarea {
	        width: 100%;
	        height: 150px;
	        resize: vertical;
	    }
	
	    .button-container {
	    	height: 60px;
	        text-align: center;
	    }
	
	    .button-container input[type="submit"],
	    .button-container input[type="button"] {
	        margin-right: 25px;
	        margin-left: 25px;
	        width: 90px;
	    }
	</style>
</head>
<body>
	<div class="inputbox container">
	    <h1 class="text-primary"><b>방명록 입력</b></h1>
	    <form action="/jwbook_2023/guestBookControl?action=insert" method="post" onsubmit="return validateForm()">
	        <table class="table table-bordered table-hover">
			    <tr>
			        <th>작성자</th>
			        <td><input class="border-0" type="text" id="author" name="author"></td>
			    </tr>
			    <tr>
			    	<th>이메일</th>
			        <td><input class="border-0" type="text" id="email" name="email"></td>
			    </tr>
			    <tr>
			        <th>제  목</th>
			        <td><input class="border-0" type="text" id="title" name="title"></td>
			    </tr>
			    <tr>
			        <th>비밀번호</th>
			        <td><input class="border-0" type="text" id="gPassword" name="gPassword"></td>
			    </tr>
			</table>
	        
	        <textarea id="content" name="content" rows="5" cols="30"></textarea><br><br>
	        
	        <div class="button-container container border-0">
		        <input class="btn btn-primary" type="submit" value="입력" onclick="/jwbook_2023/guestBookControl?action=insert">
		        <input class="btn btn-primary" type="button" value="취소" onclick="clearForm()">
		        <input class="btn btn-primary" type="button" value="목록" onclick="location.href='/jwbook_2023/guestBookControl?action=list'">
		    </div>
	    </form>
	</div>
</body>
</html>