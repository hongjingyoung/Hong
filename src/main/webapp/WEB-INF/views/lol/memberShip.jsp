<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$("#jButton").click(function(){
			var lName = $("#lName").val();	//이름
			var lId = $("#lId").val();				//아이디
			var lPassword = $("#lPassword").val(); 	//비밀번호
			var lPassword2 = $("#lPassword2").val();  //중복확인
			if(lName == ""){
				alert("이름을 입력해주세요");
				return false;
			}
			if(lId == ""){
				alert("아이디를 입력해주세요");
				return false;
			}
			if(lPassword == ""){
				alert("비밀번호를 입력해주세요");
				return false;
			}
			if(lPassword != lPassword2){
				alert("비밀번호가 일치하지않습니다");
				return false;
			}
			$("#frm").submit();
		});
		$("#userIdSearch").click(function(){
			$.ajax({
				url: "/lol/loginCheck",
				type: "post",
				dataType: "json",
				data:{lId : "lId"},
				success:function(data){		
						if(data.result == '200'){
							alert("사용가능한아이디입니다");
						}
						else{
							console.log(data);
							alert("중복된아이디입니다");
						}
				},
				error:function(data){
						console.log(data);
						alert("죄송합니다. 다시 해주세요");
				}
			});
		});
	});
</script>
<style>
table{
 width: 70%;
 border: 1px solid #444444;
height: 300px;
margin: auto;
}
input{
	height: 100%;
	width: 50%;
}
</style>
</head>
<body>
	
	     <form id="frm" action="/lol/memberShip2" method="post" enctype="multipart/form-data">
            <table class="">
                <tr>
                    <th colspan="7">회원가입</th>
                </tr>
                <tr>
                    <th>이름</th>
                    <td><input type="text" id="lName" name="lName">
                    	
                    </td>
                </tr>
                <tr >
                    <th>아이디</th>
                    <td><input type="text" id="lId" name="lId" >
                    <Button type="button" id=userIdSearch>중복확인</Button>
                    </td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" id="lPassword" name="lPassword" ></td>
                </tr>
                 <tr>
                    <th>비밀번호 확인</th>
                    <td><input type="password" id="lPassword2" name="lPassword2" ></td>
                </tr>
                <tr>
                <tr>
                    <th colspan="3"><Button type="submit"  id="jButton">가입하기</Button>
                     <Button type="reset" id="cButton">취소</Button></th>
                </tr>
            </table>
	</form>
</body>
</html>