<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script>
	$(document).ready(function(){
		$("#memberLeave").click(function(){
			var lId = $("#lId").val();
			var lPassword = $("#lPassword").val();
			$.ajax({
				url: "/lol/memberLeave2",
				type: "post",
				dataType: "json",
				data:{"lId":lId, "lPassword":lPassword},
				success: function(data){
					console.log(data);
					if(data.result == "200"){
						location.href="/lol/loginForm";
						alert("회원탈퇴가 완료되셨습니다.")
					}else{
						console.log(data)
						
					}
				},
				error: function(data){
					console.log(data)
				}	
			});
		});
	});
</script>
</head>
<body>
	<table width="300" align="center">
		<tr>
			<td>아이디<input type="text" id="lId" name="lId" /><br></td>
		</tr>
		<tr>
			<td>비밀번호<input type="password" id="lPassword"  name="lPassword" /><br></td>
		</tr>
		<tr>
			<td><a href="/lol/memberShip"><button type="button"  id="memberLeave2" >회원가입</button> </a>
		</tr>

		<tr>
			<td><button type="button"  id="memberLeave"  style="width: 180pt; height:30pt;	background-color:#eff7f9; border:1 solid ">회원탈퇴</button><br></td>
		</tr>
		

		
	</table>
</body>
</html>