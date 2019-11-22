<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="corsText"></div>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(function () {
    $.ajax("http://localhost:81/test")
        .done(function(msg){

            var result = msg.result;
    		var text = "";
    		for(var i=0; i<result.length; i++){
				text += "아이디 : " + result[i].userId + ", 이름 : " + result[i].userName + "<br>";	
       		}

			alert("success!!!");
            $("#corsText").html(text);

        }).fail(function(){
            alert("fail...");
    });
});
</script>
</body>
</html>