<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="httpClientText"></div>

<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(function(){
	var result = JSON.parse('${result}');
	var userList = result.userList;
	
	var text = "";
	for(var i=0; i<userList.length; i++){
		text += "아이디 : " + userList[i].userId + ", 이름 : " + userList[i].userName + "<br>";	
	}
	
	alert("success!!!");
    $("#httpClientText").html(text);
});
</script>

</body>
</html>